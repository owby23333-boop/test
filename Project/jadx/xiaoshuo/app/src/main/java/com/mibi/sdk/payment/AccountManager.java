package com.mibi.sdk.payment;

import android.content.Context;
import com.mibi.sdk.account.AccountInjector;
import com.mibi.sdk.common.utils.MibiLog;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes15.dex */
class AccountManager {
    private static final String ACCOUNT_MODULE_INJECTOR = "com.mibi.sdk.account.AccountInjector";
    private static final String TAG = "AccountManager";

    public static void initAccount(Context context) {
        tryInjectAccount(context);
    }

    public static boolean isLogined(Context context) {
        Boolean bool;
        Boolean bool2 = Boolean.FALSE;
        try {
            bool = (Boolean) AccountInjector.class.getMethod("isLogined", Context.class).invoke(null, context);
        } catch (ClassNotFoundException unused) {
        } catch (IllegalAccessException e) {
            e = e;
        } catch (NoSuchMethodException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        try {
            MibiLog.d("AccountManager", "isLogin:" + bool);
        } catch (ClassNotFoundException unused2) {
            bool2 = bool;
            MibiLog.e("AccountManager", "AccountInjector is not founded.Use no account");
            bool = bool2;
        } catch (IllegalAccessException e4) {
            e = e4;
            bool2 = bool;
            e.printStackTrace();
            bool = bool2;
        } catch (NoSuchMethodException e5) {
            e = e5;
            bool2 = bool;
            e.printStackTrace();
            bool = bool2;
        } catch (InvocationTargetException e6) {
            e = e6;
            bool2 = bool;
            e.printStackTrace();
            bool = bool2;
        }
        return bool.booleanValue();
    }

    public static void tryClearAccount() {
        try {
            AccountInjector.class.getMethod("release", new Class[0]).invoke(null, new Object[0]);
            MibiLog.d("AccountManager", "tryInjectAccount success");
        } catch (ClassNotFoundException unused) {
            MibiLog.e("AccountManager", "AccountInjector is not founded.Use no account");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    private static void tryInjectAccount(Context context) {
        try {
            AccountInjector.class.getMethod("inject", Context.class).invoke(null, context);
            MibiLog.d("AccountManager", "tryInjectAccount success");
        } catch (ClassNotFoundException unused) {
            MibiLog.e("AccountManager", "AccountInjector is not founded.Use no account");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }
}
