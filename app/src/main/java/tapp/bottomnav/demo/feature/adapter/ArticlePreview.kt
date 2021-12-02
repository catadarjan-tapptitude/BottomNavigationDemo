package tapp.bottomnav.demo.feature.adapter

import java.util.*

data class ArticlePreview(
    val id: Int,
    val date: Date,
    val title: String,
    val contentPreview: String,
    val imageUrl: String
)
