package com.tolikavr.composition.domain.usecases

import com.tolikavr.composition.domain.entity.GameSettings
import com.tolikavr.composition.domain.entity.Level
import com.tolikavr.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
  private val repository: GameRepository
) {
  operator fun invoke(level: Level): GameSettings {
    return repository.getGameSettings(level)
  }
}