package d.a.j;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.c;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import anetwork.channel.http.NetworkSdkSetting;
import com.ss.android.download.api.constant.BaseConstants;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile boolean a = true;
    private static volatile boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f20697c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f20698d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f20699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile long f20700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f20701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, List<String>> f20702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f20703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final List<String> f20704j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile int f20705k = 10000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f20706l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f20707m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile int f20708n = BaseConstants.Time.MINUTE;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f20709o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, List<String>> f20710p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile boolean f20711q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static volatile boolean f20712r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static volatile boolean f20713s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static volatile boolean f20714t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static volatile a f20715u;

    public static void a(a aVar) {
        if (f20715u != null) {
            f20715u.unRegister();
        }
        if (aVar != null) {
            aVar.register();
        }
        f20715u = aVar;
    }

    public static boolean b(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = f20702h) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == f20704j) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void c() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext());
        f20700f = defaultSharedPreferences.getLong("Cache.Flag", 0L);
        f20712r = defaultSharedPreferences.getBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", false);
        f20713s = defaultSharedPreferences.getBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", true);
    }

    public static void c(boolean z2) {
    }

    public static boolean d() {
        return f20697c && f20699e;
    }

    public static void e(boolean z2) {
        f20698d = z2;
    }

    public static void f(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateWhiteUrlList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f20702h = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, f20704j);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        f20702h = concurrentHashMap;
    }

    public static void f(boolean z2) {
    }

    public static void g(boolean z2) {
        f20711q = z2;
    }

    public static void h(boolean z2) {
        f20706l = z2;
    }

    public static void i(boolean z2) {
        ALog.i("anet.NetworkConfigCenter", "[setSpdyEnabled]", null, "enable", Boolean.valueOf(z2));
        b = z2;
    }

    public static boolean j() {
        return f20697c;
    }

    public static boolean k() {
        return f20711q;
    }

    public static boolean l() {
        return f20706l;
    }

    public static boolean m() {
        return a;
    }

    public static boolean n() {
        return b;
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            f20709o = null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(Constants.KEY_HOST);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (c.c(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f20709o = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
        }
    }

    public static void e(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateRequestWhiteList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f20703i = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f20703i = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse bizId failed", null, e2, new Object[0]);
        }
    }

    public static boolean g() {
        return f20714t;
    }

    public static boolean h() {
        return f20707m;
    }

    public static boolean i() {
        return f20698d;
    }

    public static void a(long j2) {
        if (j2 != f20700f) {
            ALog.i("anet.NetworkConfigCenter", "set cache flag", null, "old", Long.valueOf(f20700f), "new", Long.valueOf(j2));
            f20700f = j2;
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
            editorEdit.putLong("Cache.Flag", f20700f);
            editorEdit.apply();
            anetwork.channel.cache.a.a();
        }
    }

    public static void c(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "setDegradeRequestList", null, "Degrade List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f20710p = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, f20704j);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        f20710p = concurrentHashMap;
    }

    public static int b() {
        return f20705k;
    }

    public static void b(int i2) {
        f20705k = i2;
    }

    public static void b(boolean z2) {
        f20701g = z2;
    }

    public static void b(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    String string = jSONArray.getString(i2);
                    if (c.c(string)) {
                        arrayList.add(string);
                    }
                }
                HttpDispatcher.getInstance().addHosts(arrayList);
            } catch (JSONException e2) {
                ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = f20703i;
        if (f20703i == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void d(boolean z2) {
        f20712r = z2;
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        editorEdit.putBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", f20712r);
        editorEdit.apply();
    }

    public static boolean e() {
        return f20701g;
    }

    public static int a() {
        return f20708n;
    }

    public static void a(int i2) {
        f20708n = i2;
    }

    public static boolean a(RequestStatistic requestStatistic) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (requestStatistic == null || (copyOnWriteArrayList = f20709o) == null || TextUtils.isEmpty(requestStatistic.host)) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (requestStatistic.host.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = f20710p) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == f20704j) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean f() {
        return f20712r;
    }

    public static void a(boolean z2) {
        f20713s = z2;
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        editorEdit.putBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", f20713s);
        editorEdit.apply();
    }
}
