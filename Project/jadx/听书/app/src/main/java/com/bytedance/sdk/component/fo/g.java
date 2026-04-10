package com.bytedance.sdk.component.fo;

import com.bytedance.sdk.component.g.z.kb;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f709a;
    final Map<String, String> dl;
    kb e;
    private final boolean fo;
    final String g;
    final long gc;
    final long m;
    final int z;
    private File gz = null;
    private byte[] uy = null;

    public g(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.fo = z;
        this.z = i;
        this.g = str;
        this.dl = map;
        this.f709a = str2;
        this.gc = j;
        this.m = j2;
    }

    public int z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public Map<String, String> dl() {
        return this.dl;
    }

    public String a() {
        return this.f709a;
    }

    public long gc() {
        return this.gc;
    }

    public long m() {
        return this.m;
    }

    public File e() {
        return this.gz;
    }

    public void z(File file) {
        this.gz = file;
    }

    public boolean gz() {
        return this.fo;
    }

    public long fo() {
        return this.gc - this.m;
    }

    public byte[] uy() {
        return this.uy;
    }

    public void z(byte[] bArr) {
        this.uy = bArr;
    }

    public kb kb() {
        return this.e;
    }

    public void z(kb kbVar) {
        this.e = kbVar;
    }
}
