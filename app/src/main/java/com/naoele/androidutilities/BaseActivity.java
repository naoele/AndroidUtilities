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

    // キーボードマネジャー
    private InputMethodManager _im_manager;

    // 背景レイアウト
//    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //画面全体のレイアウト
//        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        //キーボード表示を制御するためのオブジェクト
        _im_manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //キーボードを隠す
//        _im_manager.hideSoftInputFromWindow(mainLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//        //背景にフォーカスを移す
//        mainLayout.requestFocus();

        return false;
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

}
