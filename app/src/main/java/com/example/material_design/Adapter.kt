package com.example.material_design

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (var context: Context, var arraylist: ArrayList<PhotoChar>) : RecyclerView.Adapter<Adapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_item, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var photoChar: PhotoChar = arraylist[position]

        holder.icons.setImageResource(photoChar.iconsChar!!)
        holder.title.text = photoChar.alphaChar
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class ItemHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icons: ImageView = itemView.findViewById(R.id.icons_image) // listener
        var title: TextView = itemView.findViewById(R.id.image_text_view)

    }
}