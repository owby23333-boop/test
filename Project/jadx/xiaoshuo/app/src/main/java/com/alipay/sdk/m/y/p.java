package com.alipay.sdk.m.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2008a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a() {
        return com.alipay.sdk.m.n.a.f1870b;
    }

    public static String b(Context context) {
        if (EnvUtils.isPreSandBox()) {
            return com.alipay.sdk.m.n.a.c;
        }
        if (EnvUtils.isNewSanBox()) {
            return com.alipay.sdk.m.n.a.d;
        }
        if (context == null) {
            return com.alipay.sdk.m.n.a.f1869a;
        }
        String str = com.alipay.sdk.m.n.a.f1869a;
        return TextUtils.isEmpty(str) ? com.alipay.sdk.m.n.a.f1869a : str;
    }

    public static String a(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f2008a), null, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("url")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
