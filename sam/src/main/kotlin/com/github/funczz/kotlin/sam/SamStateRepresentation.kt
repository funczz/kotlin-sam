package com.github.funczz.kotlin.sam

/**
 * ビューをモデルのプロパティ値から計算する
 * @author　funczz
 * @version　0.2.0
 */
interface SamStateRepresentation<MODEL : Any, OUTPUT : Any> {

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
