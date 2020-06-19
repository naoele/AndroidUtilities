package com.naoele.androidutilities;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activityの共通クラス
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        // 戻るボタン無効化
//        if (e.getAction()==KeyEvent.ACTION_DOWN) {
//            switch (e.getKeyCode()) {
//                case KeyEvent.KEYCODE_BACK:
//                    // ダイアログ表示など特定の処理を行いたい場合はここに記述
//                    // 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
//                    return true;
//            }
//        }

        return super.dispatchKeyEvent(e);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        //背景タッチでキーボードを隠す
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }

        return super.dispatchTouchEvent(ev);
    }

}
