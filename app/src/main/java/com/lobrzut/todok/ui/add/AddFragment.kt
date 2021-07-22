package com.lobrzut.todok.ui.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lobrzut.todok.R
import com.lobrzut.todok.database.TaskEntry
import com.lobrzut.todok.databinding.FragmentAddBinding
import com.lobrzut.todok.viewmodel.TaskViewModel


class AddFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentAddBinding.inflate(inflater)

        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.categories)
        )

        binding.apply {
            spinner.adapter = myAdapter
            btnAdd.setOnClickListener {
                if (TextUtils.isEmpty((editTask.text))) {
                    Toast.makeText(requireContext(), "It's Empty", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val title_str = editTask.text.toString()
                val cat = spinner.selectedItemPosition

                val taskEntry = TaskEntry(0,title_str, cat, System.currentTimeMillis())

                viewModel.insert(taskEntry)
                Toast.makeText(requireContext(), "Added Done!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)

            }}

        return binding.root
    }

}