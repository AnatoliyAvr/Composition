package com.tolikavr.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tolikavr.composition.R
import com.tolikavr.composition.databinding.FragmentGameFinishedBinding
import com.tolikavr.composition.domain.entity.GameResult

class GameFinishedFragment : Fragment() {

  private val args by navArgs<GameFinishedFragmentArgs>()

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
    setupClickListeners()
    bindViews()
  }

  private fun bindViews() {
    with(binding) {
      with(args) {
        emojiResult.setImageResource(getSmileResId())
        tvRequiredAnswers.text = String.format(
          getString(R.string.required_score),
          gameResult.gameSettings.minCountOfRightAnswers
        )
        tvScoreAnswers.text = String.format(
          getString(R.string.score_answers),
          gameResult.countOfRightAnswers
        )
        tvRequiredPercentage.text = String.format(
          getString(R.string.required_percentage),
          gameResult.gameSettings.minPercentOfRightAnswers
        )
        tvScorePercentage.text = String.format(
          getString(R.string.score_percentage),
          getPercentOfRightAnswer()
        )
      }
    }
  }

  private fun setupClickListeners() {
    binding.buttonRetry.setOnClickListener {
      retryGame()
    }
  }

  private fun getSmileResId(): Int {
    return if (args.gameResult.winner) R.drawable.ic_smile else R.drawable.ic_sad
  }

  private fun getPercentOfRightAnswer() = with(args.gameResult) {
    if (countOfQuestions == 0) 0
    else ((countOfRightAnswers / countOfQuestions.toDouble() * 100).toInt())
  }

  private fun retryGame() {
    findNavController().popBackStack()
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}