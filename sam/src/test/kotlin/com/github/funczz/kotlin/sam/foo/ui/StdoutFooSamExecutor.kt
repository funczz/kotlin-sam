package io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.ui

import com.github.funczz.kotlin.sam.ISamExecutor
import com.github.funczz.kotlin.sam.ISamModelPresent
import com.github.funczz.kotlin.sam.ISamStateNextAction
import com.github.funczz.kotlin.sam.ISamStateRepresentation
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooData
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamModel
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamModelPresent
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamStateNextAction

class StdoutFooSamExecutor(
    private val stdoutFooSamStateRepresentation: StdoutFooSamStateRepresentation
) : ISamExecutor<
        FooData,
        FooSamModel,
        ISamModelPresent<FooData, FooSamModel>,
        ISamStateNextAction<FooSamModel>,
        ISamStateRepresentation<FooSamModel>> {

    override fun samPresent(): ISamModelPresent<FooData, FooSamModel> = FooSamModelPresent

    override fun samNextAction(): ISamStateNextAction<FooSamModel> = FooSamStateNextAction

    override fun samRepresentation(): ISamStateRepresentation<FooSamModel> = stdoutFooSamStateRepresentation


}