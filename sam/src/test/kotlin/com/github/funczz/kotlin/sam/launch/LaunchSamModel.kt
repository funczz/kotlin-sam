package io.kotlintest.provided.com.github.funczz.kotlin.sam.launch

import com.github.funczz.kotlin.sam.SamModel
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event.*

/**
 * @author　funczz
 */
class LaunchSamModel : SamModel<Event> {

    /** カウント値 */
    var counter: Int = INITIAL
        private set

    /** カウントダウンを開始しているなら真、それ以外は偽 */
    var started: Boolean = false
        private set

    /** 異常終了しているなら真、それ以外は偽 */
    var aborted: Boolean = false
        private set

    /** 発射しているなら真、それ以外は偽 */
    var launched: Boolean = false
        private set

    override fun present(data: Event) {

        /** イベント値をモデルに適用 */
        when (data) {
            is InitializeEvent -> {
                counter = INITIAL
                started = false
                aborted = false
                launched = false
            }

            is StartEvent -> {
                counter = data.initial
                started = true
                aborted = false
                launched = false
            }

            is DecrementEvent -> {
                counter = data.current
            }

            is LaunchEvent -> {
                launched = true
            }

            is AbortEvent -> {
                aborted = true
            }
        }

        /** 次アクションを適用 */
        while (true) {
            if (!LaunchSamState.nextAction(model = this)) break
        }
    }

    companion object {

        /** カウント値の初期値 */
        const val INITIAL = 10

    }
}