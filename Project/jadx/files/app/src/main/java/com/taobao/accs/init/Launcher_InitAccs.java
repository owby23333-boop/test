package com.taobao.accs.init;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class Launcher_InitAccs implements Serializable {
    public static String defaultAppkey = "21646297";
    public static String mAppkey = null;
    public static Context mContext = null;
    public static boolean mForceBindUser = false;
    public static boolean mIsInited = false;
    public static String mSid;
    public static String mTtid;
    public static String mUserId;
    public static IAppReceiver mAppReceiver = new d();
    public static final Map<String, String> SERVICES = new HashMap();

    /* JADX INFO: compiled from: Taobao */
    static class a implements ILoginInfo {
        a() {
        }

        @Override // com.taobao.accs.ILoginInfo
        public boolean getCommentUsed() {
            return false;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getEcode() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getHeadPicLink() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getNick() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getSid() {
            return Launcher_InitAccs.mSid;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getSsoToken() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getUserId() {
            return Launcher_InitAccs.mUserId;
        }
    }

    static {
        SERVICES.put("im", "com.taobao.tao.amp.remote.AccsReceiverCallback");
        SERVICES.put("powermsg", "com.taobao.appfrmbundle.mkt.AccsReceiverService");
        SERVICES.put("pmmonitor", "com.taobao.appfrmbundle.mkt.AccsReceiverService");
        SERVICES.put("cloudsync", "com.taobao.datasync.network.accs.AccsCloudSyncService");
        SERVICES.put("acds", "com.taobao.acds.compact.AccsACDSService");
        SERVICES.put(GlobalClientInfo.AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        SERVICES.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        SERVICES.put("agooTokenReport", "org.android.agoo.accs.AgooService");
        SERVICES.put("AliLive", "com.taobao.playbudyy.gameplugin.danmu.DanmuCallbackService");
        SERVICES.put("orange", "com.taobao.orange.accssupport.OrangeAccsService");
        SERVICES.put("tsla", "com.taobao.android.festival.accs.HomepageAccsMassService");
        SERVICES.put("taobaoWaimaiAccsService", "com.taobao.takeout.order.detail.service.TakeoutOrderDetailACCSService");
        SERVICES.put("login", "com.taobao.android.sso.v2.service.LoginAccsService");
        SERVICES.put("ranger_abtest", "com.taobao.ranger3.RangerACCSService");
        SERVICES.put("accs_poplayer", "com.taobao.tbpoplayer.AccsPopLayerService");
        SERVICES.put("dm_abtest", "com.tmall.wireless.ant.accs.AntAccsService");
        SERVICES.put("family", "com.taobao.family.FamilyAccsService");
        SERVICES.put("taobao-dingtalk", "com.laiwang.protocol.android.LwpAccsService");
        SERVICES.put("amp-sync", "com.taobao.message.init.accs.AccsReceiverCallback");
        SERVICES.put("friend_invite_msg", "com.taobao.message.init.accs.TaoFriendAccsReceiverCallback");
        SERVICES.put("slider", "com.taobao.slide.accs.SlideAccsService");
    }

    public void init(Application application, HashMap<String, Object> map) {
        String str;
        int i2;
        ALog.i("Launcher_InitAccs", "init", new Object[0]);
        try {
            if (Launcher_InitAgooLifecycle.mADaemonValid) {
                try {
                    Launcher_InitAgooLifecycle.adaemonClazz.getMethod("initialize", Context.class).invoke(null, application);
                } catch (Exception e2) {
                    ALog.e("Launcher_InitAccs", "adaemon initializeLifecycle error", e2, new Object[0]);
                }
            }
            AwcnConfig.setAccsSessionCreateForbiddenInBg(true);
            mContext = application.getApplicationContext();
            if ((mContext.getApplicationInfo().flags & 2) != 0) {
                ALog.isUseTlog = false;
                anet.channel.util.ALog.setUseTlog(false);
            }
            try {
                int iIntValue = ((Integer) map.get("envIndex")).intValue();
                mAppkey = (String) map.get("onlineAppKey");
                if (iIntValue == 1) {
                    mAppkey = (String) map.get("preAppKey");
                    i2 = 1;
                } else {
                    if ((iIntValue == 3) || (iIntValue == 2)) {
                        mAppkey = (String) map.get("dailyAppkey");
                        i2 = 2;
                    } else {
                        i2 = 0;
                    }
                }
                try {
                    str = (String) map.get(UMModuleRegister.PROCESS);
                } catch (Throwable th) {
                    th = th;
                    str = null;
                }
            } catch (Throwable th2) {
                th = th2;
                str = null;
                i2 = 0;
            }
            try {
                mTtid = (String) map.get(Constants.KEY_TTID);
                mUserId = (String) map.get("userId");
                mSid = (String) map.get("sid");
            } catch (Throwable th3) {
                th = th3;
                ALog.e("Launcher_InitAccs", "init get param error", th, new Object[0]);
            }
            if (TextUtils.isEmpty(mAppkey)) {
                ALog.e("Launcher_InitAccs", "init get appkey null！！", new Object[0]);
                mAppkey = defaultAppkey;
            }
            ACCSManager.setAppkey(application, mAppkey, i2);
            ALog.i("Launcher_InitAccs", "init", "appkey", mAppkey, Constants.KEY_MODE, Integer.valueOf(i2), UMModuleRegister.PROCESS, str);
            ACCSClient.init(mContext, new AccsClientConfig.Builder().setAppKey(mAppkey).setConfigEnv(i2).setTag("default").build());
            if (UtilityImpl.isMainProcess(mContext)) {
                mIsInited = true;
                ThreadPoolExecutorFactory.execute(new c(this));
            }
        } catch (Throwable th4) {
            ALog.e("Launcher_InitAccs", "init", th4, new Object[0]);
        }
    }
}
