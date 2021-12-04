package tapp.bottomnav.demo.feature.home.adapter

import java.util.Date

data class ArticlePreview(
    val id: Int,
    val date: Date,
    val title: String,
    val contentPreview: String,
    val imageUrl: String
)
