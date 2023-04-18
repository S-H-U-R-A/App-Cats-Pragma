package com.example.appcatspragma.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.appcatspragma.data.model.Cat
import com.example.appcatspragma.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapterRvCats: CatListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        initObservers()

    }

    private fun initComponents() {
        //SE CONFIGURA EL ADAPTADOR
        adapterRvCats = CatListAdapter()
        binding.rvCats.adapter = adapterRvCats
    }

    private fun initObservers() {
        //SE ESCUCHA EL ESTADO
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.uiState
                    .collect{ stateUi ->
                        handleLoading( stateUi.isLoading )
                        handleListCat ( stateUi.listCats )
                    }
            }
        }
    }

    private fun handleLoading(isVisible: Boolean) {
        binding.piQuery.isVisible = isVisible
    }

    private fun handleListCat( listCats: List<Cat> ) {
        //SE ENVIA LA LISTA DE GATOS AL ADAPTER
        Log.d("MAINACTIVITY", listCats.toString() )
        adapterRvCats.submitList( listCats )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}