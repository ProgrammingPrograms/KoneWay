package com.example.farmersinternational

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.farmersinternational.ui.theme.FarmersInternationalTheme
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.storage.Storage

val supabase = createSupabaseClient(
    supabaseUrl = "https://ymfpyatyatdevhhpfrdt.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InltZnB5YXR5YXRkZXZoaHBmcmR0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDE5NTcxMjIsImV4cCI6MjA1NzUzMzEyMn0.-3Vjgvtk_N_t3GRXihm1dmvOx73MDijHrVP0LR1-nrY"
) {

    //...

    install(Storage) {
        // settings
    }

}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //  val authViewModel: AuthViewModel by viewModels()
        setContent {
            FarmersInternationalTheme {


            }

        }
    }
}
