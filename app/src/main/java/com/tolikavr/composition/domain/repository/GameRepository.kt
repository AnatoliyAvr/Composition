package com.tolikavr.composition.domain.repository

import com.tolikavr.composition.domain.entity.GameSettings
import com.tolikavr.composition.domain.entity.Level
import com.tolikavr.composition.domain.entity.Question

interface GameRepository {

  fun generateQuestion(
    maxSumValue: Int,
    countOfOptions: Int
  ): Question

  fun getGameSettings(level: Level): GameSettings
}