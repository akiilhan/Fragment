/**package com.example.emrealtunbilek.fragmentbackstack

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    internal var manager: FragmentManager

    protected fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = getFragmentManager()
        manager.addOnBackStackChangedListener(this)
    }


    fun addFragmentA(v: View) {

        val fragmentA = FragmentA()

        val transaction = manager.beginTransaction()
        transaction.add(R.id.container, fragmentA, "fragA")
        transaction.addToBackStack("addFragA")
        transaction.commit()


    }

    fun addFragmentB(v: View) {

        val fragmentB = FragmentB()

        val transaction = manager.beginTransaction()
        transaction.add(R.id.container, fragmentB, "fragB")
        transaction.addToBackStack("addFragB")
        transaction.commit()

    }

    fun removeFragmentA(v: View) {

        val fragmentA = manager.findFragmentByTag("fragA") as FragmentA
        val transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.remove(fragmentA)
            transaction.addToBackStack("removeFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }

    }

    fun removeFragmentB(v: View) {
        val fragmentB = manager.findFragmentByTag("fragB") as FragmentB
        val transaction = manager.beginTransaction()
        if (fragmentB != null) {
            transaction.remove(fragmentB)
            transaction.addToBackStack("removeFragB")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment B bulunamadı", Toast.LENGTH_LONG).show()
        }

    }

    fun replaceByFragmentA(v: View) {

        val fragmentA = FragmentA()
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragmentA, "fragA")
        transaction.addToBackStack("replaceFragA")
        transaction.commit()

    }

    fun replaceByFragmentB(v: View) {

        val fragmentB = FragmentB()
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragmentB, "fragB")
        transaction.addToBackStack("replaceFragB")
        transaction.commit()

    }

    fun attachFragmentA(v: View) {

        val fragmentA = manager.findFragmentByTag("fragA") as FragmentA
        val transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.attach(fragmentA)
            transaction.addToBackStack("attachFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }


    }

    fun detachFragmentA(v: View) {

        val fragmentA = manager.findFragmentByTag("fragA") as FragmentA
        val transaction = manager.beginTransaction()
        if (fragmentA != null) {
            transaction.detach(fragmentA)
            transaction.addToBackStack("detachFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }


    }

    fun showFragmentA(v: View) {


        val fragmentA = manager.findFragmentByTag("fragA") as FragmentA
        val transaction = manager.beginTransaction()

        if (fragmentA != null) {
            transaction.show(fragmentA)
            transaction.addToBackStack("showFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }


    }

    fun hideFragmentA(v: View) {

        val fragmentA = manager.findFragmentByTag("fragA") as FragmentA
        val transaction = manager.beginTransaction()

        if (fragmentA != null) {
            transaction.hide(fragmentA)
            transaction.addToBackStack("hideFragA")
            transaction.commit()
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show()
        }

    }

    fun backButton(v: View) {

        manager.popBackStack()

    }

    fun popAddAInclusive(v: View) {

        manager.popBackStack("addFragA", FragmentManager.POP_BACK_STACK_INCLUSIVE)

    }

    fun popAddB(v: View) {

        manager.popBackStack("addFragB", 0)

    }


    override fun onBackStackChanged() {

        val elemanSayisi = manager.backStackEntryCount

        val mesaj = StringBuilder("")

        for (i in elemanSayisi - 1 downTo 0) {
            mesaj.append("Index ").append(i).append(" : ")
            mesaj.append(manager.getBackStackEntryAt(i).name)
            mesaj.append(" \n")

        }

        Log.e("EMRE", "$mesaj \n")


    }
}*/