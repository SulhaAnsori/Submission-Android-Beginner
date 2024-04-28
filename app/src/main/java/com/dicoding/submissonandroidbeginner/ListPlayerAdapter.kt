package com.dicoding.submissonandroidbeginner

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPlayerAdapter(private val listPlayer: ArrayList<Player>) :
    RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvRate: TextView = itemView.findViewById(R.id.tv_item_rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_player, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPlayer.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listPlayer[position]
        Log.d("Adapter", "onBindViewHolder data position: $position")
        holder.imgPhoto.setImageResource(data.photo)
        holder.tvName.text = data.name
        holder.tvRate.text = data.rate
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val moveIntent = Intent(context, DetailActivity::class.java)
           moveIntent.putExtra(DetailActivity.EXTRA_NAME, listPlayer[position])
            context.startActivity(moveIntent)
        }
    }
}