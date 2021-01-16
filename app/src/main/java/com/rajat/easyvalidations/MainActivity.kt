package com.rajat.easyvalidations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rajat.validator.ErrorType
import com.rajat.validator.Validator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val validator = Validator.create(activity = null).isEmpty("", "avdd")
        validator?.isValid(ErrorType.TOAST)
        validator?.isValid(ErrorType.SNACKBAR)
        validator?.isValid(ErrorType.DIALOG)
        validator?.isValid {

        }
    }
}