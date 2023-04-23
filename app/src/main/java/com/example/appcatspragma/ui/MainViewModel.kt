package com.example.appcatspragma.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcatspragma.data.model.Cat
import com.example.appcatspragma.domain.usecases.GetCatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCaseGetAllCats: GetCatsUseCase
) : ViewModel() {

    private var _uiState: MutableStateFlow<MainUiState> = MutableStateFlow( MainUiState() )
    val uiState = _uiState.asStateFlow()

    init {
        getCats()
    }

    private fun getCats() {
        viewModelScope.launch{

            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }

            try {

                useCaseGetAllCats().onEach { listCats ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            listCats = listCats
                        )
                    }
                }.launchIn(viewModelScope)

            } catch (e: Exception) {

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        userMessage = e.message.toString()
                    )
                }

            }
        }
    }


}

data class MainUiState(
    val isLoading: Boolean = false,
    val listCats: List<Cat> = emptyList(),
    val userMessage: String = ""
)