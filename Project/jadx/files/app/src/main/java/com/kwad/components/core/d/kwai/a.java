package com.kwad.components.core.d.kwai;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.core.d.kwai.a$a, reason: collision with other inner class name */
    static class C0396a {
        private static final c IF = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long aj(String str) {
        return mW().ak(str);
    }

    private static c mW() {
        return C0396a.IF;
    }

    public static String o(long j2) {
        String strP = mW().p(j2);
        return strP.endsWith("=") ? strP.replace("=", "") : strP;
    }
}
