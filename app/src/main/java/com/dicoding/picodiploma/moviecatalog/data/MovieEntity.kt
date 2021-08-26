package com.dicoding.picodiploma.moviecatalog.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var id: String?,
    var bg: String?,
    var poster: Int = 0,
    var title: String?,
    var genre: String?,
    var release: String?,
    var duration: String?,
    var description: String?
): Parcelable