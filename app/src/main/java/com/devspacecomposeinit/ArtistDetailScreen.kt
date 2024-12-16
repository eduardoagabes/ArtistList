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