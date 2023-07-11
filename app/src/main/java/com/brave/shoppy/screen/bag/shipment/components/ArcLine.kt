package com.brave.shoppy.screen.bag.shipment.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp
import com.brave.shoppy.ui.theme.borderGrayColor
import com.brave.shoppy.utils.mediumBorder_2
import com.brave.shoppy.utils.smallBorder_1

@Composable
fun ArcLine(
    modifier: Modifier = Modifier.size(120.dp)
) {
    Canvas(modifier = modifier) {
        drawIntoCanvas { canvas ->
            val arcPaint = Paint().apply {
                color = borderGrayColor
                style = PaintingStyle.Stroke
                strokeWidth = 2f
                isAntiAlias = true
            }

            val width = size.width
            val height = size.height
            val rect = Rect(0f, 0f, width, height)
            canvas.drawArc(
                rect,
                startAngle = -90f,
                sweepAngle = 180f,
                useCenter = false,
                arcPaint
            )
        }
    }
}