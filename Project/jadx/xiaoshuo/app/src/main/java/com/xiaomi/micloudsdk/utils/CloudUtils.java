package com.xiaomi.micloudsdk.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import cn.kuaipan.android.utils.NetworkHelpers;
import cn.kuaipan.kss.KssDef;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.utils.ObjectUtils;
import com.xiaomi.micloudsdk.exception.CloudServerException;
import com.xiaomi.micloudsdk.request.CloudRequestHelper;
import com.xiaomi.micloudsdk.request.Request;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class CloudUtils {
    private static final String ACTION_COM_XIAOMI_ACTION_DATA_IN_TRANSFER = "com.xiaomi.action.DATA_IN_TRANSFER";
    public static final String CODE = "code";
    private static final int CODE_EXCEED_MAX_REDIRECT_COUNT = 10034;
    public static final int CODE_IS_INTERNATIONAL_ACCOUNT = 1;
    public static final int CODE_NOT_INTERNATIONAL_ACCOUNT = 0;
    private static final int CODE_REDIRECT = 308;
    public static final int CODE_UNKOWN_ERROR = 2;
    public static final String DATA = "data";
    private static final String EXTRA_MICLOUD_HOSTS = "extra_micloud_hosts";
    public static final String EXTRA_SYNC_MODE = "extra_sync_mode";
    public static final int EXTRA_VALUE_SYNC_MODE_ALL = 2;
    public static final int EXTRA_VALUE_SYNC_MODE_ONLY_WLAN = 1;
    public static final int EXTRA_VALUE_SYNC_MODE_STANDARD = 0;
    private static final int MAX_REDIRECT_COUNT = 15;
    private static final String PREF_MICLOUD_HOSTS = "pref_micloud_hosts";
    public static final String REDIRECT_URL = "redirectUrl";
    private static final int RESUME_SYNC_INTERVAL = 300000;
    private static final int RESUME_SYNC_INTERVAL_SECOND = 300;
    public static final String RETRY_AFTER = "retryAfter";
    private static final String RETRY_TIME = "retryTime";
    public static final int[] SERVER_RETRY_INTERVALS = {1000, 2000, 5000, 10000};
    public static final String URL_RELOCATION_BASE;
    private static final String URL_RELOCATION_QUERY;
    private static final boolean USE_PREVIEW;
    private static final String XIAOMI_ACCOUNT_TYPE = "com.xiaomi";
    public static final String X_XIAOMI_REDIRECT_COUNT = "X-XIAOMI-REDIRECT-COUNT";
    public static final String X_XIAOMI_SUPPORT_REDIRECT = "X-XIAOMI-SUPPORT-REDIRECT";
    public static Map<String, Object> sHostsCache;
    private static AtomicBoolean sIsUpdateMiCloudHosts;
    private static volatile boolean sNeedUpdateHosts;
    private static Object sUpdateMiCloudHostsLock;

    static {
        boolean z = XMPassport.USE_PREVIEW;
        USE_PREVIEW = z;
        String str = z ? "http://relocationapi.micloud.preview.n.xiaomi.net" : "http://relocationapi.micloud.xiaomi.net";
        URL_RELOCATION_BASE = str;
        URL_RELOCATION_QUERY = str + "/mic/relocation/v3/user/record";
        sHostsCache = new ConcurrentHashMap();
        sUpdateMiCloudHostsLock = new Object();
        sIsUpdateMiCloudHosts = new AtomicBoolean(false);
        sNeedUpdateHosts = true;
    }

    public static String checkRedirect(String str, int i) throws CloudServerException {
        if (i >= 15) {
            throw new CloudServerException(503, CODE_EXCEED_MAX_REDIRECT_COUNT, 300);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("code") == 308) {
                if (jSONObject.getJSONObject("data").optBoolean("isPermanent")) {
                    sNeedUpdateHosts = true;
                }
                return jSONObject.getJSONObject("data").getString(REDIRECT_URL);
            }
            if (jSONObject.getInt("code") == 503) {
                throw new CloudServerException(503, 503, jSONObject.getJSONObject("data").getInt("retryAfter"));
            }
            if (jSONObject.getInt("code") != CODE_EXCEED_MAX_REDIRECT_COUNT) {
                return null;
            }
            throw new CloudServerException(503, CODE_EXCEED_MAX_REDIRECT_COUNT, jSONObject.getJSONObject("data").getInt("retryAfter"));
        } catch (JSONException e) {
            Log.e(CloudRequestHelper.MICLOUD_TAG, "JSONException in checkRedirect():" + str, e);
            return null;
        }
    }

    public static boolean checkWifiAvailability(Context context) {
        NetworkInfo.State state = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState();
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    private static KssDef.NetState getCurNetState(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnected()) {
            return KssDef.NetState.UNKNOWN;
        }
        if (networkInfo.getType() == 1) {
            return KssDef.NetState.Wifi;
        }
        if (networkInfo.getType() != 0) {
            return KssDef.NetState.UNKNOWN;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return KssDef.NetState.MN2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return KssDef.NetState.MN3G;
            case 13:
            case 18:
            case 19:
            case 20:
                return KssDef.NetState.MN4G;
            default:
                return KssDef.NetState.UNKNOWN;
        }
    }

    private static String getHost(String str) {
        if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
            Log.d(CloudRequestHelper.MICLOUD_TAG, "Enter getHost key=" + str);
        }
        Object obj = sHostsCache.get(str);
        String str2 = (obj == null || !(obj instanceof String)) ? null : (String) obj;
        if (!TextUtils.isEmpty(str2)) {
            if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "Hit host cache directly return host = " + str2);
            }
            return str2;
        }
        String hostList = getHostList();
        if (TextUtils.isEmpty(hostList)) {
            if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "Hosts in SystemSettings/sp = null, return null");
            }
            return null;
        }
        try {
            Map<String, Object> mapJsonToMap = ObjectUtils.jsonToMap(new JSONObject(hostList));
            sHostsCache = mapJsonToMap;
            Object obj2 = mapJsonToMap.get(str);
            if (obj2 != null && (obj2 instanceof String)) {
                str2 = (String) obj2;
            }
            if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "find host in SystemSettings/sp return host = " + str2);
            }
            return str2;
        } catch (JSONException e) {
            Log.e(CloudRequestHelper.MICLOUD_TAG, "JSONException in getHost, return null", e);
            return null;
        }
    }

    private static String getHostList() {
        if (TextUtils.isEmpty(Request.getRegion())) {
            if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "getRegion null, get from sp");
            }
            return PreferenceManager.getDefaultSharedPreferences(Request.getContext()).getString(PREF_MICLOUD_HOSTS, "");
        }
        if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
            Log.d(CloudRequestHelper.MICLOUD_TAG, "getRegion not null, get from settings: " + Request.getRegion());
        }
        return Settings.System.getString(Request.getContext().getContentResolver(), EXTRA_MICLOUD_HOSTS);
    }

    public static KssDef.NetState getNetworkClass(Context context) {
        try {
            return getCurNetState(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
        } catch (Exception unused) {
            return KssDef.NetState.UNKNOWN;
        }
    }

    public static int getSyncMode() {
        return Settings.System.getInt(Request.getContext().getContentResolver(), EXTRA_SYNC_MODE, 0);
    }

    public static String getUserAgent() {
        return Request.getRequestEnv().getUserAgent();
    }

    public static Account getXiaomiAccount() {
        Account[] accountsByType = AccountManager.get(Request.getContext()).getAccountsByType("com.xiaomi");
        if (accountsByType.length > 0) {
            return accountsByType[0];
        }
        return null;
    }

    public static int handle5xx(Context context, CloudServerException cloudServerException) {
        int i;
        int i2 = cloudServerException.statusCode;
        if (i2 / 100 != 5) {
            Log.e(CloudRequestHelper.MICLOUD_TAG, "Unrecognized server error " + cloudServerException.statusCode);
            return 0;
        }
        if (i2 != 503 || (i = cloudServerException.retryTime) <= 0) {
            i = 300000;
        }
        Log.w(CloudRequestHelper.MICLOUD_TAG, "Http 5xx error. retryTime: " + i);
        return i;
    }

    public static void handleSendDataInTransferBroadCast(Context context, CloudServerException cloudServerException) {
        if (cloudServerException.code != 503 || cloudServerException.retryTime <= 0) {
            return;
        }
        Intent intent = new Intent(ACTION_COM_XIAOMI_ACTION_DATA_IN_TRANSFER);
        intent.putExtra(RETRY_TIME, cloudServerException.retryTime);
        context.sendBroadcast(intent);
    }

    public static int isInternationalAccount(boolean z) {
        if (z) {
            sHostsCache.clear();
        }
        if (sHostsCache.isEmpty()) {
            sNeedUpdateHosts = true;
            try {
                updateMiCloudHosts();
                if (sHostsCache.isEmpty()) {
                    return 2;
                }
            } catch (CloudServerException e) {
                Log.e(CloudRequestHelper.MICLOUD_TAG, "CloudServerException in isInternationalAccount", e);
                return 2;
            }
        }
        Iterator<String> it = sHostsCache.keySet().iterator();
        if (!it.hasNext()) {
            return 2;
        }
        String next = it.next();
        return next.equals(sHostsCache.get(next)) ? 0 : 1;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }

    private static void setHostList(String str) {
        if (TextUtils.isEmpty(Request.getRegion())) {
            if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "getRegion null, set to sp");
            }
            PreferenceManager.getDefaultSharedPreferences(Request.getContext()).edit().putString(PREF_MICLOUD_HOSTS, str).apply();
        } else {
            if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "getRegion not null, set to settings: " + Request.getRegion());
            }
            Settings.System.putString(Request.getContext().getContentResolver(), EXTRA_MICLOUD_HOSTS, str);
        }
    }

    public static void setSyncMode(int i) {
        Settings.System.putInt(Request.getContext().getContentResolver(), EXTRA_SYNC_MODE, i);
    }

    public static boolean shouldUpdateHost() {
        return Request.getRequestEnv().shouldUpdateHost();
    }

    private static void updateMiCloudHosts() throws CloudServerException {
        if (sNeedUpdateHosts) {
            try {
                try {
                    if (!sIsUpdateMiCloudHosts.getAndSet(true)) {
                        Log.d(CloudRequestHelper.MICLOUD_TAG, "updateMiCloudHosts " + Thread.currentThread().getName());
                        HashMap map = new HashMap();
                        try {
                            String str = (String) Class.forName("miui.os.Build").getField("REGION").get(null);
                            Request.setRegion(str);
                            map.put("romCountry", str);
                        } catch (ClassNotFoundException unused) {
                            Log.d(CloudRequestHelper.MICLOUD_TAG, "Not in MIUI in updateMiCloudHosts");
                            map.put("romCountry", Request.getRegion());
                        } catch (IllegalAccessException unused2) {
                            Log.d(CloudRequestHelper.MICLOUD_TAG, "Not in MIUI in updateMiCloudHosts");
                        } catch (IllegalArgumentException unused3) {
                            Log.d(CloudRequestHelper.MICLOUD_TAG, "Not in MIUI in updateMiCloudHosts");
                        } catch (NoSuchFieldException unused4) {
                            Log.d(CloudRequestHelper.MICLOUD_TAG, "Not in MIUI in updateMiCloudHosts");
                        }
                        int i = 0;
                        while (!Thread.currentThread().isInterrupted()) {
                            try {
                            } catch (IllegalBlockSizeException e) {
                                Log.e(CloudRequestHelper.MICLOUD_TAG, "IllegalBlockSizeException in updateMiCloudHosts", e);
                                throw new CloudServerException(0);
                            } catch (ClientProtocolException e2) {
                                Log.e(CloudRequestHelper.MICLOUD_TAG, "ClientProtocolException in updateMiCloudHosts", e2);
                                throw new CloudServerException(0);
                            } catch (IOException e3) {
                                Log.e(CloudRequestHelper.MICLOUD_TAG, "IOException in updateMiCloudHosts", e3);
                                if (!NetworkHelpers.isNetworkAvailable(Request.getContext())) {
                                    Log.d(CloudRequestHelper.MICLOUD_TAG, "No network in IOException");
                                    throw new CloudServerException(0);
                                }
                            } catch (BadPaddingException e4) {
                                Log.e(CloudRequestHelper.MICLOUD_TAG, "BadPaddingException in updateMiCloudHosts", e4);
                                throw new CloudServerException(0);
                            } catch (JSONException e5) {
                                Log.e(CloudRequestHelper.MICLOUD_TAG, "JSONException in updateMiCloudHosts", e5);
                                throw new CloudServerException(0);
                            }
                            if (TextUtils.isEmpty(Request.getRequestEnv().getAccountName())) {
                                sIsUpdateMiCloudHosts.set(false);
                                synchronized (sUpdateMiCloudHostsLock) {
                                    sUpdateMiCloudHostsLock.notifyAll();
                                }
                                return;
                            }
                            JSONObject jSONObject = new JSONObject(Request.securePost(URL_RELOCATION_QUERY, map));
                            if (jSONObject.getInt("code") == 0) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("data").getJSONObject("hostList");
                                if (jSONObject2 != null) {
                                    Log.d(CloudRequestHelper.MICLOUD_TAG, "getHostList set sNeedUpdateHosts to false " + Thread.currentThread().getName());
                                    setHostList(jSONObject2.toString());
                                    sHostsCache = ObjectUtils.jsonToMap(jSONObject2);
                                    sNeedUpdateHosts = false;
                                }
                            }
                            int[] iArr = SERVER_RETRY_INTERVALS;
                            if (i >= iArr.length) {
                                throw new CloudServerException(0);
                            }
                            Log.e(CloudRequestHelper.MICLOUD_TAG, "Wait " + iArr[i] + " ms for retry");
                            Thread.sleep((long) iArr[i]);
                            i++;
                        }
                        throw new InterruptedException();
                    }
                    synchronized (sUpdateMiCloudHostsLock) {
                        Log.v(CloudRequestHelper.MICLOUD_TAG, "Waiting for an existing updateMiCloudHosts to finish " + Thread.currentThread().getName());
                        sUpdateMiCloudHostsLock.wait();
                        Log.v(CloudRequestHelper.MICLOUD_TAG, "The existing updateMiCloudHosts finished " + Thread.currentThread().getName());
                    }
                    sIsUpdateMiCloudHosts.set(false);
                    synchronized (sUpdateMiCloudHostsLock) {
                        sUpdateMiCloudHostsLock.notifyAll();
                    }
                } catch (InterruptedException e6) {
                    Log.e(CloudRequestHelper.MICLOUD_TAG, "InterruptedException in updateMiCloudHosts", e6);
                    throw new CloudServerException(0);
                }
            } catch (Throwable th) {
                sIsUpdateMiCloudHosts.set(false);
                synchronized (sUpdateMiCloudHostsLock) {
                    sUpdateMiCloudHostsLock.notifyAll();
                    throw th;
                }
            }
        }
    }

    public static String updateRequestHost(String str) throws CloudServerException {
        updateMiCloudHosts();
        try {
            URL url = new URL(str);
            String host = url.getHost();
            String host2 = getHost(host);
            return (TextUtils.isEmpty(host2) || host.equals(host2)) ? str : new URL(url.getProtocol(), host2, url.getFile()).toString();
        } catch (MalformedURLException e) {
            Log.e(CloudRequestHelper.MICLOUD_TAG, "MalformedURLException in updateHost", e);
            return str;
        }
    }
}
