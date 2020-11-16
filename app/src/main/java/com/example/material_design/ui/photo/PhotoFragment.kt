package com.example.material_design.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.material_design.Adapter
import com.example.material_design.PhotoChar
import com.example.material_design.R

class PhotoFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList: ArrayList<PhotoChar>? = null
    private var adapter: Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_photo, container, false)
        recyclerView = view?.findViewById(R.id.photo_recycler_view)
        gridLayoutManager = GridLayoutManager(context, 3 , LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setImage()
        adapter = Adapter(requireContext(), arrayList!!)
        recyclerView?.adapter = adapter

        return rootview
    }

    private fun setImage(): ArrayList<PhotoChar> {
        var items: ArrayList<PhotoChar> = ArrayList()

        items.add(PhotoChar(R.drawable.photo1, "Photo1"))
        items.add(PhotoChar(R.drawable.photo2, "Photo2"))
        items.add(PhotoChar(R.drawable.photo3, "Photo3"))
        items.add(PhotoChar(R.drawable.photo4, "Photo4"))
        items.add(PhotoChar(R.drawable.photo5, "Photo5"))
        items.add(PhotoChar(R.drawable.photo6, "Photo6"))

        return items
    }
}