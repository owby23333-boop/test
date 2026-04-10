package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DevTools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1949a;

    public String getDemoGameUrl() {
        String str = this.f1949a;
        this.f1949a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f1949a = str;
        }
    }
}
