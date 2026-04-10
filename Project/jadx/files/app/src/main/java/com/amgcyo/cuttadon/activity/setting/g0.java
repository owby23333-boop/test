package com.amgcyo.cuttadon.activity.setting;

import com.umeng.message.api.UPushSettingCallback;

/* JADX INFO: compiled from: MkSettingActivity.java */
/* JADX INFO: loaded from: classes.dex */
class g0 implements UPushSettingCallback {
    final /* synthetic */ MkSettingActivity a;

    g0(MkSettingActivity mkSettingActivity) {
        this.a = mkSettingActivity;
    }

    @Override // com.umeng.message.api.UPushSettingCallback
    public void onFailure(String str, String str2) {
        this.a.p();
    }

    @Override // com.umeng.message.api.UPushSettingCallback
    public void onSuccess() {
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("swtich_jpush", true);
        this.a.p();
    }
}
