package com.example.entrega4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.entrega4.CountryStuff.Country

class AdapterCountryPaging: PagingDataAdapter<Country, AdapterCountryPaging.CountryItem>(
    DIFF_CALLBACK
) {
    inner class CountryItem (v: View) : RecyclerView.ViewHolder(v)

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem.CountryId == newItem.CountryId
            }

            override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onBindViewHolder(holder: CountryItem, position: Int) {
        val item = getItem(position)

        holder.itemView.findViewById<TextView>(R.id.name_en).text = item?.name_en + " - " + item?.name_es
        holder.itemView.findViewById<TextView>(R.id.capital_es).text = item?.capital_es + " - " + item?.capital_es
        holder.itemView.findViewById<TextView>(R.id.continent_es).text = item?.continent_es + " - " + item?.continent_es
        holder.itemView.findViewById<TextView>(R.id.dial_code).text = item?.dial_code
        holder.itemView.findViewById<TextView>(R.id.code_2).text = item?.code_2
        holder.itemView.findViewById<TextView>(R.id.code_3).text = item?.code_3
        holder.itemView.findViewById<TextView>(R.id.tld).text = item?.tld
        holder.itemView.findViewById<TextView>(R.id.km2).text = item?.km2.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItem {
        return CountryItem(LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent,false))
    }

}