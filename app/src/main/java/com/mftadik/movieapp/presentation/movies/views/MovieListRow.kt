package com.mftadik.movieapp.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mftadik.movieapp.domain.model.Movie

@Composable
fun MovieListRow(
    movie : Movie,
    onItemClick : (Movie) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                onItemClick(movie)
            }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = rememberAsyncImagePainter(model = movie.Poster),
            contentDescription = movie.Title,
            modifier = Modifier.padding(16.dp)
                .size(200.dp,200.dp)
                .clip(RectangleShape)
        )
        Column(
            modifier = Modifier.align(Alignment.CenterVertically), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                movie.Title,
                style = MaterialTheme.typography.headlineMedium,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                textAlign = TextAlign.Center
                )
            Text(
                movie.Year,
                style = MaterialTheme.typography.headlineSmall,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}