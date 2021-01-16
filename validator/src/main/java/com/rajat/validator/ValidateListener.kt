package com.rajat.validator

interface ValidateListener {
    fun isValid(): Boolean
    fun message(): String?
}