package com.example.testapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [26])
class BeforeClassTest {
    @Rule
    @JvmField
    val powerMockRule = PowerMockRule()

    companion object {
        @BeforeClass
        @JvmStatic
        fun init() {
            InitData.init(10)
        }
    }
    @Test
    fun testInit() {
        // Test should fail here because initData has not been inited
        assertEquals(10, InitData.getData())
    }
}
