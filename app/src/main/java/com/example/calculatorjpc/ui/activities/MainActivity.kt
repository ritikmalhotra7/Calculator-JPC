package com.example.calculatorjpc.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorjpc.ui.theme.CalculatorJPCTheme
import com.example.calculatorjpc.ui.theme.Gray
import com.example.calculatorjpc.ui.theme.darkGrey
import com.example.calculatorjpc.ui.theme.Orange
import com.example.calculatorjpc.ui.viewmodels.CalculatorViewModel
import com.example.calculatorjpc.utils.CalculatorActions
import com.example.calculatorjpc.utils.CalculatorButton
import com.example.calculatorjpc.utils.CalculatorOperator
import com.example.calculatorjpc.utils.CalculatorState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorJPCTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                MainScreen(
                    state = state,
                    buttonSpacing = 8.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(darkGrey)
                        .padding(8.dp),
                    onAction = viewModel::onAction
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorActions) -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "AC",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = { onAction(CalculatorActions.Clear) }
                )
                CalculatorButton(
                    text = "Del",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Delete) }
                )
                CalculatorButton(
                    text = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperator.Divide)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "7",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(7)) }
                )
                CalculatorButton(
                    text = "8",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(8)) }
                )
                CalculatorButton(
                    text = "9",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(9)) }
                )

                CalculatorButton(
                    text = "*",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperator.Multiply)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "4",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(4)) }
                )
                CalculatorButton(
                    text = "5",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(5)) }
                )
                CalculatorButton(
                    text = "6",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(6)) }
                )

                CalculatorButton(
                    text = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperator.Subtract)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "1",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(1)) }
                )
                CalculatorButton(
                    text = "2",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(2)) }
                )
                CalculatorButton(
                    text = "3",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(3)) }
                )

                CalculatorButton(
                    text = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperator.Add)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "0",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = { onAction(CalculatorActions.Numbers(0)) }
                )
                CalculatorButton(
                    text = ".",
                    modifier = Modifier
                        .background(Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Decimal) }
                )

                CalculatorButton(
                    text = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Calculate) }
                )
            }

        }
    }
}