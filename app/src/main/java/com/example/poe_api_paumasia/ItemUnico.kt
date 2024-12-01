package com.example.poe_api_paumasia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.poe_api_paumasia.databinding.FragmentItemInfoBinding
import com.example.poe_api_paumasia.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ItemUnico : Fragment() {

    private var _binding: FragmentItemInfoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentItemInfoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        if (args != null) {
            val item: ObjetoPoE? = args.getParcelable("item") as ObjetoPoE?
            if (item != null) {
                updateUi(item)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUi(unico: ObjetoPoE) {
        Log.d("itemgg", unico.toString())

        binding.nombreItem.setText(unico.name)
        binding.tierItem.setText(unico.tier+ " "+unico.categoria)
        Glide.with(requireContext()).load(
            unico.imagen
        ).into(binding.imageView)
        binding.tamano.setText(unico.dimensions)
        binding.level.setText(unico.minLevel)

        binding.poeDb.setText(unico.poeDb)
        binding.wikiLink.setText(unico.poewiki)
    }
}