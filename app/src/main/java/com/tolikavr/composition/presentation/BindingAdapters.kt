package com.tolikavr.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.tolikavr.composition.R
import com.tolikavr.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
  textView.text = String.format(
    textView.context.getString(R.string.required_score),
    count
  )
}

@BindingAdapter("score")
fun bindScore(textView: TextView, score: Int) {
  textView.text = String.format(
    textView.context.getString(R.string.score_answers),
    score
  )
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, percentage: Int) {
  textView.text = String.format(
    textView.context.getString(R.string.required_percentage),
    percentage
  )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
  textView.text = String.format(
    textView.context.getString(R.string.score_percentage),
    getPercentOfRightAnswer(gameResult)
  )
}

private fun getPercentOfRightAnswer(gameResult: GameResult) = with(gameResult) {
  if (countOfQuestions == 0) 0
  else ((countOfRightAnswers / countOfQuestions.toDouble() * 100).toInt())
}

@BindingAdapter("resultEmoji")
fun bindResultEmoji(imageView: ImageView, winner: Boolean) {
  imageView.setImageResource(getSmileResId(winner))
}

private fun getSmileResId(winner: Boolean): Int {
  return if (winner) R.drawable.ic_smile else R.drawable.ic_sad
}


