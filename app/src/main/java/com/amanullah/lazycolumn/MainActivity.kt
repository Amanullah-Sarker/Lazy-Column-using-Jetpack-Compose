package com.amanullah.lazycolumn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amanullah.lazycolumn.repository.PersonRepository
import com.amanullah.lazycolumn.ui.theme.LazyColumnTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val personRepository = PersonRepository()
                    val getAllData = personRepository.getAllData()

//                    LazyColumn{
//                        items(items = getAllData)
//                        { person ->
//                            CustomItem(person = person)
//                        }
//                    }

//                    LazyColumn(
//                        contentPadding = PaddingValues(12.dp),
//                        verticalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        items(items = getAllData)
//                        { person ->
//                            CustomItem(person = person)
//                        }
//                    }

//                    LazyColumn(
//                        contentPadding = PaddingValues(12.dp),
//                        verticalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        itemsIndexed(items = getAllData)
//                        { index, person ->
//                            Log.d("MainActivity", index.toString())
//                            CustomItem(person = person)
//                        }
//                    }

                    LazyColumn(
                        contentPadding = PaddingValues(12.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        itemsIndexed(
                            items = getAllData,
                            key = { index, person ->
                                person.id
                            }
                        )
                        { index, person ->
                            Log.d("MainActivity", index.toString())
                            CustomItem(person = person)
                        }
                    }
                }
            }
        }
    }
}