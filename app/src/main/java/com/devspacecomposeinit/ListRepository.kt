package com.devspacecomposeinit

class ListRepository {

    private val leonardo = Artist(
        id = 1,
        name = "Leonardo da Vinci",
        lastSeenOnline = "3 minutes ago",
        image = R.drawable.ic_leonardo_da_vinci,
        art = R.drawable.ic_mona_lisa,
        description = "Leonardo da Vinci (1452-1519) artista y genio renacentista italiano nacido en Vinci, Italia. Fue pintor, inventor, científico y arquitecto. Es conocido por obras maestras como La Mona Lisa y La última cena, así como por sus estudios anatómicos y mecánicos que sentaron las bases de la ingeniería moderna. Su legado combina arte y ciencia, marcando un hito en la historia de la humanidad."
    )

    private val picasso = Artist(
        id = 2,
        name = "Pablo Picasso",
        lastSeenOnline = "5 minutes ago",
        image = R.drawable.ic_pablo_picasso,
        art = R.drawable.ic_beijo,
        description = "Pablo Picasso (1881-1973) nacido en Málaga, España, Picasso fue uno de los artistas más influyentes del siglo XX. Cofundador del cubismo, revolucionó el arte con su capacidad de reinterpretar la forma y la perspectiva. Entre sus obras más famosas están Guernica, un poderoso mensaje contra la guerra, y Les Demoiselles d'Avignon, una pieza que rompió con las convenciones artísticas de su época."
    )

    private val salvador = Artist(
        id = 3,
        name = "Salvador Dali",
        lastSeenOnline = "7 minutes ago",
        image = R.drawable.ic_salvador_dali,
        art = R.drawable.ic_persistence_of_memory,
        description = "Salvador Dalí (1904-1989) nacido en Figueres, España, Dalí fue un icono del surrealismo, conocido por su estilo excéntrico y obras como La persistencia de la memoria, con sus famosos relojes derretidos. Su imaginación ilimitada lo llevó a explorar la pintura, la escultura, el cine y la fotografía, dejando un legado de obras que desafían la lógica y revelan los paisajes del subconsciente."
    )

    private val vanGogh = Artist(
        id = 4,
        name = "Vicent Ban Gogh",
        lastSeenOnline = "10 minutes ago",
        image = R.drawable.ic_vincent_van_gogh,
        art = R.drawable.ic_starry_night,
        description = "Vincent van Gogh (1853-1890) pintor postimpresionista nacido en Zundert, Países Bajos. Su vida estuvo marcada por luchas personales, pero produjo más de 2,000 obras, incluyendo La noche estrellada y Los girasoles. Su uso emocional del color y sus pinceladas expresivas revolucionaron el arte y lo convirtieron en uno de los artistas más venerados del mundo, a pesar de haber vendido solo una pintura en vida."
    )


    fun getArtistList(): List<Artist> {
        return listOf(vanGogh, salvador, picasso, leonardo)
    }

    fun getArtistById(id: Int): Artist {
        return getArtistList().first { it.id == id }
    }
}