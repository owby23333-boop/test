package com.kwad.sdk.ip.direct;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Comparable<c> {
    private String ip;
    private boolean success;
    private int weight;
    private float atp = -1.0f;
    private int atu = 20;
    private int att = 3;
    private StringBuffer atv = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return (int) (this.atp - cVar.atp);
    }

    public final int Bi() {
        return this.att;
    }

    public final float Bj() {
        return this.atp;
    }

    public final void bE(int i2) {
        this.weight = i2;
    }

    public final void bg(boolean z2) {
        this.success = z2;
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void i(float f2) {
        this.atp = f2;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.att + ", pingWaitTime=" + this.atu + ", pingTime='" + this.atp + " ms', success=" + this.success + '}';
    }
}
