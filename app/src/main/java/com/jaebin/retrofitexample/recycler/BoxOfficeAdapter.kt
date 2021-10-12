package com.jaebin.retrofitexample.recycler


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaebin.retrofitexample.contract.BoxOfficeAdapterContract
import com.jaebin.retrofitexample.contract.OnItemClick
import com.jaebin.retrofitexample.data.DailyBoxOffice
import com.jaebin.retrofitexample.databinding.MoviecardBinding

class BoxOfficeAdapter :RecyclerView.Adapter<BoxOfficeAdapter.ViewHolder>(),
BoxOfficeAdapterContract.Model,BoxOfficeAdapterContract.View{

    private var movieData:List<DailyBoxOffice> = listOf()
    private lateinit var onItemClick: OnItemClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MoviecardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getData(position)
        holder.itemBinding.movieRank.text = data.rank
        holder.itemBinding.movieName.text = data.movieNm
        holder.itemBinding.movieYear.text = data.openDt
        holder.itemView.setOnClickListener{
            onItemClick.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    class ViewHolder(val itemBinding:MoviecardBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun setOnClickListener(clickListener: OnItemClick) {
        this.onItemClick = clickListener
    }


    override fun setData(contents: List<DailyBoxOffice>) {
        this.movieData= contents
    }

    override fun getData(pos: Int): DailyBoxOffice {
        return movieData[pos]
    }
}