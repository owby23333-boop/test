package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f7450a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f117a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return !TextUtils.isEmpty(tVar.f117a) && tVar.f117a.equals(this.f117a);
    }
}
