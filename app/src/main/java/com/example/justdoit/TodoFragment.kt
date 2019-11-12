package com.example.justdoit


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_habits.*
import kotlinx.android.synthetic.main.fragment_todo.*

/**
 * A simple [Fragment] subclass.
 */
class TodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fbtn_add_todo.setOnClickListener{
            Toast.makeText(activity?.applicationContext,"Add Todo Cliecked", Toast.LENGTH_SHORT).show()
        }
    }
}

