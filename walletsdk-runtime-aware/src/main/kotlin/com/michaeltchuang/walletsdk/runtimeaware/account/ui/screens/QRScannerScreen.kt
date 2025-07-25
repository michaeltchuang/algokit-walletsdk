package com.michaeltchuang.walletsdk.runtimeaware.account.ui.screens

import android.Manifest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.michaeltchuang.walletsdk.runtimeaware.account.ui.components.OnBoardingScreens
import com.michaeltchuang.walletsdk.runtimeaware.account.ui.components.PermissionRationaleDialog
import com.michaeltchuang.walletsdk.runtimeaware.account.ui.viewmodel.QRScannerViewModel
import com.michaeltchuang.walletsdk.runtimeaware.designsystem.widget.AlgoKitTopBar
import org.koin.androidx.compose.koinViewModel
import qrscanner.CameraLens
import qrscanner.QrScanner
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Scaffold

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun QRCodeScannerScreen(
    navController: NavController,
    onQrScanned: (String) -> Unit
) {
    val viewModel: QRScannerViewModel = koinViewModel()
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    val hasProcessedResult = remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.viewEvent.collect {
            when (it) {
                is QRScannerViewModel.ViewEvent.NavigateToRecoveryPhraseScreen -> {
                    navController.navigate(OnBoardingScreens.RECOVER_PHRASE_SCREEN.name + "/${it.mnemonic}")
                }
                is QRScannerViewModel.ViewEvent.ShowUnrecognizedDeeplink -> {
                    snackbarHostState.showSnackbar("Unrecognized QR Code")
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                cameraPermissionState.status.isGranted -> {
                    QrScanner(
                        modifier = Modifier.fillMaxSize(),
                        flashlightOn = false,
                        cameraLens = CameraLens.Back,
                        openImagePicker = false,
                        onCompletion = {
                            if (!hasProcessedResult.value) {
                                viewModel.handleDeeplink(it)
                                onQrScanned(it)
                                hasProcessedResult.value = true
                            }
                        },
                        imagePickerHandler = {},
                        onFailure = {},
                    )
                }

                cameraPermissionState.status.shouldShowRationale || !cameraPermissionState.status.isGranted -> {
                    PermissionRationaleDialog(
                        onRequestPermission = { cameraPermissionState.launchPermissionRequest() },
                        onDismiss = { navController.popBackStack() }
                    )
                }
            }
            AlgoKitTopBar(
                modifier = Modifier.padding(horizontal = 24.dp),
                onClick = { navController.popBackStack() }
            )
        }
    }
}
