package com.solinftec.baseproject

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}