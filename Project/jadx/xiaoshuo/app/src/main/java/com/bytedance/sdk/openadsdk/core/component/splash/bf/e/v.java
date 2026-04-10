package com.bytedance.sdk.openadsdk.core.component.splash.bf.e;

import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class v extends e {
    private com.bytedance.sdk.openadsdk.core.y.e.bf bf;
    private File d;
    private Map<String, String> m;
    private com.bytedance.sdk.openadsdk.core.y.e.bf tg;
    private com.bytedance.sdk.component.v.bf vn;
    private String wu;
    private long zk;
    private boolean ga = false;
    private boolean p = false;
    private boolean v = false;

    public v() {
    }

    public com.bytedance.sdk.openadsdk.core.y.e.bf bf() {
        return this.bf;
    }

    public File d() {
        return this.d;
    }

    public void e(com.bytedance.sdk.openadsdk.core.y.e.bf bfVar) {
        this.tg = bfVar;
    }

    public boolean ga() {
        return this.ga;
    }

    public boolean m() {
        return this.v;
    }

    public boolean p() {
        return this.p;
    }

    public com.bytedance.sdk.openadsdk.core.y.e.bf tg() {
        return this.tg;
    }

    public long v() {
        return this.zk;
    }

    public com.bytedance.sdk.component.v.bf vn() {
        return this.vn;
    }

    public String wu() {
        return this.wu;
    }

    public Map<String, String> zk() {
        return this.m;
    }

    public void bf(boolean z) {
        this.p = z;
    }

    public void d(boolean z) {
        this.v = z;
    }

    public void e(boolean z) {
        this.ga = z;
    }

    public void e(com.bytedance.sdk.component.v.bf bfVar) {
        this.vn = bfVar;
    }

    public void e(long j) {
        this.zk = j;
    }

    public v(com.bytedance.sdk.openadsdk.core.y.e.bf bfVar) {
        this.bf = bfVar;
    }

    public void e(Map<String, String> map) {
        this.m = map;
    }

    public void e(String str) {
        this.wu = str;
    }

    public v(File file) {
        this.d = file;
    }
}
