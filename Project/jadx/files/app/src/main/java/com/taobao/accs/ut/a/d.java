package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.umeng.message.MsgConstant;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18278g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f18281j = "receiveMessage";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18279h = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18282k = false;

    public void a() {
        String str;
        String strValueOf;
        if (this.f18282k) {
            return;
        }
        this.f18282k = true;
        HashMap map = new HashMap();
        try {
            str = this.a;
            try {
                strValueOf = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
            try {
                map.put("device_id", this.a);
                map.put("data_id", this.b);
                map.put("receive_date", this.f18274c);
                map.put("to_bz_date", this.f18275d);
                map.put("service_id", this.f18276e);
                map.put("data_length", this.f18277f);
                map.put(MsgConstant.INAPP_MSG_TYPE, this.f18278g);
                map.put("repeat", this.f18279h ? "y" : "n");
                map.put("user_id", this.f18280i);
                UTMini.getInstance().commitEvent(66001, "receiveMessage", str, (Object) null, strValueOf, map);
            } catch (Throwable th2) {
                th = th2;
                ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str, (String) null, strValueOf, map) + " " + th.toString(), new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            strValueOf = null;
        }
    }
}
