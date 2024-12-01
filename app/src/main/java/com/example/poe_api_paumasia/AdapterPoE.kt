package com.example.poe_api_paumasia


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.math.log

class AdapterPoE(private val context: Context, var dataSource: List<ObjetoPoE>) :
    RecyclerView.Adapter<AdapterPoE.ViewHolder>() {
    // cojo el layout par añadir las cosas luego
//    private val inflater: LayoutInflater =
//        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.itemName)
        val imageView: ImageView = view.findViewById(R.id.imageItem)
        val tierView: TextView = view.findViewById(R.id.tier)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPoE.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.itemviewlista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterPoE.ViewHolder, position: Int) {
        val item = dataSource[position]

        //Configurar el texto e imagen del objeto del apadter
        holder.nameView.text = item.name
        holder.tierView.text = item.tier

        Log.e("imagenItem", item.imagen)
        Glide.with(context).load(item.imagen).into(holder.imageView)

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelable("item", item)
            }
            NavHostFragment.findNavController(it.findFragment())
                .navigate(R.id.action_FirstFragment_to_item_info, bundle)
        }

    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    //
    public fun updateData(newData: List<ObjetoPoE>) {
        //como que vacia y rellena la arrayList
        dataSource = listOf()
        dataSource = newData
        Log.d("DATA_SOURCE##", "Items fetched: ${dataSource.size}")

        //hace aparecer los cmabios en la arraylist, exclusivamente del LayoutPokemonAdapter
        notifyDataSetChanged()
    }

}