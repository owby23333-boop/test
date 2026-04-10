package com.baidu.tts.tools;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.cuid.util.DeviceId;

/* JADX INFO: loaded from: classes2.dex */
public class GetCUID {
    private static final String TAG = "Device";

    private GetCUID() {
    }

    public static String getCUID(Context context) {
        String cuid = DeviceId.getCUID(context);
        LoggerProxy.d(TAG, "cuid=" + cuid);
        return cuid;
    }
}
