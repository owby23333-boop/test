package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.HttpConstant;
import com.anythink.core.api.ATAdConst;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class StrategyTable implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static Comparator<StrategyCollection> f447e = new o();
    protected String a;
    protected volatile String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, Long> f448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected transient boolean f449d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HostLruCache f450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile transient int f451g;

    /* JADX INFO: compiled from: Taobao */
    private static class HostLruCache extends SerialLruCache<String, StrategyCollection> {
        public HostLruCache(int i2) {
            super(i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyCollection> entry) {
            if (!entry.getValue().f435d) {
                return true;
            }
            Iterator<Map.Entry<String, StrategyCollection>> it = entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().f435d) {
                    it.remove();
                    return false;
                }
            }
            return false;
        }
    }

    protected StrategyTable(String str) {
        this.a = str;
        a();
    }

    private void b() {
        if (HttpDispatcher.getInstance().isInitHostsChanged(this.a)) {
            for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                this.f450f.put(str, new StrategyCollection(str));
            }
        }
    }

    private void c() {
        try {
            if (HttpDispatcher.getInstance().isInitHostsChanged(this.a)) {
                TreeSet treeSet = null;
                synchronized (this.f450f) {
                    for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                        if (!this.f450f.containsKey(str)) {
                            this.f450f.put(str, new StrategyCollection(str));
                            if (treeSet == null) {
                                treeSet = new TreeSet();
                            }
                            treeSet.add(str);
                        }
                    }
                }
                if (treeSet != null) {
                    a(treeSet);
                }
            }
        } catch (Exception e2) {
            ALog.e("awcn.StrategyTable", "checkInitHost failed", this.a, e2, new Object[0]);
        }
    }

    protected void a() {
        if (this.f450f == null) {
            this.f450f = new HostLruCache(256);
            b();
        }
        Iterator<StrategyCollection> it = this.f450f.values().iterator();
        while (it.hasNext()) {
            it.next().checkInit();
        }
        ALog.i("awcn.StrategyTable", "strategy map", null, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, Integer.valueOf(this.f450f.size()));
        this.f451g = GlobalAppRuntimeInfo.isTargetProcess() ? 0 : -1;
        if (this.f448c == null) {
            this.f448c = new ConcurrentHashMap();
        }
    }

    public String getCnameByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f450f) {
            strategyCollection = this.f450f.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0) {
            a(str);
        }
        if (strategyCollection != null) {
            return strategyCollection.f434c;
        }
        return null;
    }

    public List<IConnStrategy> queryByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.c.c(str)) {
            return Collections.EMPTY_LIST;
        }
        c();
        synchronized (this.f450f) {
            strategyCollection = this.f450f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f450f.put(str, strategyCollection);
            }
        }
        if (strategyCollection.b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
        return strategyCollection.queryStrategyList();
    }

    public void update(l.d dVar) {
        ALog.i("awcn.StrategyTable", "update strategyTable with httpDns response", this.a, new Object[0]);
        try {
            this.b = dVar.a;
            this.f451g = dVar.f482f;
            l.b[] bVarArr = dVar.b;
            if (bVarArr == null) {
                return;
            }
            synchronized (this.f450f) {
                for (l.b bVar : bVarArr) {
                    if (bVar != null && bVar.a != null) {
                        if (bVar.f476j) {
                            this.f450f.remove(bVar.a);
                        } else {
                            StrategyCollection strategyCollection = this.f450f.get(bVar.a);
                            if (strategyCollection == null) {
                                strategyCollection = new StrategyCollection(bVar.a);
                                this.f450f.put(bVar.a, strategyCollection);
                            }
                            strategyCollection.update(bVar);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ALog.e("awcn.StrategyTable", "fail to update strategyTable", this.a, th, new Object[0]);
        }
        this.f449d = true;
        if (ALog.isPrintLog(1)) {
            StringBuilder sb = new StringBuilder("uniqueId : ");
            sb.append(this.a);
            sb.append("\n-------------------------domains:------------------------------------");
            ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
            synchronized (this.f450f) {
                for (Map.Entry<String, StrategyCollection> entry : this.f450f.entrySet()) {
                    sb.setLength(0);
                    sb.append(entry.getKey());
                    sb.append(" = ");
                    sb.append(entry.getValue().toString());
                    ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
                }
            }
        }
    }

    private void b(Set<String> set) {
        TreeSet<StrategyCollection> treeSet = new TreeSet(f447e);
        synchronized (this.f450f) {
            treeSet.addAll(this.f450f.values());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (StrategyCollection strategyCollection : treeSet) {
            if (!strategyCollection.isExpired() || set.size() >= 40) {
                return;
            }
            strategyCollection.b = 30000 + jCurrentTimeMillis;
            set.add(strategyCollection.a);
        }
    }

    private void a(String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(str);
        a(treeSet);
    }

    protected void a(String str, boolean z2) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f450f) {
            strategyCollection = this.f450f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f450f.put(str, strategyCollection);
            }
        }
        if (z2 || strategyCollection.b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
    }

    private void a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if ((GlobalAppRuntimeInfo.isAppBackground() && AppLifecycle.lastEnterBackgroundTime > 0) || !NetworkStatusHelper.isConnected()) {
            ALog.i("awcn.StrategyTable", "app in background or no network", this.a, new Object[0]);
            return;
        }
        int amdcLimitLevel = AmdcRuntimeInfo.getAmdcLimitLevel();
        if (amdcLimitLevel == 3) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f450f) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                StrategyCollection strategyCollection = this.f450f.get(it.next());
                if (strategyCollection != null) {
                    strategyCollection.b = 30000 + jCurrentTimeMillis;
                }
            }
        }
        if (amdcLimitLevel == 0) {
            b(set);
        }
        HttpDispatcher.getInstance().sendAmdcRequest(set, this.f451g);
    }

    void a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyCollection strategyCollection;
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyTable", "[notifyConnEvent]", null, HttpConstant.HOST, str, "IConnStrategy", iConnStrategy, "ConnEvent", connEvent);
        }
        String str2 = iConnStrategy.getProtocol().protocol;
        if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
            anet.channel.e.a.a(connEvent.isSuccess);
            ALog.e("awcn.StrategyTable", "enable http3", null, "uniqueId", this.a, "enable", Boolean.valueOf(connEvent.isSuccess));
        }
        if (!connEvent.isSuccess && anet.channel.strategy.utils.c.b(iConnStrategy.getIp())) {
            this.f448c.put(str, Long.valueOf(System.currentTimeMillis()));
            ALog.e("awcn.StrategyTable", "disable ipv6", null, "uniqueId", this.a, Constants.KEY_HOST, str);
        }
        synchronized (this.f450f) {
            strategyCollection = this.f450f.get(str);
        }
        if (strategyCollection != null) {
            strategyCollection.notifyConnEvent(iConnStrategy, connEvent);
        }
    }

    boolean a(String str, long j2) {
        Long l2 = this.f448c.get(str);
        if (l2 == null) {
            return false;
        }
        if (l2.longValue() + j2 >= System.currentTimeMillis()) {
            return true;
        }
        this.f448c.remove(str);
        return false;
    }
}
