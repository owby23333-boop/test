package com.alibaba.sdk.android.utils.crashdefend;

/* JADX INFO: compiled from: CrashDefendSDKInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Cloneable {
    public long a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f55b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2247c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f56c;
    public int crashCount;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f57d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2248d = 0;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public volatile boolean f58d = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SDKMessageCallback f54a = null;

    public Object clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
