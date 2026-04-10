package com.anythink.expressad.exoplayer.j.a;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class j {
    private static final String a = "exo_";
    private static final String b = "exo_redir";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9637c = "exo_len";

    private j() {
    }

    public static long a(i iVar) {
        return iVar.a(f9637c);
    }

    @Nullable
    private static Uri b(i iVar) {
        String strA = iVar.a(b, (String) null);
        if (strA == null) {
            return null;
        }
        return Uri.parse(strA);
    }

    public static void a(k kVar, long j2) {
        kVar.a(f9637c, j2);
    }

    private static void a(k kVar) {
        kVar.a(f9637c);
    }

    private static void b(k kVar) {
        kVar.a(b);
    }

    public static void a(k kVar, Uri uri) {
        kVar.a(b, uri.toString());
    }
}
