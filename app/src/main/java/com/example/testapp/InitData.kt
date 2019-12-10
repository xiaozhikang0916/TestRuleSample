package com.example.testapp

object InitData {
    private var initData: Int = 0

    fun init(init: Int) {
        initData = init
    }

    fun getData(): Int {
        return initData
    }
}