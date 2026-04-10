package com.bytedance.sdk.openadsdk.core.dt;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.bf.tg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class zk {
    private View bh;
    private boolean s;
    private View t;
    private float e = -1.0f;
    private float bf = -1.0f;
    private float d = -1.0f;
    private float tg = -1.0f;
    private long ga = -1;
    private long vn = -1;
    private int p = -1;
    private int v = -1;
    private int zk = -1024;
    private boolean m = true;
    private int wu = 0;
    private int xu = 0;
    private boolean w = false;
    private SparseArray<tg.e> l = new SparseArray<>();
    private List<Integer> f = new ArrayList();

    public int bf() {
        return this.v;
    }

    public float bh() {
        return this.e;
    }

    public int d() {
        return this.zk;
    }

    public int e() {
        return this.p;
    }

    public boolean f() {
        return this.w;
    }

    public View ga() {
        return this.bh;
    }

    public boolean l() {
        return this.s;
    }

    public List<Integer> m() {
        return this.f;
    }

    public int p() {
        return this.wu;
    }

    public float s() {
        return this.d;
    }

    public float t() {
        return this.bf;
    }

    public boolean tg() {
        return this.m;
    }

    public int v() {
        return this.xu;
    }

    public View vn() {
        return this.t;
    }

    public float w() {
        return this.tg;
    }

    public long wu() {
        return this.ga;
    }

    public long xu() {
        return this.vn;
    }

    public SparseArray<tg.e> zk() {
        return this.l;
    }

    public void bf(int i) {
        this.v = i;
    }

    public void d(int i) {
        this.zk = i;
    }

    public void e(int i) {
        this.p = i;
    }

    public void ga(int i) {
        this.xu = i;
    }

    public void tg(int i) {
        this.wu = i;
    }

    public void bf(View view) {
        this.t = (View) new WeakReference(view).get();
    }

    public void d(float f) {
        this.d = f;
    }

    public void e(boolean z) {
        this.m = z;
    }

    public void tg(float f) {
        this.tg = f;
    }

    public void bf(long j) {
        this.vn = j;
    }

    public void d(boolean z) {
        this.w = z;
    }

    public void e(View view) {
        this.bh = (View) new WeakReference(view).get();
    }

    public void bf(float f) {
        this.bf = f;
    }

    public void e(SparseArray<tg.e> sparseArray) {
        this.l = sparseArray;
    }

    public void bf(boolean z) {
        this.s = z;
    }

    public void e(long j) {
        this.ga = j;
    }

    public void e(float f) {
        this.e = f;
    }
}
