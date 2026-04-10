package com.kwad.sdk.core.webview.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.p;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.e.kwai.b bVar) {
        String str = bVar.asJ;
        File file = new File(str);
        if (!p.G(file)) {
            return false;
        }
        if (!TextUtils.isEmpty(bVar.asL)) {
            String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
            if (fileMD5 != null && fileMD5.length() > 10) {
                fileMD5 = fileMD5.substring(0, 10);
            }
            if (!ba.isEquals(fileMD5, bVar.asL)) {
                p.V(file);
                return false;
            }
        }
        com.kwad.sdk.core.webview.a.b.b.a(bVar, 2);
        try {
            com.kwad.sdk.core.webview.a.b.a.f(context, str, com.kwad.sdk.core.webview.a.b.a.v(context, bVar.asI));
            p.V(file);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 2, e2.getMessage());
            return false;
        }
    }
}
