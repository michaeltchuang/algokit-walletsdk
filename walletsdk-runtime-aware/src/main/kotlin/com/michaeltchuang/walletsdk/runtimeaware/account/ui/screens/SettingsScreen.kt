package com.michaeltchuang.walletsdk.runtimeaware.account.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.michaeltchuang.walletsdk.runtimeaware.R
import com.michaeltchuang.walletsdk.runtimeaware.account.ui.components.OnBoardingScreens
import com.michaeltchuang.walletsdk.runtimeaware.designsystem.theme.AlgoKitTheme

@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AlgoKitTheme.colors.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {

        Text(
            text = stringResource(R.string.settings),
            modifier = Modifier
                .padding(vertical = 16.dp),
            color = AlgoKitTheme.colors.textMain,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Section: App Preferences
        Text(
            text = stringResource(R.string.app_preferences),
            color = AlgoKitTheme.colors.textMain,
            style = AlgoKitTheme.typography.body.regular.sansMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        SettingsItem(R.drawable.ic_moon, stringResource(R.string.theme), navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Section: Support
        Text(
            text = stringResource(R.string.support),
            color = AlgoKitTheme.colors.textMain,
            style = AlgoKitTheme.typography.body.regular.sansMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        SettingsItem(R.drawable.ic_feedback, stringResource(R.string.get_help), navController)
        SettingsItem(
            R.drawable.ic_text_document,
            stringResource(R.string.privacy_policy),
            navController
        )
        SettingsItem(
            R.drawable.ic_text_document,
            stringResource(R.string.terms_and_services),
            navController
        )
        SettingsItem(
            R.drawable.ic_code,
            stringResource(R.string.developer_settings),
            navController
        )
    }
}

@Composable
fun SettingsItem(icon: Int, title: String, navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate(OnBoardingScreens.THEME_SCREEN.name) }
            .padding(vertical = 12.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = title,
            tint = AlgoKitTheme.colors.textMain,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            color = AlgoKitTheme.colors.textMain,
            modifier = Modifier.weight(1f),
            style = AlgoKitTheme.typography.body.regular.sansMedium,
        )
        Icon(
            Icons.Default.KeyboardArrowRight,
            tint = AlgoKitTheme.colors.textMain,
            contentDescription = stringResource(R.string.next)
        )
    }
}

@PreviewLightDark
@Composable
fun SettingsScreenPreview() {
    AlgoKitTheme {
        SettingsScreen(navController = rememberNavController())
    }
}

