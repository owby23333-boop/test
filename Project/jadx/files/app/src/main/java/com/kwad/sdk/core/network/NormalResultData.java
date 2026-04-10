package com.kwad.sdk.core.network;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class NormalResultData extends BaseResultData {
    public int code;
    public String data;
    public Map<String, String> header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.afK;
        this.header = null;
    }
}
