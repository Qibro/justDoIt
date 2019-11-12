package com.example.justdoit


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.alertdialog_add_habits.*
import kotlinx.android.synthetic.main.fragment_habits.*

/**
 * A simple [Fragment] subclass.
 */
class HabitsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_habits, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fbtn_add_habits.setOnClickListener{
            val mBuilder = AlertDialog.Builder(activity!!)
            val view = LayoutInflater.from(activity?.applicationContext).inflate(R.layout.alertdialog_add_habits,null)
            mBuilder.setView(view)
            val alertDialog = mBuilder.create()
            alertDialog.show()
        }
    }
}

