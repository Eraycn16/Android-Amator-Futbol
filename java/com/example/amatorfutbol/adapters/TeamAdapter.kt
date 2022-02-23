package com.example.amatorfutbol.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amatorfutbol.databinding.TeamRowBinding
import com.example.amatorfutbol.models.TeamModel

class TeamAdapter(val arr: ArrayList<TeamModel>) : RecyclerView.Adapter<TeamAdapter.MyViewHolder>(){

    class MyViewHolder(val bind:TeamRowBinding):RecyclerView.ViewHolder(bind.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val bind = TeamRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(bind)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = arr.get(position)

        holder.bind.apply {
            team.setText(item.teamName)
            teamDraw.setText(item.tDraw)
            teamLose.setText(item.tLose)
            teamMatch.setText(item.tMatch)
            teamPoint.setText(item.tPoint)
            teamWin.setText(item.tWin)
        }
    }

    override fun getItemCount(): Int {
       return arr.size
    }
}