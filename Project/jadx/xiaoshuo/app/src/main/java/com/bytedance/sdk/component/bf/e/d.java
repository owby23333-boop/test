package com.bytedance.sdk.component.bf.e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    void onFailure(bf bfVar, IOException iOException);

    void onResponse(bf bfVar, s sVar) throws IOException;
}
