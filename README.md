# rajat-validator
Easy Single Line Validations

//Gradle

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.rajat-suman:rajat-validator:0.1'
	}


//Maven

Step 1. Add the JitPack repository to your build file

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.rajat-suman</groupId>
	    <artifactId>rajat-validator</artifactId>
	    <version>0.1</version>
	</dependency>



Sample Code

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
