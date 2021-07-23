package dev.goobar.androidstudyguidejuly21.data

import com.squareup.moshi.JsonClass

/**
 * Will represent items parsed from the network request we make with Volley
 */
@JsonClass(generateAdapter = true) // this annotation will help Moshi generate a deserializer
data class Topic(val title: String, val content: String)
