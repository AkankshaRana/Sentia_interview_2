package com.example.sentia2.presentation.propertyList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sentia2.R
import com.example.sentia2.domain.model.Property

class PropertyAdapter(

    private var properties: List<Property>,
    private val onItemClicked: (position: Int) -> Unit

    ) : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>()
{
    //Default images for Property and agent
    private val DEFAULT_PROPERTY_IMAGE = R.drawable.ic_outline_apartment_24
    private val DEFAULT_AGENT_IMAGE = R.drawable.ic_launcher_foreground

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.property_card, parent, false)
        return PropertyViewHolder(view, onItemClicked)
    }

    override fun getItemCount(): Int {
        return properties.size
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val property = properties[position]
        holder.propertyImageView

        //Load the url for propertyImage
        Glide.with(holder.propertyImageView)
            .load(property.property_images[0].attachment.url)
            .centerCrop()
            .placeholder(DEFAULT_PROPERTY_IMAGE)
            .error(DEFAULT_PROPERTY_IMAGE)
            .into(holder.propertyImageView)

        //Load the url fro agent image
        Glide.with(holder.agentImageView)
            .load(property.agent.avatar.small.url)
            .placeholder(DEFAULT_AGENT_IMAGE)
            .error(DEFAULT_AGENT_IMAGE)
            .override(150,150)
            .thumbnail(0.25f)
            .centerCrop()
            .into(holder.agentImageView)

        holder.propertyPriceTextView.text = property.display_price
        holder.agentNameTextView.text = property.agent.first_name
        holder.addressTextView.text = property.location.address
        holder.bedroomTextView.text = property.bedrooms.toString()
        holder.bathroomTextView.text = property.bathrooms.toString()
        holder.carspaceTextView.text = property.carspaces.toString()

    }

    class PropertyViewHolder(
        view: View,
        private val onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(view),
        View.OnClickListener{

        internal var propertyImageView: ImageView
        internal var agentImageView: ImageView
        internal var propertyPriceTextView: TextView
        internal var agentNameTextView: TextView
        internal var addressTextView: TextView
        internal var bedroomTextView: TextView
        internal var bathroomTextView: TextView
        internal var carspaceTextView: TextView

        init {

            propertyImageView = view.findViewById(R.id.property_imageview)
            agentImageView = view.findViewById(R.id.agent_imageview)
            propertyPriceTextView =  view.findViewById(R.id.property_price_textview)
            agentNameTextView = view.findViewById(R.id.agent_name_textview)
            addressTextView = view.findViewById(R.id.address_textview)
            bedroomTextView = view.findViewById(R.id.bedroom_textview)
            bathroomTextView = view.findViewById(R.id.bathroom_textview)
            carspaceTextView = view.findViewById(R.id.carspace_textview)

            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val position = absoluteAdapterPosition
            onItemClicked(position)
        }
    }
}
