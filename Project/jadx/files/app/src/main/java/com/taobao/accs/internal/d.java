package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.v;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.x;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements IBaseService {
    protected static ConcurrentHashMap<String, com.taobao.accs.net.b> a = new ConcurrentHashMap<>(2);
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Service f18196c;

    public d(Service service) {
        this.f18196c = null;
        this.f18196c = service;
        this.b = service.getApplicationContext();
    }

    protected static com.taobao.accs.net.b a(Context context, String str, boolean z2) {
        com.taobao.accs.net.b vVar = null;
        try {
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "getConnection", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.w("ElectionServiceImpl", "getConnection configTag null or env invalid", "conns.size", Integer.valueOf(a.size()));
            if (a.size() > 0) {
                return a.elements().nextElement();
            }
            return null;
        }
        ALog.i("ElectionServiceImpl", "getConnection", Constants.KEY_CONFIG_TAG, str, com.anythink.expressad.foundation.d.c.bT, Boolean.valueOf(z2));
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag != null && configByTag.getDisableChannel()) {
            ALog.e("ElectionServiceImpl", "getConnection channel disabled!", Constants.KEY_CONFIG_TAG, str);
            return null;
        }
        int iB = x.b(context);
        String str2 = str + com.anythink.expressad.foundation.g.a.bQ + iB;
        synchronized (d.class) {
            try {
                com.taobao.accs.net.b bVar = a.get(str2);
                if (bVar == null) {
                    try {
                        AccsClientConfig.mEnv = iB;
                        vVar = new v(context, 0, str);
                        a.put(str2, vVar);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    vVar = bVar;
                }
                if (z2) {
                    vVar.a();
                }
                return vVar;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    private void b(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            String stringExtra4 = intent.getStringExtra("app_sercet");
            String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
            int intExtra = intent.getIntExtra(Constants.KEY_MODE, 0);
            ALog.i("ElectionServiceImpl", "handleStartCommand", Constants.KEY_CONFIG_TAG, stringExtra5, "appkey", stringExtra2, "appSecret", stringExtra4, Constants.KEY_TTID, stringExtra3, "pkg", stringExtra);
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || !stringExtra.equals(this.b.getPackageName())) {
                return;
            }
            x.a(this.b, intExtra);
            com.taobao.accs.net.b bVarA = a(this.b, stringExtra5, false);
            if (bVarA != null) {
                bVarA.a = stringExtra3;
            } else {
                ALog.e("ElectionServiceImpl", "handleStartCommand start action, no connection", Constants.KEY_CONFIG_TAG, stringExtra5);
            }
            UtilityImpl.c(this.b, stringExtra2);
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "handleStartCommand", th, new Object[0]);
        }
    }

    public abstract int a(Intent intent);

    @Override // com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onCreate() {
        ALog.i("ElectionServiceImpl", "onCreate,", Constants.KEY_SDK_VERSION, 221);
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onDestroy() {
        ALog.e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.b = null;
        this.f18196c = null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        ALog.i("ElectionServiceImpl", "onStartCommand begin", NativeAdvancedJsUtils.f8246p, action);
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            b(intent);
        }
        return a(intent);
    }

    @Override // com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    protected static com.taobao.accs.net.b b(Context context, String str, boolean z2) {
        return a(context, str, z2);
    }
}
