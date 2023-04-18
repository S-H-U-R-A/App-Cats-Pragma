package com.example.appcatspragma.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.appcatspragma.R
import com.example.appcatspragma.data.model.Cat
import com.example.appcatspragma.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObservers()

    }

    private fun initObservers() {

        //SE ESCUCHA EL ESTADO
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState
                    .collect{
                        handleLoading( it.isLoading )
                        handleListCat ( it.listCats )
                    }
            }
        }

    }

    private fun handleLoading(isVisible: Boolean) {
        binding.piQuery.isVisible = isVisible
    }

    private fun handleListCat(listCats: List<Cat>) {

    }



    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}