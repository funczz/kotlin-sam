package com.github.funczz.kotlin.sam

/**
 * SAM Action インターフェイス:
 * SAM モデルを生成するクラス
 * @param D Any: SAM Action 入力データ
 * @param M ISamModel: SAM モデル
 * @author funczz
 */
interface ISamAction<D, M : ISamModel> {

    /**
     * 特定のビジネスロジックを適用した SAM モデルを生成する。
     * @param present SAM Present 関数: SAM モデルを生成する関数
     * @param data SAM Action 入力データ
     * @return Result M - ISamModel: SAM モデル
     */
    fun execute(present: (D) -> Result<M>, data: D): Result<M>

}