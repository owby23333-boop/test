package com.bytedance.z.g.e;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1512a;
    private boolean dl;
    private String g;
    private byte[] gc;
    private String z;

    public String z() {
        return this.z;
    }

    public boolean g() {
        return this.f1512a;
    }

    public byte[] dl() {
        return this.gc;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1513a;
        private boolean dl;
        private String g;
        private byte[] gc;
        private String z;

        public z z(String str) {
            this.z = str;
            return this;
        }

        public z z(boolean z) {
            this.f1513a = z;
            return this;
        }

        public z z(byte[] bArr) {
            this.gc = bArr;
            return this;
        }

        public gc z() {
            gc gcVar = new gc();
            gcVar.z = this.z;
            gcVar.g = this.g;
            gcVar.dl = this.dl;
            gcVar.f1512a = this.f1513a;
            gcVar.gc = this.gc;
            return gcVar;
        }
    }
}
