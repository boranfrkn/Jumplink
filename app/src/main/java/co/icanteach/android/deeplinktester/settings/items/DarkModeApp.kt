package co.icanteach.android.deeplinktester.settings.items

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.icanteach.android.deeplinktester.R
import co.icanteach.android.deeplinktester.settings.composables.SwitchableItem
import co.icanteach.android.deeplinktester.ui.ThemesPreview
import co.icanteach.android.deeplinktester.ui.core.VerticalSpacer
import co.icanteach.android.deeplinktester.ui.theme.DeeplinkTesterTheme

@Composable
fun DarkModeApp(
    isDarkThemeSelected: Boolean,
    onDarkThemeChanged: (Boolean) -> (Unit)
) {
    SwitchableItem(
        title = stringResource(id = R.string.settings_dark_mode_title),
        description = stringResource(id = R.string.settings_dark_mode_desc),
        icon = painterResource(id = R.drawable.ic_dark_mode),
        isChecked = isDarkThemeSelected,
    ) { result ->
        onDarkThemeChanged.invoke(result)
    }
    VerticalSpacer(value = 32.dp)
}

@ThemesPreview
@Composable
private fun DarkModeAppOff_Preview() {
    DeeplinkTesterTheme {
        Surface {
            DarkModeApp(isDarkThemeSelected = false) {}
        }
    }
}

@ThemesPreview
@Composable
private fun DarkModeAppOn_Preview() {
    DeeplinkTesterTheme {
        Surface {
            DarkModeApp(isDarkThemeSelected = true) {}
        }
    }
}