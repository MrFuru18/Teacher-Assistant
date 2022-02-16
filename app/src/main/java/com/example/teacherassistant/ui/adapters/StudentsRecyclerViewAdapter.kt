package com.example.teacherassistant.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.StudentsData
import kotlinx.android.synthetic.main.student_element.view.*

class StudentsRecyclerViewAdapter: RecyclerView.Adapter<StudentsRecyclerViewAdapter.ViewHolder>() {

    private var studentsList = emptyList<StudentsData>()

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_element, parent, false))
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = studentsList[position]
        holder.itemView.text_id.text = currentItem.id.toString()
        holder.itemView.text_firstName.text = currentItem.firstName
        holder.itemView.text_lastName.text = currentItem.lastName
    }

    fun setData(students: List<StudentsData>){
        this.studentsList = students
        notifyDataSetChanged()
    }
}