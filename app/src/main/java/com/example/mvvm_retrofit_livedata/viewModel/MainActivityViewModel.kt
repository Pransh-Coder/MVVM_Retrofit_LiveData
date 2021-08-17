package com.example.mvvm_retrofit_livedata.viewModel

import android.app.ProgressDialog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_retrofit_livedata.BookListModel
import com.example.mvvm_retrofit_livedata.network.RetrofitClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel:ViewModel() {

    val booksList = MutableLiveData<BookListModel>()


    fun getBooksData(charSeq:String){
        val retrofitClient = RetrofitClient()

        retrofitClient.fetchBooksData(query = charSeq)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getBookListObserverRX())
    }


     fun getBookListObserverRX():Observer<BookListModel>{
        return object : Observer<BookListModel>{

            override fun onSubscribe(d: Disposable) {
                //start progress bar
            }

            override fun onNext(bookListModel:BookListModel) {
                booksList.value = bookListModel
            }

            override fun onError(e: Throwable) {
                booksList.value = null
            }

            override fun onComplete() {
               //hide progress bar
            }

        }
    }

}
