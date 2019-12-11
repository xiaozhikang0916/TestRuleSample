package com.example.testapp.utils

import org.junit.rules.MethodRule
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.FrameworkMethod
import org.junit.runners.model.Statement

class TestRuleAdapter(private val rule: MethodRule) : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return rule.apply(base, createFrameworkMethod(description), getTestObject(description))
    }

    private fun createFrameworkMethod(description: Description): FrameworkMethod {
        try {
            val methodName = description.methodName
            val c = getTestClass(description)
            val m = c.getDeclaredMethod(methodName)
            return FrameworkMethod(m)
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }

    private fun getTestClass(description: Description): Class<*> {
        return description.testClass
    }

    private fun getTestObject(description: Description): Any {
        try {
            return getTestClass(description).newInstance()
        } catch (e: InstantiationException) {
            throw IllegalStateException(e)
        } catch (e: IllegalAccessException) {
            throw IllegalStateException(e)
        }
    }
}
