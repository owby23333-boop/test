package com.chad.library.adapter.base.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

/* JADX INFO: compiled from: LoadMoreView.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private int a = 1;
    private boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14748c = "没有更多数据了";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14749d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14750e = 0;

    private void b(com.chad.library.adapter.base.b bVar) {
        bVar.a(c(), this.f14748c);
        if (this.f14750e != 0) {
            bVar.a(b(), this.f14750e);
        }
        if (this.f14749d != 0) {
            bVar.b(c(), this.f14749d);
        }
    }

    private void c(com.chad.library.adapter.base.b bVar, boolean z2) {
        bVar.a(h(), z2);
        View viewA = bVar.a(g());
        if (viewA instanceof ImageView) {
            a(bVar, (ImageView) viewA, z2);
        }
    }

    @LayoutRes
    public abstract int a();

    public void a(int i2) {
        this.a = i2;
    }

    protected abstract void a(com.chad.library.adapter.base.b bVar, ImageView imageView, boolean z2);

    @IdRes
    protected abstract int b();

    @IdRes
    public abstract int c();

    @IdRes
    protected abstract int d();

    @IdRes
    protected abstract int e();

    public int f() {
        return this.a;
    }

    @IdRes
    protected abstract int g();

    @IdRes
    protected abstract int h();

    @IdRes
    public abstract int i();

    public final boolean j() {
        if (b() == 0) {
            return true;
        }
        return this.b;
    }

    public void a(int i2, String str) {
        this.a = i2;
        this.f14748c = str;
    }

    public void a(int i2, int i3, int i4) {
        this.a = i2;
        this.f14749d = i3;
        this.f14750e = i4;
    }

    private void c(com.chad.library.adapter.base.b bVar) {
        if (TextUtils.isEmpty(this.f14748c)) {
            this.f14748c = "加载失败，请点我重试!";
        }
        bVar.a(e(), this.f14748c);
    }

    private void b(com.chad.library.adapter.base.b bVar, boolean z2) {
        bVar.a(d(), z2);
    }

    public void a(com.chad.library.adapter.base.b bVar) {
        int i2 = this.a;
        if (i2 == 1) {
            c(bVar, false);
            b(bVar, false);
            a(bVar, false);
            b(bVar);
            c(bVar);
            return;
        }
        if (i2 == 2) {
            c(bVar, true);
            b(bVar, false);
            a(bVar, false);
        } else {
            if (i2 == 3) {
                c(bVar, false);
                b(bVar, true);
                a(bVar, false);
                c(bVar);
                return;
            }
            if (i2 != 4) {
                return;
            }
            c(bVar, false);
            b(bVar, false);
            a(bVar, true);
            b(bVar);
        }
    }

    private void a(com.chad.library.adapter.base.b bVar, boolean z2) {
        int iB = b();
        if (iB != 0) {
            bVar.a(iB, z2);
        }
    }

    public final void a(boolean z2) {
        this.b = z2;
    }
}
