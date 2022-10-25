package com.kodego.inventory.app.siroy

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodego.inventory.app.siroy.databinding.ActivityHomePageBinding
import com.kodego.inventory.app.siroy.databinding.AddDialogBinding
import com.kodego.inventory.app.siroy.databinding.QuantityDialogBinding
import java.text.FieldPosition


class HomePageActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomePageBinding
    lateinit var adapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data source
        var productList: MutableList<Products> = mutableListOf<Products>(
            Products(R.drawable.ic_baseline_local_taxi_24, "Car Parts", "This is a package for car parts",19),
            Products(R.drawable.ic_baseline_border_color_24, "ColorPen", "This is a premium Pen",20),
            Products(R.drawable.ic_baseline_coffee_24, "Coffee", "Hot Coffee",33)

        )

        //pass data source to adapter
        adapter = ProductAdapter(productList)
        adapter.onItemClick = {
            Toast.makeText(applicationContext,it.itemName, Toast.LENGTH_SHORT ).show()
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("itemName",it.itemName)
            intent.putExtra("itemDescription",it.itemDescription)
            intent.putExtra("imgProduct",it.imageName)
            intent.putExtra("txtvQuantity",it.quantity)
            startActivity(intent)

        }
        adapter.onUpdateButtonClick = { item:Products, position:Int ->
            showUpdateDialog(item, position)
        }

        adapter.onDeleteButtonClick = { item: Products, position: Int ->
            adapter.products.removeAt(position)
            adapter.notifyDataSetChanged()
        }

        binding.fabAdd.setOnClickListener(){
            showAddDialog()
        }


        binding.rvMyRecycler.adapter = adapter
        binding.rvMyRecycler.layoutManager = LinearLayoutManager(this)

    }
    fun showUpdateDialog(item:Products, position: Int){
        val dialog = Dialog(this)
        val binding: QuantityDialogBinding = QuantityDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnUpdate.setOnClickListener(){
            var newQuantity: Int = binding.edtxtDialog.text.toString().toInt()
            adapter.products[position].quantity = newQuantity
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }
    }
    fun showAddDialog(){
        val dialog = Dialog(this)
        val binding: AddDialogBinding = AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        val images = arrayListOf<String>("ic_baseline_lock_24","ic_baseline_person_24","ic_baseline_school_24")
        val spinnerAdapter = ArrayAdapter(applicationContext, R.layout.textview, images)

        binding.spinDialog.adapter = spinnerAdapter
        binding.btnAdd.setOnClickListener(){
            val image:Int = resources.getIdentifier(binding.spinDialog.selectedItem.toString(),"drawable", packageName)
            var itemName : String = binding.edtxtItemName.text.toString()
            var itemDescription: String = binding.edtxtItemDescription.text.toString()
            var quantity: Int = binding.edtxtQuantity.text.toString().toInt()

            adapter.products.add(Products(image, itemName, itemDescription, quantity))
            adapter.notifyItemInserted(adapter.itemCount+1)
            dialog.dismiss()
        }

    }
}