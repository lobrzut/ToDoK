package com.lobrzut.todok.ui.update

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lobrzut.todok.R
import com.lobrzut.todok.database.TaskEntry
import com.lobrzut.todok.databinding.FragmentUpdateBinding
import com.lobrzut.todok.viewmodel.TaskViewModel


class UpdateFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentUpdateBinding.inflate(inflater)

        val args = UpdateFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            updateEditTask.setText(args.taskEntry.title)
            updateSpinner.setSelection(args.taskEntry.category)

            btnUpdate.setOnClickListener {
                if (TextUtils.isEmpty(updateEditTask.text)) {
                    Toast.makeText(requireContext(), "it's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

                }

                val task_str = updateEditTask.text
                val category = updateSpinner.selectedItemPosition

                val taskEntry = TaskEntry(
                    args.taskEntry.id,
                    task_str.toString(),
                    category,
                    args.taskEntry.timestamp
                )

                viewModel.update(taskEntry)
                Toast.makeText(requireContext(), "Updated", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updateFragment_to_taskFragment)
            }
        }
        return binding.root
    }
}