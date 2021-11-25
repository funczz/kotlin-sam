package com.github.funczz.kotlin.sam

/**
 * SAM State Representation インターフェイス:
 * SAM Representation 関数を定義するクラス。
 * ビューの状態を管理する。
 * @param O representation 関数の実行結果
 * @param M ISamModel: SAM モデル
 * @author funczz
 */
interface ISamStateRepresentation<M : ISamModel, R, O> {

    /**
     * ビューを更新する。
     * @param model ISamModel: SAM モデル
     * @param representationData representation 処理で用いる値
     * @return Result representation 関数の実行結果
     */
    fun representation(model: M, representationData: R): Result<O>

}