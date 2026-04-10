package com.liulishuo.filedownloader.message;

/* JADX INFO: compiled from: MessageSnapshotFlow.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private volatile e a;
    private volatile b b;

    /* JADX INFO: compiled from: MessageSnapshotFlow.java */
    public static final class a {
        private static final c a = new c();
    }

    /* JADX INFO: compiled from: MessageSnapshotFlow.java */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static c a() {
        return a.a;
    }

    public void a(b bVar) {
        this.b = bVar;
        if (bVar == null) {
            this.a = null;
        } else {
            this.a = new e(5, bVar);
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.liulishuo.filedownloader.message.a) {
            if (this.b != null) {
                this.b.a(messageSnapshot);
            }
        } else if (this.a != null) {
            this.a.a(messageSnapshot);
        }
    }
}
