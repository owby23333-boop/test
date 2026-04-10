package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PM {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Map<Class<?>, String> f17807q = new b();
    private final Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f17809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f17810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DexClassLoader f17811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RandomAccessFile f17812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FileLock f17813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f17814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final f f17815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile POFactory f17816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f17817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Future<Boolean> f17818m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f17820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f17821p;
    final ExecutorService a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17819n = false;

    class a implements Callable<Boolean> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!PM.this.f17814i) {
                PM pm = PM.this;
                pm.f17814i = pm.tryLockUpdate();
            }
            if (PM.b(PM.this)) {
                PM.c(PM.this);
            }
            PM.this.f17817l = (int) (System.currentTimeMillis() - jCurrentTimeMillis);
            return Boolean.TRUE;
        }
    }

    static class b extends HashMap<Class<?>, String> {
        b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.b = context.getApplicationContext();
        this.f17815j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        if (SDKStatus.isNoPlugin) {
            return;
        }
        d();
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.f17821p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.f17808c);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.f12231u, com.qq.e.comm.managers.b.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.b));
            jSONObject.put("ict", this.f17817l);
            jSONObject.put("mup", this.f17814i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean b() {
        if (!this.f17814i) {
            return false;
        }
        try {
            com.qq.e.comm.managers.plugin.b.a(this.b, h.e(this.b), h.f(this.b));
            this.f17808c = Sig.ASSET_PLUGIN_SIG;
            this.f17809d = h.e(this.b);
            this.f17810e = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean b(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            if (r5 == 0) goto L6d
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r2.<init>()     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L31
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L31
            r2.append(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L31
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L31
            boolean r2 = r5.c()     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto L29
            boolean r5 = r5.b()     // Catch: java.lang.Throwable -> L31
            if (r5 == 0) goto L2b
        L29:
            r5 = 1
            r1 = 1
        L2b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L43
        L31:
            r5 = move-exception
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L55
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L55
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L55
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L43:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            return r1
        L55:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        L6d:
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.b(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    static void c(PM pm) {
        File file;
        if (pm == null) {
            throw null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file2 = pm.f17809d;
        sb.append(file2 == null ? "null" : file2.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (SDKStatus.isNoPlugin || pm.f17808c == null || (file = pm.f17809d) == null) {
            if (SDKStatus.isNoPlugin) {
                return;
            }
            pm.f17811f = null;
            return;
        }
        try {
            pm.f17811f = new DexClassLoader(file.getAbsolutePath(), h.a(pm.b).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.f17815j;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            f fVar2 = pm.f17815j;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    private boolean c() {
        if (this.f17820o) {
            return false;
        }
        if (this.f17814i) {
            g gVar = new g(h.c(this.b), h.d(this.b));
            if (gVar.a()) {
                GDTLogger.d("NextExist,Updated=" + gVar.a(h.e(this.b), h.f(this.b)));
            }
        }
        g gVar2 = new g(h.e(this.b), h.f(this.b));
        if (!gVar2.a()) {
            return false;
        }
        if (gVar2.c() >= SDKStatus.getBuildInPluginVersion()) {
            this.f17808c = gVar2.b();
            this.f17810e = gVar2.c();
            this.f17809d = h.e(this.b);
            this.f17821p = gVar2.d();
            this.f17819n = true;
            return true;
        }
        GDTLogger.d("last updated plugin version =" + this.f17810e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
        return false;
    }

    private void d() {
        this.f17819n = false;
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.f17820o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
        this.f17818m = this.a.submit(new a());
    }

    public <T> T getFactory(Class<T> cls) throws e {
        Future<Boolean> future = this.f17818m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = (SDKStatus.isNoPlugin || Sig.ASSET_PLUGIN_SIG == null) ? PM.class.getClassLoader() : this.f17811f;
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = f17807q.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> clsLoadClass = classLoader.loadClass(str);
            T tCast = cls.cast(clsLoadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(clsLoadClass, this.b, a()));
            GDTLogger.d("ServiceDelegateFactory =" + tCast);
            return tCast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws e {
        if (this.f17816k == null) {
            synchronized (this) {
                if (this.f17816k == null) {
                    try {
                        this.f17816k = (POFactory) getFactory(POFactory.class);
                    } catch (e e2) {
                        if (!this.f17819n) {
                            throw e2;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.f17820o = true;
                        d();
                        this.f17816k = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        return this.f17816k;
    }

    public int getPluginVersion() {
        if (SDKStatus.isNoPlugin) {
            return 1381;
        }
        Future<Boolean> future = this.f17818m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.f17810e;
    }

    public boolean tryLockUpdate() {
        try {
            File fileB = h.b(this.b);
            if (!fileB.exists()) {
                fileB.createNewFile();
                h.a("lock", fileB);
            }
            if (!fileB.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileB, "rw");
            this.f17812g = randomAccessFile;
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
            this.f17813h = fileLockTryLock;
            if (fileLockTryLock == null) {
                return false;
            }
            this.f17812g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
