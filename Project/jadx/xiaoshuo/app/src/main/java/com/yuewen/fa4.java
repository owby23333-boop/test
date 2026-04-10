package com.yuewen;

import android.text.Html;

/* JADX INFO: loaded from: classes17.dex */
public class fa4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11086a = "&nbsp;";

    public static String a(String str) {
        return Html.fromHtml(str.replace(" ", f11086a)).toString();
    }
}
