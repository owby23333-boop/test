package com.yuewen;

import android.util.Patterns;

/* JADX INFO: loaded from: classes10.dex */
public class bw0 implements tb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9452a;

    public bw0(String str) {
        this.f9452a = str;
    }

    @Override // com.yuewen.tb4
    public boolean isValid() {
        return Patterns.EMAIL_ADDRESS.matcher(this.f9452a).matches();
    }
}
