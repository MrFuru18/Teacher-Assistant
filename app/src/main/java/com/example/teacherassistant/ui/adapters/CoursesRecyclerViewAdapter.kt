package com.example.teacherassistant.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.CoursesData
import kotlinx.android.synthetic.main.course_element.view.*

class CoursesRecyclerViewAdapter: RecyclerView.Adapter<CoursesRecyclerViewAdapter.ViewHolder>() {

    private var coursesList = emptyList<CoursesData>()

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.course_element, parent, false))
    }

    override fun getItemCount(): Int {
        return coursesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = coursesList[position]
        holder.itemView.text_courseName.text = currentItem.name
        holder.itemView.text_day.text = currentItem.day
        holder.itemView.text_timeBlock.text = currentItem.timeBlock
    }

    fun setData(courses: List<CoursesData>){
        this.coursesList = courses
        notifyDataSetChanged()
    }
}