package com.kwad.components.core.webview.tachikoma.a;

import com.kwad.components.core.webview.jshandler.a;
import com.kwad.sdk.components.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c implements m {
    public abstract void b(a.C0354a c0354a);

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        String str = " ";
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        str = (String) obj;
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                return null;
            }
        }
        a.C0354a c0354a = new a.C0354a();
        c0354a.parseJson(new JSONObject(str));
        b(c0354a);
        return null;
    }
}
