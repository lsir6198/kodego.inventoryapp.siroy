package com.kodego.inventory.app.siroy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Toast
import com.kodego.inventory.app.siroy.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetName.setOnClickListener() {
//            Toast.makeText(applicationContext, "Hello from Toast", Toast.LENGTH_LONG).show()
            var name: String = binding.edtPersonName.text.toString()
            binding.txtName.text = name

        }

        binding.rgRadioGroup.setOnCheckedChangeListener { rgRadioGroup, checkOption ->
            when (checkOption) {
                R.id.rgButton1 -> Toast.makeText(
                    applicationContext,
                    "Option 1 Selected",
                    Toast.LENGTH_LONG
                ).show()
                R.id.rgButton2 -> Toast.makeText(
                    applicationContext,
                    "Option 1 Selected",
                    Toast.LENGTH_LONG
                ).show()
                R.id.rgButton3 -> Toast.makeText(
                    applicationContext,
                    "Option 1 Selected",
                    Toast.LENGTH_LONG
                ).show()
            }


        }

        binding.cb1.setOnClickListener() {
            if (binding.cb1.isChecked) {
                Toast.makeText(applicationContext, "CheckBox 1 Checked", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(applicationContext, "CheckBox 1 Unchecked", Toast.LENGTH_LONG).show()
            }

            if (binding.cb2.isChecked) {
                Toast.makeText(applicationContext, "CheckBox 2 Checked", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(applicationContext, "CheckBox 2 Unchecked", Toast.LENGTH_LONG).show()
            }

        }

        val data = arrayListOf<String>("Option 1", "Option 2", "Option 3")
        val adapterParent = ArrayAdapter(applicationContext, R.layout.textview, data)

        binding.spSpin.adapter = adapterParent
    }
}