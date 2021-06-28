package com.example.sentia2.presentation.propertyDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sentia2.R
import com.example.sentia2.domain.model.Property


class PropertyDetailFragment : Fragment() {

    lateinit var propertyDetail: Property

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Reading bundle arguments
        arguments?.getParcelable<Property>("propertyDetail")?.let { property ->
            propertyDetail = property
            Log.d("Detail Fragment:", property.description)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_property_detail, container, false)

        var textview: TextView = view.findViewById(R.id.detail_textview)
        textview.text = propertyDetail.description

        return view
    }
}