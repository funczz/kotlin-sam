package com.github.funczz.kotlin.sam

/**
 * ビューと次アクション述語の両方をモデルのプロパティ値から計算する
 * @author　funczz
 * @version　0.1.0
 */
interface SamState<MODEL : Any, OUTPUT : Any> : SamStateNextAction<MODEL>, SamStateRepresentation<MODEL, OUTPUT>