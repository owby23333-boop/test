package com.anythink.basead.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.anythink.basead.handler.OfferClickHandler;
import com.anythink.core.api.IExHandler;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.basead.ui.web.WebLandPageActivity;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.ak;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.z;
import com.anythink.core.common.k.l;
import com.anythink.core.common.p;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5807c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5808d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5809e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5810f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5811g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5812h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5813i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5814j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5815k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    com.anythink.core.common.e.i f5816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f5817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f5818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Context f5819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f5820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    com.anythink.core.common.e.j f5821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    b f5822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    IOfferClickHandler f5823s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    a f5824t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f5825u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f5827w = c.class.getSimpleName();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f5828x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f5829y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f5830z = 2;
    private final int A = 10;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f5826v = false;

    /* JADX INFO: renamed from: com.anythink.basead.a.c$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.anythink.basead.c.i a;

        AnonymousClass1(com.anythink.basead.c.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            if (c.a(c.this, this.a)) {
                return;
            }
            final int i2 = c.this.f5821q.f7312m.l() != 2 ? c.b(c.this, this.a) ? 1 : 2 : 0;
            if (i2 == 1 && c.this.f5821q.f7312m.l() == 1) {
                return;
            }
            IExHandler iExHandlerB = n.a().b();
            if (c.this.f5816l.D() != 4 || 1 != c.this.f5821q.f7312m.o() || iExHandlerB == null || i2 == 1) {
                c.a(c.this, i2, this.a);
            } else {
                c cVar = c.this;
                iExHandlerB.openApkConfirmDialog(cVar.f5819o, cVar.f5816l, cVar.f5821q, new com.anythink.core.common.f.a() { // from class: com.anythink.basead.a.c.1.1
                    @Override // com.anythink.core.common.f.a
                    public final void a(boolean z2) {
                        if (z2) {
                            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.a.c.1.1.1
                                @Override // java.lang.Runnable
                                public final void run() throws Throwable {
                                    C01301 c01301 = C01301.this;
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    c.a(c.this, i2, anonymousClass1.a);
                                }
                            });
                        } else {
                            c.this.f5817m = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.a.c$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ boolean a;

        AnonymousClass2(boolean z2) {
            this.a = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar = c.this.f5822r;
            if (bVar != null && !this.a) {
                bVar.a();
            }
            b bVar2 = c.this.f5822r;
            if (bVar2 != null) {
                bVar2.b();
            }
            b bVar3 = c.this.f5822r;
            if (bVar3 != null) {
                bVar3.a(true);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.a.c$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar = c.this.f5822r;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    static class a {
        long a;
        long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f5831c;

        a() {
        }

        final boolean a() {
            return System.currentTimeMillis() - this.a <= this.b;
        }
    }

    public interface b {
        void a();

        void a(boolean z2);

        void b();
    }

    public c(Context context, com.anythink.core.common.e.j jVar, com.anythink.core.common.e.i iVar) {
        this.f5816l = iVar;
        this.f5821q = jVar;
        this.f5819o = context.getApplicationContext();
        k kVar = jVar.f7312m;
        this.f5820p = !(iVar instanceof com.anythink.core.common.e.g) ? !((iVar instanceof s) && ((s) iVar).O() == 1) : !((kVar instanceof ab) && ((ab) kVar).Y() == 1);
        this.f5816l.g(jVar.f7303d);
        this.f5823s = new OfferClickHandler();
        this.f5825u = this.f5821q.f7312m.Q() != 2;
    }

    static /* synthetic */ boolean b(c cVar, com.anythink.basead.c.i iVar) {
        return cVar.b(iVar, false);
    }

    private com.anythink.basead.c.d e() {
        return d.a().a(this.f5816l.d(), this.f5816l.p());
    }

    private boolean f() {
        ak akVarL = n.a().L();
        boolean z2 = akVarL.b() == 1;
        boolean z3 = akVarL.a() == 1;
        String strL = com.anythink.core.common.k.d.l();
        if (TextUtils.isEmpty(strL)) {
            com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, 5);
            return false;
        }
        if (!z2) {
            com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, 3);
            return false;
        }
        if (!z3) {
            com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, 1);
            return false;
        }
        String strE = this.f5816l.e();
        String strF = this.f5816l.f();
        if (TextUtils.isEmpty(strE) || TextUtils.isEmpty(strF)) {
            com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, 4);
            return false;
        }
        try {
            Object objC = com.anythink.core.common.k.d.c(strL);
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objNewInstance = cls.newInstance();
            cls.getField("userName").set(objNewInstance, strE);
            cls.getField("path").set(objNewInstance, strF);
            cls.getField("miniprogramType").set(objNewInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            Class<?> cls2 = Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI");
            Class<?>[] clsArr = new Class[1];
            clsArr[0] = Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq");
            cls2.getMethod("sendReq", clsArr).invoke(objC, objNewInstance);
            com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, 0);
            return true;
        } catch (Throwable th) {
            com.anythink.core.common.e.j jVar = this.f5821q;
            com.anythink.core.common.e.i iVar = this.f5816l;
            th.getMessage();
            com.anythink.core.common.j.c.a(jVar, iVar, 2);
            return false;
        }
    }

    private boolean g() {
        if (this.f5816l.n() == 42) {
            return true;
        }
        com.anythink.core.common.e.i iVar = this.f5816l;
        return (iVar instanceof z) && ((z) iVar).a() == 42;
    }

    private void h() {
        this.f5818n = true;
    }

    public final void a(b bVar) {
        this.f5822r = bVar;
    }

    public final com.anythink.core.common.e.j c() {
        return this.f5821q;
    }

    public final void d() {
        this.f5822r = null;
    }

    private void b(com.anythink.basead.c.i iVar) {
        if (this.f5825u || !this.f5826v) {
            this.f5826v = true;
            com.anythink.basead.a.b.a(9, this.f5816l, iVar);
        }
    }

    public final boolean a() {
        return this.f5817m;
    }

    public final void a(com.anythink.basead.c.i iVar) {
        if (this.f5817m) {
            return;
        }
        this.f5817m = true;
        this.f5818n = false;
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(iVar));
    }

    private boolean b(com.anythink.basead.c.i iVar, final boolean z2) {
        iVar.f5937i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d dVarE = e();
        iVar.f5937i.a = dVarE != null ? dVarE.f5898c : "";
        com.anythink.basead.a.b.a(23, this.f5816l, iVar);
        if (!TextUtils.isEmpty(this.f5816l.z())) {
            String strZ = this.f5816l.z();
            String str = this.f5821q.f7303d;
            String strReplaceAll = strZ.replaceAll("\\{req_id\\}", str != null ? str : "");
            p.a().a(this.f5816l);
            if (com.anythink.core.basead.a.a.a(this.f5819o, strReplaceAll, false)) {
                com.anythink.basead.c.a aVar = iVar.f5935g;
                if (aVar != null) {
                    aVar.f5892i = true;
                }
                b(iVar);
                com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, strReplaceAll, "1", 0);
                this.f5817m = false;
                n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        b bVar = c.this.f5822r;
                        if (bVar != null && !z2) {
                            bVar.a();
                        }
                        b bVar2 = c.this.f5822r;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                        b bVar3 = c.this.f5822r;
                        if (bVar3 != null) {
                            bVar3.a(true);
                        }
                    }
                });
                com.anythink.basead.a.b.a(24, this.f5816l, iVar);
                return true;
            }
            p.a().b(this.f5816l);
            if (com.anythink.basead.a.b.a(this.f5819o, this.f5816l.B())) {
                com.anythink.basead.a.b.a(28, this.f5816l, iVar);
            } else {
                com.anythink.basead.a.b.a(29, this.f5816l, iVar);
            }
            com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, strReplaceAll, "0", 0);
        }
        return false;
    }

    private boolean a(com.anythink.basead.c.i iVar, boolean z2) {
        iVar.f5937i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d dVarE = e();
        iVar.f5937i.a = dVarE != null ? dVarE.f5898c : "";
        if (!TextUtils.isEmpty(this.f5816l.o())) {
            String strO = this.f5816l.o();
            String str = this.f5821q.f7303d;
            String strReplaceAll = strO.replaceAll("\\{req_id\\}", str != null ? str : "");
            if (com.anythink.core.basead.a.a.a(this.f5819o, strReplaceAll, false)) {
                com.anythink.basead.c.a aVar = iVar.f5935g;
                if (aVar != null) {
                    aVar.f5892i = true;
                }
                b(iVar);
                com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, strReplaceAll, "1", 1);
                this.f5817m = false;
                n.a().a(new AnonymousClass2(z2));
                return true;
            }
            com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, strReplaceAll, "0", 1);
        }
        return false;
    }

    private void a(int i2, com.anythink.basead.c.i iVar) throws Throwable {
        String strB;
        com.anythink.basead.c.d dVar;
        String strB2;
        String strB3;
        com.anythink.basead.c.d dVarA;
        boolean z2 = true;
        if (i2 != 1) {
            n.a().a(new AnonymousClass4());
        }
        strB = "";
        String strA = this.f5816l.A() != null ? this.f5816l.A() : "";
        String str = this.f5821q.f7303d;
        if (str == null) {
            str = "";
        }
        String strA2 = j.a(strA.replaceAll("\\{req_id\\}", str), iVar, System.currentTimeMillis());
        if (g() && this.f5816l.D() == 4) {
            dVar = new com.anythink.basead.c.d("", "", "");
        } else {
            dVar = new com.anythink.basead.c.d(strA2, "", "");
        }
        a(dVar);
        int iD = this.f5816l.D();
        if (iD == 1) {
            if (!strA2.startsWith("http")) {
                a(strA2, i2, iVar);
                return;
            }
            a aVar = this.f5824t;
            boolean z3 = aVar != null && aVar.a();
            if (this.f5820p) {
                String strY = this.f5816l.y();
                if (z3) {
                    strY = this.f5824t.f5831c;
                }
                if (!TextUtils.isEmpty(strY)) {
                    a(strY, i2, iVar);
                    z2 = false;
                }
            }
            if (z3) {
                strB2 = this.f5824t.f5831c;
            } else {
                strB2 = b(strA2);
                if (!TextUtils.isEmpty(strB2)) {
                    a(strB2);
                }
            }
            if (z2) {
                if (TextUtils.isEmpty(strB2)) {
                    strB2 = dVar.a;
                }
                a(strB2, i2, iVar);
                return;
            }
            return;
        }
        if (iD == 2 || iD == 3) {
            if (g() && !TextUtils.isEmpty(this.f5816l.z())) {
                strB = b(strA2);
                String strA3 = com.anythink.basead.d.b.a.a.a(strB);
                dVar.b = strB;
                dVar.f5898c = strA3;
                a(dVar);
            }
            if (TextUtils.isEmpty(strB)) {
                strB = dVar.a;
            }
            a(strB, i2, iVar);
            return;
        }
        if (iD != 4) {
            a(TextUtils.isEmpty("") ? dVar.a : "", i2, iVar);
            return;
        }
        if (g() && TextUtils.isEmpty(dVar.a) && (dVarA = com.anythink.basead.d.b.a.a.a(this.f5821q, this.f5816l, strA2)) != null) {
            dVar.a = dVarA.a;
            dVar.f5898c = dVarA.f5898c;
        }
        a aVar2 = this.f5824t;
        if (aVar2 != null && aVar2.a()) {
            strB3 = this.f5824t.f5831c;
        } else {
            strB3 = b(dVar.a);
            if (!TextUtils.isEmpty(strB3)) {
                a(strB3);
            }
        }
        dVar.b = strB3;
        a(dVar);
        if (TextUtils.isEmpty(strB3)) {
            strB3 = dVar.a;
        } else {
            iVar.f5938j = true;
        }
        a(strB3, i2, iVar);
    }

    private String b(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        String str2;
        boolean z2 = false;
        String headerField = str;
        for (int i2 = 0; i2 < 10; i2++) {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setInstanceFollowRedirects(false);
                        if (this.f5821q.f7312m != null && com.anythink.basead.a.b.a(9, this.f5821q.f7312m)) {
                            String strI = com.anythink.core.common.k.d.i();
                            if (!TextUtils.isEmpty(strI)) {
                                httpURLConnection.addRequestProperty("User-Agent", strI);
                            }
                        }
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                            headerField = httpURLConnection.getHeaderField("Location");
                            if (!com.anythink.core.basead.a.a.b(headerField) && !headerField.contains(com.anythink.china.common.a.a.f6395g) && headerField.startsWith("http")) {
                                httpURLConnection.disconnect();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            }
                            z2 = true;
                        }
                        if (z2 || responseCode == 200) {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return headerField;
                        }
                        com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, str, headerField, String.valueOf(responseCode), "");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return "";
                    } catch (Exception e2) {
                        e = e2;
                        str2 = headerField;
                        httpURLConnection2 = httpURLConnection;
                        com.anythink.core.common.j.c.a(this.f5821q, this.f5816l, str, str2, "", e.getMessage());
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = headerField;
            }
        }
        return "";
    }

    public final com.anythink.core.common.e.i b() {
        return this.f5816l;
    }

    private synchronized void a(String str) {
        if (this.f5824t == null) {
            this.f5824t = new a();
        }
        this.f5824t.f5831c = str;
        this.f5824t.b = this.f5821q.f7312m.P();
        this.f5824t.a = System.currentTimeMillis();
    }

    private void a(com.anythink.basead.c.d dVar) {
        d.a().a(this.f5816l.d(), this.f5816l.p(), dVar);
    }

    private void a(String str, int i2, com.anythink.basead.c.i iVar) {
        b bVar;
        b bVar2;
        if (i2 == 1) {
            return;
        }
        if (this.f5818n) {
            this.f5817m = false;
            if ((!TextUtils.isEmpty(this.f5816l.o()) || !TextUtils.isEmpty(this.f5816l.z())) && (bVar2 = this.f5822r) != null) {
                bVar2.a(false);
            }
            b(iVar);
            n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.5
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar3 = c.this.f5822r;
                    if (bVar3 != null) {
                        bVar3.b();
                    }
                }
            });
            return;
        }
        if (i2 == 0 && b(iVar, true)) {
            return;
        }
        if ((!TextUtils.isEmpty(this.f5816l.o()) || !TextUtils.isEmpty(this.f5816l.z())) && (bVar = this.f5822r) != null) {
            bVar.a(false);
        }
        if (!TextUtils.isEmpty(this.f5816l.B()) && (this.f5816l.D() == 1 || this.f5816l.D() == 4)) {
            boolean zA = a(this.f5819o, this.f5816l.B());
            iVar.f5937i = new com.anythink.basead.c.b();
            com.anythink.basead.c.d dVarE = e();
            iVar.f5937i.a = dVarE != null ? dVarE.f5898c : "";
            com.anythink.basead.c.a aVar = iVar.f5935g;
            if (aVar != null) {
                aVar.f5893j = zA ? 5 : aVar.f5893j;
            }
            if (zA) {
                b(iVar);
                com.anythink.basead.a.b.a(25, this.f5816l, iVar);
                this.f5817m = false;
                n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        b bVar3 = c.this.f5822r;
                        if (bVar3 != null) {
                            bVar3.b();
                        }
                    }
                });
                return;
            }
            com.anythink.basead.a.b.a(26, this.f5816l, iVar);
        }
        if (iVar.f5935g != null && this.f5816l.D() == 4) {
            if (iVar.f5938j) {
                IExHandler iExHandlerB = n.a().b();
                com.anythink.basead.c.a aVar2 = iVar.f5935g;
                aVar2.f5893j = iExHandlerB != null ? iExHandlerB.checkDownloadType(this.f5816l, this.f5821q) : aVar2.f5893j;
            } else {
                iVar.f5935g.f5893j = 3;
            }
        }
        b(iVar);
        if (TextUtils.isEmpty(str)) {
            str = this.f5816l.y();
        }
        if (TextUtils.isEmpty(str)) {
            n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.7
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (TextUtils.isEmpty(c.this.f5816l.A())) {
                            Toast.makeText(c.this.f5819o, com.anythink.core.common.k.h.a(c.this.f5819o, "basead_click_empty", com.anythink.expressad.foundation.h.i.f10649g), 0).show();
                        } else {
                            Toast.makeText(c.this.f5819o, com.anythink.core.common.k.h.a(c.this.f5819o, "basead_click_fail", com.anythink.expressad.foundation.h.i.f10649g), 0).show();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            this.f5817m = false;
            n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.8
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar3 = c.this.f5822r;
                    if (bVar3 != null) {
                        bVar3.b();
                    }
                }
            });
            return;
        }
        int iD = this.f5816l.D();
        if (iD == 1) {
            boolean z2 = (str == null || str.startsWith("http")) ? false : true;
            if (!com.anythink.core.basead.a.a.a(this.f5819o, str, z2) && !z2) {
                if (this.f5821q.f7312m.k() == 2) {
                    com.anythink.core.basead.b.a aVar3 = new com.anythink.core.basead.b.a();
                    aVar3.f6586c = this.f5816l;
                    aVar3.f6591h = this.f5821q;
                    aVar3.f6589f = str;
                    aVar3.f6590g = this.f5823s;
                    WebLandPageActivity.a(this.f5819o, aVar3);
                } else {
                    l.a(this.f5819o, str);
                }
            }
        } else if (iD == 2) {
            l.a(this.f5819o, str);
        } else if (iD == 3) {
            com.anythink.core.basead.b.a aVar4 = new com.anythink.core.basead.b.a();
            aVar4.f6586c = this.f5816l;
            aVar4.f6591h = this.f5821q;
            aVar4.f6589f = str;
            aVar4.f6590g = this.f5823s;
            WebLandPageActivity.a(this.f5819o, aVar4);
        } else if (iD == 4) {
            a(str, iVar);
        } else if (iD != 6) {
            if (this.f5821q.f7312m.k() == 2) {
                com.anythink.core.basead.b.a aVar5 = new com.anythink.core.basead.b.a();
                aVar5.f6586c = this.f5816l;
                aVar5.f6591h = this.f5821q;
                aVar5.f6589f = str;
                aVar5.f6590g = this.f5823s;
                WebLandPageActivity.a(this.f5819o, aVar5);
            } else {
                l.a(this.f5819o, str);
            }
        } else if (!f()) {
            com.anythink.core.basead.b.a aVar6 = new com.anythink.core.basead.b.a();
            aVar6.f6586c = this.f5816l;
            aVar6.f6591h = this.f5821q;
            aVar6.f6589f = str;
            aVar6.f6590g = this.f5823s;
            WebLandPageActivity.a(this.f5819o, aVar6);
        }
        this.f5817m = false;
        n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.9
            @Override // java.lang.Runnable
            public final void run() {
                b bVar3 = c.this.f5822r;
                if (bVar3 != null) {
                    bVar3.b();
                }
            }
        });
    }

    private void a(String str, com.anythink.basead.c.i iVar) {
        if (iVar.f5938j) {
            if (!TextUtils.isEmpty(str)) {
                if (com.anythink.basead.a.b.a(this.f5819o, this.f5821q, this.f5816l, e(), str, new i())) {
                    return;
                }
            } else {
                l.a(this.f5819o, str);
                return;
            }
        }
        l.a(this.f5819o, str);
    }

    public static boolean a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ boolean a(c cVar, com.anythink.basead.c.i iVar) {
        iVar.f5937i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d dVarE = cVar.e();
        iVar.f5937i.a = dVarE != null ? dVarE.f5898c : "";
        if (!TextUtils.isEmpty(cVar.f5816l.o())) {
            String strO = cVar.f5816l.o();
            String str = cVar.f5821q.f7303d;
            String strReplaceAll = strO.replaceAll("\\{req_id\\}", str != null ? str : "");
            if (com.anythink.core.basead.a.a.a(cVar.f5819o, strReplaceAll, false)) {
                com.anythink.basead.c.a aVar = iVar.f5935g;
                if (aVar != null) {
                    aVar.f5892i = true;
                }
                cVar.b(iVar);
                com.anythink.core.common.j.c.a(cVar.f5821q, cVar.f5816l, strReplaceAll, "1", 1);
                cVar.f5817m = false;
                n.a().a(cVar.new AnonymousClass2(false));
                return true;
            }
            com.anythink.core.common.j.c.a(cVar.f5821q, cVar.f5816l, strReplaceAll, "0", 1);
        }
        return false;
    }

    static /* synthetic */ void a(c cVar, int i2, com.anythink.basead.c.i iVar) throws Throwable {
        String strB;
        com.anythink.basead.c.d dVar;
        String strB2;
        String strB3;
        com.anythink.basead.c.d dVarA;
        boolean z2 = true;
        if (i2 != 1) {
            n.a().a(cVar.new AnonymousClass4());
        }
        strB = "";
        String strA = cVar.f5816l.A() != null ? cVar.f5816l.A() : "";
        String str = cVar.f5821q.f7303d;
        if (str == null) {
            str = "";
        }
        String strA2 = j.a(strA.replaceAll("\\{req_id\\}", str), iVar, System.currentTimeMillis());
        if (cVar.g() && cVar.f5816l.D() == 4) {
            dVar = new com.anythink.basead.c.d("", "", "");
        } else {
            dVar = new com.anythink.basead.c.d(strA2, "", "");
        }
        cVar.a(dVar);
        int iD = cVar.f5816l.D();
        if (iD == 1) {
            if (!strA2.startsWith("http")) {
                cVar.a(strA2, i2, iVar);
                return;
            }
            a aVar = cVar.f5824t;
            boolean z3 = aVar != null && aVar.a();
            if (cVar.f5820p) {
                String strY = cVar.f5816l.y();
                if (z3) {
                    strY = cVar.f5824t.f5831c;
                }
                if (!TextUtils.isEmpty(strY)) {
                    cVar.a(strY, i2, iVar);
                    z2 = false;
                }
            }
            if (z3) {
                strB2 = cVar.f5824t.f5831c;
            } else {
                strB2 = cVar.b(strA2);
                if (!TextUtils.isEmpty(strB2)) {
                    cVar.a(strB2);
                }
            }
            if (z2) {
                if (TextUtils.isEmpty(strB2)) {
                    strB2 = dVar.a;
                }
                cVar.a(strB2, i2, iVar);
                return;
            }
            return;
        }
        if (iD == 2 || iD == 3) {
            if (cVar.g() && !TextUtils.isEmpty(cVar.f5816l.z())) {
                strB = cVar.b(strA2);
                String strA3 = com.anythink.basead.d.b.a.a.a(strB);
                dVar.b = strB;
                dVar.f5898c = strA3;
                cVar.a(dVar);
            }
            if (TextUtils.isEmpty(strB)) {
                strB = dVar.a;
            }
            cVar.a(strB, i2, iVar);
            return;
        }
        if (iD != 4) {
            cVar.a(TextUtils.isEmpty("") ? dVar.a : "", i2, iVar);
            return;
        }
        if (cVar.g() && TextUtils.isEmpty(dVar.a) && (dVarA = com.anythink.basead.d.b.a.a.a(cVar.f5821q, cVar.f5816l, strA2)) != null) {
            dVar.a = dVarA.a;
            dVar.f5898c = dVarA.f5898c;
        }
        a aVar2 = cVar.f5824t;
        if (aVar2 != null && aVar2.a()) {
            strB3 = cVar.f5824t.f5831c;
        } else {
            strB3 = cVar.b(dVar.a);
            if (!TextUtils.isEmpty(strB3)) {
                cVar.a(strB3);
            }
        }
        dVar.b = strB3;
        cVar.a(dVar);
        if (TextUtils.isEmpty(strB3)) {
            strB3 = dVar.a;
        } else {
            iVar.f5938j = true;
        }
        cVar.a(strB3, i2, iVar);
    }
}
