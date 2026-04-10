package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class g implements RequestCb {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z2) {
        this.a.b.onDataReceive(byteArray, z2);
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 <= 0 && i2 != -204) {
            this.a.f412d.handleCallbacks(2, new anet.channel.entity.b(2, 0, "Http connect fail"));
        }
        this.a.b.onFinish(i2, str, requestStatistic);
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        ALog.i("awcn.HttpSession", "", this.a.a.getSeq(), "httpStatusCode", Integer.valueOf(i2));
        ALog.i("awcn.HttpSession", "", this.a.a.getSeq(), "response headers", map);
        this.a.b.onResponseCode(i2, map);
        this.a.f411c.serverRT = HttpHelper.parseServerRT(map);
        f fVar = this.a;
        fVar.f412d.handleResponseCode(fVar.a, i2);
        f fVar2 = this.a;
        fVar2.f412d.handleResponseHeaders(fVar2.a, map);
    }
}
