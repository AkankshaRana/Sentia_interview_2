package com.example.sentia2.presentation.propertyList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sentia2.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PropertyListFragment : Fragment() {

    private val viewModel: PropertyListViewModel by viewModels()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>
    private lateinit var recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_property_list, container, false)

        val properties = viewModel.propertyList

        linearLayoutManager = LinearLayoutManager(context)
        recycler_view = v.findViewById(R.id.property_list_recyclerview)
        recycler_view.layoutManager = linearLayoutManager

        properties.observe(viewLifecycleOwner, Observer {
            val progressbar : ProgressBar=  v.findViewById(R.id.progressbar)
            progressbar.isVisible = false

            adapter = PropertyAdapter(
                it
            ){ position -> onListItemClick(position) }
            recycler_view.adapter = adapter
        })

        return v
    }

    //Click listener for recyclerview list item
    private fun onListItemClick(
        position: Int,
    ) {
        val bundle = Bundle()
        viewModel.propertyList
        bundle.putParcelable("propertyDetail", viewModel.propertyList.value?.get(position))
        findNavController().navigate(
            R.id.action_propertyListFragment_to_propertyDetailFragment,
            bundle
        )
    }
}