package mx.tec.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //WYSIWYG - what you see is what you get

        // intro to kotlin

        // variable declaration
        // 2 possibilities regarding memory manipulation
        // - mutable
        // - unmutable
        var var1 : Float = 2.3f
        var1 = 5f
        var1 = 2.3f

        val var2 : Int = 2
        // doesn't work
        // var2 = 4

        // hard-typed language
        // a variable remains on the type it was declared throughout execution
        // a type can be assigned implicitly

        var var3 = "HEY GUYS!"

        // null protection in kotlin is built-in
        // by default types in kotlin are non-nullable
        var var4 : String?
        var var5 : String

        var4 = "hey"
        var5 = "hi"

        var5 = var4
        var4 = var5

        //var4 = null

        // cannot save a null into non-nullable type
        // var5 = null

        // if a type exists and hasn't been imported you can use
        // ctrl + space for suggestions
        Log.i("MAIN_ACTIVITY", "${var4.length}")
    }
}