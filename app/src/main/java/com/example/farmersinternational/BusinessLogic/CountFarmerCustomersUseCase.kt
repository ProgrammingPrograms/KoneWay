package com.example.farmersinternational.domainlayer

import com.example.farmersinternational.dataLayer.entity.User
import com.example.farmersinternational.dataLayer.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CustomerCounterUseCase @Inject constructor(private val userRepository: UserRepository) {
   private val _counter = MutableStateFlow(0L)
    val counter: StateFlow<Long> = _counter.asStateFlow()

    suspend operator fun invoke(user:User, userId:Long): StateFlow<Long> {
         userRepository.getUserWhoBuying(userId).collect{theUsers ->
             if (theUsers != null) {
                 _counter.value += 1
             }

         }
        return counter
    }
}

