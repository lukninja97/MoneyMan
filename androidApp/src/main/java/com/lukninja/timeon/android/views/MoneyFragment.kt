package com.lukninja.timeon.android.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lukninja.timeon.android.R
import com.lukninja.timeon.android.databinding.FragmentClockBinding
import com.lukninja.timeon.android.databinding.FragmentMoneyBinding

class MoneyFragment : Fragment() {

    private var _binding: FragmentMoneyBinding? = null
    private val binding: FragmentMoneyBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoneyBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}