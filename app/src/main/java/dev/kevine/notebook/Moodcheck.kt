package dev.kevine.notebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Moodcheck : AppCompatActivity() {
    val moodMessages: HashMap<String, String> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moodcheck)
        initializeMoodMessages()
    }
    fun initializeMoodMessages(){
//        find a way to be mentioning the users name in the message
        moodMessages["Happy"] ="Yay! thats the spirit"
        moodMessages["Sad"] = "Don`t worry better days are coming"
        
}
    fun showMessageForMood(view: View){
        val moodButton= view as Button
        val mood = moodButton.text.toString()
        val message = moodMessages[mood]

        message?.let{
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}
