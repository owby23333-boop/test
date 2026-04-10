package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16593a = "";

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f16593a, ((qr0) obj).f16593a);
    }
}
