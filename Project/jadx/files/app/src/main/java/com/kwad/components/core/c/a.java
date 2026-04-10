package com.kwad.components.core.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.ksad.download.DownloadTask;
import com.kuaishou.aegon.Aegon;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.w;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.h;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.k;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean IB;
    private static final AtomicBoolean IC = new AtomicBoolean(false);
    private static List<Throwable> ID;

    /* JADX INFO: renamed from: com.kwad.components.core.c.a$a, reason: collision with other inner class name */
    static class C0392a {
        public static String ag(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = i2 >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!dataDir.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return dataDir;
        }
    }

    private static String ai(String str) {
        try {
            int iIndexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (iIndexOf > 0) {
                return str.substring(0, iIndexOf);
            }
            return null;
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
            return null;
        }
    }

    public static void b(Throwable th) {
        b.printStackTrace(th);
        if (IC.get()) {
            com.kwad.sdk.crash.b.f(th);
        } else {
            c(th);
        }
    }

    private static void c(Throwable th) {
        if (ID == null) {
            ID = new CopyOnWriteArrayList();
        }
        ID.add(th);
    }

    public static synchronized void initAsync(Context context) {
        if (context != null) {
            if (!IC.get() && !IB) {
                IB = true;
                g.execute(new av() { // from class: com.kwad.components.core.c.a.1
                    @Override // com.kwad.sdk.utils.av
                    public final void doTask() {
                        if (d.b(c.abr)) {
                            b.d("KsAdExceptionCollectorHelper", "init");
                            com.kwad.sdk.crash.b.a(a.mP());
                            a.IC.set(true);
                            a.mO();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mO() {
        List<Throwable> list = ID;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.crash.b.f(it.next());
        }
        ID.clear();
        ID = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.kwad.sdk.crash.c mP() {
        final Context context = ServiceProvider.getContext();
        return new c.a().bx(context).bb(d.b(com.kwad.sdk.core.config.c.acB)).bc(d.b(com.kwad.sdk.core.config.c.acC)).bd(KsAdSDKImpl.get().getIsExternal()).cZ(d.a(com.kwad.sdk.core.config.c.acD)).cY(d.a(com.kwad.sdk.core.config.c.acE)).df(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1)).bB(KsAdSDKImpl.get().getSDKVersionCode()).dg(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1)).bC(KsAdSDKImpl.get().getApiVersionCode()).bD(1).de("com.kwad.sdk").dh(context.getPackageName()).di(ServiceProvider.CF().appId).dj(ServiceProvider.CF().appName).dk(k.bS(context)).db(at.getDeviceId()).dc(ServiceProvider.CF().appId).da("Android").dd(C0392a.ag(context)).a(new h() { // from class: com.kwad.components.core.c.a.3
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a mV() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.dl(w.xu());
                aVar.putString("mKsadAppId", ServiceProvider.CF().appId);
                aVar.putString("mKsadAppName", ServiceProvider.CF().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", k.bS(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1));
                aVar.putInt("mKsadSdKVersionCode", KsAdSDKImpl.get().getSDKVersionCode());
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 417);
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.c.a.2
            @Override // com.kwad.sdk.crash.f
            public final void a(int i2, ExceptionMessage exceptionMessage) {
                com.kwad.sdk.g.tf();
                if (i2 == 1 || i2 == 3 || i2 == 4) {
                    b.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i2);
                }
            }
        }).d(mQ()).e(mR()).w(d.uj()).j(d.a(com.kwad.sdk.core.config.c.adw)).zI();
    }

    private static String[] mQ() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ai(KsAdSDKImpl.class.getName()));
            arrayList.add(ai(DownloadTask.class.getName()));
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
        }
        try {
            arrayList.add(ai(CpuMemoryProfiler.class.getName()));
            arrayList.add(ai(Aegon.class.getName()));
        } catch (Throwable th2) {
            b.printStackTraceOnly(th2);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] mR() {
        String[] strArr = new String[1];
        try {
            String name = com.kwad.sdk.crash.d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
        }
        return strArr;
    }
}
