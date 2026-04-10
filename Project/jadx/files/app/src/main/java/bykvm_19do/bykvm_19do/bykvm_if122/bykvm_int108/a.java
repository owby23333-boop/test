package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.m;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.a f1723e = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, Pair<Boolean, String>> f1724f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CountDownLatch f1725g = new CountDownLatch(1);
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f1726c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.b f1727d;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a$a, reason: collision with other inner class name */
    static final class RunnableC0051a implements Runnable {
        RunnableC0051a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            String str;
            if (a.f1724f.containsKey("pangle")) {
                a.k();
            }
            Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 start ---------------------");
            for (Map.Entry entry : a.f1724f.entrySet()) {
                if (entry.getValue() != null) {
                    if (!((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                        sb = new StringBuilder();
                        sb.append("adnName = ");
                        sb.append((String) entry.getKey());
                        sb.append(" 初始化失败 ");
                        str = (String) ((Pair) entry.getValue()).second;
                    } else if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g((String) entry.getKey())) {
                        sb = new StringBuilder();
                        sb.append("adnName = ");
                        sb.append((String) entry.getKey());
                        str = " 自定义ADN调用初始化方法成功，请开发者确保接入的自定义ADN初始化结果";
                    } else {
                        Logger.i("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化成功");
                    }
                    sb.append(str);
                    Logger.e("TTMediationSDK_SDK_Init", sb.toString());
                }
            }
            Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 end ---------------------");
        }
    }

    class b implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a$b$a, reason: collision with other inner class name */
        class C0052a implements IGMInitAdnResult {
            C0052a() {
            }

            @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
            public void fail(@NonNull AdError adError) {
                a.this.b.set(true);
                a.this.h();
            }

            @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
            public void success() {
                a.this.b.set(true);
                a.this.h();
            }
        }

        b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.a, new C0052a());
            a.this.f(this.a);
            a.this.h(this.a);
            a.this.a.set(true);
            a.this.h();
        }
    }

    class c implements Runnable {
        final /* synthetic */ Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.a);
            a.this.a(this.a);
            a.this.c(this.a);
            a.this.i(this.a);
            a.this.g(this.a);
            a.j(this.a);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.c.a(this.a);
            a.this.f1726c.set(true);
            a.this.h();
        }
    }

    class d implements IGMInitAdnResult {
        final /* synthetic */ IGMInitAdnResult a;

        d(a aVar, IGMInitAdnResult iGMInitAdnResult) {
            this.a = iGMInitAdnResult;
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void fail(@NonNull AdError adError) {
            a.j();
            IGMInitAdnResult iGMInitAdnResult = this.a;
            if (iGMInitAdnResult != null) {
                iGMInitAdnResult.fail(adError);
            }
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void success() {
            a.j();
            IGMInitAdnResult iGMInitAdnResult = this.a;
            if (iGMInitAdnResult != null) {
                iGMInitAdnResult.success();
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ Context a;

        e(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(this.a);
            a.this.e(this.a);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.b.get() && a.this.a.get() && a.this.f1726c.get() && a.this.f1727d != null) {
                a.this.f1727d.a();
            }
        }
    }

    public static GMCustomAdapterConfiguration a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f1723e.b(str);
    }

    public static String a(Map<String, Object> map, String str) {
        return f1723e.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), map, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.a(context).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, IGMInitAdnResult iGMInitAdnResult) {
        j.a(context).a(new d(this, iGMInitAdnResult));
    }

    public static void a(String str, Pair<Boolean, String> pair) {
        f1724f.put(str, pair);
    }

    public static Map<String, Object> b(Map<String, Object> map, String str) {
        return f1723e.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), map, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.b(context).e();
    }

    public static int c() {
        return f1724f.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.e(context).e();
    }

    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.a d() {
        return f1723e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        b bVar = new b(context);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            bVar.run();
        } else {
            ThreadHelper.runOnUiThread(bVar);
        }
    }

    public static Map<String, ITTAdapterConfiguration> e() {
        return f1723e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        ThreadHelper.runOnThreadPool(new c(context));
    }

    public static String f() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVarA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a("pangle");
        String strA = aVarA != null ? aVarA.a() : null;
        return TextUtils.isEmpty(strA) ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b() : strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.f(context).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context) {
        new g(context).e();
    }

    public static boolean g() {
        return f1725g.getCount() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ThreadHelper.runOnMSDKThread(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Context context) {
        new h(context).e();
    }

    public static void i() {
        synchronized (a.class) {
            ThreadHelper.runOnThreadPool(new RunnableC0051a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Context context) {
        new l(context).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        f1725g.countDown();
    }

    public static void j(Context context) {
        new m(context).e();
    }

    public static void k() {
        try {
            f1725g.await(4000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.b bVar) {
        this.f1727d = bVar;
        this.a.set(false);
        this.f1726c.set(false);
        this.b.set(false);
        ThreadHelper.runOnUiThread(new e(context));
    }
}
