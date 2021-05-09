package org.dogadaev.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.dogadaev.entity.Dairy
import org.dogadaev.home.databinding.ItemDairyLayoutBinding
import org.dogadaev.presentation.viewmodel.HomeViewModel

typealias OnItemLongClickListener = (Dairy) -> Unit

class DairiesAdapter(
    private val longClickListener: OnItemLongClickListener
): ListAdapter<Dairy, DairiesAdapter.ViewHolder>(DiffCallback()) {

    private class DiffCallback : DiffUtil.ItemCallback<Dairy>() {
        override fun areItemsTheSame(oldItem: Dairy, newItem: Dairy) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Dairy, newItem: Dairy) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemDairyLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
        longClickListener
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(
        private val binding: ItemDairyLayoutBinding,
        private val longClickListener: OnItemLongClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Dairy) {
            binding.apply {
                container.setOnLongClickListener {
                    longClickListener(item)
                    true
                }
                title.text = item.title
                description.text = item.description
            }
        }
    }
}