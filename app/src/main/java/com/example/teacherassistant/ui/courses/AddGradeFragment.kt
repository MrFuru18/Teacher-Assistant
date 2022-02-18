package com.example.teacherassistant.ui.courses

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.model.entities.GradesData
import com.example.teacherassistant.ui.AssistantViewModel
import kotlinx.android.synthetic.main.fragment_add_grade.*
import kotlinx.android.synthetic.main.fragment_add_grade.view.*

class AddGradeFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel
    private val args by navArgs<AddGradeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_grade, container, false)

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)

        view.button_confirm.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val idCourse = args.currentStudentInCourse.idCourse
        val idStudent = args.currentStudentInCourse.idStudent
        val grade = edit_grade.text.toString()
        val category = edit_category.text.toString()
        val comm = edit_comment.text.toString()

        if(inputCheck(grade, category, comm)){
            val grade = GradesData(0, idCourse, idStudent, grade.toDouble(), category, comm)
            assistantViewModel.addGrade(grade)
            Toast.makeText(requireContext(), "Pomyślnie dodano", Toast.LENGTH_SHORT).show()
            val action = AddGradeFragmentDirections.actionAddGradeFragmentToGradesFragment(args.currentStudentInCourse)
            findNavController().navigate(action)
        }
        else{
            Toast.makeText(requireContext(), "Pola są puste", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(grade: String, category: String, comm: String): Boolean{
        return !(TextUtils.isEmpty(grade) && TextUtils.isEmpty(category) && TextUtils.isEmpty(comm))
    }


    companion object {
        fun newInstance() {}
    }
}