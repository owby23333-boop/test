package anet.channel.strategy;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import com.baidu.mobads.sdk.internal.bj;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class StrategyCollection implements Serializable {
    String a;
    volatile long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile String f434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private StrategyList f437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient long f438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient boolean f439h;

    public StrategyCollection() {
        this.f437f = null;
        this.b = 0L;
        this.f434c = null;
        this.f435d = false;
        this.f436e = 0;
        this.f438g = 0L;
        this.f439h = true;
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.b > bj.f12907e) {
            this.f437f = null;
        } else {
            if (this.f437f != null) {
                this.f437f.checkInit();
            }
        }
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.b;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (this.f437f != null) {
            this.f437f.notifyConnEvent(iConnStrategy, connEvent);
            if (!connEvent.isSuccess && this.f437f.shouldRefresh()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f438g > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.a);
                    this.f438g = jCurrentTimeMillis;
                }
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.f437f == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.f439h) {
            this.f439h = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.a, this.f436e);
            policyVersionStat.reportType = 0;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        return this.f437f.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyList = ");
        sb.append(this.b);
        StrategyList strategyList = this.f437f;
        if (strategyList != null) {
            sb.append(strategyList.toString());
        } else if (this.f434c != null) {
            sb.append('[');
            sb.append(this.a);
            sb.append("=>");
            sb.append(this.f434c);
            sb.append(']');
        } else {
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    public synchronized void update(l.b bVar) {
        this.b = System.currentTimeMillis() + (((long) bVar.b) * 1000);
        if (!bVar.a.equalsIgnoreCase(this.a)) {
            ALog.e("StrategyCollection", "update error!", null, Constants.KEY_HOST, this.a, "dnsInfo.host", bVar.a);
            return;
        }
        if (this.f436e != bVar.f478l) {
            this.f436e = bVar.f478l;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.a, this.f436e);
            policyVersionStat.reportType = 1;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        this.f434c = bVar.f470d;
        if ((bVar.f472f != null && bVar.f472f.length != 0 && bVar.f474h != null && bVar.f474h.length != 0) || (bVar.f475i != null && bVar.f475i.length != 0)) {
            if (this.f437f == null) {
                this.f437f = new StrategyList();
            }
            this.f437f.update(bVar);
            return;
        }
        this.f437f = null;
    }

    protected StrategyCollection(String str) {
        this.f437f = null;
        this.b = 0L;
        this.f434c = null;
        this.f435d = false;
        this.f436e = 0;
        this.f438g = 0L;
        this.f439h = true;
        this.a = str;
        this.f435d = DispatchConstants.isAmdcServerDomain(str);
    }
}
