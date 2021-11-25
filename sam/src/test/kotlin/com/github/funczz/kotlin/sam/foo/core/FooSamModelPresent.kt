package io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core

import com.github.funczz.kotlin.sam.ISamModelPresent

object FooSamModelPresent : ISamModelPresent<FooData, FooSamModel> {

    override fun present(data: FooData): Result<FooSamModel> {
        return Result.success(FooSamModel(model = FooModel().also { it.set(data.value) }))
    }

}