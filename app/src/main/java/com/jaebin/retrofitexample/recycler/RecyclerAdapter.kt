package com.jaebin.retrofitexample.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.jaebin.retrofitexample.data.DailyBoxOffice
import com.jaebin.retrofitexample.databinding.MoviecardBinding

class RecyclerAdapter(val dailyBoxOfficeList: List<DailyBoxOffice>) :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var temp : DailyBoxOffice
    private lateinit var database : FirebaseDatabase
    private lateinit var myRef : DatabaseReference

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MoviecardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding).apply {
            itemView.setOnClickListener {
                val curPos = adapterPosition
                val data :DailyBoxOffice =  dailyBoxOfficeList.get(curPos)
                temp = DailyBoxOffice(data.movieNm,data.openDt,data.rank)
                database = FirebaseDatabase.getInstance()
                myRef = database.getReference()
                myRef.child("영화").setValue(temp)

                Toast.makeText(parent.context,"추가되었습니다",Toast.LENGTH_SHORT).show()
            }



        }
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