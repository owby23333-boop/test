package com.kwad.components.ad.draw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.n;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        boolean zA = n.qi().a(sceneImplCovert, "loadDrawAd");
        sceneImplCovert.setAdStyle(6);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0403a().e(new com.kwad.components.core.n.kwai.b(sceneImplCovert)).aE(zA).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
            public final void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                        arrayList.add(new c(adTemplate));
                    }
                }
                if (!arrayList.isEmpty()) {
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            KsAdLoadManager.ac().b(arrayList);
                            drawAdListener.onDrawAdLoad(arrayList);
                        }
                    });
                    return;
                }
                onError(f.afS.errorCode, f.afS.msg + "(无视频资源)");
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
            public final void onError(final int i2, final String str) {
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        drawAdListener.onError(i2, str);
                    }
                });
            }
        }).pz());
    }
}
