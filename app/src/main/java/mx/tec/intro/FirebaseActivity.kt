package mx.tec.intro

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mx.tec.intro.ui.theme.IntroTheme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseActivity : ComponentActivity() {

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirebaseExample(auth = auth, activity = this)
                }
            }
        }
        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()

        // whenever you start / restart activity check if user is valid
        val currentUser = auth.currentUser
        if(currentUser == null) {
            // no user == need to login
            // finish()
            // display login interface
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirebaseExample(activity : Activity? = null, auth : FirebaseAuth? = null) {

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = {Text("Login")}
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {Text("Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = {

            }
        )
        {
            Text("Login")
        }
        Button(
            onClick = {

                // we will need a reference to the activity
                // reason: we need one to setup a listener for a task
                // since activity is nullable we need a null safe block
                if(activity != null){
                    auth?.createUserWithEmailAndPassword(login, password)
                        ?.addOnCompleteListener(activity){ task ->
                            // the task was done!
                            if (task.isSuccessful){

                            } else {

                            }
                        }
                }
            }
        )
        {
            Text("Sign up")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroTheme {
        FirebaseExample()
    }
}