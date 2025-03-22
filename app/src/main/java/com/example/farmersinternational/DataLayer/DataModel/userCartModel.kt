package com.example.farmersinternational.DataLayer.DataModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class userCartModel(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,

    val numberOfItemsInCart: Int? = null,
    val price: Int? = null,

    // cart data, items in cart, exactly the items in the cart, track that by id,
// rest information come later, suspend function

)
