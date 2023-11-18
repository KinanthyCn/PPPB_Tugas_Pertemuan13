package com.kinan.tugas_pertemuan_12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kinan.tugas_pertemuan_12.databinding.ItemDuckBinding
import com.kinan.tugas_pertemuan_12.model.Bebek

class DuckAdapter (
    private val listBebek: List<Duck>
) : RecyclerView.Adapter<DuckAdapter.ItemDuckViewHolder>(){
    inner class ItemDuckViewHolder(private val binding: ItemDuckBinding)
     :RecyclerView.ViewHolder(binding.root){
            fun bind(data: Duck){
                with(binding){


                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDuckViewHolder {
        val binding = ItemDuckBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemDuckViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBebek.size
    }

    override fun onBindViewHolder(holder: ItemDuckViewHolder, position: Int) {
        holder.bind(listBebek[position])
    }

}


