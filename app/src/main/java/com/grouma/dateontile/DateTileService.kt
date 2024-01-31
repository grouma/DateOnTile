package com.grouma.dateontile

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.protolayout.ColorBuilders
import androidx.wear.protolayout.LayoutElementBuilders
import androidx.wear.protolayout.TimelineBuilders.Timeline
import androidx.wear.protolayout.material.Colors
import androidx.wear.protolayout.material.Text
import androidx.wear.protolayout.material.Typography
import androidx.wear.tiles.RequestBuilders
import androidx.wear.tiles.TileBuilders.Tile
import androidx.wear.tiles.TileService
import com.google.android.horologist.compose.tools.LayoutRootPreview
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class DateTileService : TileService() {

    override fun onTileRequest(requestParams: RequestBuilders.TileRequest): ListenableFuture<Tile> {
        val context = this.applicationContext
        val now = LocalDateTime.now()
        val tomorrow = LocalDateTime.of(now.toLocalDate(), LocalTime.MIDNIGHT).plusDays(1)
        val millisToTomorrow = ChronoUnit.MILLIS.between(now, tomorrow)

        return Futures.immediateFuture(
            Tile.Builder()
                .setTileTimeline(
                    Timeline.fromLayoutElement(
                        tileLayout(context)
                    )
                )
                .setFreshnessIntervalMillis(millisToTomorrow)
                .build()
        )
    }
}

private fun tileLayout(context: Context): LayoutElementBuilders.LayoutElement {
    val date = LocalDate.now()

    return LayoutElementBuilders.Column.Builder()
        .addContent(
            Text.Builder(context, date.format(DateTimeFormatter.ofPattern("EEEE")))
                .setColor(ColorBuilders.argb(Colors.DEFAULT.onSurface))
                .setTypography(Typography.TYPOGRAPHY_TITLE1)
                .build()
        )
        .addContent(
            Text.Builder(context, date.format(DateTimeFormatter.ofPattern("MMMM d")))
                .setColor(ColorBuilders.argb(Colors.DEFAULT.onSurface))
                .setTypography(Typography.TYPOGRAPHY_TITLE1)
                .build()
        )
        .build()
}

@Preview(
    device = Devices.WEAR_OS_SMALL_ROUND,
    showSystemUi = true,
    backgroundColor = 0xff000000,
    showBackground = true
)
@Composable
fun TilePreview() {
    LayoutRootPreview(root = tileLayout(LocalContext.current))
}