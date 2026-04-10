package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class WebCardRegisterLiveMessageListener implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;

    public static final class AdLiveMessageInfoList extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -9127181276274466179L;
        public List<AdLiveMessageItemInfo> adLiveMessageInfos;

        public static final class AdLiveMessageItemInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            private static final long serialVersionUID = 1943278809007082732L;
            public String content;
            public String userName;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.sdk.core.d.b.d("TAGGG", "recive CallBack ");
        this.RZ = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerLiveMessageListener";
    }

    public final void l(List<AdLiveMessageInfo> list) {
        com.kwad.sdk.core.d.b.d("TAGGG", "size " + list.size());
        if (this.RZ == null) {
            return;
        }
        AdLiveMessageInfoList adLiveMessageInfoList = new AdLiveMessageInfoList();
        adLiveMessageInfoList.adLiveMessageInfos = new ArrayList();
        for (AdLiveMessageInfo adLiveMessageInfo : list) {
            AdLiveMessageInfoList.AdLiveMessageItemInfo adLiveMessageItemInfo = new AdLiveMessageInfoList.AdLiveMessageItemInfo();
            adLiveMessageItemInfo.userName = adLiveMessageInfo.userName;
            adLiveMessageItemInfo.content = adLiveMessageInfo.content;
            adLiveMessageInfoList.adLiveMessageInfos.add(adLiveMessageItemInfo);
        }
        com.kwad.sdk.core.d.b.d("TAGGG", "size " + adLiveMessageInfoList.toJson().toString());
        this.RZ.a(adLiveMessageInfoList);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
    }
}
