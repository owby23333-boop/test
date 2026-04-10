package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private Map<String, List<AdTemplate>> ta;

    /* synthetic */ i(byte b) {
        this();
    }

    private i() {
        this.ta = new ConcurrentHashMap();
    }

    static class a {
        private static final i tb = new i(0);
    }

    public static i hs() {
        return a.tb;
    }

    public final void H(String str) {
        this.ta.remove(str);
    }
}
