package org.dogadaev.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.dogadaev.entity.Diary
import org.dogadaev.home.databinding.ItemDairyLayoutBinding

typealias OnItemClickListener = (Diary) -> Unit

class DairiesAdapter(
    private val onItemClicked: OnItemClickListener,
    private val onItemLongClicked: OnItemClickListener,
) : ListAdapter<Diary, DairiesAdapter.ViewHolder>(DiffCallback()) {

    private class DiffCallback : DiffUtil.ItemCallback<Diary>() {
        override fun areItemsTheSame(oldItem: Diary, newItem: Diary) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Diary, newItem: Diary) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemDairyLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
        onItemClicked,
        onItemLongClicked,
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(
        private val binding: ItemDairyLayoutBinding,
        private val onItemClicked: OnItemClickListener,
        private val onItemLongClicked: OnItemClickListener,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Diary) {
            binding.apply {
                container.setOnLongClickListener {
                    onItemLongClicked(item)
                    true
                }
                container.setOnClickListener {
                    onItemClicked(item)
                }
                title.text = item.title
                description.text = item.description
            }
        }
    }
}