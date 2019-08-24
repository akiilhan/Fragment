package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

    fun addFragmentA(v: View) {
        var fragmentA=FragmentA() // -> Önce nesne tanımlıyoruz.
        var transaction= manager.beginTransaction()//-> fragment işlemi başlatıyoruz.
        transaction.add(R.id.container,fragmentA,"FragA") //->
        transaction.commit()
    }
    fun addFragmentB(View:View){
        var fragmentB = FragmentB()
        var transaction=manager.beginTransaction()
        transaction.add(R.id.container,fragmentB,"fragB")
        transaction.commit()
    }
    /**fun removeFragmentA(view:View){

          var fragmentA= manager.findFragmentByTag("FragA") as FragmentA
        var transaction=manager.beginTransaction()
        if (fragmentA!=null){
            transaction.remove(fragmentA)
            transaction.commit()
        }
        else {
            Toast.makeText(this,"Fragment A bulunamadı",Toast.LENGTH_LONG).show()
        }
    }*/
    fun removeFragmentA(v: View) {

        val fragmentA = manager.findFragmentByTag("FragA") as FragmentA?
        val transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.remove(fragmentA)
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }

    }
    fun removeFragmentB(view:View){

        var fragmentB= manager.findFragmentByTag("fragB") as FragmentB?
        var transaction=manager.beginTransaction()
        if (fragmentB!=null){
            transaction.remove(fragmentB)
            transaction.commit()
        } else Toast.makeText(this,"Fragment B bulunamadı",Toast.LENGTH_LONG).show()


    }


}
