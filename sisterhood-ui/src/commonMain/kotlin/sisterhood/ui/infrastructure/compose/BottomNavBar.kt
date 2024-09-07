package sisterhood.ui.infrastructure.compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BottomNavBar(
    state: BottomNavBarState
) {
    NavigationBar {
        Page.entries.forEach { page ->
            val selected = page == state.currentPage
            BottomNavBarItem(
                iconImageVector = page.iconImageVector,
                selected = selected,
                onSelected = { state.currentPage = page }
            )
        }
    }
}

@Composable
private fun RowScope.BottomNavBarItem(
    iconImageVector: ImageVector,
    selected: Boolean,
    onSelected: () -> Unit,
) {
    NavigationBarItem(
        icon = {
            Icon(
                imageVector = iconImageVector,
                contentDescription = ""
            )
        },
        selected = selected,
        onClick = { if (!selected) onSelected() }
    )
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    MaterialTheme {
        BottomNavBar(state = rememberBottomNavBarState())
    }
}
