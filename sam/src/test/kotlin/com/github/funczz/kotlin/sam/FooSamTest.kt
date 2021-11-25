package io.kotlintest.provided.com.github.funczz.kotlin.sam

import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooData
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamAction
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamModelPresent
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamStateNextAction
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.ui.StdoutFooSamExecutor
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.ui.StdoutFooSamStateRepresentation
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FooSamTest : StringSpec() {

    init {

        "StdoutFooSamState.nextAction: `hello world.` -> `hello world.`" {
            val expected = "hello world."

            val data = FooData(value = expected)
            val origModel = FooSamAction.execute(
                present = FooSamModelPresent::present,
                data = data
            ).getOrThrow()
            val nextModel = FooSamStateNextAction.nextAction(
                model = origModel
            ).getOrThrow()
            val result = StdoutFooSamStateRepresentation.representation(
                model = nextModel,
                representationData = Unit
            ).getOrThrow()

            result shouldBe expected
        }

        "StdoutFooSamState.nextAction: blank -> `foo`" {
            val expected = "foo"

            val data = FooData(value = "")
            val origModel = FooSamAction.execute(
                present = FooSamModelPresent::present,
                data = data
            ).getOrThrow()
            val nextModel = FooSamStateNextAction.nextAction(
                model = origModel
            ).getOrThrow()
            val result = StdoutFooSamStateRepresentation.representation(
                model = nextModel,
                representationData = Unit
            ).getOrThrow()

            result shouldBe expected
        }

        "StdoutFooSamExecutor.execute: `hello world.` -> `hello world.`" {
            val expected = "hello world."

            val data = FooData(value = expected)
            val result = StdoutFooSamExecutor.execute(
                samAction = FooSamAction,
                samActionData = data,
                representationData = Unit
            ).getOrThrow()

            result shouldBe expected
        }

        "StdoutFooSamExecutor.execute: blank -> `foo`" {
            val expected = "foo"

            val data = FooData(value = "")
            val result = StdoutFooSamExecutor.execute(
                samAction = FooSamAction,
                samActionData = data,
                representationData = Unit
            ).getOrThrow()

            result shouldBe expected
        }
    }
}