package io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core

import com.github.funczz.kotlin.sam.Continue
import com.github.funczz.kotlin.sam.ISamStateNextAction
import com.github.funczz.kotlin.sam.SamNextActionData
import com.github.funczz.kotlin.sam.Terminate

object FooSamStateNextAction : IFooSamState, ISamStateNextAction<FooSamModel> {

    override fun nextActionPredicate(
        data: SamNextActionData<FooSamModel>
    ): Result<SamNextActionData<FooSamModel>> {
        val result = when (data) {
            is Terminate<FooSamModel> -> data
            is Continue<FooSamModel> -> {
                when (isBlank(data.model)) {
                    true -> Continue(FooSamModel(model = FooModel().also { it.set("foo") }))
                    else -> Terminate(data.model)
                }
            }
        }
        return Result.success(result)
    }

}