package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.b;
import com.kwad.sdk.utils.ap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {
    private IAdLiveEndRequest fV;

    public a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.fV = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final Map<String, String> getBodyMap() {
        return this.fV.getBodyMap();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.fV;
        if (iAdLiveEndRequest == null || iAdLiveEndRequest.getHeader() == null || this.fV.getHeader().size() <= 0) {
            return super.getHeader();
        }
        for (String str : this.fV.getHeader().keySet()) {
            if (!TextUtils.isEmpty(this.fV.getHeader().get(str))) {
                addHeader(str, this.fV.getHeader().get(str));
            }
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return ap.appendUrl(this.fV.getUrl(), this.fV.getUrlParam());
    }
}
