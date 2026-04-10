package com.yuewen;

import android.text.TextUtils;
import com.duokan.common.BookFormat;

/* JADX INFO: loaded from: classes3.dex */
public class sr3 {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        hp0 hp0Var = new hp0(str);
        if (!TextUtils.isDigitsOnly(hp0Var.b())) {
            return false;
        }
        long j = Long.parseLong(hp0Var.b());
        return j >= zu0.r && j < zu0.s;
    }

    public static boolean b(String str) {
        return new hp0(str).b().length() == 32;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        hp0 hp0Var = new hp0(str);
        if (!TextUtils.isDigitsOnly(hp0Var.b())) {
            return false;
        }
        long j = Long.parseLong(hp0Var.b());
        return j >= zu0.q && j < zu0.r;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        hp0 hp0Var = new hp0(str);
        return TextUtils.isDigitsOnly(hp0Var.b()) && Long.parseLong(hp0Var.b()) < zu0.q;
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(new hp0(str).b());
    }

    public static BookFormat f(String str) {
        if (TextUtils.isEmpty(str)) {
            return BookFormat.PIRATE;
        }
        hp0 hp0Var = new hp0(str);
        if (!TextUtils.isDigitsOnly(hp0Var.b())) {
            return BookFormat.EPUB;
        }
        long j = Long.parseLong(hp0Var.b());
        return (j < zu0.q || j >= zu0.r) ? (j < zu0.r || j >= zu0.s) ? BookFormat.EPUB : BookFormat.ABK : BookFormat.SBK;
    }
}
