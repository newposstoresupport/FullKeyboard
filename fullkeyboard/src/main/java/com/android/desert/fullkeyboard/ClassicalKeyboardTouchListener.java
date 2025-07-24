package com.android.desert.fullkeyboard;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * @ClassName: ClassicalKeyboardTouchListener
 * @Author: zhouqiang(1376359644 @ qq.com)
 * @Email: newpos@newpostech.com
 * @Date: 2024/1/3-10:48
 * @Version: 1.0
 * @Description:
 * @website: https://www.newpostech.com/
 */
public class ClassicalKeyboardTouchListener implements View.OnTouchListener {
    private ClassicalKeyBoardUtil keyboardUtil;
    private int keyboardType = 1;
    private int scrollTo = -1;

    public ClassicalKeyboardTouchListener(ClassicalKeyBoardUtil util, int keyboardType, int scrollTo){
        this.keyboardUtil = util;
        this.keyboardType = keyboardType;
        this.scrollTo = scrollTo;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (keyboardUtil != null && keyboardUtil.getEd() !=null &&v.getId() != keyboardUtil.getEd().getId())
                keyboardUtil.showKeyBoardLayout((EditText) v,keyboardType,scrollTo);
            else if(keyboardUtil != null && keyboardUtil.getEd() ==null){
                keyboardUtil.showKeyBoardLayout((EditText) v,keyboardType,scrollTo);
            }else{
//                Log.d("ClassicalKeyboardTouchListener", "v.getId():" + v.getId());
//                Log.d("ClassicalKeyboardTouchListener", "keyboardUtil.getEd().getId():" + keyboardUtil.getEd().getId());
                    if (keyboardUtil != null) {
                        keyboardUtil.setKeyBoardCursorNew((EditText) v);
                }
            }
        }
        return false;
    }
}
