package com.yuewen;

import com.duokan.reader.ui.store.data.cms.Extend;

/* JADX INFO: loaded from: classes12.dex */
public class v6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18892b;
    public String c;

    public v6(Extend extend) {
        if (extend != null) {
            this.f18891a = extend.freeMinutes;
            this.c = extend.freeTitle;
            this.f18892b = extend.trySeconds;
        }
    }

    public v6(int i, int i2, String str) {
        this.f18891a = i;
        this.f18892b = i2;
        this.c = str;
    }
}
