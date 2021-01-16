package com.rajat.validator

import android.app.Activity
import android.app.AlertDialog
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Matcher
import java.util.regex.Pattern

object ValidatorUtils {

    //PasswordValidator
    fun validPassword(password: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@*#$%^&+=!])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

    //EmailValidator

    fun isEmailValid(string: String): Boolean {
        return Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z]{2,5}" +
                    ")+"
        ).matcher(string.trim())
            .matches()
    }

    //MobileValidator

    fun isMobileValid(string: String): Boolean {
        return Pattern.compile("([0-9]{7,15})")
            .matcher(string.trim())
            .matches()
    }

    //Make Toast
    fun Activity.showToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()


    //Make SnackBar
    fun Activity.showSnackBar(message: String) =
        Snackbar.make(
            this.findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        ).show()

    //make Dialog
    fun Activity.makeDialog(message: String) {
        val dialog = AlertDialog.Builder(this)
        dialog.setCancelable(false)
        dialog.setTitle(message)
        dialog.setPositiveButton(getString(R.string.ok)) { dialogInterface, i ->
            dialogInterface.cancel()
            dialogInterface.dismiss()
            finishAffinity()
        }
        dialog.create()
        dialog.show()
    }


}