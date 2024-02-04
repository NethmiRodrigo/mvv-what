package com.example.mvvm.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm.model.Nation
import com.example.mvvm.ui.theme.MvvmTheme
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@Composable
fun NationItem(nation: Nation) {
    Card(modifier = Modifier
        .padding(4.dp, 4.dp)
        .fillMaxWidth()
        .height(100.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp) {
        Surface {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Column {
                    Text(
                        text = "Country",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = "Probability",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(2.dp))
                Column {
                    Text(
                        text = nation.country_id,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp),
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = "${String.format("%.2f", nation.probability * 100) }%",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NationItemPreview() {
    MvvmTheme {
        NationItem(nation = Nation("LK", 0.96))
    }
}
