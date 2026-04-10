package com.umeng.message.proguard;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushReceiver;
import org.json.JSONObject;

/* JADX INFO: compiled from: UPushReceiverHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static final String a = "Receiver";
    private static final UPushReceiver b = new UPushReceiver();

    public static void a() {
        if (UPushReceiver.a()) {
            try {
                Context contextB = r.b();
                if (contextB == null) {
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addDataScheme(Constants.KEY_PACKAGE);
                contextB.registerReceiver(b, intentFilter);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        String action = intent.getAction();
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        if (schemeSpecificPart == null || schemeSpecificPart.length() == 0) {
            return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(action) && !booleanExtra) {
            a(schemeSpecificPart, 80);
        } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            if (booleanExtra) {
                a(schemeSpecificPart, 81);
            } else {
                a(schemeSpecificPart, 82);
            }
        }
    }

    public static void a(final Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        c.b(new Runnable() { // from class: com.umeng.message.proguard.f.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.c(intent);
                } catch (Throwable th) {
                    UPLog.e(f.a, "err:", th.getMessage());
                }
            }
        });
    }

    private static void a(String str, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkg", str);
            jSONObject.put(MsgConstant.KEY_ACTION_TYPE, i2);
            UMWorkDispatch.sendEvent(r.b(), MsgConstant.PUSH_PKG_STAT, q.a(), jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
