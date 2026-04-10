package com.taobao.accs.net;

import anet.channel.strategy.StrategyCenter;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyCenter.getInstance().saveData();
    }
}
