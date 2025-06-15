package com.example.f1app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrija.f1app.model.Drivers
import com.adrija.f1now.repository.DriverRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class DriverViewModel : ViewModel() {

    private val repository = DriverRepository()

    private val _drivers = MutableStateFlow<List<Drivers>>(emptyList())
    val drivers: StateFlow<List<Drivers>> = _drivers

    init {
        fetchDrivers()
    }

    private fun fetchDrivers() {
        viewModelScope.launch {
            try {
                val response = repository.getDrivers()
                val driverList = response.MRData?.DriverTable?.Drivers
                _drivers.value = driverList ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun getDriverById(driverId: String?): Drivers? {
        return drivers.value.find { it.driverId == driverId }
    }

}

