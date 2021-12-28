package com.tolikavr.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolikavr.composition.databinding.FragmentChooseLevelBinding

class ChooseLevelFragment : Fragment() {

  private var _binding: FragmentChooseLevelBinding? = null
  private val binding: FragmentChooseLevelBinding
    get() = _binding ?: throw  RuntimeException("FragmentChooseLevelBinding == null")

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}