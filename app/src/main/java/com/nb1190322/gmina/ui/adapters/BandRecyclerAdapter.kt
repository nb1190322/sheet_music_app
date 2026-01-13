package com.nb1190322.gmina.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nb1190322.gmina.data_classes.Band
import com.nb1190322.gmina.databinding.ItemBandBinding

class BandAdapter(
    private val bands: List<Band>
) : RecyclerView.Adapter<BandAdapter.BandViewHolder>() {

    class BandViewHolder(private val binding: ItemBandBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(band: Band) {
            binding.textBandName.text = band.name
            binding.textRole.text = band.role
            binding.textStatus.text = band.status
            binding.root.setOnClickListener {
                // TODO: Implement band entry logic
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandViewHolder {
        val binding = ItemBandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BandViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BandViewHolder, position: Int) {
        val band = bands[position]
        holder.bind(band)
    }

    override fun getItemCount() = bands.size
}