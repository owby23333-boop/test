package com.bytedance.sdk.openadsdk.core.component.splash.bf.e;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdSlot;

/* JADX INFO: loaded from: classes10.dex */
public class d {
    private v bf;
    private Context d;
    private vn e;
    private int ga = 1;
    private TTAdSlot p;
    private String tg;
    private String v;
    private int vn;

    public d(Context context, String str, vn vnVar, v vVar, TTAdSlot tTAdSlot) {
        this.d = context;
        this.tg = str;
        this.e = vnVar;
        this.bf = vVar;
        this.p = tTAdSlot;
        if (vVar == null || TextUtils.isEmpty(vVar.wu())) {
            return;
        }
        this.v = vVar.wu();
    }

    public v bf() {
        return this.bf;
    }

    public String d() {
        return this.tg;
    }

    public vn e() {
        return this.e;
    }

    public int ga() {
        return this.vn;
    }

    public Context getContext() {
        return this.d;
    }

    public TTAdSlot tg() {
        return this.p;
    }

    public String vn() {
        return this.v;
    }

    public void e(int i) {
        this.vn = i;
    }
}
