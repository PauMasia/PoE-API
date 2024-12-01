package com.example.poe_api_paumasia

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poe_api_paumasia.databinding.FragmentFirstBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.runner.manipulation.Ordering
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FirstFragment : Fragment() {


    private var _binding: FragmentFirstBinding? = null
    private val BASE_URL = "https://paumasia.pythonanywhere.com/"
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id= item.itemId
        if (id== R.id.refresh) {
            restart()
            return true
        }

         return super.onOptionsItemSelected(item)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {

            var adapter = AdapterPoE(requireContext(), emptyList())
//        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
//
//            val api = getRetrofit().create(API_Interface::class.java)
//            val items = api.getData()
//
//            adapter.dataSource= items
//            Log.e("#####1", adapter.dataSource.toString())
//
//        }
            adapter = buscarItems(adapter)
            delay(4000) // Wait for 2 seconds

            Log.e("#####2", adapter.dataSource.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buscarItems(adapter: AdapterPoE): AdapterPoE {
        val model = ViewModelProvider(this).get(ModelViewItem::class.java)
        model.items.observe(viewLifecycleOwner) { result ->
            Log.d("XXX", result.toString())
            adapter.dataSource = listOf()
            adapter.updateData(result)
            binding.rvItems.apply {
                layoutManager = GridLayoutManager(context, 3)

            }
            binding.rvItems.addItemDecoration(GridSpacingItemDecoration(0, 0)) // Comment this out.


        }
        binding.rvItems.adapter = adapter

//        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
//            try {
//
//
//                val api = getRetrofit().create(API_Interface::class.java)
//                val items = api.getData()
//                Log.e("#####4", items.toString())
//                withContext(Dispatchers.Main) {
//                    if (!items.isNullOrEmpty()) {
//                        adapter.dataSource = items
//                        adapter.notifyDataSetChanged()
//
//                        binding.rvItems.apply {
//                            layoutManager = GridLayoutManager(context, 4)
//
//                        }
//                        binding.rvItems.addItemDecoration(GridSpacingItemDecoration(0, 0)) // Comment this out.
//                        binding.rvItems.adapter= adapter
//                        adapter.updateData(items)
//                        Log.d("RecyclerViewSetup", "Number of items: ${adapter.dataSource.size}")
//                    } else {
//                        Log.d("RecyclerViewSetup", "No items fetched.")
//                    }
//                }
//            } catch (e: Exception) {
//                Log.e("API_ERROR", e.message.toString())
//            }

        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val mWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

        if (mWifi!!.isConnected) {
            Log.e("wifiii", mWifi.toString() +"\n "+mWifi.isConnected)
            restart()
        }

        return adapter
    }

    private fun restart() {
        val itemViewModel = ModelViewItem(app = Application())
        lifecycleScope.launch {
            itemViewModel.reload()
        }
    }

}
