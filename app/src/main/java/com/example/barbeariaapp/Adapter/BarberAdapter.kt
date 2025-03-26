package com.example.barbeariaapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbeariaapp.Model.BarberItem
import com.example.barbeariaapp.databinding.ItemBarberBinding

class BarberAdapter(
    private val items: List<BarberItem>,
    private val onItemClick: (BarberItem) -> Unit
) : RecyclerView.Adapter<BarberAdapter.BarberViewHolder>() {
    inner class BarberViewHolder(private val binding: ItemBarberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(items[position])
                }
            }
        }

        fun bind(item: BarberItem) {
            binding.tvTitle.text = item.title
            binding.tvSubtitle.text = item.subtitle
            binding.tvHorarioDisponivel.text = item.horario
            binding.ivLogo.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarberViewHolder {
        val binding = ItemBarberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BarberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BarberViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
