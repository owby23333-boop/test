package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.utils.EngineThreadPool;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.component.ttvideo.log.a f86a;
    private c c;
    private String e;
    private String f;
    private Context j;
    private int g = 0;
    public int h = 0;
    private int i = 0;
    private long k = -2147483648L;
    private f b = new f();
    private boolean d = true;

    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f f87a;
        private Handler b = new Handler(Looper.getMainLooper());
        c c;

        /* JADX INFO: renamed from: com.bykv.vk.component.ttvideo.log.d$a$a, reason: collision with other inner class name */
        class RunnableC0025a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f88a;

            RunnableC0025a(a aVar, JSONObject jSONObject) {
                this.f88a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.instance.a(false, this.f88a);
            }
        }

        public a(f fVar, d dVar, c cVar) {
            this.f87a = fVar;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTVideoEngineLog.i("VideoEventLoggerV2", "AyncGetLogDataRunnable enter");
            f fVar = this.f87a;
            if (fVar == null) {
                TTVideoEngineLog.e("VideoEventLoggerV2", "rEvent is null, return.");
                return;
            }
            JSONObject jSONObjectA = fVar.a(this.c);
            Handler handler = this.b;
            if (handler == null || handler.getLooper() == null) {
                TTVideoEngineLog.i("VideoEventLoggerV2", "report in child thread");
                e.instance.a(false, jSONObjectA);
            } else {
                TTVideoEngineLog.i("VideoEventLoggerV2", "report in main looper");
                this.b.post(new RunnableC0025a(this, jSONObjectA));
            }
        }
    }

    public d(Context context, com.bykv.vk.component.ttvideo.log.a aVar) {
        this.f86a = aVar;
        this.c = new c(aVar, context);
        this.j = context;
    }

    private void b() {
        this.i = 0;
        this.d = true;
        this.h = 0;
        this.k = -2147483648L;
    }

    private void c() {
        String strDecode;
        StringBuilder sb;
        String string;
        if (!TextUtils.isEmpty(this.e)) {
            strDecode = this.e;
        } else if (TextUtils.isEmpty(this.f)) {
            return;
        } else {
            strDecode = this.f;
        }
        try {
            strDecode = URLDecoder.decode(strDecode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            sb = new StringBuilder("exception:");
            string = e.toString();
            TTVideoEngineLog.e("VideoEventLoggerV2", sb.append(string).toString());
        } catch (IllegalArgumentException e2) {
            sb = new StringBuilder("exception:");
            string = e2.toString();
            TTVideoEngineLog.e("VideoEventLoggerV2", sb.append(string).toString());
        }
        int iIndexOf = strDecode.indexOf("&l=");
        if (iIndexOf > 0) {
            int iIndexOf2 = strDecode.indexOf("&", iIndexOf + 1);
            int i = iIndexOf + 3;
            this.b.o = iIndexOf2 > 0 ? strDecode.substring(i, iIndexOf2) : strDecode.substring(i);
        }
    }

    private void d() {
        if (this.b == null) {
            return;
        }
        TTVideoEngineLog.i("VideoEventLoggerV2", "sendEvent pt_new:" + this.b.b + ", mEvent:" + this.b + ", eventBase:" + this.c);
        if (this.b.b > 0 || this.k > 0) {
            int i = this.g;
            if (i > 0) {
                this.c.h = i;
            }
            SharedPreferences sharedPreferencesG = g.g(this.j, "VideoEventLogger", 0);
            this.b.p = sharedPreferencesG.getString("playersessionid", "");
            SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
            editorEdit.putString("playersessionid", this.c.f);
            editorEdit.apply();
            f fVar = this.b;
            fVar.n = this.c.f;
            fVar.h = this.h;
            String str = this.e;
            if (str != null) {
                fVar.k = str;
            }
            String str2 = this.f;
            if (str2 != null) {
                this.b.l = str2;
            }
            f fVar2 = this.b;
            fVar2.c = fVar2.b;
            fVar2.f90a = this.k;
            if (fVar2.e <= 0 && fVar2.d > 0) {
                fVar2.e = System.currentTimeMillis();
            }
            if (TextUtils.isEmpty(this.b.o)) {
                c();
            }
            EngineThreadPool.a().execute(new a(this.b, this, this.c));
            b();
        }
    }

    private void f(int i) {
        d();
        this.b = new f();
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a() {
        if (this.i != 4) {
            this.i = 2;
            this.d = false;
            f fVar = this.b;
            if (fVar.d <= 0) {
                fVar.d = System.currentTimeMillis();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r8) {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 5
            if (r8 == r2) goto L1c
            int r2 = r7.i
            r3 = 4
            r4 = 0
            if (r2 != r3) goto Lf
            r3 = r4
            goto L10
        Lf:
            r3 = 1
        L10:
            r5 = 3
            if (r2 != r5) goto L14
            goto L15
        L14:
            r4 = r3
        L15:
            if (r4 == 0) goto L1c
            com.bykv.vk.component.ttvideo.log.c r2 = r7.c
            r2.a()
        L1c:
            boolean r2 = r7.d
            if (r2 == 0) goto L2d
            com.bykv.vk.component.ttvideo.log.f r2 = r7.b
            long r3 = r2.d
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L2d
            r2.f = r0
            goto L31
        L2d:
            com.bykv.vk.component.ttvideo.log.f r2 = r7.b
            r2.e = r0
        L31:
            r7.f(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.a(int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(long j, String str) {
        this.i = 1;
        this.c.a(str);
        if (this.k <= 0) {
            this.k = j;
        }
        this.d = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.bykv.vk.component.ttvideo.utils.Error r10, int r11) {
        /*
            r9 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r11 = r9.i
            r2 = 0
            r3 = 1
            r4 = 4
            if (r11 != r4) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r3
        Le:
            r6 = 3
            if (r11 != r6) goto L12
            goto L13
        L12:
            r2 = r5
        L13:
            r11 = 5
            r9.i = r11
            boolean r11 = r9.d
            if (r11 == 0) goto L27
            com.bykv.vk.component.ttvideo.log.f r11 = r9.b
            long r5 = r11.d
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 > 0) goto L27
            r11.f = r0
            goto L44
        L27:
            java.lang.String r11 = r10.c
            java.lang.String r5 = "kTTVideoErrorDomainVideoOwnPlayer"
            boolean r11 = r11.equals(r5)
            if (r11 != 0) goto L3b
            java.lang.String r11 = r10.c
            java.lang.String r5 = "kTTVideoErrorDomainVideoOSPlayer"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L40
        L3b:
            int r11 = r9.h
            int r11 = r11 + r3
            r9.h = r11
        L40:
            com.bykv.vk.component.ttvideo.log.f r11 = r9.b
            r11.e = r0
        L44:
            if (r2 == 0) goto L4b
            com.bykv.vk.component.ttvideo.log.c r11 = r9.c
            r11.a()
        L4b:
            com.bykv.vk.component.ttvideo.log.f r11 = r9.b
            int r0 = r10.getType()
            r11.i = r0
            com.bykv.vk.component.ttvideo.log.f r11 = r9.b
            int r10 = r10.f92a
            r11.j = r10
            r9.f(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.a(com.bykv.vk.component.ttvideo.utils.Error, int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(Error error, int i, int i2) {
        if (error.c.equals(Error.VideoOwnPlayer) || error.c.equals(Error.VideoOSPlayer)) {
            this.h++;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str) {
        if (this.c == null || str == null || str.isEmpty()) {
            return;
        }
        this.c.b(str);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str, String str2) {
        this.e = str;
        c cVar = this.c;
        if (cVar != null) {
            cVar.g = str;
        }
        this.f = str2;
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void b(int i) {
        this.b.m = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r9) {
        /*
            r8 = this;
            int r0 = r8.i
            if (r0 != 0) goto L5
            return
        L5:
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = r8.i
            r3 = 4
            r4 = 0
            if (r2 != r3) goto L11
            r3 = r4
            goto L12
        L11:
            r3 = 1
        L12:
            r5 = 3
            if (r2 != r5) goto L16
            r3 = r4
        L16:
            r8.i = r4
            boolean r2 = r8.d
            if (r2 == 0) goto L35
            com.bykv.vk.component.ttvideo.log.f r2 = r8.b
            long r4 = r2.b
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L35
            long r4 = r2.d
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L35
            long r4 = r2.f
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L39
            r2.f = r0
            goto L39
        L35:
            com.bykv.vk.component.ttvideo.log.f r2 = r8.b
            r2.e = r0
        L39:
            if (r3 == 0) goto L40
            com.bykv.vk.component.ttvideo.log.c r0 = r8.c
            r0.a()
        L40:
            r8.f(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.c(int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void d(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 10) {
            f fVar = this.b;
            if (fVar.b <= 0) {
                fVar.b = jCurrentTimeMillis;
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void e(int i) {
        this.g = i;
        this.c.h = i;
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void reset() {
        this.d = true;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.c = new c(this.f86a, this.j);
    }
}
