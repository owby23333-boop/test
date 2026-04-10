package com.kwad.components.core.e.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static c oS() {
        return C0330a.OD;
    }

    public static String y(long j) {
        String strZ = oS().z(j);
        return strZ.endsWith("=") ? strZ.replace("=", "") : strZ;
    }

    public static long ai(String str) {
        return oS().aj(str);
    }

    /* JADX INFO: renamed from: com.kwad.components.core.e.b.a$a, reason: collision with other inner class name */
    static class C0330a {
        private static final c OD = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }
}
