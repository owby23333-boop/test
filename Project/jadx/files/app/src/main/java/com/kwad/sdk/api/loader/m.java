package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import com.umeng.analytics.pro.am;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class m {

    static abstract class a<T> implements c<T> {
        c<T> ZM;

        a(c<T> cVar) {
            this.ZM = cVar;
        }
    }

    static class b implements f<a.C0427a> {
        b() {
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0427a> cVar) {
            try {
                new com.kwad.sdk.api.loader.f(vVar).a(new f.a() { // from class: com.kwad.sdk.api.loader.m.b.1
                    @Override // com.kwad.sdk.api.loader.f.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.tA()) {
                            cVar.b(bVar.Ze);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.d.ax(vVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public interface c<T> {
        void b(T t2);
    }

    static class d implements f<a.C0427a> {
        f<a.C0427a> ZQ;

        d(f<a.C0427a> fVar) {
            this.ZQ = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0427a> cVar) {
            this.ZQ.a(vVar, new a<a.C0427a>(cVar) { // from class: com.kwad.sdk.api.loader.m.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                @WorkerThread
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void b(@NonNull a.C0427a c0427a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    File fileK = null;
                    try {
                        j.a(c0427a);
                        fileK = com.kwad.sdk.api.loader.h.k(vVar.getContext(), c0427a.sdkVersion);
                        i.b(c0427a.Zb, fileK);
                        j.a(c0427a, System.currentTimeMillis() - jCurrentTimeMillis);
                        c0427a.Zc = fileK;
                        cVar.b(c0427a);
                    } catch (Throwable th) {
                        j.a(c0427a, System.currentTimeMillis() - jCurrentTimeMillis, Log.getStackTraceString(th));
                        com.kwad.sdk.api.loader.h.e(fileK);
                    }
                }
            });
        }
    }

    static class e implements f<Boolean> {
        f<a.C0427a> ZQ;

        e(f<a.C0427a> fVar) {
            this.ZQ = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<Boolean> cVar) {
            this.ZQ.a(vVar, new c<a.C0427a>() { // from class: com.kwad.sdk.api.loader.m.e.1
                private void a(a.C0427a c0427a, int i2, Throwable th) {
                    com.kwad.sdk.api.loader.h.e(c0427a.Zc);
                    j.b(c0427a, i2, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void b(@NonNull a.C0427a c0427a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        j.b(c0427a);
                        if (!com.kwad.sdk.api.loader.b.b(vVar.getContext(), c0427a.Zc.getPath(), c0427a.sdkVersion)) {
                            a(c0427a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.g.i(vVar.getContext(), c0427a.sdkVersion);
                        com.kwad.sdk.api.loader.h.e(c0427a.Zc);
                        j.b(c0427a, System.currentTimeMillis() - jCurrentTimeMillis);
                        cVar.b(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0427a, 2, th);
                    }
                }
            });
        }
    }

    public interface f<T> {
        void a(v vVar, c<T> cVar);
    }

    static class g implements f<a.C0427a> {
        f<a.C0427a> ZQ;

        g(f<a.C0427a> fVar) {
            this.ZQ = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, final c<a.C0427a> cVar) {
            this.ZQ.a(vVar, new a<a.C0427a>(cVar) { // from class: com.kwad.sdk.api.loader.m.g.1
                private void a(a.C0427a c0427a, int i2, Throwable th) {
                    com.kwad.sdk.api.loader.h.e(c0427a.Zc);
                    j.a(c0427a, i2, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void b(@NonNull a.C0427a c0427a) {
                    try {
                        File file = c0427a.Zc;
                        if (!r.f(file)) {
                            a(c0427a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (r.a(file, c0427a.Tb)) {
                            cVar.b(c0427a);
                        } else {
                            a(c0427a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c0427a, 3, th);
                    }
                }
            });
        }
    }

    static class h implements f<a.C0427a> {
        f<a.C0427a> ZQ;

        h(f<a.C0427a> fVar) {
            this.ZQ = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0427a> cVar) {
            this.ZQ.a(vVar, new c<a.C0427a>() { // from class: com.kwad.sdk.api.loader.m.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void b(a.C0427a c0427a) {
                    String strAy = com.kwad.sdk.api.loader.g.ay(vVar.getContext());
                    if (TextUtils.isEmpty(strAy)) {
                        strAy = com.kwad.sdk.api.c.tv().getSDKVersion();
                    }
                    String str = c0427a.sdkVersion;
                    StringBuilder sb = new StringBuilder("UpgradeProducer curVersion:");
                    sb.append(strAy);
                    sb.append("-newVersion");
                    sb.append(str);
                    t.a(vVar.getContext(), am.aU, c0427a.interval);
                    t.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0427a.tz()) {
                        u.aE(vVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + strAy);
                        return;
                    }
                    if (com.kwad.sdk.api.loader.g.q(c0427a.sdkVersion, strAy) && c0427a.ty()) {
                        cVar.b(c0427a);
                        return;
                    }
                    new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0427a.sdkVersion + " currentDynamicVersion:" + strAy + " dynamicType:" + c0427a.Za);
                }
            });
        }
    }

    static f<Boolean> tH() {
        return new e(new g(new d(new h(new b()))));
    }
}
