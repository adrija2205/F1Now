package com.example.f1now.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrija.f1now.model.Drivers
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
                _drivers.value = repository.getDrivers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getDriverById(driverNumber: String?): Drivers? {
        return _drivers.value.find { it.driver_number == driverNumber }
    }
}
