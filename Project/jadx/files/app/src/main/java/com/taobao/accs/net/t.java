package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.taobao.accs.net.j;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class t implements RequestCb {
    final /* synthetic */ IAuth.AuthCallback a;
    final /* synthetic */ j.a b;

    t(j.a aVar, IAuth.AuthCallback authCallback) {
        this.b = aVar;
        this.a = authCallback;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z2) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 < 0) {
            ALog.e(this.b.f18231c, "auth onFinish", "statusCode", Integer.valueOf(i2));
            this.a.onAuthFail(i2, "onFinish auth fail");
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        ALog.e(this.b.f18231c, BaseMonitor.ALARM_POINT_AUTH, "httpStatusCode", Integer.valueOf(i2));
        if (i2 == 200) {
            this.a.onAuthSuccess();
            if (this.b.f18232d instanceof j) {
                ((j) this.b.f18232d).o();
            }
        } else {
            this.a.onAuthFail(i2, "auth fail");
        }
        Map<String, String> mapA = UtilityImpl.a(map);
        ALog.d(this.b.f18231c, BaseMonitor.ALARM_POINT_AUTH, "header", mapA);
        String str = mapA.get("x-at");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.f18232d.f18208k = str;
    }
}
