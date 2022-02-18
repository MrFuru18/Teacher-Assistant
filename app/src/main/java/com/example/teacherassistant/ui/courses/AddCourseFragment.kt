package com.example.teacherassistant.ui.courses

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.model.entities.CoursesData
import com.example.teacherassistant.ui.AssistantViewModel
import kotlinx.android.synthetic.main.fragment_add_course.*
import kotlinx.android.synthetic.main.fragment_add_course.view.*


class AddCourseFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_course, container, false)

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)

        view.button_confirm.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val name = edit_text_name.text.toString()
        val day = edit_text_day.text.toString()
        val timeBlock = edit_text_time.text.toString()

        if(inputCheck(name, day, timeBlock)){
            val course = CoursesData(0, name, day, timeBlock)
            assistantViewModel.addCourse(course)
            Toast.makeText(requireContext(), "Pomyślnie dodano", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addCourseFragment_to_navigation_courses2)
        }
        else{
            Toast.makeText(requireContext(), "Pola są puste", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(name: String, day: String, timeBlock: String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(day) && TextUtils.isEmpty(timeBlock))
    }


    companion object {
        fun newInstance() {}
    }
}