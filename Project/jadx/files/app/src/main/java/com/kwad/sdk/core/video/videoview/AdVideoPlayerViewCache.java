package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> BX;

    enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache(0);

        Holder() {
        }

        final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    private AdVideoPlayerViewCache() {
        this.BX = new HashMap<>(1);
    }

    /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.BX.put(str, new WeakReference<>(aVar));
    }

    public final a cv(String str) {
        WeakReference<a> weakReference = this.BX.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.BX.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.BX.remove(str);
    }
}
