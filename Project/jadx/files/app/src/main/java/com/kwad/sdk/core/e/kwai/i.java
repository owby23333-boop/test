package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import com.kwad.sdk.utils.r;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        try {
            String str = (String) r.a(r.c("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
            try {
                new StringBuilder("getOAID oaid:").append(str);
                return str;
            } catch (Exception unused) {
                return str;
            }
        } catch (Exception unused2) {
            return "";
        }
    }
}
