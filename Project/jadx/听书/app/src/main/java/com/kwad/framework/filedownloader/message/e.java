package com.kwad.framework.filedownloader.message;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private volatile g aoK;
    private volatile b aoL;

    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static final class a {
        private static final e aoM = new e();
    }

    public static e yT() {
        return a.aoM;
    }

    public final void a(b bVar) {
        this.aoL = bVar;
        if (bVar == null) {
            this.aoK = null;
        } else {
            this.aoK = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.aoL != null) {
                this.aoL.r(messageSnapshot);
            }
        } else if (this.aoK != null) {
            this.aoK.u(messageSnapshot);
        }
    }
}
