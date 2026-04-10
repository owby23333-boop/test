package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.component.sdk.annotation.Keep;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.api.TTILog;

/* JADX INFO: loaded from: classes10.dex */
@Keep
public class LogAdapter implements com.bytedance.sdk.component.e {
    public static LogAdapter sAdapter;
    private TTILog e;

    private LogAdapter() {
    }

    @Keep
    public static void zzz(TTILog tTILog) {
        if (sAdapter != null) {
            return;
        }
        zzz(tTILog, false);
    }

    @Override // com.bytedance.sdk.component.e
    public void bf(String str, String str2) {
        TTILog tTILog = this.e;
        if (tTILog != null) {
            tTILog.d(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.e
    public void d(String str, String str2) {
        TTILog tTILog = this.e;
        if (tTILog != null) {
            tTILog.i(str, str2);
        }
    }

    public TTILog e() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.e
    public void ga(String str, String str2) {
        TTILog tTILog = this.e;
        if (tTILog != null) {
            tTILog.e(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.e
    public void tg(String str, String str2) {
        TTILog tTILog = this.e;
        if (tTILog != null) {
            tTILog.w(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.e
    public void e(String str, String str2) {
        TTILog tTILog = this.e;
        if (tTILog != null) {
            tTILog.v(str, str2);
        }
    }

    public static void zzz(TTILog tTILog, boolean z) {
        LogAdapter logAdapter = new LogAdapter();
        sAdapter = logAdapter;
        if (z) {
            logAdapter.e = new e(tTILog);
        } else {
            logAdapter.e = tTILog;
        }
        wu.e(sAdapter);
    }

    @Override // com.bytedance.sdk.component.e
    public void bf(String str, String str2, Throwable th) {
        TTILog tTILog = this.e;
        if (tTILog != null) {
            tTILog.e(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.e
    public void e(String str, String str2, Throwable th) {
        TTILog tTILog = this.e;
        if (tTILog != null) {
            tTILog.w(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.e
    public void e(String str, Throwable th) {
        TTILog tTILog = this.e;
        if (tTILog != null) {
            tTILog.e(str, th);
        }
    }
}
