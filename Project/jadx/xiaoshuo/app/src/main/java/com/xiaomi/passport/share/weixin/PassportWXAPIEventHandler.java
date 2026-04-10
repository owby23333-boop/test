package com.xiaomi.passport.share.weixin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.xiaomi.passport.jsb.method_impl.PassportJsbMethodShareMiniProgramToFriend;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public class PassportWXAPIEventHandler implements IWXAPIEventHandler {
    WeakReference<Activity> mActivityRef;

    public PassportWXAPIEventHandler(Activity activity) {
        this.mActivityRef = new WeakReference<>(activity);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        Activity activity = this.mActivityRef.get();
        if (activity != null) {
            Intent intent = new Intent(PassportJsbMethodShareMiniProgramToFriend.WEIXIN_SHARE_RESULT);
            intent.putExtra(PassportJsbMethodShareMiniProgramToFriend.WEIXIN_SHARE_RESULT_ERR_CODE, baseResp.errCode);
            intent.putExtra(PassportJsbMethodShareMiniProgramToFriend.WEIXIN_SHARE_RESULT_ERR_STR, baseResp.errStr);
            activity.sendBroadcast(intent);
        }
    }
}
