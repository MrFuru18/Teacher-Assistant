package com.example.teacherassistant.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.databinding.FragmentCoursesBinding
import com.example.teacherassistant.ui.AssistantViewModel
import com.example.teacherassistant.ui.adapters.CoursesRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_courses.view.*

class CoursesFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
      val view = inflater.inflate(R.layout.fragment_courses, container, false)

      val adapter = CoursesRecyclerViewAdapter()
      val recyclerView = view.recyclerview_courses
      recyclerView.adapter = adapter
      recyclerView.layoutManager = LinearLayoutManager(requireContext())

      assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)
      assistantViewModel.readCoursesAllData.observe(viewLifecycleOwner, Observer { course ->
          adapter.setData(course)
      })

      return view
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById<FloatingActionButton>(R.id.addCourseButton)).setOnClickListener {

            it.findNavController().navigate(R.id.action_navigation_courses_to_addCourseFragment)

        }
    }


}