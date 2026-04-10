package d.a.o;

import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ g f20746s;

    h(g gVar) {
        this.f20746s = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(this.f20746s, ThreadPoolExecutorFactory.Priority.HIGH);
    }
}
