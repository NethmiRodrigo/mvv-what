package com.example.mvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm.model.Nation
import com.example.mvvm.ui.theme.MvvmTheme
import com.example.mvvm.view.components.NationItem
import com.example.mvvm.view.components.SearchBar
import com.example.mvvm.viewModel.NationViewModel

@Composable
fun HomeScreen(viewModel: NationViewModel) {
    val query = remember { mutableStateOf(TextFieldValue("")) }

    Column {
        SearchBar(query, search = { viewModel.getResult(it) })
        if (viewModel.nationListResponse.isEmpty()) {
            Card(
                modifier = Modifier
                    .padding(4.dp, 4.dp)
                    .fillMaxWidth()
                    .height(40.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "No Results Found",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
        } else NationList(viewModel.nationListResponse)
    }

}

@Composable
fun NationList(nationList: List<Nation>) {
    LazyColumn {
        itemsIndexed(items = nationList) { _: Int, item: Nation ->
            NationItem(nation = item)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MvvmTheme {
        HomeScreen(viewModel = NationViewModel())
    }
}