package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.h;
import com.umeng.analytics.pro.an;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class s {

    public interface c<T> {
        void j(T t);
    }

    public interface f<T> {
        void a(ab abVar, c<T> cVar);
    }

    static f<Boolean> Ds() {
        return new e(new g(new d(new h(new b()))));
    }

    static abstract class a<T> implements c<T> {
        c<T> auD;

        a(c<T> cVar) {
            this.auD = cVar;
        }
    }

    static class e implements f<Boolean> {
        f<a.C0385a> auH;

        e(f<a.C0385a> fVar) {
            this.auH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<Boolean> cVar) {
            this.auH.a(abVar, new c<a.C0385a>() { // from class: com.kwad.sdk.api.loader.s.e.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(a.C0385a c0385a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c0385a);
                        if (!com.kwad.sdk.api.loader.d.a(abVar.getContext(), getClass().getClassLoader(), c0385a.atD.getPath(), c0385a.sdkVersion)) {
                            a(c0385a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.q(abVar.getContext(), c0385a.sdkVersion);
                        j.j(c0385a.atD);
                        l.b(c0385a, System.currentTimeMillis() - jCurrentTimeMillis);
                        cVar.j(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0385a, 2, th);
                    }
                }

                private void a(a.C0385a c0385a, int i, Throwable th) {
                    j.j(c0385a.atD);
                    l.b(c0385a, i, Log.getStackTraceString(th));
                }
            });
        }
    }

    static class g implements f<a.C0385a> {
        f<a.C0385a> auH;

        g(f<a.C0385a> fVar) {
            this.auH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(ab abVar, final c<a.C0385a> cVar) {
            this.auH.a(abVar, new a<a.C0385a>(cVar) { // from class: com.kwad.sdk.api.loader.s.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(a.C0385a c0385a) {
                    try {
                        File file = c0385a.atD;
                        if (!x.k(file)) {
                            a(c0385a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!x.a(file, c0385a.md5)) {
                            a(c0385a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.j(c0385a);
                        }
                    } catch (Throwable th) {
                        a(c0385a, 3, th);
                    }
                }

                private void a(a.C0385a c0385a, int i, Throwable th) {
                    j.j(c0385a.atD);
                    l.a(c0385a, i, th.getMessage());
                }
            });
        }
    }

    static class d implements f<a.C0385a> {
        f<a.C0385a> auH;

        d(f<a.C0385a> fVar) {
            this.auH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0385a> cVar) {
            this.auH.a(abVar, new a<a.C0385a>(cVar) { // from class: com.kwad.sdk.api.loader.s.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(a.C0385a c0385a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    File fileS = null;
                    try {
                        l.a(c0385a);
                        fileS = j.s(abVar.getContext(), c0385a.sdkVersion);
                        k.c(c0385a.atC, fileS);
                        l.a(c0385a, System.currentTimeMillis() - jCurrentTimeMillis);
                        c0385a.atD = fileS;
                        cVar.j(c0385a);
                    } catch (Throwable th) {
                        l.a(c0385a, System.currentTimeMillis() - jCurrentTimeMillis, Log.getStackTraceString(th));
                        j.j(fileS);
                    }
                }
            });
        }
    }

    static class h implements f<a.C0385a> {
        f<a.C0385a> auH;

        h(f<a.C0385a> fVar) {
            this.auH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0385a> cVar) {
            this.auH.a(abVar, new c<a.C0385a>() { // from class: com.kwad.sdk.api.loader.s.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(a.C0385a c0385a) {
                    String strAX = i.aX(abVar.getContext());
                    if (TextUtils.isEmpty(strAX)) {
                        strAX = com.kwad.sdk.api.c.Dd().getSDKVersion();
                    }
                    String str = c0385a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), an.aU, c0385a.interval);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0385a.Dj()) {
                        aa.be(abVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + strAX);
                    } else if (i.L(c0385a.sdkVersion, strAX) && c0385a.Di()) {
                        cVar.j(c0385a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0385a.sdkVersion + " currentDynamicVersion:" + strAX + " dynamicType:" + c0385a.atB);
                    }
                }
            });
        }
    }

    static class b implements f<a.C0385a> {
        b() {
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0385a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(abVar).a(new h.a() { // from class: com.kwad.sdk.api.loader.s.b.1
                    @Override // com.kwad.sdk.api.loader.h.a
                    public final void a(a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.isLegal()) {
                            cVar.j(bVar.atE);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.aW(abVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
