package com.lukninja.timeon

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}