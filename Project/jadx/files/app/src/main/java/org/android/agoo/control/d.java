package org.android.agoo.control;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class d implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AgooFactory f21279c;

    d(AgooFactory agooFactory, byte[] bArr, boolean z2) {
        this.f21279c = agooFactory;
        this.a = bArr;
        this.b = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = new String(this.a, com.anythink.expressad.foundation.g.a.bN);
            if (TextUtils.isEmpty(str)) {
                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "msg==null", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                return;
            }
            ALog.i("AgooFactory", "message = " + str, new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("api");
            String string2 = jSONObject.getString("id");
            String string3 = TextUtils.equals(string, "agooReport") ? jSONObject.getString("status") : null;
            if (TextUtils.equals(string, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "handlerACKMessage", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("AgooFactory", "updateMsg data begin,api=" + string + ",id=" + string2 + ",status=" + string3 + ",reportTimes=" + Config.e(AgooFactory.mContext), new Object[0]);
                }
                if (TextUtils.equals(string, "agooReport")) {
                    if (TextUtils.equals(string3, "4") && this.b) {
                        this.f21279c.messageService.a(string2, "1");
                    } else if ((TextUtils.equals(string3, "8") || TextUtils.equals(string3, "9")) && this.b) {
                        this.f21279c.messageService.a(string2, MessageService.MSG_DB_COMPLETE);
                    }
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, string3, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                    return;
                }
                return;
            }
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json key null", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        } catch (Throwable th) {
            ALog.e("AgooFactory", "updateMsg get data error,e=" + th, new Object[0]);
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json exception", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        }
    }
}
