package io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.ui

import com.github.funczz.kotlin.sam.ISamStateRepresentation
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamModel
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.IFooSamState

class StdoutFooSamStateRepresentation : IFooSamState, ISamStateRepresentation<FooSamModel> {

    var result = ""

    fun clean() {
        result = ""
    }

    override fun representation(model: FooSamModel) {

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
    }

}