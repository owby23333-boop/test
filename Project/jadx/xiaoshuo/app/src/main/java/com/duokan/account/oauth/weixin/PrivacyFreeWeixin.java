package com.duokan.account.oauth.weixin;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.opensdk.openapi.IWXAPI;

/* JADX INFO: loaded from: classes10.dex */
class PrivacyFreeWeixin implements Weixin {
    @Override // com.duokan.account.oauth.weixin.Weixin
    public IWXAPI createWxApi(int i) {
        return null;
    }

    @Override // com.duokan.account.oauth.weixin.Weixin
    public boolean isSupportShareWeiXinFriends(Context context) {
        return false;
    }

    @Override // com.duokan.account.oauth.weixin.Weixin
    public boolean isWeiXinInstalled(Context context) {
        return false;
    }

    @Override // com.duokan.account.oauth.weixin.Weixin
    public boolean isWeiXinPaySupported(Context context) {
        return false;
    }

    @Override // com.duokan.account.oauth.weixin.Weixin
    public void login() {
    }

    @Override // com.duokan.account.oauth.weixin.Weixin
    public void send2Friend(String str, String str2) {
    }

    @Override // com.duokan.account.oauth.weixin.Weixin
    public void share(ShareInfo shareInfo) {
    }

    @Override // com.duokan.account.oauth.weixin.Weixin
    public void shareWithSummary(Bitmap bitmap, String str) {
    }
}
