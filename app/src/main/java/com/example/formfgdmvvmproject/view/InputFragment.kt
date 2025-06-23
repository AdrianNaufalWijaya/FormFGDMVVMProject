package com.example.formfgdmvvmproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.example.formfgdmvvmproject.R
import com.example.formfgdmvvmproject.databinding.ActivityMainBinding
import com.example.formfgdmvvmproject.databinding.FragmentInputBinding
import com.example.formfgdmvvmproject.viewmodel.AttandanceViewModel
import com.example.formfgdmvvmproject.model.AttendanceModel

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    private val viewModel: AttandanceViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)

        //pengisian spinner dengan item dari res array
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.kategori_peserta,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spCategory.adapter = adapter


        }

        //pengambilan value dari field view

        binding.btnsubmit.setOnClickListener {
            val model = AttendanceModel(
                name = binding.edtNama.text.toString(),
                phone = binding.edtTelefon.text.toString(),
                email = binding.edtEmail.text.toString(),
                gender = if(binding.radLakilaki.isChecked) "Laki-laki" else "Perempuan",
                skillset = listOfNotNull(
                    if (binding.chkAlgo.isChecked) "Algoritma" else null,
                    if (binding.chkProblemSolving.isChecked) "Problem Solving" else null,
                    if (binding.chkCrriticalthinking.isChecked) "Critical Thinking" else null,
                    if (binding.chkPrograming.isChecked) "Programing" else null,
                    if (binding.chkDesignthinking.isChecked) "Design Thinking" else null
                ),
                kategori = binding.spCategory.selectedItem?.toString() ?: "Tidak Diketahui"

            )

            viewModel.setAttandanceData(model)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OutputFragment())
                .addToBackStack(null)
                .commit()

        }

        return binding.root
    }
}