package com.tolikavr.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tolikavr.composition.databinding.FragmentGameBinding
import com.tolikavr.composition.domain.entity.GameResult

class GameFragment : Fragment() {

  private val args by navArgs<GameFragmentArgs>()

  private val viewModel by lazy {
//    val args = GameFragmentArgs.fromBundle(requireArguments())
    ViewModelProvider(
      this,
      GameViewModelFactory(requireActivity().application, args.level)
    )[GameViewModel::class.java]
  }

  private var _binding: FragmentGameBinding? = null
  private val binding: FragmentGameBinding
    get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentGameBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.viewModel = viewModel
    binding.lifecycleOwner = viewLifecycleOwner
    observeViewModel()
  }

  private fun observeViewModel() {
    viewModel.gameResult.observe(viewLifecycleOwner) {
      launchGameFinishedFragment(it)
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  private fun launchGameFinishedFragment(gameResult: GameResult) {
    findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameFinishedFragment(gameResult))
  }
}