package com.example.testapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testapp.utils.TestRuleAdapter
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [26])
class AdapterRuleTest {
    @Rule
    @JvmField
    val initRule = RuleChain.outerRule(TestRuleAdapter(PowerMockRule())).around(InitRule())
    @Mock
    lateinit var mock: MockInterface

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        `when`(mock.makeInt()).thenReturn(100)
    }

    @Test
    fun testInit() {
        assertEquals(10, InitData.getData())

        //make sure powermock is working now
        assertEquals(100, mock.makeInt())
    }
}

interface MockInterface {
    fun makeInt(): Int
}
