package sisterhood.ui.infrastructure.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun rememberBottomNavBarState(
    initialPage: Page = Page.HOME
): BottomNavBarState =
    remember(initialPage) {
        BottomNavBarState(
            initialPage = initialPage
        )
    }


class BottomNavBarState(
    initialPage: Page
) {
    private val currentPageState: MutableState<Page> = mutableStateOf(initialPage)
    var currentPage: Page
        get() = currentPageState.value
        set(value) {
            currentPageState.value = value
        }
}
