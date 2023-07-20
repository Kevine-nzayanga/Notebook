package dev.kevine.notebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import dev.kevine.notebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         onResume()
    }
    override fun onResume() {
        super.onResume()

        binding.btn1.setOnClickListener {
            validateLogin()
        }

//        val button = findViewById<Button>(R.id.btn1)
//        button.setOnClickListener {
//            val intent = Intent(this@MainActivity, Moodcheck::class.java )
//            startActivity(intent)
//        }
        clearErrorOnType()
    }
    fun clearErrorOnType(){
        binding.tiuser.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tluser.error = null
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        binding.tipass.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tlpass.error = null
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
    
    fun validateLogin(){
        var username = binding.tiuser.text.toString()
        var password = binding.tipass.text.toString()
        
        var error = false
        if (username.isBlank()){
            binding.tluser.error = "Username is required"
        }
        if (password.isBlank()){
            binding.tlpass.error = "Password is required"
        }
        if (!error){
            Toast.makeText(this, "$username succsessfully signed in",Toast.LENGTH_LONG).show()
        }
    }
}