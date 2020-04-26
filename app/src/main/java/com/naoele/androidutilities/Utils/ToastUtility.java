package com.naoele.androidutilities.Utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtility {

    /**
     * Toastを表示する
     */
    public static void showToast(final Context context, final String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(final String message) {
        Toast.makeText(ContextUtility.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toastを長く表示する
     */
    public static void showLongToast(final Context context, final String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


    public static void showLongToast(final String message) {
        Toast.makeText(ContextUtility.getContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * 位置を変更したToastを表示する
     *
     * @param message the message is shown.
     * @param gravity android.view.Gravity. ex : Gravity.CENTER ...etc
     * @param x       width pixel
     * @param y       height pixel
     */
    public static void showChangePositionToast(final String message, final int gravity, final int x, final int y) {
        Toast toast = Toast.makeText(ContextUtility.getContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(gravity, x, y);
        toast.show();
    }

    public static void showChangePositionToast(final Context context, final String message, final int gravity, final int x, final int y) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(gravity, x, y);
        toast.show();
    }

    /**
     * 位置を変更したToastを長く表示する
     *
     * @param message the message is shown.
     * @param gravity android.view.Gravity. ex : Gravity.CENTER ...etc
     * @param x       width pixel
     * @param y       height pixel
     */
    public static void showLongChangePositionToast(final String message, final int gravity, final int x, final int y) {
        Toast toast = Toast.makeText(ContextUtility.getContext(), message, Toast.LENGTH_LONG);
        toast.setGravity(gravity, x, y);
        toast.show();
    }

    public static void showLongChangePositionToast(final Context context, final String message, final int gravity, final int x, final int y) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.setGravity(gravity, x, y);
        toast.show();
    }

    /**
     * Toastを中央に表示する
     */
    public static void showToastOnCenter(final String message) {
        showChangePositionToast(message, Gravity.CENTER, 0, 0);
    }

    public static void showToastOnCenter(final Context context, final String message) {
        showChangePositionToast(context, message, Gravity.CENTER, 0, 0);
    }

    /**
     * Toastを中央に長く表示する
     */
    public static void showLongToastOnCenter(final String message) {
        showLongChangePositionToast(message, Gravity.CENTER, 0, 0);
    }

    public static void showLongToastOnCenter(final Context context, final String message) {
        showLongChangePositionToast(context, message, Gravity.CENTER, 0, 0);
    }

    /**
     * Toastを上部に表示する
     */
    public static void showToastOnTop(final String message) {
        showChangePositionToast(message, Gravity.TOP, 0, CalcUtility.convertDp2Px(8));
    }

    public static void showToastOnTop(final Context context, final String message) {
        showChangePositionToast(context, message, Gravity.TOP, 0, CalcUtility.convertDp2Px(8));
    }

    /**
     * Toastを上部に長く表示する
     */
    public static void showLongToastOnTop(final String message) {
        showLongChangePositionToast(message, Gravity.TOP, 0, CalcUtility.convertDp2Px(8));
    }

    public static void showLongToastOnTop(final Context context, final String message) {
        showLongChangePositionToast(context, message, Gravity.TOP, 0, CalcUtility.convertDp2Px(8));
    }

    /**
     * UIスレッドにToastを表示する
     */
    public static void showToastOnUiThread(final Activity activity, final String message) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showToast(activity, message);
                }
            });
        }
    }

    /**
     * UIスレッドにToastを長く表示する
     */
    public static void showLongToastOnUiThread(final Activity activity, final String message) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showLongToast(activity, message);
                }
            });
        }
    }
}
