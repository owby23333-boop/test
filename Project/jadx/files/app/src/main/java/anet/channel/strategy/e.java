package anet.channel.strategy;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ StrategyInfoHolder b;

    e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.b = strategyInfoHolder;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a, true);
    }
}
