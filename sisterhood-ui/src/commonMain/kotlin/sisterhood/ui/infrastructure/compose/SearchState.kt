package sisterhood.ui.infrastructure.compose

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberSearchState(
    lazyStaggeredGridState: LazyStaggeredGridState = rememberLazyStaggeredGridState()
) = remember(lazyStaggeredGridState) {
    SearchState(
        lazyStaggeredGridState = lazyStaggeredGridState
    )
}

class SearchState(
    val lazyStaggeredGridState: LazyStaggeredGridState
)
