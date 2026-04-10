package com.kwad.sdk.core.kwai;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.o;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {
    private static String afd;

    private static String vS() {
        if (!TextUtils.isEmpty(afd)) {
            return afd;
        }
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return "";
        }
        String str = context.getPackageName() + ax.dc(context);
        afd = str;
        return str;
    }

    @Override // com.kwad.sdk.core.kwai.f
    public final void a(String str, Map<String, String> map, String str2) {
        e.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.kwai.f
    public final String bF(String str) throws Throwable {
        try {
            String strCa = o.ca(0);
            return new String(c.vT().encode(b.d(strCa.getBytes("UTF-8"), b.f(str.getBytes()))), "UTF-8");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.kwai.f
    public final void d(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", vS());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.kwai.f
    public final String getResponseData(String str) {
        try {
            return new String(b.g(b.a(o.ca(0), c.vV().decode(str.getBytes()))), "UTF-8");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return str;
        }
    }
}
