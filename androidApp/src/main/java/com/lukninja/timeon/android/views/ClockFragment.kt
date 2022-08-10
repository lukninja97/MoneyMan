package com.lukninja.timeon.android.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lukninja.timeon.android.R
import com.lukninja.timeon.android.databinding.FragmentClockBinding
import com.lukninja.timeon.android.databinding.FragmentHomeBinding

class ClockFragment : Fragment() {

    private var _binding: FragmentClockBinding? = null
    private val binding: FragmentClockBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClockBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}