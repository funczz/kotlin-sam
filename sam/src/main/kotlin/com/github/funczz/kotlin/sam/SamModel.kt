package com.github.funczz.kotlin.sam

/**
 * アプリケーションの状態を保持する
 * @author　funczz
 * @version　0.1.0
 */
interface SamModel<DATA : Any> {

    /**
     * データの値を自身に適用する
     * (値の永続化に責任を持ち、CRUDの操作を持つ)
     * @param data データ
     */
    fun present(data: DATA)

}