package com.github.funczz.kotlin.sam

import java.io.Serializable

/**
 * SAM Next Action Data:
 * SAM Next Action データ
 * @param M モデル
 * @author funczz
 */
sealed class NextActionData<M>(

    /**
     * Next Action へ渡すモデル
     */
    val model: M

) : Serializable {
    companion object {
        private const val serialVersionUID: Long = -1841770385865194091L
    }

    /**
     * 次に適用するべき Next Action がない SAM Next Action データ
     * @param M モデル
     * @author funczz
     */
    class Terminate<M>(model: M) : NextActionData<M>(model) {
        companion object {
            private const val serialVersionUID: Long = 9127971000171822821L
        }
    }

    /**
     * 次に適用するべき Next Action がある SAM Next Action データ
     * @param M モデル
     * @author funczz
     */
    class Continue<M>(model: M) : NextActionData<M>(model) {
        companion object {
            private const val serialVersionUID: Long = -1324401623336486151L
        }
    }
}


