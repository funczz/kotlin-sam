package io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core

import com.github.funczz.kotlin.sam.ISamAction

object FooSamAction : ISamAction<FooData, FooSamModel> {

    override fun execute(present: (FooData) -> Result<FooSamModel>, data: FooData): Result<FooSamModel> {
        return present(data)
    }

}