package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.a.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uy f2061a;
    private i dl;
    private com.ss.android.socialbase.downloader.fo.gz e;
    private v fo;
    private ExecutorService fv;
    private wp g;
    private un gc;
    private com.ss.android.socialbase.downloader.fo.m gz;
    private int io;
    private ExecutorService iq;
    private ExecutorService js;
    private fv kb;
    private ExecutorService ls;
    private com.ss.android.socialbase.downloader.fo.uy m;
    private ExecutorService p;
    private ExecutorService pf;
    private ExecutorService q;
    private boolean sy;
    private ExecutorService tb;
    private int uf;
    private fo uy;
    private x v;
    private com.ss.android.socialbase.downloader.gz.g wp;
    private final Context z;
    private iq zw;
    private List<com.ss.android.socialbase.downloader.a.v> i = new ArrayList();
    private boolean hh = true;
    private int l = 1056964607;

    public gz(Context context) {
        this.z = context;
    }

    public gz z(com.ss.android.socialbase.downloader.fo.uy uyVar) {
        this.m = uyVar;
        return this;
    }

    public gz z(com.ss.android.socialbase.downloader.a.v vVar) {
        synchronized (this.i) {
            if (vVar != null) {
                if (!this.i.contains(vVar)) {
                    this.i.add(vVar);
                    return this;
                }
            }
            return this;
        }
    }

    public gz z(un unVar) {
        this.gc = unVar;
        return this;
    }

    public gz z(x xVar) {
        this.v = xVar;
        return this;
    }

    public Context getContext() {
        return this.z;
    }

    public wp z() {
        return this.g;
    }

    public i g() {
        return this.dl;
    }

    public com.ss.android.socialbase.downloader.fo.uy dl() {
        return this.m;
    }

    public com.ss.android.socialbase.downloader.fo.gz a() {
        return this.e;
    }

    public v gc() {
        return this.fo;
    }

    public ExecutorService m() {
        return this.pf;
    }

    public ExecutorService e() {
        return this.ls;
    }

    public ExecutorService gz() {
        return this.p;
    }

    public ExecutorService fo() {
        return this.fv;
    }

    public ExecutorService uy() {
        return this.js;
    }

    public ExecutorService kb() {
        return this.tb;
    }

    public ExecutorService wp() {
        return this.q;
    }

    public ExecutorService i() {
        return this.iq;
    }

    public List<com.ss.android.socialbase.downloader.a.v> v() {
        return this.i;
    }

    public int pf() {
        return this.io;
    }

    public uy ls() {
        return this.f2061a;
    }

    public fo p() {
        return this.uy;
    }

    public int fv() {
        return this.uf;
    }

    public boolean js() {
        return this.sy;
    }

    public fv tb() {
        return this.kb;
    }

    public int q() {
        return this.l;
    }

    public iq iq() {
        return this.zw;
    }

    public boolean zw() {
        return this.hh;
    }

    public un io() {
        return this.gc;
    }

    public x uf() {
        return this.v;
    }

    public com.ss.android.socialbase.downloader.gz.g sy() {
        return this.wp;
    }

    public com.ss.android.socialbase.downloader.fo.m hh() {
        return this.gz;
    }

    public e l() {
        return new e(this);
    }
}
