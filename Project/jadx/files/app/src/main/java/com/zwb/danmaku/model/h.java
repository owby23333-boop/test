package com.zwb.danmaku.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TrajectoryInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    private float a;
    private float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f20692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f20693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f20694e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<BaseDanmaku> f20695f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<BaseDanmaku> f20696g = new ArrayList();

    public h a(float f2) {
        this.a = f2;
        return this;
    }

    public h b(float f2) {
        this.b = f2;
        return this;
    }

    public h c(float f2) {
        this.f20692c = f2;
        return this;
    }

    public float d() {
        return this.a;
    }

    public int e() {
        Iterator<BaseDanmaku> it = this.f20695f.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().D()) {
                i2++;
            }
        }
        return i2;
    }

    public float f() {
        return this.b;
    }

    public List<BaseDanmaku> g() {
        return this.f20695f;
    }

    public float h() {
        return this.f20692c;
    }

    public String toString() {
        return "TrajectoryInfo{, left=" + this.a + ", right=" + this.b + ", top=" + this.f20692c + ", bottom=" + this.f20693d + ", num=" + this.f20694e + ", showingDanmakus=" + this.f20695f + ", goneDanmakus=" + this.f20696g + '}';
    }

    public h a(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.f20692c = f3;
        this.b = f4;
        this.f20693d = f5;
        return this;
    }

    public float b() {
        return this.f20693d;
    }

    public List<BaseDanmaku> c() {
        return this.f20696g;
    }

    public void a(int i2) {
        this.f20694e = i2;
    }

    public void a() {
        if (this.f20695f.isEmpty()) {
            return;
        }
        Iterator<BaseDanmaku> it = this.f20695f.iterator();
        while (it.hasNext()) {
            BaseDanmaku next = it.next();
            if (!next.B()) {
                return;
            }
            it.remove();
            next.F();
            this.f20696g.add(next);
        }
    }
}
