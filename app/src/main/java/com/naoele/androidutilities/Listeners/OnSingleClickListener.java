package pckk.new_patroid.Widgets;

import android.os.SystemClock;
import android.view.View;

/**
 * <div>
 * <h3>誤クリック防止クリックリスナー</h3>
 * <p>
 * ※ユーザが2つ以上のボタンにすばやく触れた場合でも最初のボタンのみがトリガーされます。
 * </p>
 * </div>
 */
public abstract class OnSingleClickListener implements View.OnClickListener {

    /**
     * クリックしてから次のクリックができるようになるまでのインターバル(ミリ秒)
     */
    private static final long MIN_CLICK_INTERVAL = 1000;

    /**
     * 最後にクリックした時間
     */
    private long mLastClickTime = 0;

    /**
     * 誤クリック防止onClick
     */
    public abstract void onSingleClick(View v);

    @Override
    public final void onClick(View v) {

        // MIN_CLICK_INTERVALミリ秒のしきい値を使用した誤クリック防止
        if (isMisClicking()) return;

        onSingleClick(v);
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
