package sisterhood.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SisterhoodApplication(
    state: SisterhoodApplicationState = rememberSisterhoodApplicationState()
) {
    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) {
        Text("Hello, world!")
    }
}
