import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import io.ktor.client.engine.okhttp.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import sisterhood.infrastructure.dependency.createMediate
import sisterhood.infrastructure.dependency.initialize
import sisterhood.infrastructure.dependency.injectDependency
import sisterhood.presentation.EntrypointAndroid

class MainActivity : AppCompatActivity() {
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private lateinit var dependencyScope: DependencyScopeTemp
    private lateinit var initialization: Job

    override fun onCreate(savedInstanceState: Bundle?) = coroutineScope.run {
        super.onCreate(savedInstanceState)
        injectDependency {
            context = baseContext
            hentaiRepositoryPath = filesDir.absolutePath.plus("/sqlite.db")
            httpClientEngine = OkHttp.create()
        }.also {
            dependencyScope = it
        }.run {
            initialization = launch { initialize() }
            setContent {
                createMediate()
                EntrypointAndroid()
            }
        }
    }

    override fun onStart() = coroutineScope.run {
        super.onStart()
        if (initialization.isCancelled) {
            dependencyScope.run {
                initialization = launch { initialize() }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        initialization.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        initialization.cancel()
    }
}
