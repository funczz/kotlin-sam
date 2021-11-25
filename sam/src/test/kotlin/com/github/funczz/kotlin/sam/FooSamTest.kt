package io.kotlintest.provided.com.github.funczz.kotlin.sam

import io.kotlintest.TestCase
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooData
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamAction
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamModelPresent
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.core.FooSamStateNextAction
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.ui.StdoutFooSamExecutor
import io.kotlintest.provided.com.github.funczz.kotlin.sam.foo.ui.StdoutFooSamStateRepresentation
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FooSamTest : StringSpec() {

    private lateinit var stdoutFooSamStateRepresentation: StdoutFooSamStateRepresentation

    private lateinit var stdoutFooSamExecutor: StdoutFooSamExecutor

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        stdoutFooSamStateRepresentation = StdoutFooSamStateRepresentation()
        stdoutFooSamExecutor = StdoutFooSamExecutor(stdoutFooSamStateRepresentation)
    }

    init {

        "StdoutFooSamState.nextAction: `hello world.` -> `hello world.`" {
            val expected = "hello world."

            val data = FooData(value = expected)
            val origModel = FooSamAction.execute(present = FooSamModelPresent::present, data = data).getOrThrow()
            val nextModel = FooSamStateNextAction.nextAction(model = origModel).getOrThrow()
            stdoutFooSamStateRepresentation.representation(model = nextModel)

            stdoutFooSamStateRepresentation.result shouldBe expected
        }

        "StdoutFooSamState.nextAction: blank -> `foo`" {
            val expected = "foo"

            val data = FooData(value = "")
            val origModel = FooSamAction.execute(present = FooSamModelPresent::present, data = data).getOrThrow()
            val nextModel = FooSamStateNextAction.nextAction(model = origModel).getOrThrow()
            stdoutFooSamStateRepresentation.representation(model = nextModel)

            stdoutFooSamStateRepresentation.result shouldBe expected
        }

        "StdoutFooSamExecutor.execute: `hello world.` -> `hello world.`" {
            val expected = "hello world."

            val data = FooData(value = expected)
            stdoutFooSamExecutor.execute(FooSamAction, data)

            stdoutFooSamStateRepresentation.result shouldBe expected
        }

        "StdoutFooSamExecutor.execute: blank -> `foo`" {
            val expected = "foo"

            val data = FooData(value = "")
            stdoutFooSamExecutor.execute(FooSamAction, data)

            stdoutFooSamStateRepresentation.result shouldBe expected
        }
    }
}