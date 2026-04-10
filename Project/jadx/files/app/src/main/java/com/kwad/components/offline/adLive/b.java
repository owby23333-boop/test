package com.kwad.components.offline.adLive;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.offline.init.kwai.i;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHttpRequestListenerDelegate;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.utils.ap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAdLiveOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig
    public final AdLiveHttpRequestListenerDelegate getAdLiveHttpRequestListenerDelegate() {
        return new AdLiveHttpRequestListenerDelegate() { // from class: com.kwad.components.offline.adLive.b.2
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHttpRequestListenerDelegate
            public final c doPost(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
                try {
                    return com.kwad.sdk.b.sq().doPost(ap.appendUrl(str, map), map2, map3);
                } catch (Throwable unused) {
                    return null;
                }
            }
        };
    }

    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.adLive.b.1
            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
                com.kwad.components.offline.adLive.kwai.a.a(context, soLoadListener);
            }
        };
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new i(IAdLiveOfflineCompo.PACKAGE_NAME);
    }
}
