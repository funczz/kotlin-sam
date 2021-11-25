package com.github.funczz.kotlin.sam

/**
 * SAM State Next Action インターフェイス:
 * SAM NextAction を定義するクラス。
 * SAM モデルに適用する SAM アクションを管理する。
 * @param M ISamModel: SAM モデル
 * @author funczz
 */
interface ISamStateNextAction<M : ISamModel> {

    /**
     * default method:
     * SAM NextAction メソッド。
     * Terminate が返されるまで、繰り返し nextActionPredicate メソッドを実行する。
     * @param model ISamModel: SAM モデル
     * @return Result M - ISamModel: SAM モデル
     */
    fun nextAction(model: M): Result<M> {
        var result: Result<M> = Result.success(model)
        var data: SamNextActionData<M> = Continue(model)
        while (data is Continue<M>) {
            nextActionPredicate(data)
                .fold(
                    onFailure = {
                        return Result.failure(it)
                    },
                    onSuccess = {
                        result = Result.success(it.model)
                        data = it
                    }
                )
        }
        return result
    }

    /**
     * 渡されたデータクラスが Continue なら SAM Action を適用し、
     * Terminate ならそのまま返す。
     * @param data SamNextActionData: SAM Next Action データ
     * @return Result M - SamNextActionData: SAM Next Action データ。
     *         次に適用する SAM Action があるなら Continue を返し、
     *         ないなら Terminate を返す。
     */
    fun nextActionPredicate(data: SamNextActionData<M>): Result<SamNextActionData<M>>

}