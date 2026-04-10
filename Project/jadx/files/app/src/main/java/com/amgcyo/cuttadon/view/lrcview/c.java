package com.amgcyo.cuttadon.view.lrcview;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: compiled from: LrcEntry.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Comparable<c> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f4888s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f4889t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f4890u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private StaticLayout f4891v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f4892w;

    private String e() {
        if (TextUtils.isEmpty(this.f4890u)) {
            return this.f4889t;
        }
        return this.f4889t + "\n" + this.f4890u;
    }

    void a(TextPaint textPaint, int i2, int i3) {
        this.f4891v = new StaticLayout(e(), textPaint, i2, i3 != 1 ? i3 != 2 ? Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, false);
        this.f4892w = Float.MIN_VALUE;
    }

    public float b() {
        return this.f4892w;
    }

    StaticLayout c() {
        return this.f4891v;
    }

    public long d() {
        return this.f4888s;
    }

    int a() {
        StaticLayout staticLayout = this.f4891v;
        if (staticLayout == null) {
            return 0;
        }
        return staticLayout.getHeight();
    }

    public void a(float f2) {
        this.f4892w = f2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        if (cVar == null) {
            return -1;
        }
        return (int) (this.f4888s - cVar.d());
    }
}
