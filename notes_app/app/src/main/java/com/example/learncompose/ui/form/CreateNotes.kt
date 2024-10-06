package com.example.learncompose.ui.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learncompose.navigation.Route
import com.example.learncompose.viewmodel.NotesViewModel


@Composable
fun createNotes(navController: NavController, viewModel: NotesViewModel,modifier: Modifier?) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),  // Adjust padding
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),  // Space between rows
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Title: ",
                    modifier = Modifier.weight(1f)  // Allocate space
                )
                TextField(
                    value = viewModel.curr_title.value,
                    onValueChange = {it:String-> viewModel.curr_title.value = it },
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Description: ",
                    modifier = Modifier.weight(1f)
                )
                TextField(
                    value = viewModel.curr_desc.value,
                    onValueChange = { viewModel.curr_desc.value = it },
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                )
            }

            Row {
                Button(onClick = { viewModel.insertNotes(); navController.popBackStack()},
                    modifier = Modifier.fillMaxWidth()
                        .padding(top= 30.dp)) {
                    Text(text = "Add Note")
                }
            }

            Row(modifier = Modifier.padding(top= 10.dp)) {
                Button(onClick = { viewModel.deleteNotes();navController.popBackStack() },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)) {
                    Text(text = "Delete Note")
                }

                Button(onClick = { viewModel.updateNotes(); navController.popBackStack() },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)) {
                    Text(text = "Update Note")
                }
            }
        }
}


@Preview(showBackground = true)
@Composable
fun preview(){
//    createNotes(viewModel = NotesViewModel());
}