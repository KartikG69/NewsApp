package com.example.newsapp.presentation.bookmarks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.newsapp.presentation.home.NewsListView
import com.example.newsapp.utils.NavRoute

@Composable
fun BookmarksScreen(navHostController: NavHostController) {
    val viewModel: BookmarksViewModel = hiltViewModel()
    val bookmarks = viewModel.getBookmarks().collectAsState(initial = listOf())
    Column(modifier = Modifier.padding(24.dp).fillMaxSize()) {
        Text(text = "Bookmarks", fontSize = 30.sp)
        Spacer(modifier = Modifier.size(16.dp))
        NewsListView(bookmarks.value, onClick = {
            navHostController.navigate(NavRoute.createNewsDetailsRoute(it, true))
        })
    }
}