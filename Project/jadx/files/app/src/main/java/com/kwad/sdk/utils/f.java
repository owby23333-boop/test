package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static Handler Ui;
    private static ServiceConnection ahi = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                if (!f.CI()) {
                    com.kwad.sdk.core.d.b.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                messageObtain.replyTo = f.axO;
                try {
                    messenger.send(messageObtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                com.kwad.sdk.service.b.gatherException(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private static Messenger axO;
    private static volatile ExecutorService axP;
    private static volatile AppStatusRules axQ;
    private static WeakReference<Context> axR;
    private static com.kwad.sdk.collector.h axS;

    /* JADX INFO: renamed from: com.kwad.sdk.utils.f$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context jL;

        AnonymousClass2(Context context) {
            this.jL = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.collector.c.a(this.jL, new c.a() { // from class: com.kwad.sdk.utils.f.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.jL);
                    AppStatusRules unused = f.axQ = appStatusRules;
                    f.b(AnonymousClass2.this.jL, f.axQ);
                    f.bJ(AnonymousClass2.this.jL);
                    boolean zDr = bc.dr(AnonymousClass2.this.jL);
                    boolean zIsAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.axQ);
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "appStatusTargetNotEmpty: " + zIsAppStatusTargetNotEmpty + ", permissionGranted: " + zDr);
                    if (zDr && zIsAppStatusTargetNotEmpty) {
                        long jObtainDefaultScanInterval = f.axQ.obtainDefaultScanInterval();
                        if (jObtainDefaultScanInterval > 0) {
                            f.c(AnonymousClass2.this.jL, jObtainDefaultScanInterval);
                        } else {
                            f.bL(AnonymousClass2.this.jL);
                        }
                    }
                    boolean zIsUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.axQ);
                    boolean z2 = f.axQ.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "uploadTargetNotEmpty: " + zIsUploadTargetNotEmpty + ", enableUpload: " + z2);
                    if (zIsUploadTargetNotEmpty && z2 && zDr) {
                        f.CJ();
                        f.axP.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.jL, f.axQ);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.b.gatherException(th);
                                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void h(int i2, String str) {
                    com.kwad.sdk.core.d.b.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i2);
                }
            });
        }
    }

    public static class a implements com.kwad.sdk.core.b {
        private String appName;
        private List<Long> axY = new ArrayList();
        private String packageName;

        public a() {
        }

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        public static JSONArray B(List<com.kwad.sdk.collector.model.b> list) {
            List<a> listC;
            try {
                listC = C(list);
            } catch (Exception e2) {
                com.kwad.sdk.service.b.gatherException(e2);
                listC = null;
            }
            if (listC == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = listC.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            return jSONArray;
        }

        @Nullable
        private static List<a> C(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap map = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String strB = com.kwad.sdk.collector.model.c.b(bVar);
                        if (map.containsKey(strB)) {
                            aVar = (a) map.get(strB);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            map.put(strB, aVar2);
                            aVar = aVar2;
                        }
                        long jC = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.af(jC);
                        }
                    }
                    return new ArrayList(map.values());
                } catch (ClassCastException e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            }
            return null;
        }

        private void af(long j2) {
            this.axY.add(Long.valueOf(j2));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString(DispatchConstants.APP_NAME);
            this.packageName = jSONObject.optString("packageName");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("runningTimes");
            if (jSONArrayOptJSONArray != null) {
                this.axY.clear();
                int length = jSONArrayOptJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        this.axY.add(Long.valueOf(jSONArrayOptJSONArray.getLong(i2)));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, DispatchConstants.APP_NAME, this.appName);
            s.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.axY.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            s.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    public interface b {
        void n(List<com.kwad.sdk.collector.model.b> list);
    }

    static class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        private static void D(List<a> list) {
            if (list == null) {
                return;
            }
            f.axS.c(s.E(list));
        }

        private static void a(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray jSONArrayB;
            if (arrayList == null || (jSONArrayB = a.B(arrayList)) == null) {
                return;
            }
            f.axS.c(jSONArrayB);
        }

        private void b(Message message) {
            ArrayList arrayList;
            List listA;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> listA2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        listA = s.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.f.c.1
                            private static a CS() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ com.kwad.sdk.core.b uf() {
                                return CS();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        listA = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    listA = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    a(arrayList);
                }
                if (listA != null) {
                    D(listA);
                }
            }
            if (f.axR != null && f.axR.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        listA2 = s.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            private static AppStatusRules.Strategy CT() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ com.kwad.sdk.core.b uf() {
                                return CT();
                            }
                        });
                    }
                } else {
                    listA2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (listA2 != null) {
                    for (AppStatusRules.Strategy strategy : listA2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) f.axR.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (f.axR == null || f.ahi == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.a.a.b((Context) f.axR.get(), f.ahi);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                b(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }

    static class d implements b {
        private b aya = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.f.b
        public final void n(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray jSONArrayB = a.B(list);
            if (jSONArrayB != null) {
                f.axS.c(jSONArrayB);
            }
            b bVar = this.aya;
            if (bVar != null) {
                bVar.n(list);
            }
        }
    }

    private static List<com.kwad.sdk.collector.model.b> A(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static AppStatusRules CH() {
        return axQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean CI() {
        if (axO == null) {
            try {
                axO = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return axO != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void CJ() {
        if (axP != null) {
            return;
        }
        axP = com.kwad.sdk.core.threads.b.ye();
    }

    private static boolean CK() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = KsAdSDK.getContext();
                return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
            }
        } catch (ClassNotFoundException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return false;
    }

    @NonNull
    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean zIsNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + zIsNeedLaunch);
        return !zIsNeedLaunch ? new ArrayList() : com.kwad.sdk.collector.b.tO().a(strategy);
    }

    public static void a(Context context, long j2, com.kwad.sdk.collector.h hVar) {
        if (as.Eb() || com.kwad.sdk.core.config.d.D(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || context == null || com.kwad.sdk.utils.c.bH(context)) {
            return;
        }
        axS = hVar;
        boolean zIsInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "isMainProcess: " + zIsInMainProcess);
        if (zIsInMainProcess) {
            axR = new WeakReference<>(context);
            if (Ui == null) {
                Ui = new Handler(Looper.getMainLooper());
            }
            Ui.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || as.Eb() || com.kwad.sdk.core.config.d.D(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bH(context)) {
            return;
        }
        CJ();
        axP.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            @Override // java.lang.Runnable
            public final void run() {
                List listBM;
                try {
                    HashSet hashSet = new HashSet();
                    if (!bc.dr(context) || (listBM = f.bM(context)) == null) {
                        return;
                    }
                    Iterator it = listBM.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.b.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(listBM);
                    if (bVar != null) {
                        bVar.n(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    com.kwad.sdk.service.b.gatherException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String string = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.g(file.getAbsolutePath(), com.kwad.sdk.core.kwai.c.bG(string), false);
    }

    @WorkerThread
    public static void bJ(Context context) {
        if (axQ == null) {
            axQ = bK(context);
        }
    }

    @Nullable
    @WorkerThread
    private static AppStatusRules bK(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String strD = com.kwad.sdk.crash.utils.h.D(file);
            if (TextUtils.isEmpty(strD)) {
                return null;
            }
            if (com.kwad.sdk.core.kwai.c.bI(strD)) {
                strD = com.kwad.sdk.core.kwai.c.bH(strD);
            }
            JSONObject jSONObject = new JSONObject(strD);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bL(Context context) {
        if (context == null) {
            return;
        }
        boolean zCK = CK();
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "isServiceAvailable: " + zCK);
        if (zCK) {
            com.kwad.sdk.collector.a.a.a(context, ahi);
        } else {
            a(context, new d(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> bM(Context context) {
        if (!bc.dr(context)) {
            return new ArrayList();
        }
        if (axQ == null) {
            axQ = bK(context);
        }
        return bN(context);
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    private static List<com.kwad.sdk.collector.model.b> bN(Context context) {
        ArrayList arrayList = new ArrayList();
        if (as.Eb() || com.kwad.sdk.core.config.d.D(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bH(context)) {
            return arrayList;
        }
        AppStatusRules appStatusRulesCH = CH();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(appStatusRulesCH)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy strategyD = com.kwad.sdk.collector.i.d(appStatusRulesCH);
        arrayList.addAll(a(strategyD));
        strategyD.setNeedSaveLaunchTime(System.currentTimeMillis());
        return A(arrayList);
    }

    public static void c(final Context context, final long j2) {
        if (Ui == null) {
            Ui = new Handler(Looper.getMainLooper());
        }
        Ui.post(new Runnable() { // from class: com.kwad.sdk.utils.f.3
            @Override // java.lang.Runnable
            public final void run() {
                f.bL(context);
                f.Ui.postDelayed(this, j2);
            }
        });
    }
}
