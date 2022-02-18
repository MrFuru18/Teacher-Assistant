package com.example.teacherassistant.ui.courses

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.GradesData
import com.example.teacherassistant.ui.AssistantViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_add_grade.*
import kotlinx.android.synthetic.main.fragment_grade_update.view.*

class GradeUpdateFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel
    private val args by navArgs<GradeUpdateFragmentArgs>()
    private val args1 by navArgs<GradeUpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grade_update, container, false)

        view.edit_grade.setText(args.currentGrade.grade.toString())
        view.edit_category.setText(args.currentGrade.category)
        view.edit_comment.setText(args.currentGrade.comm)

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.button_confirm.setOnClickListener{
        updateDataInDatabase()

        }
    }

    private fun updateDataInDatabase() {
        val idCourse = args.currentGrade.idCourse
        val idStudent = args.currentGrade.idStudent
        val grade = edit_grade.text.toString()
        val category = edit_category.text.toString()
        val comm = edit_comment.text.toString()

        if(inputCheck(grade, category, comm)){

            val grade = GradesData(args.currentGrade.id, idCourse, idStudent, edit_grade.doubleValue(), category, comm)
            assistantViewModel.updateGrade(grade)
            Toast.makeText(requireContext(), "Pomyślnie zaktualizowano", Toast.LENGTH_SHORT).show()
            val action = GradeUpdateFragmentDirections.actionGradeUpdateFragmentToGradesFragment(args1.currentStudentInCourse)
            findNavController().navigate(action)
        }
        else{
            Toast.makeText(requireContext(), "Pola są puste", Toast.LENGTH_SHORT).show()
        }
    }

    fun EditText.doubleValue() = text.toString().toDoubleOrNull() ?: 0.0


    private fun inputCheck(grade: String, category: String, comm: String): Boolean{
        return !(TextUtils.isEmpty(grade) && TextUtils.isEmpty(category) && TextUtils.isEmpty(comm))
    }

}