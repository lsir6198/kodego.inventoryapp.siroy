package com.kodego.inventory.app.siroy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodego.inventory.app.siroy.databinding.ActivityHomePageBinding


class HomePageActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data source
        var productList = mutableListOf<Products>(
            Products(R.drawable.ic_baseline_local_taxi_24, "Car Parts", "This is a package for car parts"),
            Products(R.drawable.ic_baseline_border_color_24, "ColorPen", "This is a premium Pen"),
            Products(R.drawable.ic_baseline_coffee_24, "Coffee", "Hot Coffee")
        )

        //pass data source to adapter
        val adapter = ProductAdapter(productList)
        adapter.onItemClick = {
            Toast.makeText(applicationContext,it.itemName, Toast.LENGTH_SHORT ).show()
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("itemName",it.itemName)
            intent.putExtra("itemDescription",it.itemDescription)
            intent.putExtra("imgProduct",it.imageName)
            startActivity(intent)

        }
        binding.rvMyRecycler.adapter = adapter
        binding.rvMyRecycler.layoutManager = LinearLayoutManager(this)

    }
}