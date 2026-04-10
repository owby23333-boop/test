package anet.channel.strategy;

import java.util.Comparator;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class o implements Comparator<StrategyCollection> {
    o() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(StrategyCollection strategyCollection, StrategyCollection strategyCollection2) {
        return strategyCollection.b != strategyCollection2.b ? (int) (strategyCollection.b - strategyCollection2.b) : strategyCollection.a.compareTo(strategyCollection2.a);
    }
}
