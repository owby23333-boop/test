package com.kwai.adclient.logger.snapshot;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {
    a(String str) {
        super(str, 0);
    }

    @Override // com.kwai.adclient.logger.snapshot.c
    public final synchronized d eQ(String str) {
        return new b("empty");
    }

    @Override // com.kwai.adclient.logger.snapshot.c
    final JSONObject eR(String str) {
        return new JSONObject();
    }
}
