package com.rajat.easyvalidations

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.rajat.validator.ErrorType
import com.rajat.validator.Validator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValidations()
    }

    private fun setValidations() = try {
        val etDemo = findViewById<EditText>(R.id.etDemo)
        val etDemo2 = findViewById<EditText>(R.id.etDemo)
        val validator = Validator.create(activity = this).apply {
            isEmpty(etDemo.text.toString(), "Empty")
            isEmailValid(etDemo.text.toString(), "Invalid Email")
            isPhoneValid(etDemo.text.toString(), "Invalid Phone number")
            isValidPassword(
                etDemo.text.toString(),
                "Password must be of atleast 8 characters and must contains One Upper case, One Special character and One Numeric"
            )
            areEqual(etDemo.text.toString(), etDemo2.text.toString(), "Not Equal")
        }

        // For Errors in Toasts
        if (validator.isValid(ErrorType.TOAST)) {
            //Do Stuff
        }

        //For Errors in SnackBars
        if (validator.isValid(ErrorType.SNACKBAR)) {
            //Do Stuff
        }

        //For Errors in Dialogs
        if (validator.isValid(ErrorType.DIALOG)) {
            //Do Stuff
        }

        //for Getting error messages List
        validator.isValid {

        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}