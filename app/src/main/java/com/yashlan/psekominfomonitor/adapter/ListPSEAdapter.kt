package com.yashlan.psekominfomonitor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yashlan.psekominfomonitor.data.model.PSE
import com.yashlan.psekominfomonitor.databinding.ItemListPseBinding

class ListPSEAdapter(
    private val listPSE: ArrayList<PSE>
) : RecyclerView.Adapter<ListPSEAdapter.ListViewHolder>() {

    inner class ListViewHolder(
        private val binding: ItemListPseBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(p: PSE) {
            with(binding) {
                tvName.text = p.nama
                tvStatusId.text = p.statusId
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder = ListViewHolder(
        ItemListPseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) = holder.bind(listPSE[position])

    override fun getItemCount(): Int = listPSE.size
}