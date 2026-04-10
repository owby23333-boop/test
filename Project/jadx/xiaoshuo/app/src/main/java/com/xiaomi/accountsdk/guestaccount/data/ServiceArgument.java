package com.xiaomi.accountsdk.guestaccount.data;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public final class ServiceArgument extends BundleWrapper {
    private static final String BUNDLE_KEY_CALLBACK = "callback";
    private static final String BUNDLE_KEY_P_SID = "psid";
    private static final String BUNDLE_KEY_SDK_VERSION = "sdk_version";
    private static final String BUNDLE_KEY_SID = "sid";

    public ServiceArgument(Bundle bundle) {
        super(bundle);
    }

    public String getCallback() {
        return this.bundle.getString("callback");
    }

    public String getPSid() {
        return this.bundle.getString(BUNDLE_KEY_P_SID);
    }

    public String getSdkVersion() {
        return this.bundle.getString("sdk_version");
    }

    public String getSid() {
        return this.bundle.getString("sid");
    }

    public ServiceArgument setCallback(String str) {
        this.bundle.putString("callback", str);
        return this;
    }

    public ServiceArgument setPSid(String str) {
        this.bundle.putString(BUNDLE_KEY_P_SID, str);
        return this;
    }

    public ServiceArgument setSdkVersion(String str) {
        this.bundle.putString("sdk_version", str);
        return this;
    }

    public ServiceArgument setSid(String str) {
        this.bundle.putString("sid", str);
        return this;
    }

    @Override // com.xiaomi.accountsdk.guestaccount.data.BundleWrapper
    public /* bridge */ /* synthetic */ Bundle toBundle() {
        return super.toBundle();
    }

    public ServiceArgument() {
    }
}
