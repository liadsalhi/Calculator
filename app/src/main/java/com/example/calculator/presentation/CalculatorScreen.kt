package com.example.calculator.presentation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

private val basicButtons = listOf(
    "7", "8", "9",
    "4", "5", "6",
    "1", "2", "3",
    "0",".", "=",
    "<--","C","*",
    "/","+","-"
)



@Composable
fun CalculatorScreen(){
    val calcViewModel: CalculatorViewModel = viewModel()
    val state by calcViewModel.state.collectAsState()
    CalculatorContent(state = state,onAction = calcViewModel::onAction)
}

@Composable
fun CalculatorContent(
    state: CalculatorState,onAction: (CalculatorAction) -> Unit
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ){
        Text(
            text = state.expression,
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = state.result,
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(Modifier.weight(1f))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(basicButtons){ symbol ->
                Button(
                    onClick = { when(symbol){
                        "<--" -> onAction(CalculatorAction.OnDelete)
                        "C" -> onAction(CalculatorAction.OnClear)
                        "=" -> onAction(CalculatorAction.OnCalculate)
                        else -> onAction(CalculatorAction.OnSymbol(symbol))
                    } },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when(symbol) {
                            "<--","C" -> Color.Blue
                            "/","+","*","-","=" -> Color.Gray
                            else -> Color.Black
                        }
                    )
                ) {
                    Text(
                        text = symbol,
                        fontSize = 20.sp
                    )
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun CalculatorPreview(){
    CalculatorContent(state = CalculatorState(expression = "2+3", result = "5"), onAction = {})
}