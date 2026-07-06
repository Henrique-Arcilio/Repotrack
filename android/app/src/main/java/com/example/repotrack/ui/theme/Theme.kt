package com.example.repotrack.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = AzulRepoTrack,
    onPrimary = Color.White,

    primaryContainer = AzulClaroRepoTrack,
    onPrimaryContainer = TextoRepoTrack,

    secondary = TextoSecundarioRepoTrack,
    onSecondary = Color.White,

    background = FundoRepoTrack,
    onBackground = TextoRepoTrack,

    surface = SuperficieRepoTrack,
    onSurface = TextoRepoTrack,

    surfaceVariant = AzulClaroRepoTrack,
    onSurfaceVariant = TextoSecundarioRepoTrack,

    outline = BordaRepoTrack
)

private val DarkColorScheme = darkColorScheme(
    primary = AzulRepoTrackEscuro,
    onPrimary = FundoRepoTrackEscuro,

    primaryContainer = Color(0xFF1E3A8A),
    onPrimaryContainer = Color(0xFFDBEAFE),

    secondary = TextoSecundarioRepoTrackEscuro,
    onSecondary = FundoRepoTrackEscuro,

    background = FundoRepoTrackEscuro,
    onBackground = TextoRepoTrackEscuro,

    surface = SuperficieRepoTrackEscura,
    onSurface = TextoRepoTrackEscuro,

    surfaceVariant = Color(0xFF273449),
    onSurfaceVariant = TextoSecundarioRepoTrackEscuro,

    outline = BordaRepoTrackEscura
)

@Composable
fun RepotrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}