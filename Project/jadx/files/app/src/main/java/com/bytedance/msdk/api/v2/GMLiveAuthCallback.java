package com.bytedance.msdk.api.v2;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public interface GMLiveAuthCallback extends Serializable {
    void onAuth(GMLiveToken gMLiveToken);

    void onFailed(Throwable th);
}
