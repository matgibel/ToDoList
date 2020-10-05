package com.example.todolist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var ToDoArray = ArrayList<ToDoMemo>()

    private lateinit var td_adapter: ToDoAdapter
    //lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creation of AlertDialog Prompt (Built-in tool)
        val dialog = AlertDialog.Builder(this)
        //Inflating popuplayout and setting item to "dialogView
        val dialogView = layoutInflater.inflate(R.layout.popuplayout,null)
        //finding of edit text "et_enter_todo" and setting it to the value "et_input"
        val et_input = dialogView.findViewById<EditText>(R.id.et_enter_todo)

        // inflation of popuplayout that was set to dialogView and inputting
        // into AlertDialog
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.setPositiveButton("Submit", { dialogInterface : DialogInterface, i -> Int })

        //Creation of dialog and value stored in "customDialog"
        val customDialog = dialog.create()
        customDialog.show()

        //Addition of a clickable button (Button Positive) - setOnClickListener
        customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener{

            if(et_input.text.length > 5){
                Toast.makeText(baseContext, "Input Logged" , Toast.LENGTH_SHORT).show()

                var tmp = et_input.toString()

                var tdm: ToDoMemo = ToDoMemo(tmp)

                ToDoArray.add(tdm)

                customDialog.dismiss()
            }

            else{
                Toast.makeText(baseContext , "Input Invalid", Toast.LENGTH_SHORT).show()
            }

        }


        //Place initRecyclerView
        initRecyclerView()

    }


    private fun initRecyclerView(){
        //Calling the recycler view that was instantiated in activity_main
        rv_to_do_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            td_adapter = ToDoAdapter(ToDoArray)
            adapter = td_adapter
        }

        /**
         * Alternitive
         *
         * rv_to_do_list.layoutManager = LinearLayoutManager(this@MainActivity)
         * adapter = ToDoAdapter()
         * rv_to_do_list.adapter = adapter
         *
         */


    }

}