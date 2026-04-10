package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> Fl;

    /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache(0);

        Holder() {
        }

        final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private AdVideoPlayerViewCache() {
        this.Fl = new HashMap<>(1);
    }

    public final void a(String str, a aVar) {
        this.Fl.put(str, new WeakReference<>(aVar));
    }

    public final void remove(String str) {
        this.Fl.remove(str);
    }

    public final a eF(String str) {
        WeakReference<a> weakReference = this.Fl.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.Fl.remove(str);
        }
        return null;
    }
}
