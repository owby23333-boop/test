package com.commoncomponent.apimonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.commoncomponent.apimonitor.bean.ApiMonitorDataBean;
import com.commoncomponent.apimonitor.bean.NetState;
import com.commoncomponent.apimonitor.okhttp.ApiMonitorCallBack;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;

/* JADX INFO: loaded from: classes10.dex */
public class ApiMonitorManager {
    public static final int SDK_VERSIONCODE = 2;
    private static final String TAG = "QA_EVENT_NET_MANAGER";
    private static ApiMonitorManager instance = null;
    private static final long leastErrorRequestReport = 3000;
    private static Set<String> needCheckExceptions = null;
    public static boolean showLog = false;
    private ApiMonitorCallBack apiMonitorCallBack;
    private String appId;
    private int appVersionCode;
    private String channel;
    private Context context;
    private BroadcastReceiver netReceiver;
    private volatile NetState netState;
    private NetStateThread netStateThread;
    private String userId;
    private int sdkVersionCode = 2;
    private Executor failReportConfirmTaskExecutors = Executors.newFixedThreadPool(3);
    private Map<String, Long> requestReportTimeDatas = Collections.synchronizedMap(new HashMap());
    private final Object requestReportTimeDatasLock = new Object();
    private volatile boolean isConnect = true;
    private volatile long time = 0;
    private final Object timeLock = new Object();
    private final long validTime = 30000;

    public class ConfirmNetRunnable implements Runnable {
        private ApiMonitorDataBean data;
        private String domain;

        /* JADX INFO: renamed from: net, reason: collision with root package name */
        private NetState f2156net;

        public ConfirmNetRunnable(ApiMonitorDataBean apiMonitorDataBean, NetState netState, String str) {
            this.data = apiMonitorDataBean;
            this.f2156net = netState;
            this.domain = str;
        }

        private boolean isRealConnectNet(String str) {
            if (SystemClock.elapsedRealtime() - ApiMonitorManager.this.time <= 30000) {
                if (ApiMonitorManager.showLog) {
                    ApiMonitorManager.getInstance().printLogD(ApiMonitorManager.TAG, "上一次真实网络状态有效B 连接状态:" + ApiMonitorManager.this.isConnect);
                }
                return ApiMonitorManager.this.isConnect;
            }
            synchronized (ConfirmNetRunnable.class) {
                if (SystemClock.elapsedRealtime() - ApiMonitorManager.this.time <= 30000) {
                    if (ApiMonitorManager.showLog) {
                        ApiMonitorManager.getInstance().printLogD(ApiMonitorManager.TAG, "上一次真实网络状态有效C 连接状态:" + ApiMonitorManager.this.isConnect);
                    }
                    return ApiMonitorManager.this.isConnect;
                }
                ApiMonitorManager.this.isConnect = HttpUtils.checkConnect(str);
                if (ApiMonitorManager.showLog) {
                    ApiMonitorManager.getInstance().printLogD(ApiMonitorManager.TAG, "上一次真实网络状态过期，重新验证，校验域名：" + str + "  连通结果为:" + ApiMonitorManager.this.isConnect);
                }
                synchronized (ApiMonitorManager.this.timeLock) {
                    ApiMonitorManager.this.time = SystemClock.elapsedRealtime();
                }
                return ApiMonitorManager.this.isConnect;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isRealConnectNet(this.domain)) {
                ApiMonitorManager.this.apiMonitorCallBack.onFailReport(this.data, this.f2156net);
            } else {
                ApiMonitorManager.this.apiMonitorCallBack.onFailReport(this.data, NetState.NOT_CONNECTED);
            }
        }
    }

    public class NetStateThread extends Thread {
        private Intent intent;
        private volatile boolean isValid;

        /* JADX INFO: Access modifiers changed from: private */
        public void stopTask() {
            this.isValid = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            NetState curNetState;
            super.run();
            if (this.isValid) {
                try {
                    NetworkInfo networkInfo = (NetworkInfo) this.intent.getParcelableExtra("networkInfo");
                    curNetState = networkInfo == null ? ApiMonitorManager.this.getCurNetState() : ApiMonitorManager.this.getCurNetState(networkInfo);
                } catch (Exception unused) {
                    curNetState = ApiMonitorManager.this.getCurNetState();
                }
                if (this.isValid && ApiMonitorManager.this.netState != curNetState) {
                    ApiMonitorManager.this.netState = curNetState;
                    ApiMonitorManager.this.initTime();
                }
            }
        }

        private NetStateThread(Intent intent) {
            this.isValid = true;
            this.intent = intent;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        needCheckExceptions = hashSet;
        hashSet.add(SSLHandshakeException.class.getName());
        needCheckExceptions.add(UnknownHostException.class.getName());
        needCheckExceptions.add(SocketTimeoutException.class.getName());
        needCheckExceptions.add(SSLProtocolException.class.getName());
        needCheckExceptions.add(SocketException.class.getName());
        needCheckExceptions.add(ConnectException.class.getName());
    }

    private ApiMonitorManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetState getCurNetState() {
        try {
            return getCurNetState(((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo());
        } catch (Exception unused) {
            return NetState.UNKNOWN;
        }
    }

    public static ApiMonitorManager getInstance() {
        if (instance == null) {
            synchronized (ApiMonitorManager.class) {
                if (instance == null) {
                    instance = new ApiMonitorManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTime() {
        synchronized (this.timeLock) {
            this.time = 0L;
        }
    }

    private void registerNetMonitor() {
        this.netState = getCurNetState();
        BroadcastReceiver broadcastReceiver = this.netReceiver;
        if (broadcastReceiver == null) {
            this.netReceiver = new BroadcastReceiver() { // from class: com.commoncomponent.apimonitor.ApiMonitorManager.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        if (ApiMonitorManager.this.netStateThread != null) {
                            ApiMonitorManager.this.netStateThread.stopTask();
                            ApiMonitorManager.this.netStateThread = null;
                        }
                        ApiMonitorManager.this.netStateThread = new NetStateThread(intent);
                        ApiMonitorManager.this.netStateThread.start();
                    }
                }
            };
        } else {
            this.context.unregisterReceiver(broadcastReceiver);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.context.registerReceiver(this.netReceiver, intentFilter);
    }

    private void reportFailDataWithCheckNet(ApiMonitorDataBean apiMonitorDataBean) {
        Executor executor;
        if (apiMonitorDataBean == null || this.apiMonitorCallBack == null) {
            return;
        }
        NetState netState = this.netState;
        NetState netState2 = NetState.NOT_CONNECTED;
        if (netState == netState2 || !needCheckExceptions.contains(apiMonitorDataBean.getErrorMsg())) {
            this.apiMonitorCallBack.onFailReport(apiMonitorDataBean, this.netState);
            return;
        }
        if (SystemClock.elapsedRealtime() - this.time > 30000) {
            String pingDomain = this.apiMonitorCallBack.getPingDomain();
            if (TextUtils.isEmpty(pingDomain) || (executor = this.failReportConfirmTaskExecutors) == null) {
                this.apiMonitorCallBack.onFailReport(apiMonitorDataBean, this.netState);
                return;
            } else {
                executor.execute(new ConfirmNetRunnable(apiMonitorDataBean, this.netState, pingDomain));
                return;
            }
        }
        if (showLog) {
            getInstance().printLogD(TAG, "上一次真实网络状态有效A 连接状态:" + this.isConnect);
        }
        if (this.isConnect) {
            this.apiMonitorCallBack.onFailReport(apiMonitorDataBean, this.netState);
        } else {
            this.apiMonitorCallBack.onFailReport(apiMonitorDataBean, netState2);
        }
    }

    public static void setShowLog(boolean z) {
        showLog = z;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getSdkVersionCode() {
        return this.sdkVersionCode;
    }

    public String getUserId() {
        return this.userId;
    }

    public ApiMonitorManager init(Context context, String str, String str2, int i, String str3, ApiMonitorCallBack apiMonitorCallBack) {
        this.context = context;
        this.appId = str;
        this.userId = str2;
        this.appVersionCode = i;
        this.channel = str3;
        if (apiMonitorCallBack == null) {
            printLogE("ApiMonitorManager", "apiMonitorCallBack==null，数据你咋拿");
        }
        this.apiMonitorCallBack = apiMonitorCallBack;
        registerNetMonitor();
        return this;
    }

    public void printLogD(String str, String str2) {
        if (showLog) {
            Log.d(str, str2);
        }
    }

    public void printLogE(String str, String str2) {
        if (showLog) {
            Log.e(str, str2);
        }
    }

    public void printLogI(String str, String str2) {
        if (showLog) {
            Log.i(str, str2);
        }
    }

    public void printLogV(String str, String str2) {
        if (showLog) {
            Log.v(str, str2);
        }
    }

    public void printLogW(String str, String str2) {
        if (showLog) {
            Log.w(str, str2);
        }
    }

    public void sendMonitorFailData(ApiMonitorDataBean apiMonitorDataBean) {
        boolean z;
        if (apiMonitorDataBean == null || this.apiMonitorCallBack == null) {
            return;
        }
        String str = apiMonitorDataBean.getScheme() + apiMonitorDataBean.getPath();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this.requestReportTimeDatasLock) {
            if (!this.requestReportTimeDatas.containsKey(str) || jElapsedRealtime - this.requestReportTimeDatas.get(str).longValue() >= 3000) {
                this.requestReportTimeDatas.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            reportFailDataWithCheckNet(apiMonitorDataBean);
        }
    }

    public void sendMonitorSuccessData(ApiMonitorDataBean apiMonitorDataBean) {
        if (apiMonitorDataBean == null || this.apiMonitorCallBack == null) {
            return;
        }
        String str = apiMonitorDataBean.getScheme() + apiMonitorDataBean.getPath();
        synchronized (this.requestReportTimeDatasLock) {
            this.requestReportTimeDatas.remove(str);
        }
        this.apiMonitorCallBack.onSuccessReport(apiMonitorDataBean, this.netState);
    }

    public ApiMonitorManager updateAccountId(String str) {
        this.userId = str;
        return this;
    }

    public ApiMonitorManager updateChannel(String str) {
        this.channel = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetState getCurNetState(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return NetState.WIFI;
            }
            if (networkInfo.getType() == 0) {
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return NetState.MOBILE_2G;
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
                        return NetState.MOBILE_3G;
                    case 13:
                    case 18:
                    case 19:
                        return NetState.MOBILE_4G;
                    case 20:
                        return NetState.MOBILE_5G;
                    default:
                        return NetState.UNKNOWN;
                }
            }
            if (networkInfo.getType() == 9) {
                return NetState.ETHERNET;
            }
            return NetState.UNKNOWN;
        }
        return NetState.NOT_CONNECTED;
    }
}
