package com.kwad.sdk.core.response.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public class f {
    private static volatile f aIO;
    private String aIP = IU();

    private f() {
    }

    public static f IS() {
        if (aIO == null) {
            synchronized (f.class) {
                if (aIO == null) {
                    aIO = new f();
                }
            }
        }
        return aIO;
    }

    public final String IT() {
        return this.aIP;
    }

    public final void ez(String str) {
        if (bp.isEquals(this.aIP, str)) {
            return;
        }
        this.aIP = str;
        eA(str);
    }

    private static String IU() {
        try {
            return w.a(new File(be.dJ(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static void eA(String str) {
        try {
            w.a(new File(be.dJ(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
