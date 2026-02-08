package com.mabf.pawsy.ui.animals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mabf.pawsy.databinding.ItemAnimalBinding
import com.mabf.pawsy.domain.model.Animal

class AnimalAdapter(
    private val onItemClick: (Animal) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private val items = mutableListOf<Animal>()

    fun submitList(newItems: List<Animal>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ItemAnimalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class AnimalViewHolder(
        private val binding: ItemAnimalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(animal: Animal) {
            // "Aquí pinto lo básico para la lista"
            binding.tvName.text = animal.name
            binding.tvInfo.text = "Edad aprox: ${animal.estimatedAge} · ${animal.species} · ${animal.adoptionStatus}"

            binding.root.setOnClickListener {
                onItemClick(animal)
            }
        }
    }
}