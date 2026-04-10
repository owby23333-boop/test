package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108;

import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g;
import com.bytedance.msdk.api.AdError;
import java.io.Serializable;

/* JADX INFO: compiled from: TTAdCallbackConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {
    private String a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2136c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f2137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdError f2138e;

    public void a(g gVar) {
        this.f2137d = gVar;
    }

    public void b(boolean z2) {
        this.b = z2;
    }

    public g c() {
        return this.f2137d;
    }

    public boolean d() {
        return this.f2136c;
    }

    public boolean e() {
        if (this.a.equals("onVideoStart") || this.a.equals("onVideoPause") || this.a.equals("onVideoResume") || this.a.equals("onVideoCompleted")) {
            return false;
        }
        return this.b;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.a;
    }

    public AdError a() {
        return this.f2138e;
    }

    public void a(AdError adError) {
        this.f2138e = adError;
    }

    public void a(boolean z2) {
        this.f2136c = z2;
    }
}
