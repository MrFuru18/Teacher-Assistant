package com.example.teacherassistant.ui.students

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.StudentsData
import com.example.teacherassistant.ui.AssistantViewModel
import kotlinx.android.synthetic.main.fragment_add_student.*
import kotlinx.android.synthetic.main.fragment_add_student.view.*


class AddStudentFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)

        view.button_confirm.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = edit_text_Name.text.toString()
        val lastName = edit_text_Surname.text.toString()
        val id = edit_text_number.text.toString()

        if(inputCheck(firstName, lastName, id)){
            val student = StudentsData(Integer.parseInt(id), firstName, lastName)
            assistantViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Pomyślnie dodano", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addStudentFragment_to_navigation_students2)
        }
        else{
            Toast.makeText(requireContext(), "Pola są puste", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, id: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(id))
    }

    companion object {
        fun newInstance() {}
    }
}