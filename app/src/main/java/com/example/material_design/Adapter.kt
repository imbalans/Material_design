package com.example.material_design

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class Adapter(
    var context: Context,
    var arraylist: ArrayList<PhotoChar>,
) : RecyclerView.Adapter<Adapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(
            R.layout.grid_layout_list_item,
            parent, false
        )
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var photoChar: PhotoChar = arraylist[position]

        holder.icons.setOnLongClickListener {
            Snackbar.make(it, "Удалить фото?", Snackbar.LENGTH_SHORT)
                .setAction("Да") {
                    val newPosition = holder.adapterPosition
                    arraylist.removeAt(newPosition)
                    notifyDataSetChanged()
                }.show()
            true
        }

        holder.icons.setImageResource(photoChar.iconsChar!!)
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icons: ImageView = itemView.findViewById(R.id.icons_image)
    }
}