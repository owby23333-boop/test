package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.message.api.UPushApi;

/* JADX INFO: compiled from: UPushSdk.java */
/* JADX INFO: loaded from: classes3.dex */
public class r {
    private static Application a;

    public static void a(Context context, String str, String str2) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("context can't be null");
            }
            a(context);
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("appkey can't be null");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("secret can't be null");
            }
            final String strB = l.b(a);
            GlobalConfig.setCurrProcessNameImpl(new IProcessName() { // from class: com.umeng.message.proguard.r.1
                @Override // com.taobao.accs.IProcessName
                public String getCurrProcessName() {
                    return strB;
                }
            });
            GlobalAppRuntimeInfo.setCurrentProcess(strB);
            AwcnConfig.setWifiInfoEnable(false);
            AmdcRuntimeInfo.setForceHttps(true);
            DispatchConstants.setAmdcServerDomain(new String[]{"amdcopen.m.taobao.com", "amdc.wapa.taobao.com", "amdc.taobao.net"});
            DispatchConstants.setAmdcServerFixIp(new String[][]{new String[]{"106.11.61.135", "106.11.61.137"}, null, null});
            AccsClientConfig.Builder builder = new AccsClientConfig.Builder();
            builder.setAppKey("umeng:" + str);
            builder.setAppSecret(str2);
            builder.setInappHost("umengacs.m.taobao.com").setInappPubKey(11).setChannelHost("umengjmacs.m.taobao.com").setChannelPubKey(11);
            builder.setTag("default");
            ACCSClient.init(context, builder.build());
            TaobaoRegister.setAccsConfigTag(context, "default");
            o.a().a(a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Context b() {
        Application application = a;
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("u-push context is null! make sure PushAgent.setup(...) be called in Application.onCreate().");
    }

    public static void a(Context context) {
        if (context != null) {
            if (a == null) {
                a = (Application) context.getApplicationContext();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public static UPushApi a() {
        return p.a();
    }
}
