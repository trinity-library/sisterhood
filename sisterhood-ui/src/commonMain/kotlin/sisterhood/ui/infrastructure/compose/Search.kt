package sisterhood.ui.infrastructure.compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun Search(
    state: SearchState
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(200.dp),
        state = state.lazyStaggeredGridState
    ) {

    }
}

@Preview
@Composable
private fun SearchPreview() {
    Search(state = rememberSearchState())
}
