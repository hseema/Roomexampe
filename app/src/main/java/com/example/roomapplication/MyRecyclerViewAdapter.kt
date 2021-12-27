package com.example.roomapplication


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplication.databinding.ListItemBinding
import com.example.roomapplication.db.Subscriber

class MyRecyclerViewAdapter() : RecyclerView.Adapter<MyViewHolder>()
{
    private var subscribersList: List<Subscriber> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
      val binding : ListItemBinding =
          DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
      return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return subscribersList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(subscribersList[position])
    }

    fun setList(list:List<Subscriber>){
        subscribersList = list
        notifyDataSetChanged()
    }

}

class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(subscriber: Subscriber){
          binding.nameTextView.text = subscriber.name
          binding.emailTextView.text = subscriber.email
    }
}