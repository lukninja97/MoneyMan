package com.lukninja.moneyman

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}