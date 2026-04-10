package com.mibi.sdk.channel.alipay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.chinaums.pppay.unify.UnifyPayListener;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.LocalBroadcastManager;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.common.utils.UiUtil;

/* JADX INFO: loaded from: classes13.dex */
public class AlipayMiniProgramCallbackActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7051a = "AlipayMiniProgramCallbackActivity";

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String message;
        String queryParameter;
        super.onCreate(bundle);
        String str = f7051a;
        MibiLog.d(str, "onCreate");
        try {
            Uri data = getIntent().getData();
            queryParameter = data.getQueryParameter("errCode");
            message = data.getQueryParameter("errStr");
            MibiLog.d(str, "ali mini program pay result code :  " + queryParameter + " ; desc : " + message);
        } catch (Exception e) {
            MibiLog.d(f7051a, "parse ali mini program pay result failed : " + e.getMessage());
            message = e.getMessage();
            queryParameter = UnifyPayListener.ERR_PAY_FAIL;
        }
        Intent intent = new Intent(com.mibi.sdk.channel.alipay.f.a.d);
        intent.putExtra(CommonConstants.KEY_ERR_CODE, queryParameter);
        intent.putExtra(CommonConstants.KEY_ERR_DESC, message);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        UiUtil.moveToFront(this, UiUtil.getTaskId());
        finish();
    }
}
