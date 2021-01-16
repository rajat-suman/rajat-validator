package com.rajat.validator

class CompareValidator(
    private val editable: String,
    private val editable2: String,
    private val message: String
) : ValidateListener {
    override fun isValid(): Boolean {
        return editable.trim() == editable2.trim()
    }

    override fun message(): String? {
        return message
    }
}