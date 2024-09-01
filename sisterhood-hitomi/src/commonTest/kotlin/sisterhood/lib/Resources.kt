package sisterhood.lib

import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.readString

const val RESOURCES_PATH = "./src/commonTest/resources/"
const val GALLERYJS_RESOURCE_PATH = RESOURCES_PATH + "gallery.js"
const val GGJS_RESOURCE_PATH = RESOURCES_PATH + "gg.js"

object Resources {
    val galleryJs: String
        get() = readString(Path(path = GALLERYJS_RESOURCE_PATH))

    val ggJs: String
        get() = readString(Path(path = GGJS_RESOURCE_PATH))
    
    private fun readString(path: Path): String =
        SystemFileSystem.source(path).buffered().readString()
}
