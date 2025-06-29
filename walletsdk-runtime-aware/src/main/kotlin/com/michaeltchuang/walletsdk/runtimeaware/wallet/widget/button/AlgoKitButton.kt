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

package com.michaeltchuang.walletsdk.runtimeaware.wallet.widget.button

import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.Horizontal
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.michaeltchuang.walletsdk.runtimeaware.wallet.theme.AlgoKitTheme
import com.michaeltchuang.walletsdk.runtimeaware.wallet.widget.progress.PeraCircularProgressIndicator


@Composable
private fun PeraCoreButton(modifier: AlgoKitButtonModifier) {
    Button(
        onClick = { modifier.onClick() },
        modifier = modifier.modifier,
        shape = RoundedCornerShape(modifier.cornerRadius),
        colors = modifier.colors,
        enabled = modifier.state == AlgoKitButtonState.ENABLED,
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            horizontalArrangement = modifier.horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (modifier.state) {
                AlgoKitButtonState.PROGRESS -> {
                    PeraCircularProgressIndicator(
                        color = if (modifier.state == AlgoKitButtonState.DISABLED) {
                            modifier.colors.disabledContentColor
                        } else {
                            modifier.colors.contentColor
                        }
                    )
                }

                else -> {
                    if (modifier.leftIcon != null) {
                        modifier.leftIcon.invoke()
                        Spacer(modifier = Modifier.width(12.dp))
                    }

                    Text(
                        text = modifier.text,
                        style = modifier.textStyle,
                        color = if (modifier.state == AlgoKitButtonState.DISABLED) {
                            modifier.colors.disabledContentColor
                        } else {
                            modifier.colors.contentColor
                        }
                    )

                    if (modifier.horizontalArrangement == Start) {
                        Spacer(Modifier.weight(1f))
                    }

                    if (modifier.rightIcon != null) {
                        Spacer(modifier = Modifier.width(16.dp))
                        modifier.rightIcon.invoke()
                    }
                }
            }
        }
    }
}

@Composable
fun PeraPrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    state: AlgoKitButtonState = AlgoKitButtonState.ENABLED,
    leftIcon: @Composable (() -> Unit)? = null,
    rightIcon: @Composable (() -> Unit)? = null,
    horizontalArrangement: Horizontal = Center
) {
    PeraCoreButton(
        modifier = AlgoKitButtonModifier(
            modifier = modifier,
            onClick = onClick,
            text = text,
            textStyle = AlgoKitTheme.typography.body.regular.sansMedium,
            colors = ButtonDefaults.buttonColors(
                containerColor = AlgoKitTheme.colors.buttonPrimaryBg,
                disabledContainerColor = AlgoKitTheme.colors.buttonPrimaryDisabledBg,
                contentColor = AlgoKitTheme.colors.buttonPrimaryText,
                disabledContentColor = AlgoKitTheme.colors.buttonPrimaryDisabledText
            ),
            state = state,
            leftIcon = leftIcon,
            rightIcon = rightIcon,
            horizontalArrangement = horizontalArrangement
        )
    )
}

@Composable
fun PeraSecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    state: AlgoKitButtonState = AlgoKitButtonState.ENABLED,
    leftIcon: @Composable (() -> Unit)? = null,
    rightIcon: @Composable (() -> Unit)? = null,
    cornerRadius: Dp = 4.dp,
    horizontalArrangement: Horizontal = Center
) {
    PeraCoreButton(
        modifier = AlgoKitButtonModifier(
            modifier = modifier,
            onClick = onClick,
            text = text,
            textStyle = AlgoKitTheme.typography.body.regular.sansMedium,
            colors = ButtonDefaults.buttonColors(
                containerColor = AlgoKitTheme.colors.buttonSecondaryBg,
                disabledContainerColor = AlgoKitTheme.colors.buttonSecondaryDisabledBg,
                contentColor = AlgoKitTheme.colors.buttonSecondaryText,
                disabledContentColor = AlgoKitTheme.colors.buttonSecondaryDisabledText
            ),
            state = state,
            leftIcon = leftIcon,
            rightIcon = rightIcon,
            cornerRadius = cornerRadius,
            horizontalArrangement = horizontalArrangement
        )
    )
}

@Composable
fun PeraTertiaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    state: AlgoKitButtonState = AlgoKitButtonState.ENABLED,
    leftIcon: @Composable (() -> Unit)? = null,
    rightIcon: @Composable (() -> Unit)? = null,
    horizontalArrangement: Horizontal = Center
) {
    PeraCoreButton(
        modifier = AlgoKitButtonModifier(
            modifier = modifier,
            onClick = onClick,
            text = text,
            colors = ButtonDefaults.buttonColors(
                containerColor = AlgoKitTheme.colors.buttonSecondaryBg,
                disabledContainerColor = AlgoKitTheme.colors.buttonSecondaryDisabledBg,
                contentColor = AlgoKitTheme.colors.buttonSecondaryText,
                disabledContentColor = AlgoKitTheme.colors.buttonSecondaryDisabledText
            ),
            state = state,
            leftIcon = leftIcon,
            rightIcon = rightIcon,
            cornerRadius = 16.dp,
            textStyle = AlgoKitTheme.typography.body.large.sansMedium,
            horizontalArrangement = horizontalArrangement
        )
    )
}
