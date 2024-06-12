package com.github.funczz.kotlin.sam

/**
 * 次アクション述語をモデルのプロパティ値から計算する
 * @author　funczz
 * @version　0.2.0
 */
interface SamStateNextAction<MODEL : Any> {

    /**
     * モデルに対して適用の必要なアクションがあるならアクションをモデルに適用する
     * @param model モデル
     * @return 次アクションが適用可能なら真、それ以外は偽
     */
    fun nextAction(model: MODEL): Boolean

}