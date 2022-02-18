package com.example.teacherassistant.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.GradesData
import kotlinx.android.synthetic.main.grade_element.view.*

class GradesAdapter: RecyclerView.Adapter<GradesAdapter.ViewHolder>() {

    private var gradesList = emptyList<GradesData>()

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.grade_element, parent, false))
    }

    override fun getItemCount(): Int {
        return gradesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = gradesList[position]
        holder.itemView.text_category.text = currentItem.category
        holder.itemView.text_grade.text = currentItem.grade.toString()
        holder.itemView.text_comment.text = currentItem.comm

    }

    fun setData(grades: List<GradesData>){
        this.gradesList = grades
        notifyDataSetChanged()
    }
}