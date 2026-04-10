package com.bytedance.embedapplog;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface ISensitiveInfoProvider {
    String getCurrentProcessName(Context context);

    String getImsi();

    String getMac();

    String getSdkBuildModel();
}
