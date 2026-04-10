package com.bytedance.sdk.openadsdk.core.kb.z;

import com.bytedance.sdk.openadsdk.core.kb.a.dl;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class z implements ITTDownloadAdapter.OnEventLogHandler {
    private dl.z mPluginLogHandler;

    public z(dl.z zVar) {
        this.mPluginLogHandler = zVar;
    }

    public boolean onEventLog(int i, String str, String str2, String str3, Object obj) {
        dl.z zVar = this.mPluginLogHandler;
        if (zVar != null) {
            return zVar.z(i, str, str2, str3, obj);
        }
        return false;
    }
}
