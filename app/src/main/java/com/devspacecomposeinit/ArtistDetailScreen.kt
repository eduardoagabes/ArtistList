package com.devspacecomposeinit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devspacecomposeinit.designsystem.ToolbarWithBackButton
import com.devspacecomposeinit.ui.theme.ComposeInitTheme

@Composable
fun ArtistDetailScreen(
    artistId: Int,
    navController: NavController,
    ) {

    val repo = ListRepository()
    val artist = repo.getArtistById(artistId)

    Scaffold(
        topBar = {
            ToolbarWithBackButton(title = "Detail") {
                navController.popBackStack()
            }
        },
        content = { paddingValues ->
            ArtistDetailContent(
                artist = artist,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
private fun ArtistDetailContent(
    artist: Artist,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        ArtistCard(artist = artist,
            onClick = {}
        )

        Text(
            modifier = Modifier.padding(16.dp),
            text = artist.description
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ArtistDetailContentPreview() {
    ComposeInitTheme {
        val artist = Artist(
            id = 0,
            name = "Vicent Ban Gogh",
            lastSeenOnline = "10 minutes ago",
            image = R.drawable.ic_vincent_van_gogh,
            art = R.drawable.ic_starry_night,
            description = "Vincent van Gogh (1853-1890) pintor postimpresionista nacido en Zundert, Países Bajos. Su vida estuvo marcada por luchas personales, pero produjo más de 2,000 obras, incluyendo La noche estrellada y Los girasoles. Su uso emocional del color y sus pinceladas expresivas revolucionaron el arte y lo convirtieron en uno de los artistas más venerados del mundo, a pesar de haber vendido solo una pintura en vida."
        )
        ArtistDetailContent(artist = artist)
    }
}