package com.example.material_design.ui.photo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.material_design.Adapter
import com.example.material_design.PhotoChar
import com.example.material_design.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class PhotoFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList: ArrayList<PhotoChar>? = null
    private var adapter: Adapter? = null
    private val REQUEST_IMAGE_CAPTURE = 1
    private val items: ArrayList<PhotoChar> = ArrayList()
    private var imageView: ImageView? = null
    lateinit var currentPhotoPath: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_photo, container, false)
        recyclerView = rootview.findViewById(R.id.photo_recycler_view)
        gridLayoutManager = GridLayoutManager(context, 4, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = setImage()
        adapter = Adapter(requireContext(), arrayList!!)
        recyclerView?.adapter = adapter

        //imageView = rootview.findViewById(R.id.image_test)

        val fab: FloatingActionButton = rootview.findViewById(R.id.fab)
        fab.setOnClickListener {
            dispatchTakePictureIntent()
        }

        return rootview
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val photoFile: File? = try {
            createImageFile()
        } catch (ex: IOException) {
            null
        }
        photoFile?.also {
            val photoURI: Uri = FileProvider.getUriForFile(
                requireActivity(),
                "com.example.android.fileprovider",
                it
            )
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }

    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            currentPhotoPath = absolutePath
        }
    }


    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView?.setImageBitmap(imageBitmap)
        }
    }*/



    private fun setImage(): ArrayList<PhotoChar> {

        items.add(PhotoChar(R.drawable.photo1))
        items.add(PhotoChar(R.drawable.photo2))
        items.add(PhotoChar(R.drawable.photo3))
        items.add(PhotoChar(R.drawable.photo4))
        items.add(PhotoChar(R.drawable.photo5))
        items.add(PhotoChar(R.drawable.photo6))

        return items
    }
}