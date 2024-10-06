package com.example.learncompose.ui.note

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learncompose.model.NotesModel
import com.example.learncompose.viewmodel.NotesViewModel

@Composable
fun singleNoteView(navController: NavController,viewModel: NotesViewModel,item:NotesModel, setNotesDataAndNavigate:(NotesModel, NotesViewModel, NavController)->Unit){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { setNotesDataAndNavigate(item, viewModel,navController) },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Text(text = item.title, modifier = Modifier.padding(10.dp), maxLines = 1)
        HorizontalDivider()
        Text(text = item.description, modifier = Modifier.padding(10.dp))
    }
}

private val dummyFun:(NotesModel,NotesViewModel)->Unit ={item,viewModel->
    Log.d("currId", "1")
}

//@Preview
//@Composable
//fun getPreview(){
//    singleNoteView(NotesViewModel(),item = NotesModel(1, "subject", "this is my fav Subject"),dummyFun)
//}