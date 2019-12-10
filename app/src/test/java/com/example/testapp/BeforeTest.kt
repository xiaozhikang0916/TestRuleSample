package com.example.testapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [26])
class BeforeTest {
    @Rule
    @JvmField
    val powerMockRule = PowerMockRule()

    @Before
    fun init() {
        InitData.init(10)
    }

    @Test
    fun testInit() {
        assertEquals(10, InitData.getData())
    }
}
