package com.amgcyo.cuttadon.utils.otherutils;

import android.annotation.SuppressLint;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.app.MkApplication;

/* JADX INFO: compiled from: ZhugeIoUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class x0 {

    @SuppressLint({"StaticFieldLeak"})
    private static x0 a;

    private x0() {
        h.O0();
        MkApplication.getAppContext();
    }

    public static x0 c() {
        if (a == null) {
            synchronized (x0.class) {
                if (a == null) {
                    a = new x0();
                }
            }
        }
        return a;
    }

    public void a() {
    }

    public void a(int i2) {
    }

    public void a(int i2, int i3, int i4, String str, int i5) {
    }

    public void a(int i2, int i3, String str) {
    }

    public void a(MkUser mkUser, int i2) {
    }

    public void a(String str) {
    }

    public void a(String str, int i2, String str2) {
    }

    public void a(String str, int i2, String str2, int i3) {
    }

    public void a(String str, String str2) {
    }

    public void b() {
    }
}
