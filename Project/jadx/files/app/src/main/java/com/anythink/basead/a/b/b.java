package com.anythink.basead.a.b;

import android.text.TextUtils;
import com.anythink.basead.a.b.d;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.basead.mraid.d;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {
    public static final String a = "b";
    i b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    k f5780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    j f5781d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f5787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InterfaceC0129b f5788k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MraidWebView f5790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f5791n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Runnable f5782e = new Runnable() { // from class: com.anythink.basead.a.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            b.this.a(com.anythink.basead.c.f.a("20001", com.anythink.basead.c.f.f5912p));
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.anythink.basead.a.a.c<Void, com.anythink.basead.c.e> f5789l = new com.anythink.basead.a.b.a();

    /* JADX INFO: renamed from: com.anythink.basead.a.b.b$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        AnonymousClass2(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.f5790m = new MraidWebView(n.a().g());
            com.anythink.basead.mraid.d.a(this.a, this.b, b.this.f5790m, new d.a() { // from class: com.anythink.basead.a.b.b.2.1
                @Override // com.anythink.basead.mraid.d.a
                public final void a() {
                    b.this.b();
                }

                @Override // com.anythink.basead.mraid.d.a
                public final void a(com.anythink.basead.c.e eVar) {
                    b.this.a(eVar);
                }
            });
        }
    }

    private class a implements com.anythink.basead.a.a.b<Void, com.anythink.basead.c.e> {
        private a() {
        }

        private void b() {
            if (b.this.f5788k != null) {
                new StringBuilder("Offer load success, OfferId -> ").append(b.this.f5786i);
                b.this.f5788k.a();
            }
            b.e(b.this);
        }

        @Override // com.anythink.basead.a.a.b
        public final /* synthetic */ void a(com.anythink.basead.c.e eVar) {
            com.anythink.basead.c.e eVar2 = eVar;
            if (b.this.f5788k != null) {
                new StringBuilder("Offer load failed, OfferId -> ").append(b.this.f5786i);
                b.this.f5788k.a(eVar2);
            }
            b.e(b.this);
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(com.anythink.basead.c.e eVar) {
            if (b.this.f5788k != null) {
                new StringBuilder("Offer load failed, OfferId -> ").append(b.this.f5786i);
                b.this.f5788k.a(eVar);
            }
            b.e(b.this);
        }

        @Override // com.anythink.basead.a.a.b
        public final /* synthetic */ void a() {
            if (b.this.f5788k != null) {
                new StringBuilder("Offer load success, OfferId -> ").append(b.this.f5786i);
                b.this.f5788k.a();
            }
            b.e(b.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.a.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0129b {
        void a();

        void a(com.anythink.basead.c.e eVar);
    }

    public b(String str, boolean z2, i iVar, j jVar) {
        this.f5783f = str;
        this.f5784g = z2;
        this.b = iVar;
        this.f5781d = jVar;
        this.f5780c = this.f5781d.f7312m;
        this.f5785h = this.f5780c.m();
        this.f5789l.a(new a(this, (byte) 0));
    }

    static /* synthetic */ void e(b bVar) {
        d.a().b(bVar);
        n.a().c(bVar.f5782e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.anythink.basead.a.a.c<Void, com.anythink.basead.c.e> cVar = this.f5789l;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void c() {
        d.a().b(this);
        n.a().c(this.f5782e);
    }

    private void d() {
        n.a().a(this.f5782e, this.f5785h);
    }

    public final void a(InterfaceC0129b interfaceC0129b) {
        i iVar = this.b;
        if (iVar != null && this.f5789l != null) {
            this.f5786i = iVar.p();
            this.f5788k = interfaceC0129b;
            n.a().a(this.f5782e, this.f5785h);
            if (!this.b.g()) {
                this.f5789l.a(1);
                a();
                return;
            }
            this.f5791n = false;
            k kVar = this.f5780c;
            if (kVar != null) {
                String strValueOf = String.valueOf(kVar.t());
                boolean z2 = strValueOf.equals("1") || strValueOf.equals("3");
                this.f5789l.a(1);
                if (z2) {
                    this.f5789l.a(2);
                    a();
                }
                if (this.f5791n) {
                    return;
                }
                boolean zV = this.f5780c.V();
                String strA = com.anythink.basead.mraid.d.a(this.f5781d, this.b);
                if (TextUtils.isEmpty(strA)) {
                    a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.F, com.anythink.basead.c.f.L));
                    return;
                } else if (!zV) {
                    b();
                    return;
                } else {
                    n.a().a(new AnonymousClass2(c.a(this.f5781d, this.b), strA));
                    return;
                }
            }
            return;
        }
        a(com.anythink.basead.c.f.a("-9999", com.anythink.basead.c.f.f5919w));
    }

    private void a() {
        List<String> listB = this.b.b(this.f5780c);
        if (listB == null) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5908l, "Incomplete resource allocation! MissResource: ".concat(String.valueOf(this.b.m()))));
            return;
        }
        int size = listB.size();
        if (size == 0) {
            b();
            return;
        }
        this.f5787j = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = listB.get(i2);
            if (!TextUtils.isEmpty(str)) {
                if (this.b.D(str)) {
                    if (!c.b(str, this.f5780c.S()) && !this.f5787j.contains(str)) {
                        StringBuilder sb = new StringBuilder("videoInfo:video file is not ready to play -> ");
                        sb.append(str);
                        sb.append(",need readyRate:");
                        sb.append(this.f5780c.S());
                        this.f5787j.add(str);
                    }
                } else if (!c.c(str) && !this.f5787j.contains(str)) {
                    this.f5787j.add(str);
                }
            }
        }
        int size2 = this.f5787j.size();
        if (size2 == 0) {
            StringBuilder sb2 = new StringBuilder("Offer(");
            sb2.append(this.f5786i);
            sb2.append("), all files have already exist");
            b();
            return;
        }
        d.a().a(this);
        synchronized (this) {
            for (int i3 = 0; i3 < size2; i3++) {
                String str2 = this.f5787j.get(i3);
                boolean zD = this.b.D(str2);
                int iS = this.f5780c.S();
                if (zD) {
                    if (c.b(str2, iS)) {
                        StringBuilder sb3 = new StringBuilder("Video file ready -> ");
                        sb3.append(str2);
                        sb3.append(",videoNeedReadyRate:");
                        sb3.append(iS);
                        d.a().a(str2, iS);
                    } else {
                        StringBuilder sb4 = new StringBuilder("Video file not exis -> ");
                        sb4.append(str2);
                        sb4.append(",videoNeedReadyRate:");
                        sb4.append(iS);
                        new f(this.f5783f, this.b, this.f5780c).a();
                    }
                } else if (!c.a(str2)) {
                    if (c.c(str2)) {
                        c.a(str2, 100);
                        d.a().a(str2, 100);
                    } else {
                        c.a(str2, 0);
                        new e(this.f5783f, this.f5784g, this.b, str2).d();
                    }
                }
            }
        }
    }

    private void a(boolean z2) {
        String strA = com.anythink.basead.mraid.d.a(this.f5781d, this.b);
        if (TextUtils.isEmpty(strA)) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.F, com.anythink.basead.c.f.L));
        } else if (!z2) {
            b();
        } else {
            n.a().a(new AnonymousClass2(c.a(this.f5781d, this.b), strA));
        }
    }

    @Override // com.anythink.basead.a.b.d.a
    public final void a(String str, int i2) {
        synchronized (this) {
            c.a(str, i2);
            if (this.f5787j.contains(str) && ((!this.b.D(str) || this.f5780c.S() <= i2) && this.f5787j != null)) {
                this.f5787j.remove(str);
                StringBuilder sb = new StringBuilder();
                sb.append(this.f5786i);
                sb.append(" onResourceLoadSuccess -> resourceUrl:");
                sb.append(str);
                sb.append(",curmUrlList.size():");
                sb.append(this.f5787j.size());
                if (this.f5787j.size() == 0) {
                    b();
                }
            }
        }
    }

    @Override // com.anythink.basead.a.b.d.a
    public final void a(String str, com.anythink.basead.c.e eVar) {
        synchronized (this) {
            c.a(str, -1);
            a(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.basead.c.e eVar) {
        this.f5791n = true;
        com.anythink.basead.a.a.c<Void, com.anythink.basead.c.e> cVar = this.f5789l;
        if (cVar != null) {
            cVar.a(eVar);
        }
    }
}
