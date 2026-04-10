package com.bytedance.msdk.core.gz;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private long dl;
    private List<String> g;
    private List<String> z;

    public long z() {
        return this.dl;
    }

    public void z(long j) {
        this.dl = j;
    }

    public List<String> g() {
        return this.z;
    }

    public void z(List<String> list) {
        this.z = list;
    }

    public List<String> dl() {
        return this.g;
    }

    public void g(List<String> list) {
        this.g = list;
    }

    public String toString() {
        return "AdnLoadFailShowConfigBean{ breadRequestErrorCode=" + this.z + ",ritList=" + this.g + ",breadRequestDuration=" + this.dl + " }";
    }
}
