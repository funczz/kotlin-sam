package io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.ui

import com.github.funczz.kotlin.sam.ISamExecutor
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooData
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamModel
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamModelPresent
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamStateNextAction

object StdoutFooSamExecutor : ISamExecutor<
        FooData,
        FooSamModel,
        Unit,
        String> {

    override fun samPresent(): (FooData) -> Result<FooSamModel> = FooSamModelPresent::present

    override fun samNextAction(): (FooSamModel) -> Result<FooSamModel> = FooSamStateNextAction::nextAction

    override fun samRepresentation(): (FooSamModel, Unit) -> Result<String> =
        StdoutFooSamStateRepresentation::representation


}