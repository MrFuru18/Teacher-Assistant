package com.example.teacherassistant.ui.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.databinding.FragmentStudentsBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentsFragment : Fragment() {

private var _binding: FragmentStudentsBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentStudentsBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textStudents
      textView.text = "This is students Fragment"
    return root
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById<FloatingActionButton>(R.id.addStudentButton)).setOnClickListener {

            it.findNavController().navigate(R.id.action_navigation_students_to_addStudentFragment)

        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}