package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.u;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class GlobalConfig {
    public static AccsConfig.ACCS_GROUP mGroup = AccsConfig.ACCS_GROUP.TAOBAO;
    public static boolean enableCookie = true;

    public static void setChannelProcessName(String str) {
        a.f18131e = str;
    }

    public static void setChannelReuse(boolean z2, AccsConfig.ACCS_GROUP accs_group) {
        GlobalClientInfo.f18118d = z2;
        mGroup = accs_group;
    }

    public static void setControlFrameMaxRetry(int i2) {
        Message.CONTROL_MAX_RETRY_TIMES = i2;
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        a.f18132f = iProcessName;
    }

    public static void setEnableForground(Context context, boolean z2) {
        ALog.i("GlobalConfig", "setEnableForground", "enable", Boolean.valueOf(z2));
        u.a(context, ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, z2 ? 21 : 0);
    }

    public static void setMainProcessName(String str) {
        a.f18130d = str;
    }
}
