package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.e("aki","fragmentB onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("aki","fragmentB onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View=inflater.inflate(R.layout.fragment_b,container,false)
        return view
        Log.e("aki","fragmentB onCreateView")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("aki","fragmentB onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("aki","fragmentB onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("aki","fragmentB onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("aki","fragmentB onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("aki","fragmentB onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("aki","fragmentB onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("aki","fragmentB onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("aki","fragmentB onDetach")
    }
}