package com.rajat.validator


class EmailValidator(private val editable: String, private val message: String) :
    ValidateListener {
    override fun isValid(): Boolean {
        return ValidatorUtils.isEmailValid(editable.trim())
    }

    override fun message(): String? {
        return message
    }
}