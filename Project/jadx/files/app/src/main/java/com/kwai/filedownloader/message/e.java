package com.kwai.filedownloader.message;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private volatile g aGZ;
    private volatile b aHa;

    public static final class a {
        private static final e aHb = new e();
    }

    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e Ij() {
        return a.aHb;
    }

    public final void a(b bVar) {
        this.aHa = bVar;
        if (bVar == null) {
            this.aGZ = null;
        } else {
            this.aGZ = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.aHa != null) {
                this.aHa.r(messageSnapshot);
            }
        } else if (this.aGZ != null) {
            this.aGZ.u(messageSnapshot);
        }
    }
}
