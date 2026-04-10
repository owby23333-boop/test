package anet.channel.strategy;

import anet.channel.statist.StrategyStatObject;
import anet.channel.strategy.StrategyInfoHolder;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ Map.Entry a;
    final /* synthetic */ StrategyInfoHolder.LruStrategyMap b;

    f(StrategyInfoHolder.LruStrategyMap lruStrategyMap, Map.Entry entry) {
        this.b = lruStrategyMap;
        this.a = entry;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyTable strategyTable = (StrategyTable) this.a.getValue();
        if (strategyTable.f449d) {
            StrategyStatObject strategyStatObject = new StrategyStatObject(1);
            strategyStatObject.writeStrategyFileId = strategyTable.a;
            m.a((Serializable) this.a.getValue(), strategyTable.a, strategyStatObject);
            strategyTable.f449d = false;
        }
    }
}
