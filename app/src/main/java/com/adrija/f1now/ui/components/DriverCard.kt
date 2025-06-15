// com.adrija.f1now.ui.components.DriverCard.kt
package com.adrija.f1now.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adrija.f1app.model.Drivers

@Composable
fun DriverCard(driver: Drivers, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${driver.givenName} ${driver.familyName}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = "Nationality: ${driver.nationality}")
            Text(text = "Date of Birth: ${driver.dateOfBirth}")
        }
    }
}
