package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.INet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.sdk.core.network.b {

    @NonNull
    public final Map<String, String> arY = new HashMap();

    public c(String str, String str2, String str3) {
        this.arY.put("did", str);
        this.arY.put("sid", str2);
        this.arY.put("fileExtend", str3);
        this.arY.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final Map<String, String> getBodyMap() {
        return this.arY;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return "https://" + com.kwad.sdk.core.network.idc.a.wy().C(INet.HostType.ULOG, "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}
