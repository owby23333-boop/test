package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.net.Uri;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f849g = new d.a().b().a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f851f;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a$a, reason: collision with other inner class name */
    class C0024a implements f {
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a a;

        C0024a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
            this.a = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, a0 a0Var) throws IOException {
            if (this.a != null) {
                HashMap map = new HashMap();
                if (a0Var != null) {
                    r rVarM = a0Var.m();
                    if (rVarM != null) {
                        for (int i2 = 0; i2 < rVarM.b(); i2++) {
                            map.put(rVarM.a(i2), rVarM.b(i2));
                        }
                    }
                    this.a.a(a.this, new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b(a0Var.n(), a0Var.k(), a0Var.o(), map, a0Var.i().l(), a0Var.t(), a0Var.r()));
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, IOException iOException) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar = this.a;
            if (aVar != null) {
                aVar.a(a.this, iOException);
            }
        }
    }

    static {
        new d.a().a();
    }

    public a(v vVar) {
        super(vVar);
        this.f850e = f849g;
        this.f851f = new HashMap();
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
        y.a aVar2 = new y.a();
        s.a aVar3 = new s.a();
        try {
            Uri uri = Uri.parse(this.f853d);
            aVar3.e(uri.getScheme());
            aVar3.c(uri.getHost());
            String encodedPath = uri.getEncodedPath();
            if (!TextUtils.isEmpty(encodedPath)) {
                if (encodedPath.startsWith("/")) {
                    encodedPath = encodedPath.substring(1);
                }
                aVar3.a(encodedPath);
            }
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String str : queryParameterNames) {
                    this.f851f.put(str, uri.getQueryParameter(str));
                }
            }
            for (Map.Entry<String, String> entry : this.f851f.entrySet()) {
                aVar3.a(entry.getKey(), entry.getValue());
            }
            a(aVar2);
            aVar2.a(this.f850e);
            aVar2.a((Object) a());
            this.a.a(aVar2.a(aVar3.a()).b().a()).a(new C0024a(aVar));
        } catch (Throwable th) {
            th.printStackTrace();
            aVar.a(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    public void b(String str, String str2) {
        if (str == null) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.d.a("GetExecutor", "name cannot be null !!!");
        } else {
            this.f851f.put(str, str2);
        }
    }
}
