package com.example.farmersinternational.presentationLayer.UiState

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface GeneralState<out T> {
    data class Success<T>(val data: T): GeneralState<T>
    data class Error(val exception: Throwable):GeneralState<Nothing>
    data object Loading: GeneralState<Nothing>
}
fun<T> Flow<T>.asGeneralState() : Flow<GeneralState<T>> = map<T, GeneralState<T>>{GeneralState.Success(it)}
    .onStart { emit(GeneralState.Loading) }
    .catch { emit(GeneralState.Error(it)) }

