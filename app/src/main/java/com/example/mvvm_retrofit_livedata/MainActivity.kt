package com.example.mvvm_retrofit_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_retrofit_livedata.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerAdapterBooks: RecyclerAdapterBooks
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        observeViewModel()
        initSearchBox()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeViewModel() {
        viewModel.booksList.observe(this,Observer<BookListModel>{

           /* it.let {
                if (it!=null){
                    setupRecyclerAdapter(it.items)
                }
            }.run {
                Toast.makeText(this@MainActivity,"Unable to fetch data!",Toast.LENGTH_SHORT).show()
            }*/
            if(it!=null){
                setupRecyclerAdapter(it.items)
            }
            else{
                Toast.makeText(this@MainActivity,"Unable to fetch data!",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun initSearchBox(){

        inputBookName.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.getBooksData(s.toString())
            }

        })
    }
    private fun setupRecyclerAdapter(bookListModel: ArrayList<Items>) {
        recyclerAdapterBooks = RecyclerAdapterBooks(bookListModel)
        recyclerAdapterBooks.notifyDataSetChanged()
        recyclerView.adapter = recyclerAdapterBooks
    }
}