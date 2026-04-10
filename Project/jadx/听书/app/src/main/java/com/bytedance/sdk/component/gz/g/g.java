package com.bytedance.sdk.component.gz.g;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.gz.z.a;
import com.bytedance.sdk.component.gz.z.e;
import com.bytedance.sdk.component.gz.z.fo;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.gz.z.m;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.wp;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.bytedance.sdk.component.gz.z.z.z f732a;
    private fo dl;
    private Context g;
    private gc z;

    public g(com.bytedance.sdk.component.gz.z.z zVar) {
        z(zVar);
    }

    public g() {
    }

    public static com.bytedance.sdk.component.gz.z.z.z m() {
        if (f732a == null) {
            synchronized (g.class) {
                if (f732a == null) {
                    f732a = new com.bytedance.sdk.component.gz.g.gc.z();
                }
            }
        }
        return f732a;
    }

    public void z(gc gcVar) {
        g(gcVar);
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public fo a() {
        return this.dl;
    }

    public void g(gc gcVar) {
        this.z = gcVar;
        this.g = gcVar.getContext();
        this.dl = new com.bytedance.sdk.component.gz.g.g.g(this.z);
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public a gc() {
        gc gcVar = this.z;
        if (gcVar == null) {
            return null;
        }
        return gcVar.a();
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public gc dl() {
        gc gcVar = this.z;
        if (gcVar == null) {
            return null;
        }
        return gcVar;
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public void z(m mVar) {
        gc gcVar = this.z;
        if (gcVar != null) {
            if (mVar == null) {
                mVar = com.bytedance.sdk.component.gz.g.z.z.z.g.z;
            }
            gcVar.z(mVar);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public void z(boolean z) {
        gc gcVar = this.z;
        if (gcVar != null) {
            gcVar.z(z);
        }
    }

    private boolean z(Context context, a aVar) {
        if (context == null || aVar == null) {
            return false;
        }
        if (aVar.uy() == 1) {
            return aVar.i();
        }
        try {
            return p.z(context);
        } catch (Throwable th) {
            wp.z(th);
            return true;
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public void z() {
        final a aVarA;
        gc gcVar = this.z;
        if (gcVar == null || (aVarA = gcVar.a()) == null || this.z.getContext() == null || aVarA.gz() == null) {
            return;
        }
        if (this.z.kb()) {
            if (z(this.z.getContext(), aVarA)) {
                fo foVar = this.dl;
                if (foVar != null) {
                    foVar.z();
                    return;
                }
                return;
            }
            if (e()) {
                aVarA.gz().execute(new com.bytedance.sdk.component.gz.g.gc.g(TtmlNode.START) { // from class: com.bytedance.sdk.component.gz.g.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        gc unused = g.this.z;
                        g.this.z(aVarA.uy());
                    }
                });
                return;
            } else {
                z(aVarA.uy());
                return;
            }
        }
        fo foVar2 = this.dl;
        if (foVar2 != null) {
            foVar2.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.gz.g.g.g.z.z(this.z);
        } else if (i == 1) {
            com.bytedance.sdk.component.gz.g.g.g.g.g(this.z);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public void z(com.bytedance.sdk.component.gz.z.g gVar) {
        g(gVar);
    }

    private boolean e() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void g(final com.bytedance.sdk.component.gz.z.g gVar) {
        gc gcVar = this.z;
        if (gcVar == null || this.dl == null) {
            wp.a("log_error", "dispatch event configManager is null");
            return;
        }
        final a aVarA = gcVar.a();
        if (gVar == null || aVarA == null || this.z.getContext() == null || aVarA.gz() == null) {
            return;
        }
        if (this.z.kb()) {
            if (z(this.z.getContext(), aVarA)) {
                this.dl.z(gVar);
                return;
            }
            e();
            if (e()) {
                aVarA.gz().execute(new com.bytedance.sdk.component.gz.g.gc.g("dispatchEvent") { // from class: com.bytedance.sdk.component.gz.g.g.2
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.z(gVar, aVarA.uy());
                    }
                });
                return;
            } else {
                z(gVar, aVarA.uy());
                return;
            }
        }
        this.dl.z(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.component.gz.z.g gVar, int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.gz.g.g.g.z.z(gVar, this.z);
        } else if (i == 1) {
            com.bytedance.sdk.component.gz.g.g.g.g.z(gVar, this.z);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public void z(final String str, final List<String> list, final boolean z, Map<String, String> map, final JSONObject jSONObject) {
        gc gcVar = this.z;
        if (gcVar == null) {
            wp.a("log_error", "track configManager is null");
            return;
        }
        final a aVarA = gcVar.a();
        if (aVarA == null || this.z.getContext() == null || aVarA.gz() == null || !aVarA.m()) {
            return;
        }
        if (aVarA.uy() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (aVarA.uy() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (!this.z.kb() || z(this.z.getContext(), aVarA)) {
            com.bytedance.sdk.component.gz.g.m.z.z(this.z).z(str, list, z, map, jSONObject);
        } else if (e()) {
            aVarA.gz().execute(new com.bytedance.sdk.component.gz.g.gc.g("trackFailed") { // from class: com.bytedance.sdk.component.gz.g.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.z(str, (List<String>) list, z, aVarA.uy(), jSONObject);
                }
            });
        } else {
            z(str, list, z, aVarA.uy(), jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, List<String> list, boolean z, int i, JSONObject jSONObject) {
        if (i == 0) {
            com.bytedance.sdk.component.gz.g.g.g.z.z(str, list, z, this.z, jSONObject);
        } else if (i == 1) {
            com.bytedance.sdk.component.gz.g.g.g.g.z(str, list, z, this.z);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public void z(final String str) {
        gc gcVar = this.z;
        if (gcVar == null) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("log_error", "trackFailedUrls configManager is null", gcVar);
            return;
        }
        final a aVarA = gcVar.a();
        if (aVarA == null || this.z.getContext() == null || aVarA.gz() == null || !aVarA.m()) {
            return;
        }
        if (aVarA.uy() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.z.kb() || z(this.z.getContext(), aVarA)) {
            com.bytedance.sdk.component.gz.g.m.z.z(this.z).z(str);
        } else if (e()) {
            aVarA.gz().execute(new com.bytedance.sdk.component.gz.g.gc.g("trackFailed") { // from class: com.bytedance.sdk.component.gz.g.g.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.z(str, aVarA.uy());
                }
            });
        } else {
            z(str, aVarA.uy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.gz.g.g.g.z.z(str, this.z);
        } else if (i == 1) {
            com.bytedance.sdk.component.gz.g.g.g.g.z(str, this.z);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.e
    public void g() {
        fo foVar = this.dl;
        if (foVar != null) {
            foVar.g();
        }
    }
}
