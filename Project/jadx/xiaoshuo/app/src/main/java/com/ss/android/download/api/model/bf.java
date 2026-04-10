package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class bf {
    public String bf;
    public String d;
    public Context e;
    public String ga;
    public int m;
    public Drawable p;
    public String tg;
    public InterfaceC0480bf v;
    public boolean vn;
    public View zk;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.bf$bf, reason: collision with other inner class name */
    public interface InterfaceC0480bf {
        void bf(DialogInterface dialogInterface);

        void d(DialogInterface dialogInterface);

        void e(DialogInterface dialogInterface);
    }

    public static final class e {
        public int bf;
        private Context d;
        public View e;
        private String ga;
        private InterfaceC0480bf m;
        private String p;
        private String tg;
        private boolean v;
        private String vn;
        private Drawable zk;

        public e(Context context) {
            this.d = context;
        }

        public e bf(String str) {
            this.ga = str;
            return this;
        }

        public e d(String str) {
            this.vn = str;
            return this;
        }

        public e e(String str) {
            this.tg = str;
            return this;
        }

        public e tg(String str) {
            this.p = str;
            return this;
        }

        public e e(boolean z) {
            this.v = z;
            return this;
        }

        public e e(Drawable drawable2) {
            this.zk = drawable2;
            return this;
        }

        public e e(InterfaceC0480bf interfaceC0480bf) {
            this.m = interfaceC0480bf;
            return this;
        }

        public e e(int i) {
            this.bf = i;
            return this;
        }

        public bf e() {
            return new bf(this);
        }
    }

    private bf(e eVar) {
        this.vn = true;
        this.e = eVar.d;
        this.bf = eVar.tg;
        this.d = eVar.ga;
        this.tg = eVar.vn;
        this.ga = eVar.p;
        this.vn = eVar.v;
        this.p = eVar.zk;
        this.v = eVar.m;
        this.zk = eVar.e;
        this.m = eVar.bf;
    }
}
