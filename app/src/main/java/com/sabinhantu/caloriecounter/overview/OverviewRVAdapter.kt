package com.sabinhantu.caloriecounter.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sabinhantu.caloriecounter.database.FoodModel
import com.sabinhantu.caloriecounter.databinding.ItemFoodOverviewBinding

class OverviewRVAdapter : RecyclerView.Adapter<OverviewRVAdapter.ViewHolder>()  {

    var data = listOf<FoodModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewRVAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: OverviewRVAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    class ViewHolder private constructor(val binding: ItemFoodOverviewBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFoodOverviewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: FoodModel) {
            binding.tvItemOverviewName.text = item.name
            binding.tvItemOverviewGrams.text = item.grams.toString()
            binding.tvItemOverviewKcal.text = item.kcal.toString()
            binding.tvItemOverviewCarbs.text = item.carbs.toString() + " g"
            binding.tvItemOverviewProteins.text = item.proteins.toString()
            binding.tvItemOverviewFats.text = item.fats.toString()
        }

    }

}