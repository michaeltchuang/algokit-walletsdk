/*
 * Copyright (c) 2025 Pera Wallet, LDA
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.michaeltchuang.walletsdk.runtimeaware.wallet.widget.progress

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.michaeltchuang.walletsdk.runtimeaware.wallet.theme.AlgoKitTheme

@Composable
fun PeraCircularProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = AlgoKitTheme.colors.linkPrimary,
    strokeWidth: Dp = 3.dp
) {
    CircularProgressIndicator(
        modifier = modifier
            .width(24.dp)
            .height(24.dp),
        color = color,
        strokeWidth = strokeWidth
    )
}
