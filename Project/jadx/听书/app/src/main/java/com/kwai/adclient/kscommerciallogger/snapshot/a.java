package com.kwai.adclient.kscommerciallogger.snapshot;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends c {
    a(String str) {
        super(str, 0);
    }

    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    public final synchronized d hP(String str) {
        return new b("empty");
    }

    @Override // com.kwai.adclient.kscommerciallogger.snapshot.c
    final JSONObject hQ(String str) {
        return new JSONObject();
    }
}
