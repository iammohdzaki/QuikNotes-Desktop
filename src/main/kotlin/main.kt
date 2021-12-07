import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import repository.NotesRepository
import theme.LightThemeColors
import theme.typography
import ui.home.homeScreen
import utils.Strings

@ExperimentalMaterialApi
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(width = 1000.dp, height = 720.dp),
        title = Strings.APP_NAME
    ) {
        MaterialTheme(
            colors = LightThemeColors,
            typography = typography
        ) {
            //Initialize Repository
            val repository = NotesRepository()
            //Show Home Screen
            homeScreen(repository)
        }
    }

}
