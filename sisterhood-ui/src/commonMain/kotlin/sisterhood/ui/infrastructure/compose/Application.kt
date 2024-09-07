package sisterhood.ui.infrastructure.compose

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import sisterhood.business.commands.FetchLatestHentais

@Composable
fun Application(
    state: ApplicationState
) {
    Scaffold(
        bottomBar = {
            BottomNavBar(
                state = state.bottomNavBarState
            )
        }
    ) {
        when (state.currentPage) {
            Page.HOME -> {
                Home()
            }

            Page.SEARCH -> {
                Search(state = state.searchState)
            }

            Page.SETTINGS -> {
                Settings()
            }
        }
        LaunchedEffect(true) {
            state.sisterhoodContext.mediate(FetchLatestHentais(n = 100, skip = 0))
        }
    }
}
