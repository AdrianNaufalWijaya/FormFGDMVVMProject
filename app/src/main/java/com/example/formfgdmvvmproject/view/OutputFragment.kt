package com.example.formfgdmvvmproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.formfgdmvvmproject.R
import com.example.formfgdmvvmproject.databinding.FragmentInputBinding
import com.example.formfgdmvvmproject.databinding.FragmentOutputBinding
import com.example.formfgdmvvmproject.viewmodel.AttandanceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding

    private val viewModel: AttandanceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOutputBinding.inflate(inflater, container, false)

        viewModel.attendanceList.observe(viewLifecycleOwner) { list ->
            binding.txtViewOutput.text = list.joinToString ("\n\n"){
                "Nama: ${it.name}\n" +
                        "No HP: ${it.phone}\n"+
                        "Email: ${it.email}\n" +
                                "Jenis Kelamin :${it.gender}\n" +
                                "Skill: ${it.skillset}" +
                        "Kategori: ${it.kategori}"
            }

        }

        return binding.root
    }
}