package com.kwad.components.core.webview.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes4.dex */
public class c extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public String NN;
    public String abZ;
    public String aca;
    public int acb;

    public final AdInfo.SmallAppJumpInfo aR(String str) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        smallAppJumpInfo.mediaSmallAppId = str;
        smallAppJumpInfo.originId = this.abZ;
        smallAppJumpInfo.smallAppJumpUrl = this.aca;
        return smallAppJumpInfo;
    }
}
