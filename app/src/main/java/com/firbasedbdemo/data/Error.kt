package com.firbasedbdemo.data

class Error(e: Throwable) {
    var message: String? = null

    init {
        this.message = e.message
    }

}