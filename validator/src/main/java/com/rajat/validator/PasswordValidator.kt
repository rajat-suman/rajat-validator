package com.rajat.validator

class PasswordValidator(private val editable: String, private val message: String) :
    ValidateListener {
    override fun isValid(): Boolean {
        return ValidatorUtils.validPassword(editable.trim() ?: "")
    }

    override fun message(): String? {
        return message
    }
}