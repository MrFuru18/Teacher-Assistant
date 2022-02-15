package com.example.teacherassistant.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.databinding.FragmentCoursesBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CoursesFragment : Fragment() {

private var _binding: FragmentCoursesBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val coursesViewModel =
            ViewModelProvider(this).get(CoursesViewModel::class.java)

    _binding = FragmentCoursesBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textCourses
    coursesViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }

    return root
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById<FloatingActionButton>(R.id.addCourseButton)).setOnClickListener {

            it.findNavController().navigate(R.id.action_navigation_courses_to_addCourseFragment)

        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}