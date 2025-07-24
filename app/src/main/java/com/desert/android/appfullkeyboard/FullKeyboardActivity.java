package com.desert.android.appfullkeyboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.desert.fullkeyboard.ClassicalKeyBoardUtil;
import com.android.desert.fullkeyboard.ClassicalKeyboardTouchListener;

/**
 * @ClassName: FullKeyboardActivity
 * @Author: zhouqiang(1376359644 @ qq.com)
 * @Email: newpos@newpostech.com
 * @Date: 2024/1/3-10:38
 * @Version: 1.0
 * @Description:
 * @website: https://www.newpostech.com/
 */
public class FullKeyboardActivity extends AppCompatActivity {

    private LinearLayout rootView;
    private ScrollView scrollView;
    private EditText normalEd;
    private EditText specialEd;

    private ClassicalKeyBoardUtil classicalKeyBoardUtil ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.views_fullkeyboard);

        rootView = findViewById(R.id.root_view);
        scrollView = findViewById(R.id.sv_main);

        normalEd = findViewById(R.id.normal_ed);
        specialEd = findViewById(R.id.special_ed);

        initMoveKeyBoard();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0 ) {
            if(classicalKeyBoardUtil != null && classicalKeyBoardUtil.isShow){
                classicalKeyBoardUtil.hideSystemKeyBoard();
                classicalKeyBoardUtil.hideAllKeyBoard();
                classicalKeyBoardUtil.hideKeyboardLayout();
            }else {
                return super.onKeyDown(keyCode, event);
            }

            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initMoveKeyBoard() {
        classicalKeyBoardUtil = new ClassicalKeyBoardUtil(this, rootView, scrollView);
        classicalKeyBoardUtil.setOtherEdittext(normalEd);
        // monitor the keyboard state
        classicalKeyBoardUtil.setKeyBoardStateChangeListener((state, editText) -> {
            System.out.println("state" + state);
            System.out.println("editText" + editText.getText().toString());
        });
        // monitor the finish or next Key
        classicalKeyBoardUtil.setInputOverListener((onclickType, editText) -> {
            System.out.println("onclickType" + onclickType);
            System.out.println("editText" + editText.getText().toString());
        });
        specialEd.setOnTouchListener(new ClassicalKeyboardTouchListener(classicalKeyBoardUtil, ClassicalKeyBoardUtil.INPUTTYPE_ABC, -1));
    }
}
