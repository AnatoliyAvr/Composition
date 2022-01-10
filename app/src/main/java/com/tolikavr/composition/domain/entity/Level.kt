package com.tolikavr.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class Level : Parcelable { // Enum class неявно реализуют Serializable, указывать не надо
  TEST, EASY, NORMAL, HARD
}