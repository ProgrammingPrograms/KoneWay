package com.example.farmersinternational.States

data class userUiState(
     val isSignedIn: Boolean = false,
      val isFarmer: Boolean = false,
      val farmerPosts: List<farmerPostState> = listOf()
)

data class farmerPostState (
    val  profilePhoto: Int? = null ,
    val  isGmo: Boolean = true,
    val  postPhoto: Int? = null ,
    val  farmerFullName: String = "",
)


// data models become part of the UI state when they need to be tracked as part
// of the current state of the UI.
// ie the farmers post and stuff need to be tracked because its
//its part of the current state of the ui which is ie is signed in,
// handle the userStates ie what happens when user states