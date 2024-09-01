package sisterhood.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import sisterhood.ui.Entrypoint

@Composable
fun ApplicationScope.EntrypointDesktop(onExit: () -> Unit) =
    Window(
        onCloseRequest = {
            onExit()
            exitApplication()
        },
        title = "Sisterhood",
    ) {
        Entrypoint()
    }

