package com.example.teacherassistant.ui.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.ui.AssistantViewModel
import com.example.teacherassistant.ui.adapters.StudentsRecyclerViewAdapter
import com.example.teacherassistant.ui.adapters.StudentsToCourseAdapter
import kotlinx.android.synthetic.main.fragment_add_student_to_course.view.*


class AddStudentToCourseFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel
    private val args by navArgs<CourseFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_student_to_course, container, false)

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)

        val adapter = StudentsToCourseAdapter(assistantViewModel, args.currentCourse)
        val recyclerView = view.recyclerview_studentsToCourse
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        assistantViewModel.readStudentsAllData.observe(viewLifecycleOwner, Observer {  student ->
            adapter.setData(student)
        })

        return view
    }

    companion object {
        fun newInstance() {}
    }
}