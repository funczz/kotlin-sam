package io.kotlintest.provided.com.github.funczz.kotlin.sam.launch

import com.github.funczz.kotlin.sam.SamState
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event.LaunchEvent

/**
 * @author　funczz
 */
object LaunchSamState : SamState<LaunchSamModel, String> {

    override fun representation(model: LaunchSamModel): String {

        /** モデルの状態を文字列で返却 */
        return when {
            isReady(model = model) -> "ready."
            isCounting(model = model) -> model.counter.toString()
            isWaiting(model = model) -> "waiting..."
            isLaunched(model = model) -> "launched."
            isAborted(model = model) -> "aborted."
            else -> "something went wrong."
        }
    }

    override fun nextAction(model: LaunchSamModel): Boolean {

        /** カウントダウン開始状態かつカウントが 0 なら 発射イベントを適用する */
        if (isWaiting(model = model)) {
            LaunchSamAction.accept(input = LaunchEvent, model::present)
            return true
        }
        return false
    }

    /**
     * @param model モデル
     * @return 待機状態なら真
     */
    private fun isReady(model: LaunchSamModel): Boolean =
        model.counter > 0 && !model.started && !model.aborted && !model.launched

    /**
     * @param model モデル
     * @return カウントダウン開始状態なら真
     */
    private fun isCounting(model: LaunchSamModel): Boolean =
        model.counter > 0 && model.started && !model.aborted && !model.launched

    /**
     * @param model モデル
     * @return カウント開始状態かつカウントが 0 なら真
     */
    private fun isWaiting(model: LaunchSamModel): Boolean =
        model.counter == 0 && model.started && !model.aborted && !model.launched

    /**
     * @param model モデル
     * @return 発射済みなら真
     */
    private fun isLaunched(model: LaunchSamModel): Boolean =
        model.counter == 0 && model.started && !model.aborted && model.launched

    /**
     * @param model モデル
     * @return 異常終了なら真
     */
    private fun isAborted(model: LaunchSamModel): Boolean =
        model.counter >= 0 && model.started && model.aborted && !model.launched

}