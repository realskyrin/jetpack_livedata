package com.skyrin.jetpack_livedata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    // 创建 ViewModel
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(NameViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tv_name)

        // 给 textView 一个初始值
        textView.text = "tony"
        // 每次点击 textView 时，都更新一下 name
        textView.setOnClickListener {
            viewModel.changeName()
        }

        // 创建更新 UI 的观察者
        val nameObserver = Observer<String> { t ->
            // 更新 UI，设置最新的 name 给 textView
            textView.text = t
        }

        // 观察 LiveData ，传递 lifecycleOwner 和 nameObserver
        viewModel.name.observe(this, nameObserver)
    }
}
