package com.rajat.validator


class PhoneValidator(private val editable: String, private val message: String) :
    ValidateListener {
    override fun isValid(): Boolean {
        return ValidatorUtils.isMobileValid(editable.trim())
    }

    override fun message(): String? {
        return message
    }
}