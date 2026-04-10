package com.duokan.account.oauth.weixin;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.opensdk.openapi.IWXAPI;

/* JADX INFO: loaded from: classes10.dex */
public interface Weixin {
    IWXAPI createWxApi(int i);

    boolean isSupportShareWeiXinFriends(Context context);

    boolean isWeiXinInstalled(Context context);

    boolean isWeiXinPaySupported(Context context);

    void login();

    void send2Friend(String str, String str2);

    void share(ShareInfo shareInfo);

    void shareWithSummary(Bitmap bitmap, String str);
}
