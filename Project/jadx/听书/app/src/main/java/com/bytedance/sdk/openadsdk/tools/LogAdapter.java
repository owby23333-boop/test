package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.ti.z.dl;

/* JADX INFO: loaded from: classes2.dex */
public class LogAdapter implements com.bytedance.sdk.component.z {
    public static LogAdapter z;
    private dl.z g;

    private LogAdapter() {
    }

    public dl.z z() {
        return this.g;
    }

    public static void zzz(TTILog tTILog) {
        if (gk.dl > 5300 && z == null && tTILog != null) {
            z((dl.z) new dl.g(tTILog), false);
        }
    }

    public static void z(dl.z zVar, boolean z2) {
        LogAdapter logAdapter = new LogAdapter();
        z = logAdapter;
        if (z2) {
            logAdapter.g = new z(zVar);
        } else {
            logAdapter.g = zVar;
        }
    }

    public void a(String str, String str2) {
        dl.z zVar = this.g;
        if (zVar != null) {
            zVar.g(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.z
    public void z(String str, String str2) {
        dl.z zVar = this.g;
        if (zVar != null) {
            zVar.dl(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.z
    public void g(String str, String str2) {
        dl.z zVar = this.g;
        if (zVar != null) {
            zVar.a(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.z
    public void z(String str, String str2, Throwable th) {
        dl.z zVar = this.g;
        if (zVar != null) {
            zVar.z(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.z
    public void dl(String str, String str2) {
        dl.z zVar = this.g;
        if (zVar != null) {
            zVar.gc(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.z
    public void g(String str, String str2, Throwable th) {
        dl.z zVar = this.g;
        if (zVar != null) {
            zVar.g(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.z
    public void z(String str, Throwable th) {
        dl.z zVar = this.g;
        if (zVar != null) {
            zVar.z(str, th);
        }
    }
}
