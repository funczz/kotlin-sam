package io.kotlintest.provided.com.github.funczz.kotlin.sam.launch

import com.github.funczz.kotlin.sam.SamAction
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event.DecrementEvent
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event.Event

/**
 * @author　funczz
 */
object LaunchSamAction : SamAction<Event, Event> {

    override fun accept(input: Event, present: (Event) -> Unit) {

        /** 減算イベントなら減算した結果を present 関数に渡す */
        when (input) {
            is DecrementEvent -> {
                present(input.copy(current = input.current - 1))
            }

            else -> {
                present(input)
            }
        }
    }

}