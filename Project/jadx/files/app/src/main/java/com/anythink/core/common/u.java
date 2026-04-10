package com.anythink.core.common;

import com.anythink.core.api.AdError;
import com.anythink.core.common.g.a.c;
import com.baidu.mobads.sdk.internal.bj;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile u f7947c;
    private String b = u.class.getSimpleName();
    AtomicInteger a = new AtomicInteger(0);

    private u() {
    }

    public final synchronized void b() {
        List<com.anythink.core.common.e.o> listC;
        if (this.a.get() <= 0 && (listC = com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).c()) != null && listC.size() > 0) {
            this.a.set(listC.size());
            new StringBuilder("need to send request count: ").append(this.a.get());
            for (final com.anythink.core.common.e.o oVar : listC) {
                if (System.currentTimeMillis() - oVar.f7374f >= bj.f12906d) {
                    this.a.decrementAndGet();
                    com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).b(oVar);
                } else {
                    int iOptInt = 1000;
                    try {
                        iOptInt = new JSONObject(oVar.f7375g).optInt(com.anythink.core.common.e.o.f7368h);
                    } catch (Throwable unused) {
                    }
                    if (oVar.b == 3) {
                        new com.anythink.core.common.g.a.b(oVar.f7373e, iOptInt).a(new c.a() { // from class: com.anythink.core.common.u.2
                            @Override // com.anythink.core.common.g.a.c.a
                            public final void a(Object obj) {
                                String unused2 = u.this.b;
                                new StringBuilder("re-send success.... ").append(oVar.a());
                                com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).b(oVar);
                                u.this.a.decrementAndGet();
                            }

                            @Override // com.anythink.core.common.g.a.c.a
                            public final void a(Throwable th) {
                                String unused2 = u.this.b;
                                StringBuilder sb = new StringBuilder("re-send fail.... ");
                                sb.append(oVar.a());
                                sb.append("--error: ");
                                sb.append(th.getMessage());
                                u.this.a.decrementAndGet();
                            }
                        });
                    } else {
                        final com.anythink.core.common.g.l lVar = new com.anythink.core.common.g.l(oVar);
                        if (iOptInt == 1001) {
                            lVar.p();
                        }
                        lVar.a(0, new com.anythink.core.common.g.i() { // from class: com.anythink.core.common.u.3
                            @Override // com.anythink.core.common.g.i
                            public final void onLoadCanceled(int i2) {
                                u.this.a.decrementAndGet();
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadError(int i2, String str, AdError adError) {
                                String unused2 = u.this.b;
                                StringBuilder sb = new StringBuilder("re-send fail.... ");
                                sb.append(oVar.a());
                                sb.append("--error: ");
                                if (str == null) {
                                    str = "";
                                }
                                sb.append(str);
                                u.this.a.decrementAndGet();
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadFinish(int i2, Object obj) {
                                String unused2 = u.this.b;
                                new StringBuilder("re-send success.... ").append(oVar.a());
                                com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).b(lVar.q());
                                u.this.a.decrementAndGet();
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadStart(int i2) {
                            }
                        });
                    }
                }
            }
        }
    }

    public static u a() {
        if (f7947c == null) {
            synchronized (u.class) {
                if (f7947c == null) {
                    f7947c = new u();
                }
            }
        }
        return f7947c;
    }

    public final void a(final int i2, final String str, final String str2, final String str3, final String str4) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.u.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.e.o oVar = new com.anythink.core.common.e.o();
                oVar.b = i2;
                oVar.f7372d = str;
                oVar.f7371c = str2;
                oVar.f7373e = str3;
                oVar.f7374f = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(oVar.f7374f);
                sb.append(str3);
                oVar.a = com.anythink.core.common.k.f.a(sb.toString() != null ? str3 : "");
                oVar.f7375g = str4;
                String unused = u.this.b;
                new StringBuilder("save request:").append(oVar.a());
                com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).a(oVar);
            }
        });
    }
}
