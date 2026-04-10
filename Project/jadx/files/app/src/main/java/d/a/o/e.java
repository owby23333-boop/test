package d.a.o;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements RequestCb {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z2) {
        if (this.a.f20731u.f20760d.get()) {
            return;
        }
        d.b(this.a);
        if (this.a.f20731u.b != null) {
            this.a.f20731u.b.a(this.a.f20733w, this.a.f20732v, byteArray);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (this.a.f20731u.f20760d.getAndSet(true)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.DegradeTask", "[onFinish]", this.a.f20731u.f20759c, "code", Integer.valueOf(i2), "msg", str);
        }
        this.a.f20731u.a();
        requestStatistic.isDone.set(true);
        if (this.a.f20731u.b != null) {
            this.a.f20731u.b.a(new DefaultFinishEvent(i2, str, this.a.f20734x));
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (this.a.f20731u.f20760d.get()) {
            return;
        }
        this.a.f20731u.a();
        d.a.k.a.a(this.a.f20731u.a.g(), map);
        this.a.f20732v = HttpHelper.parseContentLength(map);
        if (this.a.f20731u.b != null) {
            this.a.f20731u.b.onResponseCode(i2, map);
        }
    }
}
