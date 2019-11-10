package com.example.justdoit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*

class MainActivity : AppCompatActivity() {
    lateinit var habitsFragment:HabitsFragment
    lateinit var dailyFragment: DailyFragment
    lateinit var todoFragment: TodoFragment
    lateinit var profileFragment: ProfileFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_nav)

            habitsFragment = HabitsFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout,habitsFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.fragment_habits ->{
                    habitsFragment = HabitsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,habitsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.fragment_daily ->{
                    dailyFragment = DailyFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,dailyFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.fragment_todo ->{
                    todoFragment = TodoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,todoFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.fragment_profile ->{
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
}
