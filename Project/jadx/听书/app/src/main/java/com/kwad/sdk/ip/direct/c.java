package com.kwad.sdk.ip.direct;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Comparable<c> {
    private String ip;
    private boolean success;
    private int weight;
    private float aRY = -1.0f;
    private int aSe = 20;
    private int aSd = 3;
    private StringBuffer aSf = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.aSd + ", pingWaitTime=" + this.aSe + ", pingTime='" + this.aRY + " ms', success=" + this.success + '}';
    }

    public final int MQ() {
        return this.aSd;
    }

    public final String getIp() {
        return this.ip;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final void bJ(boolean z) {
        this.success = z;
    }

    public final float MR() {
        return this.aRY;
    }

    public final void k(float f) {
        this.aRY = f;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void dZ(int i) {
        this.weight = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return (int) (this.aRY - cVar.aRY);
    }
}
