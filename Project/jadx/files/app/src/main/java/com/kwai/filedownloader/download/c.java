package com.kwai.filedownloader.download;

import com.kwai.filedownloader.download.ConnectTask;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    private final String RY;
    private final boolean aFL;
    private final int aFo;
    private final ConnectTask aGk;
    private final f aGl;
    private e aGm;
    final int aGn;
    private volatile boolean lf;

    public static class a {
        private String RY;
        private Boolean aGi;
        private f aGl;
        private final ConnectTask.a aGo = new ConnectTask.a();
        private Integer aGp;

        public final c HJ() {
            if (this.aGl == null || this.RY == null || this.aGi == null || this.aGp == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("%s %s %B", this.aGl, this.RY, this.aGi));
            }
            ConnectTask connectTaskHs = this.aGo.Hs();
            return new c(connectTaskHs.aFo, this.aGp.intValue(), connectTaskHs, this.aGl, this.aGi.booleanValue(), this.RY, (byte) 0);
        }

        public final a a(f fVar) {
            this.aGl = fVar;
            return this;
        }

        public final a b(com.kwai.filedownloader.download.a aVar) {
            this.aGo.a(aVar);
            return this;
        }

        public final a bM(boolean z2) {
            this.aGi = Boolean.valueOf(z2);
            return this;
        }

        public final a c(com.kwai.filedownloader.c.b bVar) {
            this.aGo.a(bVar);
            return this;
        }

        public final a cM(int i2) {
            this.aGo.cL(i2);
            return this;
        }

        public final a d(Integer num) {
            this.aGp = num;
            return this;
        }

        public final a eZ(String str) {
            this.aGo.eW(str);
            return this;
        }

        public final a fa(String str) {
            this.aGo.eX(str);
            return this;
        }

        public final a fb(String str) {
            this.RY = str;
            return this;
        }
    }

    private c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z2, String str) {
        this.aFo = i2;
        this.aGn = i3;
        this.lf = false;
        this.aGl = fVar;
        this.RY = str;
        this.aGk = connectTask;
        this.aFL = z2;
    }

    /* synthetic */ c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z2, String str, byte b) {
        this(i2, i3, connectTask, fVar, z2, str);
    }

    public final void GT() {
        pause();
    }

    public final void pause() {
        this.lf = true;
        e eVar = this.aGm;
        if (eVar != null) {
            eVar.pause();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0153  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.c.run():void");
    }
}
