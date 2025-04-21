package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.domainModel.Product
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

data class AddProductUiState(
    val productId: Long?= null,
    val farmerId:Long?= null,
    val imageUrl: String = "",
    val name: String = "",
    val price: Int = 0,
    val description: String= "",
    val fruitOrVegetable: Boolean = false,
    val isGmo: Boolean= false,
    val isOrganic: Boolean= false,
    val isGrownIn: String = "",
    val isProductAdded: Boolean=false
    )
class AddProductViewModel@Inject constructor(private val offlineFirstProductRepository: OfflineFirstProductRepository):ViewModel() {

    val _productUiState = MutableStateFlow(AddProductUiState())
        val productUiState: StateFlow<AddProductUiState> = _productUiState.asStateFlow()

        private fun addProduct(){
            viewModelScope.launch {//when they order the
                val newProduct = Product(
                    productUiState.value.productId,
                    productUiState.value.farmerId,
                    productUiState.value.imageUrl,
                    productUiState.value.name,
                    productUiState.value.price,
                    productUiState.value.description,
                    productUiState.value.fruitOrVegetable,
                    productUiState.value.isGmo,
                    productUiState.value.isOrganic,
                    productUiState.value.isGrownIn,
                )
                try {
                    offlineFirstProductRepository.insertOrIgnoreProduct(newProduct)
                    _productUiState.update { it.copy(
                        isProductAdded = true
                    ) }
                }
                catch (cancellationException: CancellationException){
                    throw cancellationException
                }
                catch (exception:Exception){
                    throw exception
                }
            }
        }

    }