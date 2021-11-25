package com.github.funczz.kotlin.sam

/**
 * ビューと次アクション述語の両方をモデルのプロパティ値から計算する
 * @author　funczz
 * @version　0.1.0
 */
interface SamState<MODEL : Any, OUTPUT : Any> {

    /**
     * モデルに対して適用の必要なアクションがあるならアクションをモデルに適用する
     * @param model モデル
     * @return 次アクションが適用可能なら真、それ以外は偽
     */
    fun nextAction(model: MODEL): Boolean

    /**
     * モデルの値からビューの状態を生成して返却する
     * @param model モデル
     * @return ビューの状態
     */
    fun representation(model: MODEL): OUTPUT

    /**
     * モデルの値をビューに適用する
     * @param model モデル
     * @param render ビューを更新する関数
     */
    fun representation(model: MODEL, render: (OUTPUT) -> Unit) {
        render(representation(model = model))
    }

}