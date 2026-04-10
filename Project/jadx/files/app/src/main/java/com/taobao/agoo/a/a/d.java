package com.taobao.agoo.a.a;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.q;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class d extends b {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18361c;

    public byte[] a() {
        try {
            q.a aVar = new q.a();
            aVar.a(b.JSON_CMD, this.f18347e).a(Constants.KEY_APP_KEY, this.a);
            if (TextUtils.isEmpty(this.b)) {
                aVar.a("utdid", this.f18361c);
            } else {
                aVar.a("deviceId", this.b);
            }
            String string = aVar.a().toString();
            ALog.i("SwitchDO", "buildData", "data", string);
            return string.getBytes(com.anythink.expressad.foundation.g.a.bN);
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3, boolean z2) {
        d dVar = new d();
        dVar.a = str;
        dVar.b = str2;
        dVar.f18361c = str3;
        if (z2) {
            dVar.f18347e = JSON_CMD_ENABLEPUSH;
        } else {
            dVar.f18347e = JSON_CMD_DISABLEPUSH;
        }
        return dVar.a();
    }
}
