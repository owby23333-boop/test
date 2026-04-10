package com.bytedance.sdk.openadsdk.core.iq;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.g.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    private View i;
    private String iq;
    private String js;
    private String p;
    private boolean pf;
    private View v;
    private int zw;
    private float z = -1.0f;
    private float g = -1.0f;
    private float dl = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1200a = -1.0f;
    private long gc = -1;
    private long m = -1;
    private int e = -1;
    private int gz = -1;
    private int fo = -1024;
    private boolean uy = true;
    private int kb = 0;
    private int wp = 0;
    private boolean ls = false;
    private int fv = -1;
    private SparseArray<a.z> tb = new SparseArray<>();
    private List<Integer> q = new ArrayList();

    public boolean z() {
        return this.zw == 2;
    }

    public void z(int i) {
        this.zw = i;
    }

    public int g() {
        return this.e;
    }

    public void g(int i) {
        this.e = i;
    }

    public int dl() {
        return this.gz;
    }

    public void dl(int i) {
        this.gz = i;
    }

    public int a() {
        return this.fo;
    }

    public void a(int i) {
        this.fo = i;
    }

    public boolean gc() {
        return this.uy;
    }

    public void z(boolean z) {
        this.uy = z;
    }

    public View m() {
        return this.i;
    }

    public void z(View view) {
        this.i = (View) new WeakReference(view).get();
    }

    public View e() {
        return this.v;
    }

    public void g(View view) {
        this.v = (View) new WeakReference(view).get();
    }

    public int gz() {
        return this.kb;
    }

    public void gc(int i) {
        this.kb = i;
    }

    public int fo() {
        return this.wp;
    }

    public void m(int i) {
        this.wp = i;
    }

    public SparseArray<a.z> uy() {
        return this.tb;
    }

    public void z(SparseArray<a.z> sparseArray) {
        this.tb = sparseArray;
    }

    public List<Integer> kb() {
        return this.q;
    }

    public long wp() {
        return this.gc;
    }

    public void z(long j) {
        this.gc = j;
    }

    public long i() {
        return this.m;
    }

    public void g(long j) {
        this.m = j;
    }

    public float v() {
        return this.z;
    }

    public void z(float f) {
        this.z = f;
    }

    public float pf() {
        return this.g;
    }

    public void g(float f) {
        this.g = f;
    }

    public float ls() {
        return this.dl;
    }

    public void dl(float f) {
        this.dl = f;
    }

    public float p() {
        return this.f1200a;
    }

    public void a(float f) {
        this.f1200a = f;
    }

    public void g(boolean z) {
        this.pf = z;
    }

    public void z(String str) {
        this.p = str;
    }

    public String fv() {
        return this.p;
    }

    public void e(int i) {
        this.fv = i;
    }

    public int js() {
        return this.fv;
    }

    public String tb() {
        return this.js;
    }

    public void g(String str) {
        this.js = str;
    }

    public void dl(boolean z) {
        this.ls = z;
    }

    public String q() {
        return this.iq;
    }

    public void dl(String str) {
        this.iq = str;
    }
}
