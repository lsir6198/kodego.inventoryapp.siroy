package com.kodego.inventory.app.siroy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.inventory.app.siroy.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetName.setOnClickListener(){
//            Toast.makeText(applicationContext, "Hello from Toast", Toast.LENGTH_LONG).show()
            var name: String = binding.edtPersonName.text.toString()
            binding.txtName.text = name

        }
    }
}