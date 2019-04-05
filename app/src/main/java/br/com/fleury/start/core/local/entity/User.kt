package br.com.fleury.start.core.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class User(
    @SerializedName("name") var fullName: String = "",
    var birthDate: String = ""
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}