package com.example.teacherassistant.ui.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.databinding.FragmentStudentsBinding
import com.example.teacherassistant.ui.AssistantViewModel
import com.example.teacherassistant.ui.adapters.StudentsRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_students.view.*

class StudentsFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_students, container, false)

        val adapter = StudentsRecyclerViewAdapter()
        val recyclerView = view.recyclerview_students
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)
        assistantViewModel.readStudentsAllData.observe(viewLifecycleOwner, Observer {  student ->
            adapter.setData(student)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById<FloatingActionButton>(R.id.addStudentButton)).setOnClickListener {

            it.findNavController().navigate(R.id.action_navigation_students_to_addStudentFragment)

        }
    }
}
