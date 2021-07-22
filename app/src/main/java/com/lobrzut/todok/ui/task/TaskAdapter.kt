package com.lobrzut.todok.ui.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lobrzut.todok.database.TaskEntry
import com.lobrzut.todok.databinding.RowLayoutBinding

class TaskAadapter : ListAdapter<TaskEntry, TaskAadapter.ViewHolder>(TaskDiffCallback) {

    companion object TaskDiffCallback : DiffUtil.ItemCallback<TaskEntry>(){
        override fun areItemsTheSame(oldItem: TaskEntry, newItem: TaskEntry) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: TaskEntry, newItem: TaskEntry) = oldItem == newItem

        }


    class ViewHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(taskEntry: TaskEntry){
            binding.taskEntry = taskEntry
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }
}