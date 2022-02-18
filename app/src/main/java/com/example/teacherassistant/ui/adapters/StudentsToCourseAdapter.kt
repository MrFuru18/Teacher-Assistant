package com.example.teacherassistant.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.StudentsData
import com.example.teacherassistant.model.entities.StudentsInCourseData
import com.example.teacherassistant.ui.AssistantViewModel
import com.example.teacherassistant.ui.courses.AddStudentToCourseFragmentDirections
import kotlinx.android.synthetic.main.fragment_add_student.*
import kotlinx.android.synthetic.main.student_element.view.*

class StudentsToCourseAdapter(private val assistantViewModel: AssistantViewModel, private val arg : CoursesData): RecyclerView.Adapter<StudentsToCourseAdapter.ViewHolder>() {

    private var studentsList = emptyList<StudentsData>()

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {}

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

        holder.itemView.studentElementLayout.setOnClickListener {
            insertDataToDatabase(holder, position)
            val action = AddStudentToCourseFragmentDirections.actionAddStudentToCourseFragmentToCourseFragment(arg)
            holder.itemView.findNavController().navigate(action)
        }
    }

    private fun insertDataToDatabase(holder: ViewHolder, position: Int) {
        val currentItem = studentsList[position]

        val idCourse = arg.id
        val name = arg.name
        val day = arg.day
        val timeBlock = arg.timeBlock
        val idStudent = currentItem.id
        val firstName = currentItem.firstName
        val lastName = currentItem.lastName

        val student = StudentsInCourseData(0, idCourse, name, day, timeBlock, idStudent, firstName, lastName)
        assistantViewModel.addStudentToCourse(student)
    }

    fun setData(students: List<StudentsData>){
        this.studentsList = students
        notifyDataSetChanged()
    }
}