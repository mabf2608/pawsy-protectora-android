package com.mabf.pawsy.ui.common

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    protected fun throwableToMessage(throwable: Throwable): String {
        return throwable.message ?: "Unexpected error"
    }

}