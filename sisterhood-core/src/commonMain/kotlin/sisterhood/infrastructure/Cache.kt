package sisterhood.infrastructure

import kotlinx.coroutines.flow.Flow
import sisterhood.lib.hitomi.Gallery

interface Cache {
    suspend fun read(vararg id: Int): Flow<Gallery>
    suspend fun write(vararg gallery: Gallery)
}
