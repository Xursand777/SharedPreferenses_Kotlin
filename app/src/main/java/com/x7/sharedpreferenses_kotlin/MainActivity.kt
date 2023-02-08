package com.x7.sharedpreferenses_kotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.x7.sharedpreferenses_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var  savedtext:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            buttonSave.setOnClickListener{
             save(edittext1.text.toString())
            }
            buttonLoad.setOnClickListener {
              load()
                textview1.text=savedtext
            }
        }




    }
    fun save(text:String?){
        val editor = getSharedPreferences("Xursand", MODE_PRIVATE).edit() as SharedPreferences.Editor
        editor.putString("x7",text)
        editor.commit()
    }

    fun load(){
        val sharedPreferences= getSharedPreferences("Xursand", MODE_PRIVATE)
         savedtext = sharedPreferences.getString("x7",null)
    }


}