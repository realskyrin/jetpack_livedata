package com.skyrin.jetpack_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class NameViewModel : ViewModel() {
    private var _name = MutableLiveData<String>()
    var name: LiveData<String> = _name

    fun changeName() {
        _name.value = if (_name.value == "pony") {
            "tony"
        } else {
            "pony"
        }
    }
}