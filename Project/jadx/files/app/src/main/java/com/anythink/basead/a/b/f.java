package com.anythink.basead.a.b;

import com.anythink.core.common.a.j;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.k;
import com.anythink.core.common.res.a.a;

/* JADX INFO: loaded from: classes.dex */
public class f {
    final String a = f.class.getSimpleName();
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private i f5804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k f5805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.anythink.core.common.res.a.a f5806h;

    public f(String str, final i iVar, k kVar) {
        this.b = iVar.x();
        this.f5804f = iVar;
        this.f5805g = kVar;
        this.f5801c = str;
        this.f5802d = iVar.p();
        this.f5803e = iVar.d();
        this.f5806h = com.anythink.core.common.res.a.c.a().a(this.b);
        this.f5806h.a(new com.anythink.core.common.res.a.b(this.f5805g.S(), this.f5805g.U()));
        this.f5806h.a(new a.AbstractC0170a() { // from class: com.anythink.basead.a.b.f.1
            @Override // com.anythink.core.common.res.a.a.AbstractC0170a
            public final void a(String str2, String str3) {
            }

            @Override // com.anythink.core.common.res.a.a.AbstractC0170a
            public final boolean a(int i2, long j2, long j3) {
                if (i2 < f.this.f5805g.S()) {
                    return false;
                }
                d.a().a(f.this.b, i2);
                return true;
            }
        });
        this.f5806h.f7885k = new a.b() { // from class: com.anythink.basead.a.b.f.2
            @Override // com.anythink.core.common.res.a.a.b
            public final void a(long j2, long j3, long j4, long j5, long j6) {
                com.anythink.basead.a.b.a(30, iVar, new com.anythink.basead.c.i("", ""));
                com.anythink.core.common.j.c.a(f.this.f5801c, f.this.f5802d, f.this.b, "1", j2, (String) null, j3, j4, f.this.f5803e, j6 - j5);
            }

            @Override // com.anythink.core.common.res.a.a.b
            public final void a(String str2, String str3, long j2, long j3, long j4, long j5) {
                com.anythink.core.common.j.c.a(f.this.f5801c, f.this.f5802d, f.this.b, "0", j2, str3, j3, 0L, f.this.f5803e, j5 - j4);
                d.a().a(f.this.b, com.anythink.basead.c.f.a(str2, str3));
            }
        };
    }

    public final void a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5802d);
        sb.append(",");
        sb.append(this.b);
        sb.append(" startRequest");
        this.f5806h.e();
    }

    public final void b() {
        int iB = j.a().b(this.b);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5802d);
        sb.append(",");
        sb.append(this.b);
        sb.append(" resumeRequest: readyRate:");
        sb.append(iB);
        sb.append(",cdRate:");
        sb.append(this.f5805g.T());
        if (iB == 100) {
            return;
        }
        this.f5806h.f();
    }
}
