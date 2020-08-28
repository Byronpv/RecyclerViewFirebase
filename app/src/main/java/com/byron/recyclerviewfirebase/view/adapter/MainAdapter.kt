package com.byron.recyclerviewfirebase.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.byron.recyclerviewfirebase.R
import com.byron.recyclerviewfirebase.domain.data.User
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    //creamos la lista, donde la implementación retorna un ArrayList
    private var dataList: MutableList<User> = mutableListOf<User>()
    // seteamos la lista

    fun setListData(data: MutableList<User>){
        dataList = data
    }

    // el viewType sirve para switchear las vistas de cómo queremos que se vean por ejemplo en la segunda vista se vea la imagen a la derecha y la descripción a la izquierda y viceversa
    // el parent es el contenedor que va a encerrar todos los datos, retorna la vista (item_row)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)

        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(dataList.size > 0){ dataList.size } else {0}
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = dataList[position]
        holder.bindView(user)
    }

    inner class MainViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

        fun bindView(user: User){
            Glide.with(context).load(user.imageUrl).into(itemView.imageProfile)
            itemView.tvTitle.text = user.nombre
            itemView.tvDescrption.text = user.decripcion

        }

    }
}