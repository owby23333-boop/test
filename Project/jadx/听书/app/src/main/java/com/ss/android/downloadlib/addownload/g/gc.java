package com.ss.android.downloadlib.addownload.g;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gc implements com.ss.android.g.z.g.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.z.z.dl.z f1987a;
    public com.ss.android.z.z.dl.g dl;
    public com.ss.android.z.z.dl.dl g;
    public com.ss.android.g.z.g.g gc;
    public long z;

    @Override // com.ss.android.g.z.g.z
    public int js() {
        return 0;
    }

    public gc() {
    }

    public gc(long j, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar) {
        this.z = j;
        this.g = dlVar;
        this.dl = gVar;
        this.f1987a = zVar;
    }

    public boolean io() {
        com.ss.android.z.z.dl.dl dlVar;
        if (this.z == 0 || (dlVar = this.g) == null || this.dl == null || this.f1987a == null) {
            return true;
        }
        return dlVar.io() && this.z <= 0;
    }

    public boolean uf() {
        if (io()) {
            return false;
        }
        if (this.g.io()) {
            com.ss.android.z.z.dl.dl dlVar = this.g;
            return (dlVar instanceof com.ss.android.g.z.z.dl) && !TextUtils.isEmpty(dlVar.uf()) && (this.dl instanceof com.ss.android.g.z.z.g) && (this.f1987a instanceof com.ss.android.g.z.z.z);
        }
        return this.g instanceof com.ss.android.g.z.z.dl;
    }

    @Override // com.ss.android.g.z.g.z
    public String z() {
        return this.g.z();
    }

    @Override // com.ss.android.g.z.g.z
    public long g() {
        return this.g.a();
    }

    @Override // com.ss.android.g.z.g.z
    public boolean dl() {
        return this.g.io();
    }

    @Override // com.ss.android.g.z.g.z
    public String a() {
        return this.g.uf();
    }

    @Override // com.ss.android.g.z.g.z
    public String gc() {
        return this.g.sy();
    }

    @Override // com.ss.android.g.z.g.z
    public String m() {
        if (this.g.l() != null) {
            return this.g.l().g();
        }
        return null;
    }

    @Override // com.ss.android.g.z.g.z
    public JSONObject e() {
        return this.g.gk();
    }

    @Override // com.ss.android.g.z.g.z
    public int gz() {
        if (this.f1987a.g() == 2) {
            return 2;
        }
        return this.g.oq();
    }

    @Override // com.ss.android.g.z.g.z
    public long wp() {
        return this.g.e();
    }

    @Override // com.ss.android.g.z.g.z
    public List<String> v() {
        return this.g.h();
    }

    @Override // com.ss.android.g.z.g.z
    public String fo() {
        return this.dl.z();
    }

    @Override // com.ss.android.g.z.g.z
    public String uy() {
        return this.dl.g();
    }

    @Override // com.ss.android.g.z.g.z
    public JSONObject kb() {
        return this.dl.pf();
    }

    @Override // com.ss.android.g.z.g.z
    public boolean i() {
        return this.dl.i();
    }

    @Override // com.ss.android.g.z.g.z
    public Object pf() {
        return this.dl.uy();
    }

    @Override // com.ss.android.g.z.g.z
    public JSONObject ls() {
        return this.dl.v();
    }

    @Override // com.ss.android.g.z.g.z
    public boolean p() {
        return this.f1987a.v();
    }

    @Override // com.ss.android.g.z.g.z
    public JSONObject fv() {
        return this.g.fv();
    }

    @Override // com.ss.android.g.z.g.z
    public com.ss.android.z.z.dl.dl q() {
        return this.g;
    }

    @Override // com.ss.android.g.z.g.z
    public com.ss.android.z.z.dl.g iq() {
        return this.dl;
    }

    @Override // com.ss.android.g.z.g.z
    public com.ss.android.z.z.dl.z zw() {
        return this.f1987a;
    }

    @Override // com.ss.android.g.z.g.z
    public int tb() {
        return this.dl.kb();
    }
}
