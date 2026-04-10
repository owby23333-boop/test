package com.amgcyo.cuttadon.view.showcaseview;

import android.app.Activity;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: MaterialShowcaseSequence.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {
    g a;
    Queue<MaterialShowcaseView> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Activity f5485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f5486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f5488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f5489h;

    /* JADX INFO: compiled from: MaterialShowcaseSequence.java */
    public interface a {
        void a(MaterialShowcaseView materialShowcaseView, int i2);
    }

    /* JADX INFO: compiled from: MaterialShowcaseSequence.java */
    public interface b {
        void a(MaterialShowcaseView materialShowcaseView, int i2);
    }

    public f(Activity activity) {
        this.f5484c = false;
        this.f5487f = 0;
        this.f5488g = null;
        this.f5489h = null;
        this.f5485d = activity;
        this.b = new LinkedList();
    }

    private void c() {
        if (this.b.size() <= 0 || this.f5485d.isFinishing()) {
            if (this.f5484c) {
                this.a.e();
                return;
            }
            return;
        }
        MaterialShowcaseView materialShowcaseViewRemove = this.b.remove();
        materialShowcaseViewRemove.setDetachedListener(this);
        materialShowcaseViewRemove.a(this.f5485d);
        b bVar = this.f5488g;
        if (bVar != null) {
            bVar.a(materialShowcaseViewRemove, this.f5487f);
        }
    }

    private void d() {
        this.b.clear();
        if (this.b.size() <= 0 || this.f5485d.isFinishing()) {
            if (this.f5484c) {
                this.a.e();
                return;
            }
            return;
        }
        MaterialShowcaseView materialShowcaseViewRemove = this.b.remove();
        materialShowcaseViewRemove.setDetachedListener(this);
        materialShowcaseViewRemove.a(this.f5485d);
        b bVar = this.f5488g;
        if (bVar != null) {
            bVar.a(materialShowcaseViewRemove, this.f5487f);
        }
    }

    public f a(MaterialShowcaseView materialShowcaseView) {
        h hVar = this.f5486e;
        if (hVar != null) {
            materialShowcaseView.setConfig(hVar);
        }
        this.b.add(materialShowcaseView);
        return this;
    }

    public void b() {
        if (this.f5484c) {
            if (a()) {
                return;
            }
            this.f5487f = this.a.b();
            if (this.f5487f > 0) {
                for (int i2 = 0; i2 < this.f5487f; i2++) {
                    this.b.poll();
                }
            }
        }
        if (this.b.size() > 0) {
            c();
        }
    }

    public f a(String str) {
        this.f5484c = true;
        this.a = new g(this.f5485d, str);
        return this;
    }

    public boolean a() {
        return this.a.b() == g.f5491d;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.d
    public void a(MaterialShowcaseView materialShowcaseView, boolean z2, boolean z3) {
        materialShowcaseView.setDetachedListener(null);
        if (z2) {
            a aVar = this.f5489h;
            if (aVar != null) {
                aVar.a(materialShowcaseView, this.f5487f);
            }
            g gVar = this.a;
            if (gVar != null) {
                this.f5487f++;
                gVar.a(this.f5487f);
            }
            c();
        }
        if (z3) {
            a aVar2 = this.f5489h;
            if (aVar2 != null) {
                aVar2.a(materialShowcaseView, this.f5487f);
            }
            g gVar2 = this.a;
            if (gVar2 != null) {
                this.f5487f++;
                gVar2.a(this.f5487f);
            }
            d();
        }
    }

    public f(Activity activity, String str) {
        this(activity);
        a(str);
    }
}
