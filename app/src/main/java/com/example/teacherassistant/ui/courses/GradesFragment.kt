package com.example.teacherassistant.ui.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.ui.AssistantViewModel
import com.example.teacherassistant.ui.adapters.GradesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_grades.view.*

class GradesFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel
    private val args by navArgs<GradesFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grades, container, false)

        view.text_firstName.setText(args.currentStudentInCourse.firstName)
        view.text_lastName.setText(args.currentStudentInCourse.lastName)
        view.text_id.setText(args.currentStudentInCourse.idStudent.toString())

        val adapter = GradesAdapter(args.currentStudentInCourse)
        val recyclerView = view.recyclerview_grades
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)
        assistantViewModel.readGrades(args.currentStudentInCourse.idCourse.toString(), args.currentStudentInCourse.idStudent.toString()).observe(viewLifecycleOwner, Observer {  grade ->
            adapter.setData(grade)
        })
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById<FloatingActionButton>(R.id.addGradeButton)).setOnClickListener {
            val action = GradesFragmentDirections.actionGradesFragmentToAddGradeFragment(args.currentStudentInCourse)
            it.findNavController().navigate(action)
        }
    }


    companion object {
        fun newInstance() {}
    }
}