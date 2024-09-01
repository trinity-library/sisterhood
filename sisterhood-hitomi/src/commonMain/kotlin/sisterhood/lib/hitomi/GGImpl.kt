package sisterhood.lib.hitomi

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class GGImpl(ggJs: String) : GG {
    private val caseNumbers: Set<Int>
    private val bString: String
    private val oBefore: Int
    private val oAfter: Int

    private val fetchedAt: Instant = Clock.System.now()

    init {
        val caseNumbersPattern = Regex("(?<=case )[0-9]+(?=:)")
        val bStringPattern = Regex("(?<=b: ')[0-9]+/(?=')")
        val oBeforePattern = Regex("(?<=var o = )[0-1](?=;)")
        val oAfterPattern = Regex("(?<=o = )[0-1](?=; break;)")

        caseNumbers = caseNumbersPattern.findAll(ggJs).map { it.value.toInt() }.toSet()
        bString = bStringPattern.find(ggJs)?.value ?: throw Error("Cannot find `b string`")
        oBefore = oBeforePattern.find(ggJs)?.value?.toInt() ?: throw Error("Cannot find `o before`")
        oAfter = oAfterPattern.find(ggJs)?.value?.toInt() ?: throw Error("Cannot find `o after`")
    }

    override val b: String
        get() = bString

    override fun m(g: Int): Int =
        if (caseNumbers.contains(g)) oAfter else oBefore

    override fun s(h: String): Int =
        Regex("(..)(.)$").find(h)!!.groupValues.let { it[2] + it[1] }.toInt(16)
}
