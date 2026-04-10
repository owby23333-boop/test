package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public class xb4 implements tb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19849a;

    public xb4(String str) {
        this.f19849a = str;
    }

    @Override // com.yuewen.tb4
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f19849a) && lp2.I(this.f19849a) && this.f19849a.length() == 4;
    }
}
