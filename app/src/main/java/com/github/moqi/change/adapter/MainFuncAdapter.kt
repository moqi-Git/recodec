package com.github.moqi.change.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.moqi.change.R
import com.github.moqi.change.beans.FuncItemBean
import kotlinx.android.synthetic.main.item_main_func.view.*

class MainFuncAdapter(private val itemList: ArrayList<FuncItemBean>): RecyclerView.Adapter<MainFuncAdapter.MainFuncViewHolder>(){

    var clickEvent: ((view: View, position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFuncViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_func, parent, false)
        return MainFuncViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: MainFuncViewHolder, position: Int) {
        holder.bindView(itemList[position])
        clickEvent?.let {
            holder.bindEvent(position, it)
        }
    }


    class MainFuncViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(item: FuncItemBean){
            itemView.item_main_func_iv_icon.setImageResource(item.iconId)
            itemView.item_main_func_tv_title.text = item.title
            itemView.item_main_func_tv_desc.text = item.description
        }

        fun bindEvent(position: Int, event: ((view: View, position: Int) -> Unit)){
            itemView.item_main_func_cv.setOnClickListener {view->
                event.invoke(view, position)
            }
        }
    }
}