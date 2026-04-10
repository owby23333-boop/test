package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.au;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.kwai.a aex;

    /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    static final class C0434a {
        static final a aey = new a(0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    @Nullable
    private File bu(String str) {
        if (vF() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.aex, str);
    }

    private synchronized void init(Context context) {
        if (this.aex != null || context == null) {
            return;
        }
        try {
            this.aex = com.kwad.sdk.core.diskcache.kwai.a.a(au.cQ(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public static a vE() {
        return C0434a.aey;
    }

    private boolean vF() {
        init(((e) ServiceProvider.get(e.class)).getContext());
        return this.aex == null;
    }

    public final boolean a(String str, a.C0442a c0442a) {
        File fileBu;
        if (!vF() && !TextUtils.isEmpty(str)) {
            String strBv = c.bv(str);
            if (b.a(this.aex, str, strBv, c0442a) && (fileBu = bu(strBv)) != null && fileBu.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File aN(String str) {
        if (vF() || TextUtils.isEmpty(str)) {
            return null;
        }
        return bu(c.bv(str));
    }

    public final boolean b(String str, @NonNull String str2, a.C0442a c0442a) {
        File fileBu;
        if (!vF() && !TextUtils.isEmpty(str)) {
            String strBv = c.bv(str2);
            if (b.a(this.aex, str, strBv, c0442a) && (fileBu = bu(strBv)) != null && fileBu.exists()) {
                return true;
            }
        }
        return false;
    }

    public final void bt(String str) {
        if (vF() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.aex, str, c.bv(str));
    }

    public final void delete() {
        if (vF()) {
            return;
        }
        try {
            this.aex.delete();
        } catch (IOException unused) {
        }
    }

    public final boolean remove(String str) {
        if (vF()) {
            return false;
        }
        try {
            an.ae(str, "cacheKey is not allowed empty");
            return this.aex.remove(c.bv(str));
        } catch (IOException unused) {
            return false;
        }
    }
}
