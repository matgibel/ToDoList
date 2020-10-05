package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.to_do_item.view.*

class ToDoAdapter (val toDoList: ArrayList<ToDoMemo>) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){


    private var items = toDoList

    class ToDoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //Binding of "tv_todo_item" within to "to_do_item" layout to the val toDoItem
        val toDoItem: TextView = itemView.tv_todo_item

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.to_do_item,
        parent,false)

        return ToDoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {

        holder.toDoItem.tv_todo_item.text = items[position].ToDoItem

    }
}