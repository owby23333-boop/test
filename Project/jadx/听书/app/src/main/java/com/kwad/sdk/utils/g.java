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
import androidx.media3.session.MediaController;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static Messenger aYt;
    private static volatile ExecutorService aYu;
    private static volatile AppStatusRules aYv;
    private static com.kwad.sdk.collector.h aYw;
    private static Handler aeD;
    private static WeakReference<Context> aeJ;
    private static ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                if (g.Ps()) {
                    messageObtain.replyTo = g.aYt;
                    try {
                        messenger.send(messageObtain);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                com.kwad.sdk.core.d.c.w("AppStatusHelper", "clientMessenger init error");
            } catch (SecurityException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.service.d.gatherException(e);
            }
        }
    };

    public interface b {
        void x(List<com.kwad.sdk.collector.model.b> list);
    }

    public static AppStatusRules Pr() {
        return aYv;
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || context == null || com.kwad.sdk.utils.d.cr(context)) {
            return;
        }
        aYw = hVar;
        boolean zIsInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isMainProcess: " + zIsInMainProcess);
        if (zIsInMainProcess) {
            aeJ = new WeakReference<>(context);
            if (aeD == null) {
                aeD = new Handler(Looper.getMainLooper());
            }
            aeD.postDelayed(new AnonymousClass2(context), MediaController.RELEASE_UNBIND_TIMEOUT_MS);
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.utils.g$2, reason: invalid class name */
    final class AnonymousClass2 extends bg {
        final /* synthetic */ Context dq;

        AnonymousClass2(Context context) {
            this.dq = context;
        }

        @Override // com.kwad.sdk.utils.bg
        public final void doTask() {
            com.kwad.sdk.collector.c.a(this.dq, new c.a() { // from class: com.kwad.sdk.utils.g.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.dq);
                    AppStatusRules unused = g.aYv = appStatusRules;
                    g.b(AnonymousClass2.this.dq, g.aYv);
                    g.ct(AnonymousClass2.this.dq);
                    boolean zEd = br.ed(AnonymousClass2.this.dq);
                    boolean zIsAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(g.aYv);
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + zIsAppStatusTargetNotEmpty + ", permissionGranted: " + zEd);
                    if (zEd && zIsAppStatusTargetNotEmpty) {
                        long jObtainDefaultScanInterval = g.aYv.obtainDefaultScanInterval();
                        if (jObtainDefaultScanInterval <= 0) {
                            g.cv(AnonymousClass2.this.dq);
                        } else {
                            g.c(AnonymousClass2.this.dq, jObtainDefaultScanInterval);
                        }
                    }
                    boolean zIsUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(g.aYv);
                    boolean z = g.aYv.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + zIsUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (zIsUploadTargetNotEmpty && z && zEd) {
                        g.Pt();
                        g.aYu.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.dq, g.aYv);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.d.gatherException(th);
                                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void s(int i, String str) {
                    com.kwad.sdk.core.d.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    public static void ct(Context context) {
        if (aYv == null) {
            aYv = cu(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Ps() {
        if (aYt == null) {
            try {
                aYt = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return aYt != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String string = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.k(file.getAbsolutePath(), com.kwad.sdk.core.a.c.encodeKsSdk(string), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Pt() {
        if (aYu == null) {
            synchronized (g.class) {
                if (aYu == null) {
                    ExecutorService executorServiceJx = GlobalThreadPools.Jx();
                    aYu = executorServiceJx;
                    com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) executorServiceJx, "appStatusHelper");
                }
            }
        }
    }

    private static AppStatusRules cu(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String strJ = com.kwad.sdk.crash.utils.h.J(file);
            if (TextUtils.isEmpty(strJ)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.isEncodeKsSdk(strJ)) {
                strJ = com.kwad.sdk.core.a.c.decodeKsSdk(strJ);
            }
            JSONObject jSONObject = new JSONObject(strJ);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(final Context context, final long j) {
        if (aeD == null) {
            aeD = new Handler(Looper.getMainLooper());
        }
        aeD.post(new bg() { // from class: com.kwad.sdk.utils.g.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                g.cv(context);
                g.aeD.postDelayed(this, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cv(Context context) {
        if (context == null) {
            return;
        }
        boolean zPu = Pu();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isServiceAvailable: " + zPu);
        if (zPu) {
            com.kwad.sdk.collector.b.a.a(context, serviceConnection);
        } else {
            a(context, new d(null));
        }
    }

    private static boolean Pu() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = ServiceProvider.getContext();
                return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
            }
        } catch (ClassNotFoundException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        return false;
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.d.cr(context)) {
            return;
        }
        Pt();
        aYu.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.4
            @Override // java.lang.Runnable
            public final void run() {
                List listCw;
                try {
                    HashSet hashSet = new HashSet();
                    if (!br.ed(context) || (listCw = g.cw(context)) == null) {
                        return;
                    }
                    Iterator it = listCw.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(listCw);
                    if (bVar != null) {
                        bVar.x(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    com.kwad.sdk.service.d.gatherException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.kwad.sdk.collector.model.b> cw(Context context) {
        if (!br.ed(context)) {
            return new ArrayList();
        }
        if (aYv == null) {
            aYv = cu(context);
        }
        return cx(context);
    }

    private static List<com.kwad.sdk.collector.model.b> cx(Context context) {
        ArrayList arrayList = new ArrayList();
        if (bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.d.cr(context)) {
            return arrayList;
        }
        AppStatusRules appStatusRulesPr = Pr();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(appStatusRulesPr)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy strategyD = com.kwad.sdk.collector.i.d(appStatusRulesPr);
        arrayList.addAll(a(strategyD));
        strategyD.setNeedSaveLaunchTime(System.currentTimeMillis());
        return O(arrayList);
    }

    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean zIsNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + zIsNeedLaunch);
        if (!zIsNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.DF().a(strategy);
    }

    private static List<com.kwad.sdk.collector.model.b> O(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static class a implements com.kwad.sdk.core.b {
        private List<Long> aYC = new ArrayList();
        private String appName;
        private String packageName;

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        public a() {
        }

        public static JSONArray P(List<com.kwad.sdk.collector.model.b> list) {
            List<a> listQ;
            try {
                listQ = Q(list);
            } catch (Exception e) {
                com.kwad.sdk.service.d.gatherException(e);
                listQ = null;
            }
            if (listQ == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = listQ.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            return jSONArray;
        }

        private static List<a> Q(List<com.kwad.sdk.collector.model.b> list) {
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
                            aVar.aY(jC);
                        }
                    }
                    return new ArrayList(map.values());
                } catch (ClassCastException e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
            return null;
        }

        private void aY(long j) {
            this.aYC.add(Long.valueOf(j));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString("packageName");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("runningTimes");
            if (jSONArrayOptJSONArray != null) {
                this.aYC.clear();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.aYC.add(Long.valueOf(jSONArrayOptJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "appName", this.appName);
            aa.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.aYC.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            aa.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    static class d implements b {
        private b aYE = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.g.b
        public final void x(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray jSONArrayP = a.P(list);
            if (jSONArrayP != null) {
                g.aYw.c(jSONArrayP);
            }
            b bVar = this.aYE;
            if (bVar != null) {
                bVar.x(list);
            }
        }
    }

    static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                c(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }

        private void c(Message message) {
            ArrayList arrayList;
            List listA;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> listA2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        listA = aa.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.g.c.1
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ com.kwad.sdk.core.b Ef() {
                                return PD();
                            }

                            private static a PD() {
                                return new a();
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
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    c((ArrayList<com.kwad.sdk.collector.model.b>) arrayList);
                }
                if (listA != null) {
                    R(listA);
                }
            }
            if (g.aeJ != null && g.aeJ.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        listA2 = aa.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.g.c.2
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ com.kwad.sdk.core.b Ef() {
                                return PE();
                            }

                            private static AppStatusRules.Strategy PE() {
                                return new AppStatusRules.Strategy();
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
                            com.kwad.sdk.collector.i.a((Context) g.aeJ.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (g.aeJ == null || g.serviceConnection == null) {
                return;
            }
            com.kwad.sdk.core.d.c.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.b.a.b((Context) g.aeJ.get(), g.serviceConnection);
        }

        private static void c(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray jSONArrayP;
            if (arrayList == null || (jSONArrayP = a.P(arrayList)) == null) {
                return;
            }
            g.aYw.c(jSONArrayP);
        }

        private static void R(List<a> list) {
            if (list == null) {
                return;
            }
            g.aYw.c(aa.S(list));
        }
    }
}
