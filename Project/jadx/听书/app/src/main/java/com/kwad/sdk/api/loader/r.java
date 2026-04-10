package com.kwad.sdk.api.loader;

/* JADX INFO: loaded from: classes4.dex */
public final class r {
    public static q Dp() {
        try {
            return (q) Class.forName("com.kwad.sdk.liteapi.KsLiteApiImpl").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
