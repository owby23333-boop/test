package com.kwai.adclient.kscommerciallogger;

import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a bej;
    private com.kwai.adclient.kscommerciallogger.a.b bek;
    private JSONObject bel;
    private boolean bem;
    private boolean isDebug;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.isDebug = false;
        this.bem = false;
    }

    public static a Te() {
        return C0431a.Te();
    }

    public final void a(com.kwai.adclient.kscommerciallogger.a.a aVar, com.kwai.adclient.kscommerciallogger.a.b bVar, JSONObject jSONObject, boolean z, boolean z2) {
        this.bej = aVar;
        this.bek = bVar;
        this.bel = jSONObject;
        this.isDebug = z;
        this.bem = z2;
    }

    public final JSONObject Tf() {
        return this.bel;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean Tg() {
        return this.bem;
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.bek;
        if (bVar != null) {
            bVar.M(cVar.Th(), cVar.toString());
        }
    }

    private void b(c cVar) {
        if (this.bej != null) {
            Object[] objArr = new Object[5];
            if (cVar.Ti() != null) {
                String str = cVar.Ti().value;
            }
            if (cVar.Tj() != null) {
                cVar.Tj().getValue();
            }
            cVar.Tm();
            b.z(cVar.Tk());
            b.z(cVar.Tl());
        }
    }

    /* JADX INFO: renamed from: com.kwai.adclient.kscommerciallogger.a$a, reason: collision with other inner class name */
    static final class C0431a {
        private static a ben;

        public static a Te() {
            if (ben == null) {
                ben = new a((byte) 0);
            }
            return ben;
        }
    }
}
