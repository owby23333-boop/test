package com.bytedance.sdk.component.panglearmor;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f780a;
    private String dl;
    private String g;
    private gz gc;
    private Context z;

    public Context z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public boolean dl() {
        return this.f780a;
    }

    public gz a() {
        return this.gc;
    }

    public static class z {
        private final String dl;
        private final String g;
        private final Context z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f781a = false;
        private gz gc = null;

        public z(Context context, String str, String str2) {
            this.z = context;
            this.dl = str2;
            this.g = str;
        }

        public void z(gz gzVar) {
            this.gc = gzVar;
        }

        public z z(boolean z) {
            this.f781a = z;
            return this;
        }

        public e z() {
            e eVar = new e();
            eVar.z = this.z;
            eVar.g = this.g;
            eVar.dl = this.dl;
            eVar.gc = this.gc;
            eVar.f780a = this.f781a;
            return eVar;
        }
    }
}
