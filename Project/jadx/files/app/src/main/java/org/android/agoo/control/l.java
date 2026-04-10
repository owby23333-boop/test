package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f21281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f21282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ NotifManager f21283e;

    l(NotifManager notifManager, String str, String str2, String str3, boolean z2) {
        this.f21283e = notifManager;
        this.a = str;
        this.b = str2;
        this.f21281c = str3;
        this.f21282d = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HashMap map = new HashMap();
            map.put("thirdTokenType", this.a);
            map.put("token", this.b);
            map.put("appkey", Config.a(NotifManager.mContext));
            map.put("utdid", com.taobao.accs.utl.j.b(NotifManager.mContext));
            if (!TextUtils.isEmpty(this.f21281c)) {
                map.put("vendorSdkVersion", this.f21281c);
            }
            ALog.d("NotifManager", "report,utdid=" + com.taobao.accs.utl.j.b(NotifManager.mContext) + ",regId=" + this.b + ",type=" + this.a, new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, "agooTokenReport", new JSONObject(map).toString().getBytes("UTF-8"), null, null, null, null);
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(NotifManager.mContext, Config.a(NotifManager.mContext), Config.b(NotifManager.mContext));
            String strA = this.f21282d ? accsInstance.a(NotifManager.mContext, accsRequest) : accsInstance.a(NotifManager.mContext, accsRequest, new TaoBaseService.ExtraInfo());
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.i("NotifManager", "reportThirdPushToken,dataId=" + strA + ",regId=" + this.b + ",type=" + this.a, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", com.taobao.accs.utl.j.b(NotifManager.mContext), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
