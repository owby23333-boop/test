package com.xiaomi.accountsdk.guestaccount.data;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
class BundleWrapper {
    protected final Bundle bundle;

    public BundleWrapper(Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("srcBundle == null");
        }
        Bundle bundle2 = new Bundle(bundle);
        this.bundle = bundle2;
        bundle2.setClassLoader(getClass().getClassLoader());
    }

    public Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public BundleWrapper() {
        this.bundle = new Bundle();
    }
}
