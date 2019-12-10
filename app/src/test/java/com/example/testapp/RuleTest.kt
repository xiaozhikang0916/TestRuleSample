package com.example.testapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.junit.runners.model.Statement
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [26])
class RuleTest {
    @Rule
    @JvmField
    val powerMockRule = PowerMockRule()
    @Rule
    @JvmField
    val initRule = RuleChain.outerRule(InitRule())

    @Test
    fun testInit() {
        // Test should fail here because initData has not been inited
        assertEquals(10, InitData.getData())
    }
}

class InitRule : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                print("Init to 10")
                InitData.init(10)
                base?.evaluate()
            }
        }
    }
}
