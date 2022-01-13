package com.tolikavr.composition.domain.entity

import android.os.Parcel
import android.os.Parcelable

//@Parcelize
data class GameSettings(
  val maxSumValue: Int,
  val minCountOfRightAnswers: Int,
  val minPercentOfRightAnswers: Int,
  val gameTimeInSeconds: Int
) : Parcelable {

  constructor(parcel: Parcel) : this(
    parcel.readInt(),
    parcel.readInt(),
    parcel.readInt(),
    parcel.readInt()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeInt(maxSumValue)
    parcel.writeInt(minCountOfRightAnswers)
    parcel.writeInt(minPercentOfRightAnswers)
    parcel.writeInt(gameTimeInSeconds)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<GameSettings> {

    override fun createFromParcel(parcel: Parcel): GameSettings {
      return GameSettings(parcel)
    }

    override fun newArray(size: Int): Array<GameSettings?> {
      return arrayOfNulls(size)
    }
  }

  val minCountOfRightAnswersString: String
    get() = minCountOfRightAnswers.toString()

  val minPercentOfRightAnswersString: String
    get() = minPercentOfRightAnswers.toString()
}
