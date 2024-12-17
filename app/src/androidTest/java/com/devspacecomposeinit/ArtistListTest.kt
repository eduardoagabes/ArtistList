package com.devspacecomposeinit

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ArtistListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testArtistListTitleDisplayCorrectly() {
        val artistList = emptyList<Artist>()

        composeTestRule.setContent {
            ArtistListContent(
                artistList = artistList,
                onClick = {}
            )
        }

        composeTestRule
            .onNodeWithText("Artist List")
            .isDisplayed()
    }

    @Test
    fun testArtistListDisplayCorrectly() {
        val artistList = listOf(
            Artist(
                id = 0,
                name = "Artist 0",
                description = "Artist Desc 0",
                lastSeenOnline = "10 min",
                image = R.drawable.ic_vincent_van_gogh,
                art = R.drawable.ic_starry_night
            ),
            Artist(
                id = 1,
                name = "Artist 1",
                description = "Artist Desc 1",
                lastSeenOnline = "12 min",
                image = R.drawable.ic_vincent_van_gogh,
                art = R.drawable.ic_starry_night
            ),
            Artist(
                id = 2,
                name = "Artist 2",
                description = "Artist Desc 2",
                lastSeenOnline = "15 min",
                image = R.drawable.ic_vincent_van_gogh,
                art = R.drawable.ic_starry_night
            )
        )

        composeTestRule.setContent {
            ArtistListContent(
                artistList = artistList,
                onClick = {}
            )
        }

        artistList.forEach { artist ->
            composeTestRule
                .onNodeWithTag(
                    ARTIST_LIST_NAME_TAG + artist.id,
                    useUnmergedTree = true
                )
                .assertTextEquals(artist.name)
                .isDisplayed()

            composeTestRule
                .onNodeWithTag(
                    ARTIST_LIST_LAST_SEE_TAG + artist.id,
                    useUnmergedTree = true
                )
                .assertTextEquals(artist.lastSeenOnline)
                .isDisplayed()
        }
    }

    @Test
    fun testArtistListClickIsTriggeredCorrectly() {
        var artistsClicked : Artist? = null

        val artistList = listOf(
            Artist(
                id = 0,
                name = "Artist 0",
                description = "Artist Desc 0",
                lastSeenOnline = "10 min",
                image = R.drawable.ic_vincent_van_gogh,
                art = R.drawable.ic_starry_night
            )
        )

        composeTestRule.setContent {
            ArtistListContent(
                artistList = artistList,
                onClick = {
                    artistsClicked = it
                }
            )
        }

        composeTestRule
            .onNodeWithTag(
                ARTIST_LIST_LAST_SEE_TAG + "0",
                useUnmergedTree = true
            )
            .performClick()

        Assert.assertEquals(artistsClicked, artistList[0])

    }
}