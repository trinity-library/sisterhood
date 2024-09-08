package sisterhood.infrastructure.sqldelight

import app.cash.sqldelight.ColumnAdapter
import sisterhood.domain.hentai.HentaiStatus

fun hentaiStatusAdapter() = object : ColumnAdapter<HentaiStatus, String> {
    override fun decode(databaseValue: String): HentaiStatus = try {
        HentaiStatus(status = databaseValue)
    } catch (exception: IllegalArgumentException) {
        throw Exception()  // TODO: cannot parse
    }

    override fun encode(value: HentaiStatus): String =
        value::class.simpleName!!
}
