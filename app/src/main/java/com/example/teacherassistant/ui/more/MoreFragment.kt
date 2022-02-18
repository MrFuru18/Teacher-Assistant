package com.example.teacherassistant.ui.more

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.ui.AssistantViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MoreFragment : Fragment() {

    private lateinit var assistantViewModel: AssistantViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_more, container, false)

        assistantViewModel = ViewModelProvider(this).get(AssistantViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById<Button>(R.id.button_delete_database)).setOnClickListener {
            deleteDatabase()
        }
    }

    private fun deleteDatabase() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Tak") {_, _ ->
            assistantViewModel.deleteGrades()
            assistantViewModel.deleteStudentsInCourses()
            assistantViewModel.deleteCourses()
            assistantViewModel.deleteStudents()
            Toast.makeText(requireContext(), "Usunięto wszystkie dane", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Nie") {_, _ ->

        }
        builder.setTitle("Usuwanie bazy danych")
        builder.setMessage("Czy na pewno przywrócić do stanu początkowego?")
        builder.create().show()
    }

    companion object {
        fun newInstance() {}

    }
}