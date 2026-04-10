package com.kwad.sdk.kgeo;

import com.kwad.components.core.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static String aSg;
    private static KGeoInfo aSh;
    private static final AtomicBoolean aSi = new AtomicBoolean();

    public static void ea(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            MT();
        } else if (i == 2) {
            com.kwad.components.core.request.b.sj().a(new b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void sl() {
                    com.kwad.components.core.request.b.sj().b(this);
                    a.MT();
                }
            });
        }
    }

    public static String Bo() {
        return aSg;
    }

    public static KGeoInfo MS() {
        return aSh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MT() {
        try {
            if (aSi.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.Pp(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.aSg = str;
                    a.MU();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void Ll() {
                    a.MU();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MU() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @Override // com.kwad.sdk.core.network.l
                public final /* synthetic */ BaseResultData parseData(String str) {
                    return ga(str);
                }

                private static KGeoResultData ga(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                public final f createRequest() {
                    return new b();
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }

                private static void a(KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.aSh = kGeoResultData.kGeoInfo;
                }
            });
        } catch (Throwable unused) {
        }
    }
}
