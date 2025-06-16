import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.adrija.f1now.ui.theme.DarkColorScheme
import com.adrija.f1now.ui.theme.Typography

@Composable
fun F1NowTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = DarkColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
