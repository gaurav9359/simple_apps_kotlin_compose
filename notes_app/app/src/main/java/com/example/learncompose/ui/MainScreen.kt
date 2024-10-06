package com.example.learncompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learncompose.model.NotesModel
import com.example.learncompose.navigation.NavigationItem
import com.example.learncompose.viewmodel.NotesViewModel
import com.example.learncompose.ui.note.singleNoteView


@Composable
fun mainScreen(navController: NavController, viewModel:NotesViewModel, setNotesDataAndNavigate:(NotesModel, NotesViewModel,NavController)->Unit, modifier: Modifier){
    Box(modifier=modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            for(item in viewModel._notes){
                Row(
                    modifier = Modifier.padding(top=20.dp)
                ){
                    singleNoteView(navController, viewModel, item = item, setNotesDataAndNavigate)

                }

            }
        }
        Column(modifier=Modifier.fillMaxSize().padding(bottom = 10.dp,end=10.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End) {
            Button(onClick = { navController.navigate(NavigationItem.CreateForm.route)},
            ) {
                Text(text = "+")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun mainScreenPreview() {
//    // Mock NotesViewModel with sample data
//    val mockNotesViewModel = NotesViewModel().apply {
//        notesList = mutableListOf(
//            NotesModel(1, "Note 1", "Description for Note 1"),
//            NotesModel(2, "Note 2", "Description for Note 2"),
//            NotesModel(3, "Note 3", "Description for Note 3")
//        )
//    }
//
//    // Dummy function for navigation
//    val dummyNavigate: (NotesModel, NotesViewModel) -> Unit = { _, _ -> }
//
//    // Show the main screen in preview
////    mainScreen(viewModel = mockNotesViewModel, setNotesDataAndNavigate = dummyNavigate)
//}

