package io.kotlintest.provided.com.github.funczz.kotlin.sam

import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.LaunchSamAction
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.LaunchSamModel
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.LaunchSamState
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event.AbortEvent
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event.DecrementEvent
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event.InitializeEvent
import io.kotlintest.provided.com.github.funczz.kotlin.sam.launch.event.StartEvent
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * @author　funczz
 */
class LaunchSAMTest : StringSpec() {

    init {

        "Ready" {
            val expected = "ready."
            val model = LaunchSamModel()
            LaunchSamAction.accept(input = InitializeEvent, present = model::present)
            val actual = LaunchSamState.representation(model = model)
            actual shouldBe expected
        }

        "Counting: カウントダウン開始" {
            val expected = "10"
            val model = LaunchSamModel()
            LaunchSamAction.accept(input = StartEvent(initial = 10), present = model::present)
            val actual = LaunchSamState.representation(model = model)
            actual shouldBe expected
        }

        "Counting: カウントを減算" {
            val expected = "9"
            val model = LaunchSamModel()
            LaunchSamAction.accept(input = StartEvent(initial = 10), present = model::present)
            LaunchSamAction.accept(input = DecrementEvent(current = model.counter), present = model::present)
            val actual = LaunchSamState.representation(model = model)
            actual shouldBe expected
        }

        "Launched" {
            val expected = "launched."
            val model = LaunchSamModel()
            LaunchSamAction.accept(input = StartEvent(initial = 1), present = model::present)
            LaunchSamAction.accept(input = DecrementEvent(current = model.counter), present = model::present)
            val actual = LaunchSamState.representation(model = model)
            actual shouldBe expected
        }

        "Aborted" {
            val expected = "aborted."
            val model = LaunchSamModel()
            LaunchSamAction.accept(input = StartEvent(initial = 1), present = model::present)
            LaunchSamAction.accept(input = AbortEvent, present = model::present)
            val actual = LaunchSamState.representation(model = model)
            actual shouldBe expected
        }

        "Ready から Launched　へ状態を遷移" {
            val expected = listOf(
                "ready.",
                "3",
                "2",
                "1",
                "launched.",
            )
            val actual = mutableListOf<String>()
            val model = LaunchSamModel()
            actual.add(LaunchSamState.representation(model = model))
            LaunchSamAction.accept(input = StartEvent(initial = 3), present = model::present)
            actual.add(LaunchSamState.representation(model = model))
            while (model.counter > 0) {
                LaunchSamAction.accept(input = DecrementEvent(current = model.counter), present = model::present)
                actual.add(LaunchSamState.representation(model = model))
            }
            actual shouldBe expected
        }

        "ビューのレンダリング" {
            val expected = "ready."
            var actual = ""
            val model = LaunchSamModel()
            LaunchSamState.representation(model = model) { actual = it }
            actual shouldBe expected
        }

    }
}