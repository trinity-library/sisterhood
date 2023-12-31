package sisterhood.application.ui.hentai

import androidx.compose.runtime.Composable
import sisterhood.usecase.HentaiInfo

@Composable
fun HentaiComponent(
    hentaiGridColumns: Int,
    hentaiGridState: HentaiGridState = rememberHentaiGridState(),
    onPressItem: (HentaiInfo) -> Unit = {},
) {
    HentaiGrid(
        columns = hentaiGridColumns,
        onPressItem = onPressItem,
        state = hentaiGridState
    )
}
