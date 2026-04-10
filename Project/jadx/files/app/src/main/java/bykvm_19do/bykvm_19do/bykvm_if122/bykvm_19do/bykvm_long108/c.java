package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m0;
import com.anythink.core.api.ATCustomRuleKeys;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.adapter.util.WeakHandler;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.UserInfoForSegment;
import com.bytedance.msdk.api.v2.GMConfigCallback;
import com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f1572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile c f1573j;
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a a;
    private final Context b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakHandler f1577f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f1574c = new AtomicInteger(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f1575d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f1576e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f1578g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1579h = -1;

    class a implements Runnable {
        final /* synthetic */ GMConfigCallback a;
        final /* synthetic */ AdError b;

        a(c cVar, GMConfigCallback gMConfigCallback, AdError adError) {
            this.a = gMConfigCallback;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            GMConfigCallback gMConfigCallback = this.a;
            if (gMConfigCallback != null) {
                gMConfigCallback.onConfigLoadFail(this.b);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ GMConfigCallback a;
        final /* synthetic */ List b;

        b(c cVar, GMConfigCallback gMConfigCallback, List list) {
            this.a = gMConfigCallback;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onConfigLoaded(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(this.b));
        }
    }

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c$c, reason: collision with other inner class name */
    class C0047c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {
        final /* synthetic */ int[] a;
        final /* synthetic */ int[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f1580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f1581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f1582e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f1583f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ GMConfigCallback f1584g;

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c$c$a */
        class a implements Runnable {
            final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b a;

            a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar) {
                this.a = bVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x00ff A[Catch: all -> 0x023c, TryCatch #4 {all -> 0x023c, blocks: (B:6:0x0014, B:8:0x0025, B:10:0x0043, B:13:0x006c, B:31:0x00e3, B:33:0x00ff, B:35:0x0105, B:36:0x010c, B:38:0x011a, B:41:0x0124, B:45:0x0177, B:47:0x0198, B:49:0x01a2, B:51:0x01b6, B:58:0x0206, B:18:0x0081, B:20:0x009c, B:25:0x00ce, B:28:0x00d7, B:15:0x007a, B:22:0x00ae), top: B:85:0x0014, inners: #0, #5 }] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x011a A[Catch: all -> 0x023c, TryCatch #4 {all -> 0x023c, blocks: (B:6:0x0014, B:8:0x0025, B:10:0x0043, B:13:0x006c, B:31:0x00e3, B:33:0x00ff, B:35:0x0105, B:36:0x010c, B:38:0x011a, B:41:0x0124, B:45:0x0177, B:47:0x0198, B:49:0x01a2, B:51:0x01b6, B:58:0x0206, B:18:0x0081, B:20:0x009c, B:25:0x00ce, B:28:0x00d7, B:15:0x007a, B:22:0x00ae), top: B:85:0x0014, inners: #0, #5 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0124 A[Catch: all -> 0x023c, TryCatch #4 {all -> 0x023c, blocks: (B:6:0x0014, B:8:0x0025, B:10:0x0043, B:13:0x006c, B:31:0x00e3, B:33:0x00ff, B:35:0x0105, B:36:0x010c, B:38:0x011a, B:41:0x0124, B:45:0x0177, B:47:0x0198, B:49:0x01a2, B:51:0x01b6, B:58:0x0206, B:18:0x0081, B:20:0x009c, B:25:0x00ce, B:28:0x00d7, B:15:0x007a, B:22:0x00ae), top: B:85:0x0014, inners: #0, #5 }] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0196  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x02b8  */
            /* JADX WARN: Removed duplicated region for block: B:73:0x02ba  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 709
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.C0047c.a.run():void");
            }
        }

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c$c$b */
        class b implements Runnable {
            final /* synthetic */ IOException a;

            b(IOException iOException) {
                this.a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.e("SdkSettingsHelper", "----网络错误，服务器无响应，稍后会尝试重新拉取配置----，setting request failed..." + this.a.getMessage());
                try {
                    c.this.a(C0047c.this.f1584g, new AdError(-2, AdError.getMessage(-2)), C0047c.this.f1582e);
                    Logger.e("SdkSettingsHelper", "----网络错误，重新拉取配置失败----，>>>>> retryLoadSettingData");
                } catch (Throwable unused) {
                }
                c.this.f1575d.set(false);
                C0047c c0047c = C0047c.this;
                int[] iArr = c0047c.b;
                iArr[0] = 0;
                int[] iArr2 = c0047c.a;
                iArr2[0] = -2;
                int i2 = iArr[0];
                int i3 = iArr2[0];
                long jCurrentTimeMillis = System.currentTimeMillis();
                C0047c c0047c2 = C0047c.this;
                h.a(i2, i3, jCurrentTimeMillis - c0047c2.f1580c, c0047c2.f1581d, c0047c2.f1582e == 0, C0047c.this.f1583f, -1L);
            }
        }

        C0047c(int[] iArr, int[] iArr2, long j2, boolean z2, int i2, JSONObject jSONObject, GMConfigCallback gMConfigCallback) {
            this.a = iArr;
            this.b = iArr2;
            this.f1580c = j2;
            this.f1581d = z2;
            this.f1582e = i2;
            this.f1583f = jSONObject;
            this.f1584g = gMConfigCallback;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            ThreadHelper.runOnMSDKThread(new a(bVar2));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            ThreadHelper.runOnMSDKThread(new b(iOException));
        }
    }

    private class d implements Runnable {
        private final GMConfigCallback a;
        private int b;

        d(GMConfigCallback gMConfigCallback, int i2) {
            this.b = 1;
            this.a = gMConfigCallback;
            this.b = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x001b A[LOOP:1: B:13:0x0018->B:14:0x001b, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x001f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x001e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x005e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0015 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:? A[LOOP:2: B:9:0x000f->B:40:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0011 -> B:12:0x0015). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                r0 = r4
            L1:
                r1 = 53
                r2 = 72
                switch(r1) {
                    case 52: goto Lf;
                    case 53: goto Lf;
                    case 54: goto L9;
                    default: goto L8;
                }
            L8:
                goto L1
            L9:
                r1 = 56
                switch(r1) {
                    case 29: goto L1f;
                    case 30: goto L1f;
                    case 31: goto L1f;
                    default: goto Le;
                }
            Le:
                goto L15
            Lf:
                r1 = 87
                switch(r1) {
                    case 85: goto L15;
                    case 86: goto L1;
                    case 87: goto L1f;
                    default: goto L14;
                }
            L14:
                goto Lf
            L15:
                r1 = r0
                r0 = 72
            L18:
                switch(r0) {
                    case 39: goto L5e;
                    case 40: goto L1e;
                    case 41: goto L1e;
                    default: goto L1b;
                }
            L1b:
                r0 = 39
                goto L18
            L1e:
                r0 = r1
            L1f:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.this
                android.content.Context r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(r1)
                boolean r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.z.a(r1)
                if (r1 != 0) goto L36
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.this     // Catch: java.lang.Throwable -> L5d
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.b(r0)     // Catch: java.lang.Throwable -> L5d
                r1 = 0
                r0.a(r1)     // Catch: java.lang.Throwable -> L5d
                goto L5d
            L36:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.this
                java.util.concurrent.atomic.AtomicBoolean r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.c(r1)
                r2 = 1
                r1.set(r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
                boolean r1 = r1.x()
                boolean r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.b()
                if (r3 != 0) goto L54
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r1)
            L54:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.this
                com.bytedance.msdk.api.v2.GMConfigCallback r3 = r0.a
                int r0 = r0.b
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(r2, r1, r3, r0)
            L5d:
                return
            L5e:
                r0 = r1
                goto Lf
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.d.run():void");
        }
    }

    private c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a aVar) {
        this.a = aVar == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f() : aVar;
        this.b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        this.f1577f = new WeakHandler(Looper.getMainLooper(), this);
    }

    public static c a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a aVar) {
        if (f1573j == null) {
            synchronized (c.class) {
                if (f1573j == null) {
                    f1573j = new c(aVar);
                }
            }
        }
        return f1573j;
    }

    private String a(JSONObject jSONObject) {
        JSONObject jSONObjectA = m0.a(jSONObject);
        if (jSONObjectA != null) {
            return jSONObjectA.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                map2.put(str.toLowerCase(), map.get(str));
            }
        }
        return map2;
    }

    private void a(GMConfigCallback gMConfigCallback, AdError adError) {
        ThreadHelper.runOnUiThread(new a(this, gMConfigCallback, adError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GMConfigCallback gMConfigCallback, AdError adError, int i2) throws Throwable {
        long j2;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.S().f("server_dist_host");
        a(gMConfigCallback, adError);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.n();
        Logger.e("SdkSettingsHelper", "setting 配置拉取失败，尝试再次拉取... mLoadingSuccess:" + this.f1576e.get() + " mRetryCount:" + (this.f1574c.get() + 1));
        this.f1575d.set(false);
        if (this.f1576e.get()) {
            this.f1578g.set(false);
            this.f1577f.removeCallbacksAndMessages(null);
            return;
        }
        if (this.f1574c.get() > 3) {
            Logger.e("SdkSettingsHelper", "setting 最多尝试四次拉取... ");
            return;
        }
        this.f1578g.set(true);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = this.f1574c.get();
        messageObtain.arg2 = i2;
        int i3 = this.f1574c.get();
        if (i3 < 3) {
            long j3 = 1;
            for (int i4 = 0; i4 <= i3; i4++) {
                j3 *= 3;
            }
            j2 = j3 * 1000;
        } else {
            j2 = 120000;
        }
        this.f1574c.incrementAndGet();
        this.f1577f.removeCallbacksAndMessages(null);
        this.f1577f.sendMessageDelayed(messageObtain, j2);
        Logger.i("SdkSettingsHelper", "setting 重试次数:" + (i3 + 1) + "  重试间隔：" + j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, GMConfigCallback gMConfigCallback, int i2) {
        int[] iArr = new int[1];
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, JSONObject> mapA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().a(i2);
        JSONObject jSONObject = mapA.get("event_label_value_root");
        JSONObject jSONObject2 = mapA.get("config_req_label_value_root");
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c cVarC = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().c();
        cVarC.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.g());
        String strQ = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().q();
        if (!TextUtils.isEmpty(strQ)) {
            cVarC.a("X-Tt-Env", strQ);
            cVarC.a("x-use-ppe", "1");
        }
        cVarC.a("User-Agent", com.bytedance.msdk.base.b.b);
        cVarC.c(a(b(jSONObject2)));
        cVarC.a(new C0047c(iArr, new int[]{0}, jCurrentTimeMillis, z2, i2, jSONObject, gMConfigCallback));
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private org.json.JSONObject b(org.json.JSONObject r11) {
        /*
            Method dump skipped, instruction units count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.b(org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                Logger.openDebugMode();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean c() {
        long jA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.S().a("max_expire_time", 0L);
        if (this.f1576e.get() && System.currentTimeMillis() > jA) {
            Logger.i("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.f1576e.set(false);
            a();
        }
        return System.currentTimeMillis() > jA;
    }

    private static List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("pangle");
        arrayList.add("gdt");
        arrayList.add("admob");
        arrayList.add("unity");
        arrayList.add("baidu");
        arrayList.add("sigmob");
        arrayList.add("mintegral");
        arrayList.add("ks");
        arrayList.add("klevin");
        return arrayList;
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
        List<String> listD = d();
        if (mapE != null && listD != null) {
            for (String str : listD) {
                ITTAdapterConfiguration iTTAdapterConfiguration = mapE.get(DefaultAdapterClasses.getClassNameByAdnName(str));
                if (iTTAdapterConfiguration != null) {
                    try {
                        jSONObject.put(str, iTTAdapterConfiguration.getNetworkSdkVersion());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject f() {
        Map<String, String> customInfos;
        JSONObject jSONObject = new JSONObject();
        GMConfigUserInfoForSegment gMConfigUserInfoForSegmentF = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().f();
        try {
            if (gMConfigUserInfoForSegmentF != null) {
                Map<String, String> customInfos2 = gMConfigUserInfoForSegmentF.getCustomInfos();
                if (customInfos2 == null) {
                    return null;
                }
                for (String str : customInfos2.keySet()) {
                    jSONObject.put(str, customInfos2.get(str));
                }
            } else {
                UserInfoForSegment userInfoForSegmentU = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().u();
                if (userInfoForSegmentU == null || (customInfos = userInfoForSegmentU.getCustomInfos()) == null) {
                    return null;
                }
                for (String str2 : customInfos.keySet()) {
                    jSONObject.put(str2, customInfos.get(str2));
                }
            }
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        GMConfigUserInfoForSegment gMConfigUserInfoForSegmentF = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().f();
        try {
            if (gMConfigUserInfoForSegmentF != null) {
                jSONObject.put("user_id", gMConfigUserInfoForSegmentF != null ? gMConfigUserInfoForSegmentF.getUserId() : "");
                jSONObject.put("channel", gMConfigUserInfoForSegmentF != null ? gMConfigUserInfoForSegmentF.getChannel() : "");
                jSONObject.put("sub_channel", gMConfigUserInfoForSegmentF != null ? gMConfigUserInfoForSegmentF.getSubChannel() : "");
                jSONObject.put(ATCustomRuleKeys.AGE, gMConfigUserInfoForSegmentF != null ? gMConfigUserInfoForSegmentF.getAge() : 0);
                jSONObject.put(ATCustomRuleKeys.GENDER, gMConfigUserInfoForSegmentF != null ? gMConfigUserInfoForSegmentF.getGender() : "");
                jSONObject.put("user_value_group", gMConfigUserInfoForSegmentF != null ? gMConfigUserInfoForSegmentF.getUserValueGroup() : "");
            } else {
                UserInfoForSegment userInfoForSegmentU = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().u();
                jSONObject.put("user_id", userInfoForSegmentU != null ? userInfoForSegmentU.getUserId() : "");
                jSONObject.put("channel", userInfoForSegmentU != null ? userInfoForSegmentU.getChannel() : "");
                jSONObject.put("sub_channel", userInfoForSegmentU != null ? userInfoForSegmentU.getSubChannel() : "");
                jSONObject.put(ATCustomRuleKeys.AGE, userInfoForSegmentU != null ? userInfoForSegmentU.getAge() : 0);
                jSONObject.put(ATCustomRuleKeys.GENDER, userInfoForSegmentU != null ? userInfoForSegmentU.getGender() : "");
                jSONObject.put("user_value_group", userInfoForSegmentU != null ? userInfoForSegmentU.getUserValueGroup() : "");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public c a() {
        Logger.e("SdkSettingsHelper", "setting resetRetryCount...");
        this.f1574c.set(0);
        this.f1578g.set(false);
        WeakHandler weakHandler = this.f1577f;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages(null);
        }
        return this;
    }

    public void a(int i2) {
        try {
            if (this.f1575d.get()) {
                this.f1579h = i2;
                Logger.i("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                ThreadHelper.runOnThreadPool(new d(null, i2));
            }
        } catch (Throwable th) {
            Logger.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void a(GMConfigCallback gMConfigCallback) {
        if (this.f1579h == 2) {
            this.f1579h = -1;
            a(2);
        }
        if (gMConfigCallback != null) {
            ThreadHelper.runOnUiThread(new b(this, gMConfigCallback, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().r()));
        }
    }

    public void a(List<String> list, GMConfigCallback gMConfigCallback) {
        AdError adError;
        if (gMConfigCallback == null) {
            return;
        }
        try {
            if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().q()) {
                adError = new AdError(AdError.ERROR_CODE_NO_PERMISSION, AdError.getMessage(AdError.ERROR_CODE_NO_PERMISSION));
            } else if (list == null || list.size() <= 0) {
                adError = new AdError(AdError.ERROR_CODE_INPUT_PARAMS_ERROR, AdError.getMessage(AdError.ERROR_CODE_INPUT_PARAMS_ERROR));
            } else {
                if (!this.f1575d.get()) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(list);
                    if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().b(list) || c()) {
                        d dVar = new d(gMConfigCallback, 1);
                        ThreadHelper.runOnThreadPool(dVar);
                        return;
                    } else {
                        Logger.d("SdkSettingsHelper", "本地配置未过期，直接回调成功");
                        gMConfigCallback.onConfigLoaded(null);
                        return;
                    }
                }
                Logger.i("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
                adError = new AdError(AdError.ERROR_CODE_CONFIG_IS_ALREADY_LOADING, AdError.getMessage(AdError.ERROR_CODE_CONFIG_IS_ALREADY_LOADING));
            }
            gMConfigCallback.onConfigLoadFail(adError);
        } catch (Throwable th) {
            Logger.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public void b(int r4) {
        /*
            r3 = this;
            java.lang.String r0 = "SdkSettingsHelper"
        L2:
            r1 = 54
            switch(r1) {
                case 52: goto L8;
                case 53: goto L2;
                case 54: goto Le;
                default: goto L7;
            }
        L7:
            goto L2
        L8:
            r1 = 37
            switch(r1) {
                case 94: goto L2;
                case 95: goto Le;
                case 96: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            android.content.Context r1 = r3.b
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w.d(r1)
            boolean r1 = r3.c()     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L1f
            java.lang.String r4 = "setting 缓存未过期，无需再次发起请求..."
        L1b:
            com.bytedance.msdk.adapter.util.Logger.i(r0, r4)     // Catch: java.lang.Throwable -> L34
            goto L3a
        L1f:
            java.util.concurrent.atomic.AtomicBoolean r1 = r3.f1575d     // Catch: java.lang.Throwable -> L34
            boolean r1 = r1.get()     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L2a
            java.lang.String r4 = "setting 正在加载，无需再次发起请求..."
            goto L1b
        L2a:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c$d r1 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c$d     // Catch: java.lang.Throwable -> L34
            r2 = 0
            r1.<init>(r2, r4)     // Catch: java.lang.Throwable -> L34
            com.bytedance.msdk.adapter.util.ThreadHelper.runOnThreadPool(r1)     // Catch: java.lang.Throwable -> L34
            goto L3a
        L34:
            r4 = move-exception
            java.lang.String r1 = "load sdk settings error: "
            com.bytedance.msdk.adapter.util.Logger.d(r0, r1, r4)
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.b(int):void");
    }

    public void c(int i2) {
        if (this.f1578g.get()) {
            Logger.e("SdkSettingsHelper", "setting 正在尝试拉取配置中...");
            return;
        }
        Logger.e("SdkSettingsHelper", "setting 尝试拉取配置...");
        a();
        b(i2);
    }

    @Override // com.bytedance.msdk.adapter.util.WeakHandler.IHandler
    public void handleMsg(Message message) {
        if (message.what != 1) {
            return;
        }
        int i2 = message.arg1;
        int i3 = message.arg2;
        if (i2 == 3) {
            this.f1578g.set(false);
        }
        Logger.e("SdkSettingsHelper", "setting 发起尝试拉取配置请求... mLoadingSuccess:" + this.f1576e.get() + "tryCount:" + (i2 + 1));
        try {
            if (this.f1576e.get()) {
                return;
            }
            b(i3);
        } catch (Throwable unused) {
        }
    }
}
