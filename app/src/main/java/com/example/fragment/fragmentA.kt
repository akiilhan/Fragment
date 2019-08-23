package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentA : Fragment() {

    //->fragment çalıştığında bir layout olmalı.Onu oluşturmalısın.


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("aki","fragmentA onAttach")
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View=inflater.inflate(R.layout.fragment_a,container,false)
        Log.d("aki","fragmentA onCreateView")

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("aki","fragmentA onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("aki","fragmentA onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("aki","fragmentA onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("aki","fragmentA onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("aki","fragmentA onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("aki","fragmentA onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("aki","fragmentA onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("aki","fragmentA onDetach")
    }


}
