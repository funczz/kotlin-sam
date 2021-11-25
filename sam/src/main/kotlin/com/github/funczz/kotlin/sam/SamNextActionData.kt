package com.github.funczz.kotlin.sam

/**
 * SAM Next Action Data:
 * SAM Next Action データ
 * @param M モデル
 * @author funczz
 */
sealed class SamNextActionData<M>(

    /**
     * Next Action へ渡すモデル
     */
    val model: M

)

/**
 * SAM Next Action Data:
 * 次に適用するべき Next Action がない SAM Next Action データ
 * @param M モデル
 * @author funczz
 */
class Terminate<M>(model: M) : SamNextActionData<M>(model)

/**
 * SAM State Next Action Data:
 * 次に適用するべき Next Action がある SAM Next Action データ
 * @param M モデル
 * @author funczz
 */
class Continue<M>(model: M) : SamNextActionData<M>(model)

