package io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event

/**
 * 減算イベント
 * @author　funczz
 */
data class DecrementEvent(

    /** 現在のカウント値 */
    val current: Int

) : Event
