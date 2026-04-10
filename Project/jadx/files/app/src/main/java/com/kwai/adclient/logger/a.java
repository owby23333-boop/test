package com.kwai.adclient.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.adclient.logger.model.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private com.kwai.adclient.logger.kwai.a aCt;
    private com.kwai.adclient.logger.kwai.b aCu;
    private JSONObject aCv;
    private boolean aCw;
    private boolean isDebug;

    /* JADX INFO: renamed from: com.kwai.adclient.logger.a$a, reason: collision with other inner class name */
    static final class C0460a {
        private static a aCx;

        public static a FG() {
            if (aCx == null) {
                aCx = new a((byte) 0);
            }
            return aCx;
        }
    }

    private a() {
        this.isDebug = false;
        this.aCw = false;
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a FG() {
        return C0460a.FG();
    }

    private void d(@NonNull c cVar) {
        com.kwai.adclient.logger.kwai.a aVar = this.aCt;
        if (aVar != null) {
            String tag = cVar.getTag();
            String str = cVar.FK() == null ? "" : cVar.FK().value;
            Object[] objArr = new Object[5];
            objArr[0] = cVar.FL() == null ? "" : cVar.FL().value;
            objArr[1] = cVar.FM() != null ? cVar.FM().getValue() : "";
            objArr[2] = cVar.FP();
            objArr[3] = b.N(cVar.FN());
            objArr[4] = b.N(cVar.FO());
            aVar.F(tag, str);
        }
    }

    public final JSONObject FH() {
        return this.aCv;
    }

    public final boolean FI() {
        return this.aCw;
    }

    public final void a(@NonNull com.kwai.adclient.logger.kwai.a aVar, @NonNull com.kwai.adclient.logger.kwai.b bVar, @Nullable JSONObject jSONObject, boolean z2, boolean z3) {
        this.aCt = aVar;
        this.aCu = bVar;
        this.aCv = null;
        this.isDebug = z2;
        this.aCw = z3;
    }

    public final void c(c cVar) {
        if (cVar == null) {
            this.aCt.G("KSCommercialLogger", "rl rtLog is null please check it");
            return;
        }
        d(cVar);
        com.kwai.adclient.logger.kwai.b bVar = this.aCu;
        if (bVar != null) {
            bVar.H(cVar.FJ(), cVar.toString());
        }
    }

    public final boolean isDebug() {
        return this.isDebug;
    }
}
