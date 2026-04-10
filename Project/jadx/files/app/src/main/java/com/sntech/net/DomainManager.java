package com.sntech.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e0.c;
import e0.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DomainManager {
    private static final String TAG = "DomainManager";
    private Context mContext;
    private OkHttpClient mOkHttpClient;
    private Map<String, String> mAvailableTemplateDomains = new HashMap();
    private boolean mInited = false;

    /* JADX INFO: renamed from: com.sntech.net.DomainManager$do, reason: invalid class name */
    public class Cdo extends TypeToken<HashMap<String, String>> {
        public Cdo(DomainManager domainManager) {
        }
    }

    /* JADX INFO: renamed from: com.sntech.net.DomainManager$if, reason: invalid class name */
    public static class Cif {

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static final DomainManager f82do = new DomainManager();
    }

    private <T> boolean arrayContains(T[] tArr, T t2) {
        return arrayIndex(tArr, t2) >= 0;
    }

    private <T> int arrayIndex(T[] tArr, T t2) {
        if (tArr == null) {
            return -1;
        }
        int i2 = 0;
        if (t2 == null) {
            while (i2 < tArr.length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
        } else {
            while (i2 < tArr.length) {
                if (t2.equals(tArr[i2])) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    private void checkDomains(final Map<String, String[]> map) {
        String str = TAG;
        StringBuilder sbA = y.b.a("checkDomains, templateDomains = ");
        sbA.append(new Gson().toJson(map));
        i.c(str, sbA.toString());
        com.sntech.net.Cif.f90for.scheduleAtFixedRate(new Runnable() { // from class: com.sntech.net.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f17909s.a(map);
            }
        }, 0L, 180L, TimeUnit.SECONDS);
    }

    private static OkHttpClient createHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(10L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(10L, timeUnit).build();
    }

    @Keep
    public static DomainManager get() {
        return Cif.f82do;
    }

    @NonNull
    private Map<String, String> getAvailableTemplateDomains() {
        HashMap map = new HashMap(3);
        if (this.mAvailableTemplateDomains.size() > 0) {
            map.putAll(this.mAvailableTemplateDomains);
            return map;
        }
        Map<String, String> availableTemplateDomains = readAvailableTemplateDomains();
        if (availableTemplateDomains != null) {
            map.putAll(availableTemplateDomains);
        }
        return map;
    }

    private boolean isDomainAvailable(String str) {
        String str2 = "http://" + str + "/health";
        String str3 = TAG;
        i.c(str3, "isDomainAvailable: check " + str2);
        try {
            Response responseExecute = this.mOkHttpClient.newCall(new Request.Builder().url(str2).get().build()).execute();
            i.c(str3, "isDomainAvailable: code " + responseExecute.code());
            return responseExecute.isSuccessful();
        } catch (Exception e2) {
            e2.printStackTrace();
            i.b(TAG, "isDomainAvailable: error " + e2);
            return false;
        }
    }

    private boolean isNetworkConnected() {
        Context context = this.mContext;
        if (context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    @Nullable
    private Map<String, String> readAvailableTemplateDomains() {
        String string = this.mContext.getSharedPreferences("prefs_sn_android", 0).getString("template_domains_available", null);
        if (string != null) {
            return (Map) new Gson().fromJson(string, new Cdo(this).getType());
        }
        return null;
    }

    private void writeAvailableTemplateDomains(Map<String, String> map) {
        c.a(this.mContext, "template_domains_available", new Gson().toJson(map));
    }

    public /* synthetic */ void a(Map map) {
        String str = TAG;
        StringBuilder sbA = y.b.a("checkDomains, isNetworkConnected() = ");
        sbA.append(isNetworkConnected());
        i.c(str, sbA.toString());
        if (isNetworkConnected()) {
            HashMap map2 = new HashMap(3);
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = this.mAvailableTemplateDomains.get(str2);
                String[] strArr = (String[]) map.get(str2);
                int iArrayIndex = arrayIndex(strArr, str3);
                if (iArrayIndex < 0) {
                    iArrayIndex = 0;
                }
                int i2 = 0;
                while (true) {
                    if (i2 < strArr.length) {
                        String str4 = strArr[(i2 + iArrayIndex) % strArr.length];
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        boolean zIsDomainAvailable = isDomainAvailable(str4);
                        Iterator it2 = it;
                        String.format("#DomainManager: checkDomains: check domain %s isAvailable = %s cost %sms", str4, Boolean.valueOf(zIsDomainAvailable), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        if (zIsDomainAvailable) {
                            i.c(TAG, "checkDomains, put domain = " + str4);
                            map2.put(str2, str4);
                            it = it2;
                            break;
                        }
                        i2++;
                        it = it2;
                    }
                }
            }
            this.mAvailableTemplateDomains.putAll(map2);
            writeAvailableTemplateDomains(this.mAvailableTemplateDomains);
            String str5 = TAG;
            StringBuilder sbA2 = y.b.a("checkDomains: AvailableTemplateDomains = ");
            sbA2.append(new Gson().toJson(this.mAvailableTemplateDomains));
            i.c(str5, sbA2.toString());
        }
    }

    @Keep
    public String getDomainByTemplate(String str) {
        return this.mAvailableTemplateDomains.containsKey(str) ? this.mAvailableTemplateDomains.get(str) : str;
    }

    @Keep
    public synchronized void init(@NonNull Context context, @NonNull DomainConfig domainConfig) {
        if (this.mInited) {
            return;
        }
        i.c(TAG, "init");
        if (com.sntech.net.Cif.f90for == null) {
            throw new IllegalStateException("NetClient should be initialized first!");
        }
        this.mContext = context;
        this.mOkHttpClient = createHttpClient();
        Map<String, String> availableTemplateDomains = getAvailableTemplateDomains();
        this.mAvailableTemplateDomains.clear();
        for (String str : domainConfig.getTemplateDomains().keySet()) {
            String str2 = availableTemplateDomains.get(str);
            if (str2 == null || !arrayContains(domainConfig.getTemplateDomains().get(str), str2)) {
                this.mAvailableTemplateDomains.put(str, ((String[]) Objects.requireNonNull(domainConfig.getTemplateDomains().get(str)))[0]);
            } else {
                this.mAvailableTemplateDomains.put(str, str2);
            }
        }
        String str3 = TAG;
        StringBuilder sbA = y.b.a("init: AvailableTemplateDomains = ");
        sbA.append(new Gson().toJson(this.mAvailableTemplateDomains));
        i.c(str3, sbA.toString());
        checkDomains(domainConfig.getTemplateDomains());
        this.mInited = true;
    }
}
