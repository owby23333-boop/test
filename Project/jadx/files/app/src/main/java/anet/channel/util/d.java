package anet.channel.util;

import anet.channel.statist.NetTypeStat;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ NetTypeStat b;

    d(String str, NetTypeStat netTypeStat) {
        this.a = str;
        this.b = netTypeStat;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(new e(this), ThreadPoolExecutorFactory.Priority.LOW);
    }
}
