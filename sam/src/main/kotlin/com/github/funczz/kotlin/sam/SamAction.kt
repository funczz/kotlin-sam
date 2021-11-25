package com.github.funczz.kotlin.sam

/**
 * ビジネスロジックを実行し、その結果をモデルに適用する
 * @author　funczz
 * @version　0.1.0
 */
interface SamAction<INPUT : Any, DATA : Any> {

    /**
     * ビジネスロジックを入力データに適用して present 関数に渡す
     * @param input 入力データ
     * @param present モデルの present 関数
     */
    fun accept(input: INPUT, present: (DATA) -> Unit)

}