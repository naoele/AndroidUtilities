package pckk.new_patroid.Widgets;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

/**
 * ボタンの誤クリックを回避するためのボタンクラス
 */
public class SafeButton extends android.support.v7.widget.AppCompatButton {

    public SafeButton(Context context) {
        super(context);
    }

    public SafeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SafeButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setOnClickListener(OnClickListener listener) {
        super.setOnClickListener(new OnClickListenerWrapper(listener));
    }

    private class OnClickListenerWrapper implements OnClickListener {

        /**
         * クリックしてから次のクリックができるようになるまでのインターバル(ミリ秒)
         */
        private static final long MIN_CLICK_INTERVAL = 1000;

        /**
         * 最後にクリックした時間
         */
        private long mLastClickTime = 0;

        private final OnClickListener mListener;

        public OnClickListenerWrapper(OnClickListener listener) {
            mListener = listener;
        }

        @Override
        public final void onClick(View v) {

            // MIN_CLICK_INTERVALミリ秒のしきい値を使用した誤クリック防止
            if (isMisClicking()) return;

            mListener.onClick(v);
        }

        /**
         * 誤クリックか判定する
         *
         * @return true：誤クリック  false：正クリック
         */
        private boolean isMisClicking() {
            if (SystemClock.elapsedRealtime() - mLastClickTime < MIN_CLICK_INTERVAL) {
                return true;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            return false;
        }
    }
}
