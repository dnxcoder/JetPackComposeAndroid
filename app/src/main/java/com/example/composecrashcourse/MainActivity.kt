package com.example.composecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecrashcourse.ui.theme.ComposeCrashCourseTheme
import com.example.composecrashcourse.R
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            ComposeCrashCourseTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen () {

    var name by remember {
        mutableStateOf("")
    }

    var names by remember {
        mutableStateOf(listOf<String>())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 10.dp, end = 10.dp)
    ){
        Row (modifier = Modifier.fillMaxWidth()){
            OutlinedTextField(
                value = name,
                onValueChange = { text ->
                    name = text;
                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier =  Modifier.width(16.dp))
            Button( onClick = {
                if(name.isNotBlank()){
                    names = names + name;
                    name = "";
                }
            }) {
                Text(text = "Add")
            }
        }
     NameList(names, modifier = Modifier.background(color = Color.Gray))
    }

}

@Composable
fun NameList (names: List<String>, modifier: Modifier = Modifier, textColor: Color? = null){

    LazyColumn (modifier = modifier){
        items(names) { currentName ->
            Text(text = currentName, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                color = textColor ?: Color.White
            )
            HorizontalDivider()
        }
    }
}

