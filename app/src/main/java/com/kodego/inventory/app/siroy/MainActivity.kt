package com.kodego.inventory.app.siroy


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.inventory.app.siroy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

     binding.btnSignIn.setOnClickListener(){
         var userName : String = binding.etUsername.text.toString()
         var password : String = binding.etPassword.text.toString()
         checkCredential(userName, password)
     }


    }
    private fun checkCredential(userName: String, userPassword: String): Boolean{
      val correctUserName : String = "admin"
      val correctPassword : String = "admin123"

      if ((correctUserName == userName)&&(correctPassword == userPassword)){

          val intent = Intent(this,HomePageActivity::class.java)
          startActivity(intent)
          finish()
          Toast.makeText(applicationContext, "Logging in", Toast.LENGTH_LONG).show()
          return true

      }else{
          Toast.makeText(applicationContext, "Invalid Credentials", Toast.LENGTH_LONG).show()
          return false
      }
    }
}