package com.naoele.androidutilities.Utils;

import android.util.DisplayMetrics;

public class CalcUtility {

    /**
     * dpからpixelへの変換
     *
     * @param dp
     * @return int pixel
     */
    public static int convertDp2Px(float dp) {
        DisplayMetrics metrics = ContextUtility.getResources().getDisplayMetrics();
        return (int) (dp * metrics.density + 0.5f);
    }

    /**
     * pixelからdpへの変換
     *
     * @param px
     * @return float dp
     */
    public static float convertPx2Dp(int px) {
        DisplayMetrics metrics = ContextUtility.getResources().getDisplayMetrics();
        return px / metrics.density;
    }
}
