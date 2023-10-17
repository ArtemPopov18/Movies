package com.example.movies.utils

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat


class Constants {

    object Screens {
        const val SPLASH_SCREENS = "splash_screens"
        const val MAIN_SCREENS = "main_screens"
        const val DETAILS_SCREENS = "details_screens"
    }
}

@Composable
fun HtmlText(html: String, modifier: Modifier) {
    AndroidView(modifier = modifier,
        factory = { context -> TextView(context).apply { this.textSize = 16f } },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) })
}