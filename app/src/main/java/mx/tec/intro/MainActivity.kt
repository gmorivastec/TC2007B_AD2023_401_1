package mx.tec.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // let's do the most basic way to access UI
    // (NOT the best)
    private lateinit var nameEditText : EditText
    private lateinit var helloButton : Button
    private lateinit var goodbyeButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //WYSIWYG - what you see is what you get

        // intro to kotlin

        // variable declaration
        // 2 possibilities regarding memory manipulation
        // - mutable
        // - unmutable
        var var1: Float = 2.3f
        var1 = 5f
        var1 = 2.3f

        val var2: Int = 2
        // doesn't work
        // var2 = 4

        // hard-typed language
        // a variable remains on the type it was declared throughout execution
        // a type can be assigned implicitly

        var var3 = "HEY GUYS!"

        // null protection in kotlin is built-in
        // by default types in kotlin are non-nullable
        var var4: String?
        var var5: String

        var4 = "hey"
        var5 = "hi"

        var5 = var4
        var4 = var5

        //var4 = null

        // cannot save a null into non-nullable type
        // var5 = null

        // if a type exists and hasn't been imported you can use
        // ctrl + space for suggestions
        // sorry about that.

        // how to do a null safe call
        Log.i("MAIN_ACTIVITY", "${var4?.length}")

        if (var4 != null) {
            Log.i("MAIN_ACTIVITY", "${var4.length}")
        }

        // LOG LEVELS
        Log.v("VERBOSE", "VERBOSE LOG")
        Log.i("INFO", "INFO LOG")
        Log.d("DEBUG", "DEBUG LOG")
        Log.w("WARNING", "WARNING LOG")
        Log.e("ERROR", "ERROR LOG")
        Log.wtf("WTF", "WHAT A TERRIBLE FAILURE")

        // some idioms / code standards in kotlin
        // classes start with upper case (mayúscula)
        // object names start with lower case (minúscula)

        // display emergent message to user
        // normally used to convey emergent info to user
        // we CAN use to debug but beware of removing it before deploy
        Toast.makeText(this, "HEY GUYS: ${var4?.length}", Toast.LENGTH_SHORT).show()

        nameEditText = findViewById(R.id.nameEditText)
        helloButton = findViewById(R.id.helloButton)
        goodbyeButton = findViewById(R.id.goodbyeButton)

        val testButton = findViewById<Button>(R.id.goodbyeButton)

        helloButton.text = "HEY GUYS!"

        // 2nd way to add logic to button press
        // - through code
        goodbyeButton.setOnClickListener {

            (it as Button).text = "SAY GOODBYE AGAIN"
            Toast.makeText(this, "GOOD BYE!", Toast.LENGTH_SHORT).show()
        }
    }

    // 2 choices to deal with button presses in layout GUI framework
    // 1 - declare a function that can be called by widget

    // method that returns nothing and receives a view
    // view is the parent class of all widgets
    fun sayHello(view: View?) {

        // what is the view about?
        // the view is a reference to the object that is invoking the method
        (view as Button).text = "SAY HELLO AGAIN"
        Toast.makeText(this, "HELLO ${nameEditText.text}", Toast.LENGTH_SHORT).show()
    }

    fun changeActivity(view : View?) {

        // when we change activities we request the creation of a new activity
        // to do so we create an intent object
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun composeActivity(view : View?) {

        // when we change activities we request the creation of a new activity
        // to do so we create an intent object
        val intent = Intent(this, ComposeExample::class.java)
        startActivity(intent)
    }

    fun firebaseActivity(view : View?) {

        // when we change activities we request the creation of a new activity
        // to do so we create an intent object
        val intent = Intent(this, FirebaseActivity::class.java)
        startActivity(intent)
    }
}