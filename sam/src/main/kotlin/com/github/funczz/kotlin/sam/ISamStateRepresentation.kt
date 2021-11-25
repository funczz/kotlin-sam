package com.github.funczz.kotlin.sam

/**
 * SAM State Representation インターフェイス:
 * SAM Representation 関数を定義するクラス。
 * ビューの状態を管理する。
 * @param M ISamModel: SAM モデル
 * @author funczz
 */
interface ISamStateRepresentation<M : ISamModel> {

    /**
     * ビューを更新する。
     * @param model ISamModel: SAM モデル
     */
    fun representation(model: M)

}