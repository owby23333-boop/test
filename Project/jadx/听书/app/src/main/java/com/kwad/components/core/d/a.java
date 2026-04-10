package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.d;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.l;
import com.kwad.sdk.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.m;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean Ob;
    private static boolean Oc;
    private static List<Throwable> Oe;
    private static Map<String, String> Of;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean Od = new AtomicBoolean(false);
    private static final List<b> Og = new CopyOnWriteArrayList();
    private static final List<c> Oh = new CopyOnWriteArrayList();

    public interface b {
        String getKey();

        JSONObject getValue();
    }

    public interface c {
        void onCrashOccur(int i, String str);
    }

    public static synchronized void initAsync(Context context) {
        if (context != null) {
            if (!mHasInit.get() && !Ob) {
                Ob = true;
                h.execute(new bg() { // from class: com.kwad.components.core.d.a.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (e.b(com.kwad.sdk.core.config.c.ayF)) {
                            com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init");
                            com.kwad.sdk.crash.b.a(a.oy());
                            a.mHasInit.set(true);
                            a.ow();
                            a.ox();
                        }
                    }
                });
            }
        }
    }

    public static synchronized void am(Context context) {
        if (context != null) {
            if (!Od.get() && !Oc) {
                Oc = true;
                h.execute(new bg() { // from class: com.kwad.components.core.d.a.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (e.b(com.kwad.sdk.core.config.c.ayF)) {
                            com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init Native");
                            com.kwad.sdk.crash.b.b(a.oy());
                            a.Od.set(true);
                        }
                    }
                });
            }
        }
    }

    public static void a(b bVar) {
        Og.add(bVar);
    }

    public static void a(c cVar) {
        Oh.add(cVar);
    }

    public static void reportSdkCaughtException(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTrace(th);
        if (!mHasInit.get()) {
            b(th);
        } else if (ov()) {
            com.kwad.sdk.crash.b.n(th);
        }
    }

    private static boolean ov() {
        return e.b(com.kwad.sdk.core.config.c.ayG);
    }

    public static void j(String str, String str2) {
        if (!mHasInit.get()) {
            k(str, str2);
        } else {
            com.kwad.sdk.crash.report.h.ah(str, str2);
        }
    }

    private static void k(String str, String str2) {
        if (Of == null) {
            Of = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Of.put(str, str2);
    }

    private static void b(Throwable th) {
        if (Oe == null) {
            Oe = new CopyOnWriteArrayList();
        }
        Oe.add(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ow() {
        if (Oe == null || !ov()) {
            return;
        }
        Iterator<Throwable> it = Oe.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.crash.b.n(it.next());
        }
        Oe.clear();
        Oe = null;
        ServiceProvider.f(new com.kwad.sdk.g.a<Throwable>() { // from class: com.kwad.components.core.d.a.3
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(Throwable th) {
                c(th);
            }

            private static void c(Throwable th) {
                com.kwad.sdk.crash.b.n(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox() {
        Map<String, String> map = Of;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                com.kwad.sdk.crash.report.h.ah(entry.getKey(), entry.getValue());
            }
        }
        Of.clear();
    }

    private static com.kwad.sdk.crash.model.b ag(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("KsAdExceptionCollectorHelper", e);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwad.sdk.crash.c oy() {
        String strA = e.a(com.kwad.sdk.core.config.c.aAd);
        com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "configStr:" + strA);
        com.kwad.sdk.crash.model.b bVarAg = ag(strA);
        String str = bVarAg.aPr;
        String str2 = bVarAg.aPs;
        boolean zA = g.a(bVarAg);
        boolean zB = g.b(bVarAg);
        final Context context = ServiceProvider.getContext();
        String strAn = C0328a.an(context);
        c.a aVarFi = new c.a().cb(context).bE(zA).bF(zB).bG(l.Cf().Bk()).fj(str).fi(str2);
        l.Cf();
        c.a aVarFq = aVarFi.fq(ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 1));
        l.Cf();
        return aVarFq.dT(BuildConfig.VERSION_CODE).fr(ExceptionMessage.getSdkCrashVersionName(l.Cf().getApiVersion(), 1)).dU(l.Cf().getApiVersionCode()).dV(1).fp("com.kwad.sdk").fs(context.getPackageName()).ft(ServiceProvider.getSDKConfig().appId).fu(ServiceProvider.getSDKConfig().appName).fv(m.cE(context)).fw(bVarAg.aPn).fx(bVarAg.aPo).fm(bd.getDeviceId()).fn(ServiceProvider.getSDKConfig().appId).fl(bVarAg.version).fy(bVarAg.aPq).fz(bVarAg.aPp).fk("Android").fo(strAn).a(new com.kwad.sdk.crash.h() { // from class: com.kwad.components.core.d.a.5
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a oH() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.fE(t.IC());
                aVar.putString("mKsadAppId", ServiceProvider.getSDKConfig().appId);
                aVar.putString("mKsadAppName", ServiceProvider.getSDKConfig().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", m.cE(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                l.Cf();
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 1));
                l.Cf();
                aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(l.Cf().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", l.Cf().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 214);
                for (b bVar : a.Og) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.a(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                n.aQ(context);
                if (i == 1 || i == 3 || i == 4) {
                    com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                }
                Iterator it = a.Oh.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onCrashOccur(i, exceptionMessage.mCrashDetail);
                }
            }
        }).d(oz()).e(oA()).H(e.EY()).m(e.a(com.kwad.sdk.core.config.c.aBl)).Lq();
    }

    private static String[] oz() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ah(KsAdSDKImpl.class.getName()));
            arrayList.add(ah(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(ah(CpuMemoryProfiler.class.getName()));
            arrayList.add(ah(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] oA() {
        String[] strArr = new String[1];
        try {
            String name = d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return strArr;
    }

    /* JADX INFO: renamed from: com.kwad.components.core.d.a$a, reason: collision with other inner class name */
    static class C0328a {
        public static String an(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            if (Build.VERSION.SDK_INT >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = context.getDataDir();
            if (dataDir != null) {
                return dataDir;
            }
            File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            return !file.exists() ? new File("/data/data/" + context.getPackageName()) : file;
        }
    }

    private static String ah(String str) {
        try {
            int iIndexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (iIndexOf > 0) {
                return str.substring(0, iIndexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }
}
