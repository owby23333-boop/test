package com.ss.android.z.z.gc;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2121a;
    public String dl;
    public Drawable e;
    public View fo;
    public String g;
    public String gc;
    public g gz;
    public boolean m;
    public int uy;
    public Context z;

    public interface g {
        void dl(DialogInterface dialogInterface);

        void g(DialogInterface dialogInterface);

        void z(DialogInterface dialogInterface);
    }

    private dl(z zVar) {
        this.m = true;
        this.z = zVar.dl;
        this.g = zVar.f2122a;
        this.dl = zVar.gc;
        this.f2121a = zVar.m;
        this.gc = zVar.e;
        this.m = zVar.gz;
        this.e = zVar.fo;
        this.gz = zVar.uy;
        this.fo = zVar.z;
        this.uy = zVar.g;
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2122a;
        private Context dl;
        private String e;
        private Drawable fo;
        public int g;
        private String gc;
        private boolean gz;
        private String m;
        private g uy;
        public View z;

        public z(Context context) {
            this.dl = context;
        }

        public z z(String str) {
            this.f2122a = str;
            return this;
        }

        public z g(String str) {
            this.gc = str;
            return this;
        }

        public z dl(String str) {
            this.m = str;
            return this;
        }

        public z a(String str) {
            this.e = str;
            return this;
        }

        public z z(boolean z) {
            this.gz = z;
            return this;
        }

        public z z(Drawable drawable) {
            this.fo = drawable;
            return this;
        }

        public z z(g gVar) {
            this.uy = gVar;
            return this;
        }

        public z z(int i) {
            this.g = i;
            return this;
        }

        public dl z() {
            return new dl(this);
        }
    }
}
