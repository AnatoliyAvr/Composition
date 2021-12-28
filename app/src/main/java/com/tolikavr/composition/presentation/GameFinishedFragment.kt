package com.tolikavr.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolikavr.composition.R
import com.tolikavr.composition.databinding.FragmentGameFinishedBinding

class GameFinishedFragment : Fragment() {

  private var _binding: FragmentGameFinishedBinding? = null
  private val binding: FragmentGameFinishedBinding
    get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
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