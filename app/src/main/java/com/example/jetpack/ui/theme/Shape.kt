package com.example.jetpack.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val shape = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = CutCornerShape(topEnd = 30.dp),
    large = RoundedCornerShape(4.dp)
)