package sisterhood.ui.infrastructure.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import sisterhood.ui.infrastructure.SisterhoodContext

@Composable
fun rememberApplicationState(
    sisterhoodContext: SisterhoodContext,
    bottomNavBarState: BottomNavBarState = rememberBottomNavBarState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    searchState: SearchState = rememberSearchState()
): ApplicationState =
    remember {
        ApplicationState(
            bottomNavBarState = bottomNavBarState,
            coroutineScope = coroutineScope,
            searchState = searchState,
            sisterhoodContext = sisterhoodContext
        )
    }

class ApplicationState(
    val bottomNavBarState: BottomNavBarState,
    val coroutineScope: CoroutineScope,
    val searchState: SearchState,
    val sisterhoodContext: SisterhoodContext
) {
    val currentPage: Page
        get() = bottomNavBarState.currentPage
}
