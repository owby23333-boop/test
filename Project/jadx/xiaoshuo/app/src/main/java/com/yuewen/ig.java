package com.yuewen;

import androidx.webkit.ProxyConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerRegistry;

/* JADX INFO: loaded from: classes3.dex */
public class ig implements df {
    public static ig e = null;
    public static final int f = 9090;
    public static final String g = "127.0.0.1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ph1 f12472a;
    public long d = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12473b = false;
    public Map<String, cw0> c = new HashMap();

    public class a implements HttpRequestHandler {
        public final cw0 a(String str) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            if (ig.this.c.containsKey(str)) {
                return (cw0) ig.this.c.get(str);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(org.apache.http.HttpRequest r19, org.apache.http.HttpResponse r20) {
            /*
                Method dump skipped, instruction units count: 227
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yuewen.ig.a.b(org.apache.http.HttpRequest, org.apache.http.HttpResponse):void");
        }

        @Override // org.apache.http.protocol.HttpRequestHandler
        public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
            b(httpRequest, httpResponse);
        }

        public a() {
        }
    }

    public static ig d() {
        if (e == null) {
            e = new ig();
        }
        return e;
    }

    @Override // com.yuewen.df
    public void a(jg[] jgVarArr, long j) {
        if (this.d != j) {
            this.d = j;
            this.c.clear();
        }
        for (jg jgVar : jgVarArr) {
            if (!this.c.containsKey(jgVar.b())) {
                this.c.put(jgVar.b(), jgVar.a());
            }
        }
    }

    @Override // com.yuewen.df
    public String b() {
        return "http://127.0.0.1:9090/";
    }

    @Override // com.yuewen.df
    public void onStart() {
        if (this.f12473b) {
            return;
        }
        this.f12473b = true;
        this.f12472a = new ph1(f);
        HttpRequestHandlerRegistry httpRequestHandlerRegistry = new HttpRequestHandlerRegistry();
        httpRequestHandlerRegistry.register(ProxyConfig.MATCH_ALL_SCHEMES, new a());
        this.f12472a.k(Executors.newScheduledThreadPool(5), null, null, null, httpRequestHandlerRegistry, null, null);
    }

    @Override // com.yuewen.df
    public void onStop() {
        if (this.f12473b) {
            this.f12473b = false;
        }
        ph1 ph1Var = this.f12472a;
        if (ph1Var != null) {
            ph1Var.i();
        }
        this.d = -1L;
        this.c.clear();
    }
}
