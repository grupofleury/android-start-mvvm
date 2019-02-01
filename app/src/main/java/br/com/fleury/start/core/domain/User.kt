package br.com.fleury.start.core.domain

import com.google.gson.annotations.SerializedName

data class User(
    var id: Long,
    @SerializedName("name") var fullName: String,
    var birthDate: String
)