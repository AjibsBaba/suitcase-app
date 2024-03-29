package com.application.suitcase.ui.suitcase

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.application.suitcase.SuitcaseNavBar
import com.application.suitcase.model.Suitcase
import com.application.suitcase.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSuitcase(viewModel: SuitcaseViewModel, navController: NavController) {

    var name by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var price by remember {
        mutableStateOf("")
    }

    var quantity by remember {
        mutableIntStateOf(0)
    }

    var imageURL by remember {
        mutableStateOf("")
    }

    val purchaseStatus by remember {
        mutableStateOf(false)
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Add Suitcase") }, actions = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.Clear, "Delete Button")
            }

        })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(value = name, onValueChange = { name = it },
                    label = { Text("Name") }, singleLine = true, modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    singleLine = false,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(value = price, onValueChange = { price = it },
                    label = { Text("Price") }, singleLine = true, modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(value = quantity.toString(),
                    onValueChange = { quantity = it.toInt() },
                    label = { Text("Quantity") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(value = imageURL,
                    onValueChange = { imageURL = it },
                    label = { Text("Image URL") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Create Record")
            }

        }

    }
}

@Composable
fun SuitcaseList(
    suitcases: List<Suitcase>
) {
    LazyColumn {
        items(suitcases) { suitcase ->
            SuitcaseItem(suitcase)
        }
    }
}


@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun SuitcaseItem(suitcase: Suitcase) {

    val state = rememberSwipeableCardState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Purple80)
            .padding(18.dp)
            .swipableCard(state = state, onSwiped = {
                direction ->
                Toast.makeText(context, "Card was swiped to the $direction", Toast.LENGTH_SHORT).show()
            }, onSwipeCancel = {
                Toast.makeText(context, "Card was swipe was cancelled", Toast.LENGTH_SHORT).show()
            }),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text = suitcase.name)
            Text(text = "Price: ${suitcase.price}")
        }
    }

}


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchasedScreen(navController: NavController, viewModel: SuitcaseViewModel) {

    Scaffold(
        topBar = { TopAppBar(title = { Text("Purchased Suitcases") }) },
        bottomBar = {
            SuitcaseNavBar(index = 1, navController)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp), verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text("No item has been purchased")
        }
    }
}


@Composable
@Preview
fun SuitcaseModalPreview() {
    AddSuitcase(viewModel = SuitcaseViewModel(), navController = rememberNavController())
}