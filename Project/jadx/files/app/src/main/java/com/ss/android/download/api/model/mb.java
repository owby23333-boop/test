package com.ss.android.download.api.model;

/* JADX INFO: loaded from: classes3.dex */
public class mb {
    public String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f17950h;
    public String hj;
    public String mb;
    public String ox;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.mb$mb, reason: collision with other inner class name */
    public static class C0509mb {
        private String b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f17951h;
        private String hj;
        private String mb;
        private String ox;

        public C0509mb b(String str) {
            this.hj = str;
            return this;
        }

        public C0509mb hj(String str) {
            this.f17951h = str;
            return this;
        }

        public C0509mb mb(String str) {
            this.mb = str;
            return this;
        }

        public C0509mb ox(String str) {
            this.ox = str;
            return this;
        }

        public mb mb() {
            return new mb(this);
        }
    }

    public mb(C0509mb c0509mb) {
        this.ox = "";
        this.mb = c0509mb.mb;
        this.ox = c0509mb.ox;
        this.b = c0509mb.b;
        this.hj = c0509mb.hj;
        this.f17950h = c0509mb.f17951h;
    }
}
