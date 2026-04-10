package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.download.ConnectTask;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Runnable {
    private final String aca;
    private final int amZ;
    private final ConnectTask anV;
    private final f anW;
    private e anX;
    final int anY;
    private final boolean anw;
    private volatile boolean nf;

    /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    private c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.amZ = i;
        this.anY = i2;
        this.nf = false;
        this.anW = fVar;
        this.aca = str;
        this.anV = connectTask;
        this.anw = z;
    }

    public final void pause() {
        this.nf = true;
        e eVar = this.anX;
        if (eVar != null) {
            eVar.pause();
        }
    }

    public final void xy() {
        pause();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0141 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.c.run():void");
    }

    public static class a {
        private String aca;
        private Boolean anT;
        private f anW;
        private final ConnectTask.a anZ = new ConnectTask.a();
        private Integer aoa;

        public final a a(f fVar) {
            this.anW = fVar;
            return this;
        }

        public final a bM(int i) {
            this.anZ.bL(i);
            return this;
        }

        public final a bs(String str) {
            this.anZ.bp(str);
            return this;
        }

        public final a bt(String str) {
            this.anZ.bq(str);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.anZ.a(bVar);
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.anZ.a(aVar);
            return this;
        }

        public final a bu(String str) {
            this.aca = str;
            return this;
        }

        public final a bg(boolean z) {
            this.anT = Boolean.valueOf(z);
            return this;
        }

        public final a i(Integer num) {
            this.aoa = num;
            return this;
        }

        public final c yt() {
            if (this.anW == null || this.aca == null || this.anT == null || this.aoa == null) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("%s %s %B", this.anW, this.aca, this.anT));
            }
            ConnectTask connectTaskYb = this.anZ.yb();
            return new c(connectTaskYb.amZ, this.aoa.intValue(), connectTaskYb, this.anW, this.anT.booleanValue(), this.aca, (byte) 0);
        }
    }
}
