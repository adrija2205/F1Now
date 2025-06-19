package com.adrija.f1now.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.adrija.f1now.model.Drivers

@Composable
fun DriverCard(driver: Drivers, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp,
            pressedElevation = 16.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1C1C1E)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val painter = rememberAsyncImagePainter(driver.headshot_url ?: "")
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .border(
                        width = 1.dp,
                        color = Color.Gray.copy(alpha = 0.4f),
                        shape = CircleShape
                    )
            ) {
                Image(
                    painter = painter,
                    contentDescription = "Driver Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = driver.full_name ?: "Unknown",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFEC1C24),
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Team: ${driver.team_name ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFFB0BEC5)
                    )
                )
                Text(
                    text = "Number: ${driver.driver_number ?: "N/A"}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(0xFF90A4AE),
                        fontSize = 12.sp
                    )
                )
            }
        }
    }
}
