package com.example.gayat.shop.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.gayat.shop.Adapters.ProductsAdapter
import com.example.gayat.shop.R
import com.example.gayat.shop.Services.DataService
import com.example.gayat.shop.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryTye = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryTye))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize =  resources.configuration.screenWidthDp
        if(screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        ProductListView.layoutManager = layoutManager
        ProductListView.adapter = adapter
    }
}
