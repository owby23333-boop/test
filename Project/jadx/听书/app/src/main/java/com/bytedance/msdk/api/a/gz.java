package com.bytedance.msdk.api.a;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f348a;
    private boolean dl;
    private String g;
    private boolean z;

    private gz(z zVar) {
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f348a = zVar.f349a;
    }

    public static class z {
        private boolean z = false;
        private String g = null;
        private boolean dl = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f349a = false;

        public z z(boolean z) {
            this.z = z;
            return this;
        }

        public z z(String str) {
            this.g = str;
            return this;
        }

        public z g(boolean z) {
            this.dl = z;
            return this;
        }

        public z dl(boolean z) {
            this.f349a = z;
            return this;
        }

        public gz z() {
            return new gz(this);
        }
    }

    public String z() {
        return this.g;
    }

    public boolean g() {
        return this.z;
    }

    public boolean dl() {
        return this.dl;
    }

    public boolean a() {
        return this.f348a;
    }
}
