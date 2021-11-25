package io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core

import com.github.funczz.kotlin.sam.ISamStateNextAction
import com.github.funczz.kotlin.sam.NextActionData

object FooSamStateNextAction : IFooSamState, ISamStateNextAction<FooSamModel> {

    override fun nextActionPredicate(
        data: NextActionData<FooSamModel>
    ): Result<NextActionData<FooSamModel>> {
        val result = when (data) {
            is NextActionData.Terminate<FooSamModel> -> data
            is NextActionData.Continue<FooSamModel> -> {
                when (isBlank(data.model)) {
                    true -> NextActionData.Continue(FooSamModel(model = FooModel().also { it.set("foo") }))
                    else -> NextActionData.Terminate(data.model)
                }
            }
        }
        return Result.success(result)
    }

}