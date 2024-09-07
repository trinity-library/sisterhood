package sisterhood.ui.infrastructure.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Page(val iconImageVector: ImageVector) {
    HOME(iconImageVector = Icons.Filled.Home),
    SEARCH(iconImageVector = Icons.Filled.Search),
    SETTINGS(iconImageVector = Icons.Filled.Settings);
}
