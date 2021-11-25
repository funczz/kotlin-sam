package io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event

import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.LaunchSamModel

/**
 * 開始イベント
 * @author　funczz
 */
data class StartEvent(

    /** カウント値の初期値 */
    val initial: Int = LaunchSamModel.INITIAL

) : Event