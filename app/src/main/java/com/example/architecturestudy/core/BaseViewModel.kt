package com.flybook.flybook.core

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel :ViewModel(){
    private val disposables: CompositeDisposable = CompositeDisposable()

    fun addToDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun getDisposable(): CompositeDisposable {
        return disposables
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}