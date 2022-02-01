package org.dogadaev.diary.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.dogadaev.entity.Diary

//class EntriesAdapter
//    : ListAdapter<Diary.Entry, EntriesAdapter.ViewHolder>(DiffCallback()) {
//
//    private class DiffCallback : DiffUtil.ItemCallback<Diary.Entry>() {
//        override fun areItemsTheSame(oldItem: Diary.Entry, newItem: Diary.Entry) = oldItem.timestamp == newItem.timestamp
//        override fun areContentsTheSame(oldItem: Diary.Entry, newItem: Diary.Entry) = oldItem == newItem
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
//        ViewDiaryEntryLayoutBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false
//        ),
//    )
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(currentList[position])
//    }
//
//    class ViewHolder(
//        private val binding: ViewDiaryEntryLayoutBinding,
//    ) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(item: Diary.Entry) {
//            binding.testText.text = item.situationDescription
//        }
//    }
//}