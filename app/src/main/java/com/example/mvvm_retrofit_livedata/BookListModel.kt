package com.example.mvvm_retrofit_livedata

import com.google.gson.annotations.SerializedName

data class BookListModel(
    @SerializedName("items") val items : ArrayList<Items>)

data class Items (

    @SerializedName("kind") val kind : String,
    @SerializedName("id") val id : String,
    @SerializedName("etag") val etag : String,
    @SerializedName("selfLink") val selfLink : String,
    @SerializedName("volumeInfo") val volumeInfo : VolumeInfo,
)
data class VolumeInfo (

    @SerializedName("title") val title : String,
    @SerializedName("subtitle") val subtitle : String,
    @SerializedName("authors") val authors : List<String>,
    @SerializedName("publisher") val publisher : String,
    @SerializedName("publishedDate") val publishedDate : String,
    @SerializedName("description") val description : String,
    @SerializedName("pageCount") val pageCount : Int,
    @SerializedName("printType") val printType : String,
    @SerializedName("categories") val categories : List<String>,
    @SerializedName("maturityRating") val maturityRating : String,
    @SerializedName("allowAnonLogging") val allowAnonLogging : Boolean,
    @SerializedName("contentVersion") val contentVersion : String,
    @SerializedName("imageLinks") val imageLinks : ImageLinks,
    @SerializedName("language") val language : String,
    @SerializedName("previewLink") val previewLink : String,
    @SerializedName("infoLink") val infoLink : String,
    @SerializedName("canonicalVolumeLink") val canonicalVolumeLink : String
)
data class ImageLinks (

    @SerializedName("smallThumbnail") val smallThumbnail : String,
    @SerializedName("thumbnail") val thumbnail : String
)
