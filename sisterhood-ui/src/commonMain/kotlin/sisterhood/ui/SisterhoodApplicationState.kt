package sisterhood.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberSisterhoodApplicationState() =
    remember { SisterhoodApplicationState() }

class SisterhoodApplicationState {
}
