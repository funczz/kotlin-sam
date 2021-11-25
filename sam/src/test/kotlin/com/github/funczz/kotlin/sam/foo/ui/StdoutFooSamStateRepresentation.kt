package io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.ui

import com.github.funczz.kotlin.sam.ISamStateRepresentation
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamModel
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.IFooSamState

object StdoutFooSamStateRepresentation : IFooSamState, ISamStateRepresentation<FooSamModel, Unit, String> {

    override fun representation(model: FooSamModel, representationData: Unit): Result<String> {
        var result = ""
        when (isBlank(model)) {
            true -> {
                "ERROR".also {
                    System.err.println(it)
                    result = it
                }
            }
            else -> {
                model.model.value.also {
                    println(it)
                    result = it
                }
            }
        }
        return Result.success(result)
    }

}