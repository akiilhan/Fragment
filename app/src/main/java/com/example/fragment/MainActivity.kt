package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.extensions.LayoutContainer


class MainActivity : AppCompatActivity() {
    var manager  =supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun addFragmentA(view: View) {
        var fragmentA=FragmentA() // -> Önce nesne tanımlıyoruz.
        var transaction= manager.beginTransaction()//-> fragment işlemi başlatıyoruz.
        transaction.add(R.id.container,fragmentA,"Fragment A") //->
        transaction.commit()
    }
    fun addFragmentB(view:View){
        var fragmentB = FragmentB()
        var transaction=manager.beginTransaction()
        transaction.add(R.id.container,fragmentB,"frangment b")
        transaction.commit()

    }


}
