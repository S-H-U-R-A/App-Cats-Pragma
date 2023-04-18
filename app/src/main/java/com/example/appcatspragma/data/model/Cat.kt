package com.example.appcatspragma.data.model

import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull


class ResponseCatsList : ArrayList<Cat>()

data class Cat(
    @SerializedName("name")
    var breedName: String,
    @SerializedName("origin")
    var origin: String,
    @SerializedName("affection_level")
    var affectionLevel: Int,
    @SerializedName("intelligence")
    var intelligence: Int,
    @SerializedName("reference_image_id")
    var idImage: String = ""
)

