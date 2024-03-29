package com.example.teacherassistant.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.StudentsInCourseData
import com.example.teacherassistant.ui.courses.CourseFragmentDirections
import com.example.teacherassistant.ui.courses.CoursesFragmentDirections
import kotlinx.android.synthetic.main.course_element.view.*
import kotlinx.android.synthetic.main.student_element.view.*

class StudentsInCourseAdapter: RecyclerView.Adapter<StudentsInCourseAdapter.ViewHolder>() {

    private var studentsList = emptyList<StudentsInCourseData>()

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_element, parent, false))
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = studentsList[position]
        holder.itemView.text_id.text = currentItem.idStudent.toString()
        holder.itemView.text_firstName.text = currentItem.firstName
        holder.itemView.text_lastName.text = currentItem.lastName

        holder.itemView.studentElementLayout.setOnClickListener {
            val action = CourseFragmentDirections.actionCourseFragmentToGradesFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(students: List<StudentsInCourseData>){
        this.studentsList = students
        notifyDataSetChanged()
    }
}