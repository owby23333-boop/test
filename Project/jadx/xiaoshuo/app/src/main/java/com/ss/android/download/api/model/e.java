package com.ss.android.download.api.model;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    public String bf;
    public String d;
    public String e;
    public String ga;
    public String tg;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.e$e, reason: collision with other inner class name */
    public static class C0481e {
        private String bf;
        private String d;
        private String e;
        private String ga;
        private String tg;

        public C0481e bf(String str) {
            this.bf = str;
            return this;
        }

        public C0481e d(String str) {
            this.tg = str;
            return this;
        }

        public C0481e e(String str) {
            this.e = str;
            return this;
        }

        public C0481e tg(String str) {
            this.ga = str;
            return this;
        }

        public e e() {
            return new e(this);
        }
    }

    public e(C0481e c0481e) {
        this.bf = "";
        this.e = c0481e.e;
        this.bf = c0481e.bf;
        this.d = c0481e.d;
        this.tg = c0481e.tg;
        this.ga = c0481e.ga;
    }
}
