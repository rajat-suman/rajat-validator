package com.rajat.validator

import android.app.Activity
import com.rajat.validator.ValidatorUtils.makeDialog
import com.rajat.validator.ValidatorUtils.showSnackBar
import com.rajat.validator.ValidatorUtils.showToast


class Validator(private val activity: Activity?) {
    private var validators: ArrayList<ValidateListener>? = null

    init {
        validators = ArrayList()
    }

    companion object {
        fun create(activity: Activity?): Validator {
            return Validator(activity)
        }
    }

    fun isEmpty(editable: String, message: String): Validator? {
        validators?.add(EmptyValidator(editable, message))
        return this
    }

    fun isEmailValid(editable: String, message: String): Validator? {
        validators?.add(EmailValidator(editable, message))
        return this
    }

    fun isPhoneValid(editable: String, message: String): Validator? {
        validators?.add(PhoneValidator(editable, message))
        return this
    }

    fun isValidPassword(editable: String, message: String): Validator? {
        validators?.add(PasswordValidator(editable, message))
        return this
    }

    fun areEqual(editable: String, editable2: String, message: String): Validator? {
        validators?.add(CompareValidator(editable, editable2, message))
        return this
    }

    //Default SnackBar
    fun isValid(): Boolean {
        validators.let {
            for (validator in it!!) {
                if (!validator.isValid()) {
                    activity?.showSnackBar(validator.message() ?: "")
                    return false
                }
            }
        }
        return true
    }

    fun isValid(type: Enum<ErrorType>): Boolean {
        validators.let {
            for (validator in it!!) {
                if (!validator.isValid()) {
                    when (type) {
                        ErrorType.TOAST -> activity?.showToast(validator.message() ?: "")
                        ErrorType.SNACKBAR -> activity?.showSnackBar(validator.message() ?: "")
                        ErrorType.DIALOG -> activity?.makeDialog(validator.message() ?: "")
                    }
                    return false
                }
            }
        }
        return true
    }

    fun isValid(customListener: ValidationResult) {
        validators.let { res ->
            customListener.invoke(res?.filter { !it.isValid() }?.map { it.message() })
        }
    }

}