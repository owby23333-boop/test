package com.kwad.components.core.n;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.x;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static volatile boolean Ok = false;
    private static volatile boolean Ol = false;
    private static Context Om;
    private static final List<a> On = new CopyOnWriteArrayList();

    public interface a {
        void a(@NonNull SdkConfigData sdkConfigData);

        void oi();
    }

    public static synchronized void a(Context context, a aVar) {
        if (Ok) {
            com.kwad.sdk.core.d.b.d("ConfigRequestManager", "config request manager has init-ed");
            return;
        }
        Ok = true;
        Om = context;
        On.add(aVar);
        com.kwad.sdk.utils.g.execute(new av() { // from class: com.kwad.components.core.n.e.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                x.j(e.Om, x.ce(e.Om) + 1);
                com.kwad.sdk.core.config.d.aR(e.Om);
                for (a aVar2 : e.On) {
                    if (aVar2 != null) {
                        aVar2.oi();
                    }
                }
                e.pw();
            }
        });
    }

    public static void a(a aVar) {
        On.add(aVar);
        if (isLoaded()) {
            aVar.oi();
        }
        if (Ol) {
            aVar.a(com.kwad.sdk.core.config.d.uG());
        }
    }

    static /* synthetic */ boolean aC(boolean z2) {
        Ol = true;
        return true;
    }

    private static boolean isLoaded() {
        return com.kwad.sdk.core.config.d.isLoaded();
    }

    public static void pw() {
        com.kwad.sdk.core.d.b.d("ConfigRequestManager", "load()");
        new m<d, SdkConfigData>() { // from class: com.kwad.components.core.n.e.2
            @NonNull
            private static SdkConfigData av(String str) {
                x.aa(e.Om, str);
                JSONObject jSONObject = new JSONObject(str);
                SdkConfigData sdkConfigData = new SdkConfigData();
                sdkConfigData.parseJson(jSONObject);
                try {
                    com.kwad.sdk.core.config.d.sK();
                    com.kwad.sdk.core.config.d.uk();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
                return sdkConfigData;
            }

            @NonNull
            private static d py() {
                return new d();
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ com.kwad.sdk.core.network.g createRequest() {
                return py();
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return av(str);
            }
        }.request(new p<d, SdkConfigData>() { // from class: com.kwad.components.core.n.e.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull d dVar) {
                com.kwad.sdk.core.d.b.d("ConfigRequestManager", "onStartRequest request url = " + dVar.getUrl());
                super.onStartRequest(dVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull d dVar, int i2, String str) {
                super.onError(dVar, i2, str);
                com.kwad.sdk.core.d.b.d("ConfigRequestManager", "onError errorCode=" + i2 + " errorMsg=" + str);
            }

            private static void b(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.config.b.aP(e.Om);
                com.kwad.sdk.core.config.d.c(sdkConfigData);
                e.aC(true);
                for (a aVar : e.On) {
                    if (aVar != null) {
                        aVar.a(sdkConfigData);
                    }
                }
                if (sdkConfigData != null) {
                    com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
                }
                w.Dh();
                w.Db();
                x.j(e.Om, 0);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                b((SdkConfigData) baseResultData);
            }
        });
    }
}
