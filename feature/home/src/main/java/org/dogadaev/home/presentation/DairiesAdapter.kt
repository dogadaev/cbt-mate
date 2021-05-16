package org.dogadaev.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.dogadaev.entity.Diary
import org.dogadaev.home.databinding.ItemDairyLayoutBinding
import org.dogadaev.navigation.NavigationGraph
import org.dogadaev.navigation.Navigator

typealias OnItemLongClickListener = (Diary) -> Unit

class DairiesAdapter(
    private val longClickListener: OnItemLongClickListener,
    private val navigator: Navigator
): ListAdapter<Diary, DairiesAdapter.ViewHolder>(DiffCallback()) {

    private class DiffCallback : DiffUtil.ItemCallback<Diary>() {
        override fun areItemsTheSame(oldItem: Diary, newItem: Diary) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Diary, newItem: Diary) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemDairyLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
        longClickListener,
        navigator
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(
        private val binding: ItemDairyLayoutBinding,
        private val longClickListener: OnItemLongClickListener,
        private val navigator: Navigator
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Diary) {
            binding.apply {
                container.setOnLongClickListener {
                    longClickListener(item)
                    true
                }
                container.setOnClickListener {
                    // todo: do navigation in a proper place!
                    navigator.navigate(NavigationGraph.Diary(item.id))
                }
                title.text = item.title
                description.text = item.description
            }
        }
    }
}