package com.kodego.inventory.app.siroy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.inventory.app.siroy.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var itemName: String? = intent.getStringExtra("itemName")
        var itemDescription : String? = intent.getStringExtra("itemDescription")
        var imageName: Int = intent.getIntExtra("imgProduct", 0)

        binding.imageName.setImageResource(imageName)
        binding.txtItemName2.text = itemName
        binding.txtDescription2.text = itemDescription

    }
}