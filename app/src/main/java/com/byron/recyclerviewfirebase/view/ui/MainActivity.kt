package com.byron.recyclerviewfirebase.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.byron.recyclerviewfirebase.view.adapter.MainAdapter
import com.byron.recyclerviewfirebase.R
import com.byron.recyclerviewfirebase.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    //El bylazy es para inicializar solo cuando se necesite, esto permite ahorro de memoria al momento de inicialziar variable al inicio de la app
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager (this)
        //seteamos el adaptador al recyclerview
        recyclerView.adapter = adapter

     /*   val dummyList = mutableListOf<User>()
        dummyList.add(User("https://i.pinimg.com/originals/c7/d0/7d/c7d07d304c5ad09f58855e2fadb769ec.jpg",
            "Android", "Tutorial RecyclerView"))
        dummyList.add(User("https://www.enter.co/wp-content/uploads/2014/09/android1.jpg",
            "Android", "Tutorial RecyclerView"))
        dummyList.add(User("https://i.pinimg.com/originals/f5/b6/f8/f5b6f802e4889096e1bc4811db6e957e.jpg",
            "Android", "Tutorial RecyclerView"))
        dummyList.add(User("https://i.pinimg.com/originals/c7/d0/7d/c7d07d304c5ad09f58855e2fadb769ec.jpg",
            "Android", "Tutorial RecyclerView"))
        dummyList.add(User("https://www.enter.co/wp-content/uploads/2014/09/android1.jpg",
            "Android", "Tutorial RecyclerView"))
        dummyList.add(User("https://i.pinimg.com/originals/f5/b6/f8/f5b6f802e4889096e1bc4811db6e957e.jpg",
            "Android", "Tutorial RecyclerView"))
        //enviamos la información al adapter
        adapter.setListData(dummyList)
        //actualizamos el recyclerview para mostrar la información
        adapter.notifyDataSetChanged()*/
        observeData()

    }

    /**
     * Después de llamar a observer
     */

    fun observeData(){
        viewModel.fetchUserData().observe(this, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}