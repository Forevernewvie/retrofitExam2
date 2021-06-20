package com.jaebin.retrofitexample.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaebin.retrofitexample.data.DailyBoxOffice
import com.jaebin.retrofitexample.databinding.MoviecardBinding

class RecyclerAdapter(val dailyBoxOfficeList: List<DailyBoxOffice>) :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MoviecardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data =dailyBoxOfficeList[position]

        holder.itembinding.movieRank.text = data.rank
        holder.itembinding.movieName.text = data.movieNm
        holder.itembinding.movieYear.text = data.openDt


    }

    override fun getItemCount(): Int {
        return dailyBoxOfficeList.size
    }

    class ViewHolder(val itembinding:MoviecardBinding) : RecyclerView.ViewHolder(itembinding.root)
}