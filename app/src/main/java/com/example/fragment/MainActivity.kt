package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.extensions.LayoutContainer


class MainActivity : AppCompatActivity(),FragmentManager.OnBackStackChangedListener {
    override fun onBackStackChanged() {

        var elemanSayisi=manager.backStackEntryCount
        var mesaj =StringBuilder("")

        for (i in elemanSayisi-1 downTo 0  ){
            mesaj.append("Index ").append(i).append(" : ")
            mesaj.append(manager.getBackStackEntryAt(i).name)
            mesaj.append(" \n")
        }
        Log.e("aki","$mesaj \n")
    }

    var manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager.addOnBackStackChangedListener(this)

    }

    fun addFragmentA(v: View) {

        //İlgili Layout'a fragmentA'yı ekleyen fonksyon

        var fragmentA = FragmentA() // -> Önce nesne tanımlıyoruz.
        var transaction = manager.beginTransaction()//-> fragment işlemi başlatıyoruz.
        transaction.add(R.id.container, fragmentA, "FragA")
        transaction.addToBackStack("addFragA")

        transaction.commit()
    }

    fun addFragmentB(View: View) {
        //İlgili Layout'a fragmentB'yı ekleyen fonksyon
        var fragmentB = FragmentB()
        var transaction = manager.beginTransaction()
        transaction.add(R.id.container, fragmentB, "fragB")
        transaction.addToBackStack("addFragB")
        transaction.commit()
    }

    fun removeFragmentA(v: View) {
        //İlgili Layout'tan fragmentA'yı çıkaran fonksyon
        val fragmentA = manager.findFragmentByTag("FragA") as FragmentA?
        val transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.remove(fragmentA)
            transaction.addToBackStack("removeFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }

    }

    fun removeFragmentB(view: View) {
        //İlgili Layout'tan fragmentA'yı çıkaran fonksyon

        var fragmentB = manager.findFragmentByTag("fragB") as FragmentB?
        var transaction = manager.beginTransaction()
        if (fragmentB != null) {
            transaction.remove(fragmentB)
            transaction.addToBackStack("removeFragB")
            transaction.commit()

        } else Toast.makeText(this, "Fragment B bulunamadı", Toast.LENGTH_LONG).show()

    }

    fun replaceByFragmentA(view: View) {
        //İlgili Layout'a fragmentA'ile değiştiriyor. (halihazırda fragment a ekli olsa bile)

        var fragmentA = FragmentA()
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragmentA, "FragA")
        transaction.addToBackStack("replaceFragA")
        transaction.commit()

    }

    fun replaceByFragmentB(view: View) {
        //İlgili Layout'a fragmentB'yı koyuyor. (halihazırda fragment b ekli olsa bile)

        var fragmentB = FragmentB()
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragmentB, "fragB")
        transaction.addToBackStack("replaceFragB")
        transaction.commit()
    }

    fun attachFragmentA(View: View) {
        val fragmentA = manager.findFragmentByTag("FragA") as FragmentA?

        var transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.attach(fragmentA)
            transaction.addToBackStack("attachFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show();
        }


    }

    fun detachFragmentA(view: View) {
        var fragmentA = manager.findFragmentByTag("FragA") as FragmentA
        var transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.detach(fragmentA)
            transaction.addToBackStack("detachFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }
    }

    fun showFragmentA(view: View) {
        var fragmentA = manager.findFragmentByTag("FragA") as FragmentA
        var transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.show(fragmentA)
            transaction.addToBackStack("showFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }

    }

    fun hideFragmentA(view: View) {
        var fragmentA = manager.findFragmentByTag("FragA") as FragmentA
        var transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.hide(fragmentA)
            transaction.addToBackStack("hideFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }


    }
    fun backButton(view: View){
        //telefonumuzdaki geri tuşunun yaptığı işi yapacak.

        // popBAckStack: geriye alma işlemlerini yapan bir yığın yapısıdır.En son eklenen elemandan bir geriye gelecek.
        manager.popBackStack()


    }
    fun popAddInclusive(view: View){
        // A'nın eklenme işlemini geri akla butonu
        manager.popBackStack("addFragA", POP_BACK_STACK_INCLUSIVE)


    }
    fun popAddB(view: View){
manager.popBackStack("addFragB",0)

    }


}






