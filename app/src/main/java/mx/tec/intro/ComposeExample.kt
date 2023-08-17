package mx.tec.intro

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import mx.tec.intro.ui.theme.IntroTheme

class ComposeExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    @Composable
    fun SayHelloButton(){
        Button(
            onClick = {
               Toast.makeText(this, "SAY HELLO", Toast.LENGTH_SHORT).show()
            }
        ){
            Text(
                text = "HELLO!"
            )
        }
    }
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Text(
                text = "A second text",
                modifier = modifier
            )
            SayHelloButton()
            SayHelloButton()
            SayHelloButton()
            Image(
                painter = painterResource(R.drawable.puppy),
                contentDescription = "a VERY sad puppy"
            )
        }

    }

    // this function's only purpose is to
    // display a preview
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        IntroTheme {
            Greeting("Android")
        }
    }
}

