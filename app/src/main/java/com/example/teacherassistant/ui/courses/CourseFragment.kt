package com.example.teacherassistant.ui.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.StudentsInCourseData
import com.example.teacherassistant.ui.AssistantViewModel
import com.example.teacherassistant.ui.adapters.StudentsInCourseAdapter
import com.example.teacherassistant.ui.adapters.StudentsRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_course.view.*

class CourseFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel
    private val args by navArgs<CourseFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course, container, false)

        view.text_courseName.setText(args.currentCourse.name)
        view.text_day.setText(args.currentCourse.day)
        view.text_timeBlock.setText(args.currentCourse.timeBlock)

        val adapter = StudentsInCourseAdapter()
        val recyclerView = view.recyclerview_studentsInCourse
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)
        assistantViewModel.readStudentsInCourse(args.currentCourse.id.toString()).observe(viewLifecycleOwner, Observer {  studentInCourse ->
            adapter.setData(studentInCourse)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById<FloatingActionButton>(R.id.addStudentToCourseButton)).setOnClickListener {
            val action = CourseFragmentDirections.actionCourseFragmentToAddStudentToCourseFragment(args.currentCourse)
            it.findNavController().navigate(action)

        }
    }


    companion object {
        fun newInstance() {}

    }
}