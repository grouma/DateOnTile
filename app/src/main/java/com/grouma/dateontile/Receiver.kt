package com.grouma.dateontile

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.wear.tiles.TileService


class Receiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            TileService.getUpdater(context.applicationContext)
                .requestUpdate(DateTileService::class.java)
        }
    }
}