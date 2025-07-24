package com.desert.android.appfullkeyboard

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

/**
 * @ClassName: MainFragment
 * @Author: zhouqiang(1376359644 @ qq.com)
 * @Email: newpos@newpostech.com
 * @Date: 2024/1/3-10:38
 * @Version: 1.0
 * @Description:
 * @website: https://www.newpostech.com/
 */
class MainFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.main, rootKey)
    }
}