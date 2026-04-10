package com.taobao.agoo.a.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.q;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class a extends b {
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_REMOVEALLALIAS = "unbindAllAlias";
    public static final String JSON_CMD_SETALIAS = "setAlias";
    public static final String JSON_PUSH_USER_TOKEN = "pushAliasToken";
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18346d;

    public static byte[] b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.f18346d = str3;
        aVar.f18347e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public static byte[] c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.f18345c = str3;
        aVar.f18347e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public byte[] a() {
        try {
            String string = new q.a().a(b.JSON_CMD, this.f18347e).a(Constants.KEY_APP_KEY, this.a).a("deviceId", this.b).a("alias", this.f18345c).a(JSON_PUSH_USER_TOKEN, this.f18346d).a().toString();
            ALog.i("AliasDO", "buildData", "data", string);
            return string.getBytes(com.anythink.expressad.foundation.g.a.bN);
        } catch (Throwable th) {
            ALog.e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.f18345c = str3;
        aVar.f18347e = "setAlias";
        return aVar.a();
    }

    public static byte[] a(String str, String str2) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.f18347e = JSON_CMD_REMOVEALLALIAS;
        return aVar.a();
    }
}
