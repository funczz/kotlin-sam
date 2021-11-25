package com.github.funczz.kotlin.sam

/**
 * SAM Executor インターフェイス:
 * SAM へ処理を投入するクラス
 * @param D Any: SAM Action 入力データ
 * @param M ISamModel: SAM モデル
 * @param MP ISamModelPresent<D, M>: SAM Present 関数を定義するクラス
 * @param SN ISamStateNextAction<M>: SAM NextAction を定義するクラス
 * @param SR ISamStateRepresentation<M>>: SAM Representation 関数を定義するクラス
 * @author funczz
 */
interface ISamExecutor<D, M : ISamModel, MP : ISamModelPresent<D, M>, SN : ISamStateNextAction<M>, SR : ISamStateRepresentation<M>> {

    /**
     * SAM Present 関数を定義するクラスを返す
     * @return ISamModelPresent
     */
    fun samPresent(): MP

    /**
     * SAM NextAction を定義するクラスを返す
     * @return ISamStateNextAction
     */
    fun samNextAction(): SN

    /**
     * SAM Representation 関数を定義するクラスを返す
     * @return ISamStateRepresentation
     */
    fun samRepresentation(): SR

    /**
     * default method:
     * SAM Action と SAM NextAction を適用して SAM モデルを返す。
     * @param samAction SAM Action
     * @param samActionData SAM Action 入力データ
     * @return Result M - ISamModel: SAM モデル
     */
    fun doAction(samAction: ISamAction<D, M>, samActionData: D): Result<M> {
        val result = samAction.execute(samPresent()::present, samActionData)
        return result.fold(
            onFailure = { result },
            onSuccess = { samNextAction().nextAction(model = it) }
        )
    }

    /**
     * default method:
     * SAM Representation 関数を適用する。
     * @param model ISamModel: SAM モデル
     */
    fun doRepresentation(model: M) {
        samRepresentation().representation(model)
    }

    /**
     * default method:
     * doAction と doRepresentation を順に適用する。
     * @param samAction SAM Action
     * @param samActionData SAM Action 入力データ
     * @throws Throwable doAction が Result.failure を返したならそのまま throw する
     */
    fun execute(samAction: ISamAction<D, M>, samActionData: D) {
        doAction(samAction, samActionData).fold(
            onFailure = { throw it },
            onSuccess = { doRepresentation(it) }
        )
    }
}