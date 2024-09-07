package sisterhood.ui.infrastructure.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import sisterhood.ui.infrastructure.koin.commonModule

@Composable
fun ApplicationScope.EntrypointDesktop() =
    Window(
        onCloseRequest = {
            exitApplication()
        },
        title = "Sisterhood",
    ) {
        Entrypoint {
            insertKoin {
                modules(commonModule)
            }
        }
    }

