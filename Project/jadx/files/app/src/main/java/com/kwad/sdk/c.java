package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static String sA() {
        return ss() + "/rest/e/v3/open/crashLog";
    }

    public static String sB() {
        return ss() + "/rest/e/v3/open/appCheck";
    }

    public static String sC() {
        return ss() + "/rest/e/v3/open/collect";
    }

    public static String ss() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.wy().C("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return str;
    }

    public static String st() {
        return ss() + "/rest/e/v3/open/univ";
    }

    public static String su() {
        return ss() + "/rest/e/v4/open/univ";
    }

    public static String sv() {
        return ss() + "/rest/e/v4/open/univ/bidding";
    }

    public static String sw() {
        return ss() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String sx() {
        return ss() + "/rest/e/v3/open/logBatch";
    }

    public static String sy() {
        return ss() + "/rest/e/v3/open/config";
    }

    public static String sz() {
        return ss() + "/rest/e/v3/open/callback";
    }
}
