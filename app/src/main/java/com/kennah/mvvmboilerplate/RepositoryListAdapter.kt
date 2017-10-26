package com.kennah.mvvmboilerplate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kennah.mvvmboilerplate.databinding.HolderRepositoryBinding
import com.kennah.mvvmboilerplate.model.GithubRepo

class RepositoryListAdapter: RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {

    private var items = mutableListOf<GithubRepo>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = HolderRepositoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun setData(data: List<GithubRepo>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: HolderRepositoryBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: GithubRepo) {
            binding.repository = repo
            binding.executePendingBindings()

            Glide.with(binding.root.context)
                    .load(repo.owner?.avatarUrl)
                    .into(binding.icon)
        }
    }
}