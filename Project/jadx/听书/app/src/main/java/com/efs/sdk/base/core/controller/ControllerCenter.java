package com.efs.sdk.base.core.controller;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.a.c;
import com.efs.sdk.base.core.config.b;
import com.efs.sdk.base.core.controller.a.a;
import com.efs.sdk.base.core.e.d;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.core.util.d;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.comm.pi.ACTD;
import com.umeng.umcrash.UMCrash;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public class ControllerCenter implements Handler.Callback {
    private static GlobalEnvStruct h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1556a = 0;
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private volatile boolean f = false;
    private a g;
    private Handler i;

    public ControllerCenter(EfsReporter.Builder builder) {
        h = builder.getGlobalEnvStruct();
        Handler handler = new Handler(com.efs.sdk.base.core.util.concurrent.a.f1581a.getLooper(), this);
        this.i = handler;
        handler.sendEmptyMessage(0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            b bVar = b.a.f1555a;
            Log.e("ballack", "initGlobalInfo called once.");
            bVar.f1554a = new com.efs.sdk.base.core.config.a();
            bVar.f1554a.a(ACTD.APPID_KEY, getGlobalEnvStruct().getAppid());
            int iMyPid = ProcessUtil.myPid();
            bVar.f1554a.a("pid", Integer.valueOf(iMyPid));
            bVar.f1554a.a("ps", ProcessUtil.getProcessName(iMyPid));
            String strA = d.a(bVar.b);
            bVar.f1554a.a("wid", strA);
            if (TextUtils.isEmpty(getGlobalEnvStruct().getUid())) {
                bVar.f1554a.a("uid", strA);
            } else {
                bVar.f1554a.a("uid", getGlobalEnvStruct().getUid());
            }
            com.efs.sdk.base.core.config.a aVar = bVar.f1554a;
            com.efs.sdk.base.core.a.a.a();
            aVar.a("stime", Long.valueOf(com.efs.sdk.base.core.a.a.b() - Process.getElapsedCpuTime()));
            bVar.f1554a.a("pkg", PackageUtil.getPackageName(bVar.b));
            bVar.f1554a.a("ver", PackageUtil.getAppVersionName(bVar.b));
            bVar.f1554a.a("vcode", PackageUtil.getAppVersionCode(bVar.b));
            bVar.f1554a.a("sdk_ver", BuildConfig.VERSION_NAME);
            bVar.f1554a.a("brand", Build.BRAND.toLowerCase());
            bVar.f1554a.a("model", Build.MODEL == null ? "unknown" : Build.MODEL.replace(" ", "-").replace("_", "-").toLowerCase());
            bVar.f1554a.a("build_model", Build.MODEL);
            DisplayMetrics displayMetrics = bVar.b.getResources().getDisplayMetrics();
            bVar.f1554a.a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
            bVar.f1554a.a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
            bVar.f1554a.a("fr", "android");
            bVar.f1554a.a("rom", Build.VERSION.RELEASE);
            bVar.f1554a.a("sdk", Integer.valueOf(Build.VERSION.SDK_INT));
            bVar.f1554a.a("lang", Locale.getDefault().getLanguage());
            bVar.f1554a.a("tzone", TimeZone.getDefault().getID());
            bVar.f1554a.a(TKDownloadReason.KSAD_TK_NET, NetworkUtil.getNetworkType(bVar.b));
            try {
                String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(bVar.b);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    bVar.f1554a.a(UMCrash.KEY_HEADER_ACCESS, "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    bVar.f1554a.a(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
                } else {
                    bVar.f1554a.a(UMCrash.KEY_HEADER_ACCESS, "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    bVar.f1554a.a(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
                }
                bVar.f1554a.a(UMCrash.KEY_HEADER_NETWORK_TYPE, Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(bVar.b)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f unused = f.a.f1544a;
            c.a().b();
            a();
            com.efs.sdk.base.core.f.f fVar = f.a.f1570a;
            boolean zIsIntl = h.isIntl();
            com.efs.sdk.base.core.f.c cVar = fVar.f1569a;
            if (zIsIntl) {
                cVar.f1568a = "https://errnewlogos.umeng.com/api/crashsdk/logcollect";
                cVar.b = "4ea4e41a3993";
            } else {
                cVar.f1568a = "https://errnewlog.umeng.com/api/crashsdk/logcollect";
                cVar.b = "28ef1713347d";
            }
            fVar.b = this;
            fVar.c.f1566a = fVar.b;
            fVar.d.f1566a = fVar.b;
            this.f = true;
            com.efs.sdk.base.core.c.d.a().sendEmptyMessageDelayed(0, h.getLogSendDelayMills());
            com.efs.sdk.base.core.f.f fVar2 = f.a.f1570a;
            if (fVar2.b != null && getGlobalEnvStruct().isEnableWaStat()) {
                fVar2.b.send(new com.efs.sdk.base.core.f.b("efs_core", "pvuv", fVar2.f1569a.c));
            }
        } else if (i == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                b((ILogProtocol) obj);
            }
        } else if (i == 3) {
            a();
        }
        return true;
    }

    public static GlobalEnvStruct getGlobalEnvStruct() {
        return h;
    }

    private void a() {
        if (this.g == null) {
            this.g = new a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            h.mAppContext.registerReceiver(this.g, intentFilter);
        } catch (Throwable th) {
            Log.w("efs.base", "register network change receiver error", th);
            int i = this.f1556a + 1;
            this.f1556a = i;
            if (i < 3) {
                this.i.sendEmptyMessageDelayed(3, 6000L);
            }
        }
    }

    public void send(ILogProtocol iLogProtocol) {
        if (!this.f) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = iLogProtocol;
            this.i.sendMessage(messageObtain);
            return;
        }
        b(iLogProtocol);
    }

    private void b(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.controller.ControllerCenter.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    iLogProtocol.insertGlobal(b.a.f1555a.a());
                    if (!"wa".equalsIgnoreCase(iLogProtocol.getLogType())) {
                        ControllerCenter.a(iLogProtocol);
                    }
                    if (ControllerCenter.getGlobalEnvStruct().isEnableSendLog()) {
                        final com.efs.sdk.base.core.d.b bVarA = com.efs.sdk.base.core.d.b.a(iLogProtocol);
                        final com.efs.sdk.base.core.e.d dVar = d.a.f1565a;
                        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.e.d.1

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ com.efs.sdk.base.core.d.b f1564a;

                            public AnonymousClass1(final com.efs.sdk.base.core.d.b bVarA2) {
                                bVar = bVarA2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                d.this.f1563a.a(bVar);
                            }
                        });
                    }
                } catch (Throwable th) {
                    Log.e("efs.base", "log send error", th);
                }
            }
        });
    }

    public HttpResponse sendSyncImmediately(String str, int i, String str2, boolean z, File file) {
        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b(str, (byte) 2);
        bVar.b(1);
        bVar.d = file;
        bVar.a(str2);
        bVar.a(i);
        bVar.b.b = z;
        bVar.c();
        d.a.f1565a.f1563a.a(bVar);
        return bVar.b.c;
    }

    static /* synthetic */ void a(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : getGlobalEnvStruct().getCallback(9)) {
            HashMap map = new HashMap(4);
            map.put("log_type", iLogProtocol.getLogType());
            map.put("log_data", iLogProtocol.generateString());
            map.put("link_key", iLogProtocol.getLinkKey());
            map.put("link_id", iLogProtocol.getLinkId());
            Message messageObtain = Message.obtain(null, 9, map);
            Message messageObtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(messageObtain, messageObtain2));
            messageObtain.recycle();
            messageObtain2.recycle();
        }
    }
}
