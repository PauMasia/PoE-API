package com.example.poe_api_paumasia

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
@Entity
@Parcelize
data class ObjetoPoE
    (
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("grouping")
    val tier: String,
    @SerializedName("imagen")
    val imagen: String,
    @SerializedName("dimensions")
    val dimensions: String,
    @SerializedName("category")
    val categoria: String,
    //esta cosa esta en mayuscula posible problema
    @SerializedName("miniLvl")
    val minLevel: String,
    @SerializedName("poedbUrl")
    val poeDb: String,
    @SerializedName("poewikilink")
    val poewiki: String,

    ) : Parcelable {
    override fun toString(): String {
        return "" + id + " " + name + " " + tier
    }
}


