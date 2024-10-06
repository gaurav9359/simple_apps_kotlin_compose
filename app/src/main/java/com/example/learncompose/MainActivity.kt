package com.example.learncompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.annotation.Dimension
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.learncompose.model.NotesModel
import com.example.learncompose.navigation.Navigation
import com.example.learncompose.navigation.Route
import com.example.learncompose.ui.form.createNotes
import com.example.learncompose.ui.mainScreen
import com.example.learncompose.ui.note.singleNoteView
import com.example.learncompose.ui.theme.LearnComposeTheme
import com.example.learncompose.viewmodel.NotesViewModel
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun MyApp(navController: NavController,viewModel: NotesViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        mainScreen(navController, viewModel = viewModel, setNotesAndNavigate, modifier=Modifier.weight(1f))
    }
}

val setNotesAndNavigate:(NotesModel, NotesViewModel, navController: NavController)->Unit={ item, viewModel, navController->
    viewModel.id=item.id
    viewModel.curr_desc.value=item.description
    viewModel.curr_title.value=item.title

    navController.navigate(Route.CreateNote.name);
}

//@Composable
//fun Greeting(name: String) {
//    Text(
//        color = Color.Red,
//        text = "Hello $name!"
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    val context= LocalContext.current
//    var checked2= false;
//    MaterialTheme {
//        Column(
//            Modifier
//                .fillMaxSize()
//                .background(Color.Cyan),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ){
//            Text(
//                color = Color.Red,
//                text = "Hello orewa!",
//                modifier = Modifier
//                    .background(Color.Gray)
//                    .padding(top = 40.dp)
//                    .clickable {
//                        Toast
//                            .makeText(context, "oreno", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//            )
//            Greeting(name = "namaiva gaurav")
//            Button(onClick = { Toast.makeText(context, "name", Toast.LENGTH_SHORT).show() }) {
//                Text(text = "click me")
//            }
//            Checkbox(checked = checked2, onCheckedChange = {checked->  checked2=checked
//                Toast.makeText(context, "checked", Toast.LENGTH_SHORT).show()})
//        }
//    }

//}