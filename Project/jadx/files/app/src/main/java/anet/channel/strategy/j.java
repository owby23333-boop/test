package anet.channel.strategy;

import anet.channel.strategy.StrategyList;
import anet.channel.strategy.l;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class j implements StrategyList.Predicate<IPConnStrategy> {
    final /* synthetic */ l.a a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConnProtocol f461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrategyList f462d;

    j(StrategyList strategyList, l.a aVar, String str, ConnProtocol connProtocol) {
        this.f462d = strategyList;
        this.a = aVar;
        this.b = str;
        this.f461c = connProtocol;
    }

    @Override // anet.channel.strategy.StrategyList.Predicate
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(IPConnStrategy iPConnStrategy) {
        return iPConnStrategy.getPort() == this.a.a && iPConnStrategy.getIp().equals(this.b) && iPConnStrategy.protocol.equals(this.f461c);
    }
}
