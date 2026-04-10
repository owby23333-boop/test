package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public class sj2 implements tb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17477a;

    public sj2(String str) {
        this.f17477a = str;
    }

    @Override // com.yuewen.tb4
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f17477a) && this.f17477a.length() == 11 && lp2.I(this.f17477a);
    }
}
