package com.tolikavr.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tolikavr.composition.R
import com.tolikavr.composition.databinding.FragmentChooseLevelBinding
import com.tolikavr.composition.domain.entity.Level

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
    with(binding) {
      buttonLevelTest.setOnClickListener {
        launchGameFragment(Level.TEST)
      }
      buttonLevelEasy.setOnClickListener {
        launchGameFragment(Level.EASY)
      }
      buttonLevelNormal.setOnClickListener {
        launchGameFragment(Level.NORMAL)
      }
      buttonLevelHard.setOnClickListener {
        launchGameFragment(Level.HARD)
      }
    }
  }

  private fun launchGameFragment(level: Level) {
    val args = Bundle().apply { putParcelable(GameFragment.KEY_LEVE, level) }
    findNavController().navigate(R.id.action_chooseLevelFragment_to_gameFragment, args)
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  companion object {

    fun newInstance(): ChooseLevelFragment {
      return ChooseLevelFragment()
    }
  }
}