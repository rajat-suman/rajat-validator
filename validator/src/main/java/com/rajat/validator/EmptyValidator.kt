package com.rajat.validator

class EmptyValidator(private val editable: String, private val message: String) :
    ValidateListener {
    override fun isValid(): Boolean {
        return editable.trim().isNotEmpty()
    }

    override fun message(): String? {
        return message
    }
}