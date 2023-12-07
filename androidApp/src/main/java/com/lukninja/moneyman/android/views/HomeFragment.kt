package com.lukninja.moneyman.android.views

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lukninja.moneyman.android.R
import com.lukninja.moneyman.android.databinding.FragmentClientBinding
import com.lukninja.moneyman.android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listeners()
    }

    private fun listeners() = with(binding) {
        cardEmprestados.setOnClickListener {
            openDialogClient()
        }
    }

    private fun openDialogClient() {
        val view = FragmentClientBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        MaterialAlertDialogBuilder(requireContext())
            .setView(view.root)
            .setPositiveButton("OK") { _, _ ->
                validateFields()
            }
            .create()
            .show()
    }

    private fun validateFields() {
        TODO("Not yet implemented")
    }
}