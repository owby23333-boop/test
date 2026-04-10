package anet.channel.strategy.dispatch;

import android.os.Build;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class d {
    public static final String TAG = "amdc.DispatchParamBuilder";

    d() {
    }

    public static Map a(Map<String, Object> map) {
        IAmdcSign sign = AmdcRuntimeInfo.getSign();
        if (sign == null || TextUtils.isEmpty(sign.getAppkey())) {
            ALog.e(TAG, "amdc sign is null or appkey is empty", null, new Object[0]);
            return null;
        }
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        if (!NetworkStatusHelper.isConnected()) {
            ALog.e(TAG, "no network, don't send amdc request", null, new Object[0]);
            return null;
        }
        map.put("appkey", sign.getAppkey());
        map.put("v", DispatchConstants.VER_CODE);
        map.put("platform", DispatchConstants.ANDROID);
        map.put(DispatchConstants.PLATFORM_VERSION, Build.VERSION.RELEASE);
        if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getUserId())) {
            map.put("sid", GlobalAppRuntimeInfo.getUserId());
        }
        map.put(DispatchConstants.NET_TYPE, status.toString());
        map.put("carrier", NetworkStatusHelper.getCarrier());
        map.put("mnc", NetworkStatusHelper.getSimOp());
        if (AmdcRuntimeInfo.latitude != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            map.put("lat", String.valueOf(AmdcRuntimeInfo.latitude));
        }
        if (AmdcRuntimeInfo.longitude != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            map.put("lng", String.valueOf(AmdcRuntimeInfo.longitude));
        }
        map.putAll(AmdcRuntimeInfo.getParams());
        map.put("channel", AmdcRuntimeInfo.appChannel);
        map.put(DispatchConstants.APP_NAME, AmdcRuntimeInfo.appName);
        map.put("appVersion", AmdcRuntimeInfo.appVersion);
        map.put(DispatchConstants.STACK_TYPE, Integer.toString(a()));
        map.put("domain", b(map));
        map.put(DispatchConstants.SIGNTYPE, sign.useSecurityGuard() ? "sec" : "noSec");
        map.put("t", String.valueOf(System.currentTimeMillis()));
        String strA = a(sign, map);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        map.put("sign", strA);
        return map;
    }

    private static String b(Map map) {
        Set set = (Set) map.remove(DispatchConstants.HOSTS);
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int a() {
        int iC = anet.channel.util.c.c();
        if (iC == 1) {
            return 4;
        }
        if (iC != 2) {
            return iC != 3 ? 4 : 1;
        }
        return 2;
    }

    static String a(IAmdcSign iAmdcSign, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(anet.channel.strategy.utils.c.d(map.get("appkey")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("domain")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.APP_NAME)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("appVersion")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.BSSID)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("channel")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("deviceId")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("lat")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("lng")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.MACHINE)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.NET_TYPE)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("other")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("platform")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.PLATFORM_VERSION)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.PRE_IP)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("sid")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("t")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("v")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.SIGNTYPE)));
        try {
            return iAmdcSign.sign(sb.toString());
        } catch (Exception e2) {
            ALog.e(TAG, "get sign failed", null, e2, new Object[0]);
            return null;
        }
    }
}
