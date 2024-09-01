package sisterhood.lib.hitomi

class FakeGG : GG {
    override val b: String
        get() = "foo"

    override fun m(g: Int): Int = 123

    override fun s(h: String): Int = 456
}
