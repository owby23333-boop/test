package com.bytedance.sdk.openadsdk.core.component.splash.dl.z;

import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.io.z.g f1006a;
    private long fo;
    private long fv;
    private String i;
    private long kb;
    private com.bytedance.sdk.openadsdk.ls.dl.g.g ls;
    private com.bytedance.sdk.component.fo.g m;
    private String p;
    private boolean pf;
    private long uy;
    private boolean v;
    private Map<String, String> wp;
    private boolean gc = false;
    private boolean e = false;
    private boolean gz = false;
    private AtomicBoolean js = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.z.z
    public int z() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.z.z
    public void z(int i) {
        this.z = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.z.z
    public na g() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.z.z
    public void z(na naVar) {
        this.g = naVar;
    }

    public gz(na naVar, boolean z) {
        this.g = naVar;
        this.v = z;
    }

    public gz(com.bytedance.sdk.openadsdk.core.io.z.g gVar, na naVar, boolean z) {
        this.f1006a = gVar;
        this.g = naVar;
        this.v = z;
    }

    public com.bytedance.sdk.openadsdk.core.io.z.g a() {
        return this.f1006a;
    }

    public boolean gc() {
        return this.gc;
    }

    public void z(boolean z) {
        this.gc = z;
    }

    public void z(com.bytedance.sdk.component.fo.g gVar) {
        this.m = gVar;
    }

    public boolean m() {
        return this.e;
    }

    public void g(boolean z) {
        this.e = z;
    }

    public long e() {
        return this.fo;
    }

    public void g(long j) {
        this.fo = j;
    }

    public void dl(long j) {
        this.uy = j;
    }

    public long gz() {
        return this.kb;
    }

    public void a(long j) {
        this.kb = j;
    }

    public Map<String, String> fo() {
        return this.wp;
    }

    public void z(Map<String, String> map) {
        this.wp = map;
    }

    public boolean uy() {
        return this.gz;
    }

    public void dl(boolean z) {
        this.gz = z;
    }

    public void z(String str) {
        this.i = str;
    }

    public boolean kb() {
        return this.v;
    }

    public void a(boolean z) {
        this.pf = z;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.g wp() {
        return this.ls;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        this.ls = gVar;
    }

    public String i() {
        return this.p;
    }

    public void g(String str) {
        this.p = str;
    }

    public long v() {
        return this.fv;
    }

    public void gc(long j) {
        this.fv = j;
    }

    public boolean pf() {
        return this.js.get();
    }

    public void gc(boolean z) {
        this.js.set(z);
    }
}
