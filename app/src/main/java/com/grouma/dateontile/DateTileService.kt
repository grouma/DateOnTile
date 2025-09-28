package com.grouma.dateontile

import android.content.Context
import androidx.wear.protolayout.ColorBuilders.argb
import androidx.wear.protolayout.LayoutElementBuilders
import androidx.wear.protolayout.TimelineBuilders.Timeline
import androidx.wear.protolayout.material.Text
import androidx.wear.protolayout.material.Typography
import androidx.wear.protolayout.material3.ColorScheme
import androidx.wear.protolayout.material3.materialScope
import androidx.wear.protolayout.types.LayoutColor
import androidx.wear.tiles.RequestBuilders
import androidx.wear.tiles.TileBuilders.Tile
import androidx.wear.tiles.TileService
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
            Tile.Builder().setTileTimeline(
                Timeline.fromLayoutElement(
                    materialScope(
                        this, requestParams.deviceConfiguration, defaultColorScheme = ColorScheme(
                            primary = LayoutColor(0xFFFFFFFF.toInt()),
                            secondary = LayoutColor(0xFFBDBDBD.toInt()),
                        )
                    ) {
                        tileLayout(context, colorScheme)
                    })
            ).setFreshnessIntervalMillis(millisToTomorrow).build()
        )
    }
}

private fun tileLayout(
    context: Context, colorScheme: ColorScheme
): LayoutElementBuilders.LayoutElement {
    val date = LocalDate.now()

    return LayoutElementBuilders.Column.Builder().addContent(
        Text.Builder(context, date.format(DateTimeFormatter.ofPattern("EEEE")))
            .setColor(argb(colorScheme.secondary.prop.argb))
            .setTypography(Typography.TYPOGRAPHY_TITLE1).build()
    ).addContent(
        Text.Builder(context, date.format(DateTimeFormatter.ofPattern("MMMM d")))
            .setColor(argb(colorScheme.primary.prop.argb))
            .setTypography(Typography.TYPOGRAPHY_TITLE1).build()
    ).build()
}