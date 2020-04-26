package com.naoele.androidutilities.Utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * ApplicationContextをどこからでも参照できるシングルトンクラス
 */
public class ContextUtility {

    private static ContextUtility instance = null;
    private Context applicationContext;

    /**
     * アクセスレベルをパッケージローカルにして意図しないところで呼び出されるのを防ぐ
     */
    static void onCreateApplication(Context applicationContext) {
        // Application#onCreateのタイミングでシングルトンが生成される
        instance = new ContextUtility(applicationContext);
    }

    private ContextUtility(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * インスタンスを呼び出す拡張メソッドに使用する
     */
    public static ContextUtility getInstance() {
        isNull();
        return instance;
    }

    /**
     * ApplicationContextを取得する
     */
    public static Context getContext() {
        isNull();
        return instance.getApplicationContext();
    }

    /**
     * strings.xmlから文字列を取得する
     */
    public static String getString(int resId) {
        isNull();
        return instance.getApplicationContext().getString(resId);
    }

    /**
     * Resourcesを取得する
     */
    public static Resources getResources() {
        isNull();
        return instance.getContext().getResources();
    }

    private static void isNull() {
        if (instance == null) {
            // こんなことは起きないはず
            throw new RuntimeException("ContextUtility should be initialized!");
        }
    }

    private Context getApplicationContext() {
        return this.applicationContext;
    }
}
