package com.mibi.sdk.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public class Utils {
    private static final String TAG = "Utils";
    public static final String sServiceNumber = "400-100-3399";

    public static class ValueDivided {
        public String mFractionalPart;
        public String mIntegerPart;
    }

    private Utils() {
    }

    public static long[] LongArrayListTolongArray(List<Long> list) {
        long[] jArr = new long[list.size()];
        Iterator<Long> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    public static long[] LongSetTolongArray(Set<Long> set) {
        long[] jArr = new long[set.size()];
        Iterator<Long> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    public static boolean checkStrings(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static void collapseSoftInputMethod(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        ((InputMethodManager) context.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void dial(Activity activity, String str) {
        activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    public static void dialService(Activity activity) {
        dial(activity, sServiceNumber);
    }

    public static void ensureOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("current thread is not main");
        }
    }

    public static boolean getBooleanPref(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static String getFullPrice(long j) {
        return String.format(Locale.US, "%.2f", Double.valueOf(j / 100.0d));
    }

    public static long getLongPref(Context context, String str, long j) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j);
    }

    public static ValueDivided getPriceIntegerAndFractionalPart(long j) {
        ValueDivided valueDivided = new ValueDivided();
        String simplePrice = getSimplePrice(j);
        int iIndexOf = simplePrice.indexOf(Consts.DOT);
        if (iIndexOf == -1) {
            valueDivided.mIntegerPart = simplePrice;
            valueDivided.mFractionalPart = "";
        } else {
            valueDivided.mIntegerPart = simplePrice.substring(0, iIndexOf);
            valueDivided.mFractionalPart = simplePrice.substring(iIndexOf + 1);
        }
        return valueDivided;
    }

    public static String getSimplePrice(long j) {
        return j % 100 == 0 ? String.format(Locale.US, TimeModel.NUMBER_FORMAT, Long.valueOf(j / 100)) : j % 10 == 0 ? String.format(Locale.US, "%.1f", Double.valueOf(j / 100.0d)) : String.format(Locale.US, "%.2f", Double.valueOf(j / 100.0d));
    }

    public static String getStringPref(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static boolean isInnerIntent(Context context, Intent intent) {
        ActivityInfo activityInfoResolveActivityInfo = intent.resolveActivityInfo(context.getPackageManager(), 0);
        if (activityInfoResolveActivityInfo == null) {
            return false;
        }
        return TextUtils.equals(context.getPackageName(), activityInfoResolveActivityInfo.packageName);
    }

    public static String join(CharSequence charSequence, Object... objArr) {
        return TextUtils.join(charSequence, objArr);
    }

    public static String joinUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.charAt(str.length() - 1) == '/') {
            str = str.substring(0, str.length() - 1);
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str + "/" + str2;
    }

    public static void removeAllPrefData(Context context) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0058 A[Catch: IOException -> 0x005b, TRY_LEAVE, TryCatch #7 {IOException -> 0x005b, blocks: (B:35:0x0053, B:37:0x0058), top: B:46:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean retrieveFileFromAssets(android.content.Context r3, java.lang.String r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            java.io.InputStream r3 = r3.open(r4)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L35
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L35
            r4.createNewFile()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L35
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L35
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L35
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
        L1b:
            int r1 = r3.read(r4)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            if (r1 <= 0) goto L25
            r5.write(r4, r0, r1)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            goto L1b
        L25:
            r3.close()     // Catch: java.io.IOException -> L2b
            r5.close()     // Catch: java.io.IOException -> L2b
        L2b:
            r0 = 1
            goto L4f
        L2d:
            r4 = move-exception
            goto L33
        L2f:
            r4 = move-exception
            goto L37
        L31:
            r4 = move-exception
            r5 = r1
        L33:
            r1 = r3
            goto L51
        L35:
            r4 = move-exception
            r5 = r1
        L37:
            r1 = r3
            goto L3e
        L39:
            r4 = move-exception
            r5 = r1
            goto L51
        L3c:
            r4 = move-exception
            r5 = r1
        L3e:
            java.lang.String r3 = "Utils"
            java.lang.String r2 = "Utils retrieveFileFromAssets IOException "
            com.mibi.sdk.common.utils.MibiLog.e(r3, r2, r4)     // Catch: java.lang.Throwable -> L50
            if (r1 == 0) goto L4a
            r1.close()     // Catch: java.io.IOException -> L4f
        L4a:
            if (r5 == 0) goto L4f
            r5.close()     // Catch: java.io.IOException -> L4f
        L4f:
            return r0
        L50:
            r4 = move-exception
        L51:
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.io.IOException -> L5b
        L56:
            if (r5 == 0) goto L5b
            r5.close()     // Catch: java.io.IOException -> L5b
        L5b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mibi.sdk.common.Utils.retrieveFileFromAssets(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public static String retrieveStringFromAssets(Context context, String str) throws Throwable {
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
        } catch (IOException unused) {
            inputStreamOpen = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(inputStreamOpen);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            scanner.close();
            String string = sb.toString();
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused2) {
                }
            }
            return string;
        } catch (IOException unused3) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpen;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static void setBooleanPref(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public static void setLongPref(Context context, String str, long j) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    public static void setStringPref(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static void showSoftInputMethod(Context context, View view, boolean z) {
        if (view == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getApplicationContext().getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(view, 1);
        } else {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
