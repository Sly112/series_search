package pl.slyberry.series.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val name: String, val categories: List<String>, val image: String?) : Parcelable
