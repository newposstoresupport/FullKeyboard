package com.desert.android.appfullkeyboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desert.android.appfullkeyboard.databinding.ActivityMainBinding

/**
 * @ClassName: MainActivity
 * @Author: zhouqiang(1376359644 @ qq.com)
 * @Email: newpos@newpostech.com
 * @Date: 2024/1/3-10:48
 * @Version: 1.0
 * @Description:
 * @website: https://www.newpostech.com/
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}