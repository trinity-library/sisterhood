package sisterhood.ui.infrastructure.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import sisterhood.ui.infrastructure.SisterhoodContext
import sisterhood.ui.infrastructure.SisterhoodContextInitialization

@Composable
fun Entrypoint(context: SisterhoodContext) = context.run {
    MaterialTheme {
        Application(
            state = rememberApplicationState(context)
        )
    }
}

@Composable
fun Entrypoint(prepareInitialization: SisterhoodContextInitialization.() -> Unit) {
    Entrypoint(
        context = SisterhoodContextInitialization().apply(prepareInitialization).initialize()
    )
}
