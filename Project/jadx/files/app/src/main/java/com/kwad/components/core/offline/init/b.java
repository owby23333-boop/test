package com.kwad.components.core.offline.init;

import android.content.Context;
import com.kwad.components.core.offline.init.kwai.g;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.utils.av;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final AtomicBoolean IC = new AtomicBoolean();

    public static void an(Context context) {
        com.kwad.components.offline.adLive.a.au(context);
        com.kwad.components.offline.obiwan.a.au(context);
        com.kwad.components.offline.tk.b.au(context);
    }

    public static void init(final Context context) {
        if (IC.get()) {
            return;
        }
        IC.set(true);
        OfflineHostProvider.get().init(context, new g());
        com.kwad.sdk.utils.g.execute(new av() { // from class: com.kwad.components.core.offline.init.b.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                b.an(context);
            }
        });
    }
}
