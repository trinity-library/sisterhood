package sisterhood.infrastructure

import kotlinx.coroutines.flow.Flow
import sisterhood.domain.Id

interface Cache<T> {
    suspend fun read(vararg id: Id): Flow<T>
    suspend fun write(vararg gallery: T)
}
