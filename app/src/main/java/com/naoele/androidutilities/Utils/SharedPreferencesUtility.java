package com.naoele.androidutilities.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

/**
 * SharedPreferencesのユーティリティクラス
 */
public class SharedPreferencesUtility {

    // 設定値保存ファイル名
    private static final String KEY_SETTINGS = "SETTINGS";

    /**
     * 設定ファイルのSharedPreferencesを取得する
     */
    private static SharedPreferences getSharedPreferences() {
        Context context = ContextUtility.getContext();
        return context.getSharedPreferences(KEY_SETTINGS, MODE_PRIVATE);
    }

    /**
     * int型の値を取得する
     */
    private static int getInt(String key, int defValue) {
        return getSharedPreferences().getInt(key, defValue);
    }

    private static int getInt(String key) {
        return getInt(key, 0);
    }

    /**
     * Integer型の値かNullを取得する
     */
    private static Integer getIntegerOrNull(String key) {
        int minValue = getInt(key, Integer.MIN_VALUE);
        int maxValue = getInt(key, Integer.MAX_VALUE);
        if (minValue == Integer.MIN_VALUE && maxValue == Integer.MAX_VALUE) return null;
        return minValue;
    }

    /**
     * long型の値を取得する
     */
    private static long getLong(String key, long defValue) {
        return getSharedPreferences().getLong(key, defValue);
    }

    private static long getLong(String key) {
        return getLong(key, 0L);
    }

    /**
     * Long型の値かNullを取得する
     */
    private static Long getLongOrNull(String key) {
        long minValue = getLong(key, Long.MIN_VALUE);
        long maxValue = getLong(key, Long.MAX_VALUE);
        if (minValue == Long.MIN_VALUE && maxValue == Long.MAX_VALUE) return null;
        return minValue;
    }

    /**
     * float型の値を取得する
     */
    private static float getFloat(String key, float defValue) {
        return getSharedPreferences().getFloat(key, defValue);
    }

    private static float getFloat(String key) {
        return getFloat(key, 0f);
    }

    /**
     * Float型の値かNullを取得する
     */
    private static Float getFloatOrNull(String key) {
        float minValue = getFloat(key, Float.MIN_VALUE);
        float maxValue = getFloat(key, Float.MAX_VALUE);
        if (minValue == Float.MIN_VALUE && maxValue == Float.MAX_VALUE) return null;
        return minValue;
    }

    /**
     * Double型の値を取得する
     */
    private static double getDouble(String key, double defValue) {
        long defaultValue = Double.doubleToRawLongBits(defValue);
        return Double.longBitsToDouble(getSharedPreferences().getLong(key, defaultValue));
    }

    private static double getDouble(String key) {
        return getDouble(key, 0.0);
    }

    /**
     * Double型の値かNullを取得する
     */
    private static Double getDoubleOrNull(String key) {
        double minValue = getDouble(key, Double.MIN_VALUE);
        double maxValue = getDouble(key, Double.MAX_VALUE);
        if (minValue == Double.MIN_VALUE && maxValue == Double.MAX_VALUE) return null;
        return minValue;
    }

    /**
     * boolean型の値を取得する
     */
    private static boolean getBoolean(String key, boolean defValue) {
        return getSharedPreferences().getBoolean(key, defValue);
    }

    private static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * Boolean型の値かNullを取得する
     */
    private static Boolean getBooleanOrNull(String key) {
        boolean isTrue = getBoolean(key, true);
        boolean isFalse = getBoolean(key, false);
        if (isTrue && !isFalse) return null;
        return isTrue;
    }

    /**
     * String型の値を取得する
     */
    private static String getString(String key, String defValue) {
        return getSharedPreferences().getString(key, defValue);
    }

    /**
     * String型の値か空白を取得する
     */
    private static String getStringOrEmpty(String key) {
        return getString(key, "");
    }

    /**
     * String型の値かNullを取得する
     */
    private static String getStringOrNull(String key) {
        String value = getString(key, null);
        if (value == null || value.isEmpty()) return null;
        return value;
    }

    /**
     * Set<String>型の値を取得する
     */
    private static Set<String> getStringSet(String key, Set<String> defValue) {
        return getSharedPreferences().getStringSet(key, defValue);
    }

    /**
     * Set<String>型の値かNullを取得する
     */
    private static Set<String> getStringSetOrNull(String key) {
        return getStringSet(key, new HashSet<String>());
    }

    /**
     * int型の値を設定する
     */
    private static void setInt(String key, int value) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putInt(key, value).apply();
    }

    /**
     * long型の値を設定する
     */
    private static void setLong(String key, long value) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putLong(key, value).apply();
    }

    /**
     * float型の値を設定する
     */
    private static void setFloat(String key, float value) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putFloat(key, value).apply();
    }

    /**
     * Double型の値を設定する
     */
    private static void setDouble(String key, Double value) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putFloat(key, value.floatValue()).apply();
    }

    /**
     * boolean型の値を設定する
     */
    private static void setBoolean(String key, boolean value) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putBoolean(key, value).apply();
    }

    /**
     * String型の値を設定する
     */
    private static void setString(String key, String value) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(key, value).apply();
    }

    /**
     * Set<String>型の値を設定する
     */
    private static void setStringSet(String key, Set<String> value) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putStringSet(key, value).apply();
    }

    /**
     * 指定したkeyの値を削除する
     */
    private static void remove(String... keys) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        for (String key : keys) {
            editor.remove(key);
        }
        editor.apply();
    }

}
