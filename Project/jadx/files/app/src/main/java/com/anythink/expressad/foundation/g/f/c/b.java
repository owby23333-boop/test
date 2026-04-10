package com.anythink.expressad.foundation.g.f.c;

import com.baidu.tts.network.HttpClientUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Serializable {
    private byte[] a;
    private InputStream b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f10514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f10518g;

    private b(String str, byte[] bArr, long j2, String str2, String str3) {
        this.f10518g = HttpClientUtil.APPLICATION_OCTET_STREAM;
        this.f10516e = str;
        this.f10517f = str2;
        this.a = bArr;
        this.f10515d = j2;
        if (str3 != null) {
            this.f10518g = str3;
        }
    }

    public final long a() {
        return this.f10515d;
    }

    public final File b() {
        return this.f10514c;
    }

    public final InputStream c() {
        return this.b;
    }

    public final byte[] d() {
        return this.a;
    }

    public final String e() {
        return this.f10516e;
    }

    public final String f() {
        return this.f10517f;
    }

    public final String g() {
        return this.f10518g;
    }

    private void a(String str) {
        this.f10516e = str;
    }

    private void b(String str) {
        this.f10517f = str;
    }

    private void c(String str) {
        this.f10518g = str;
    }

    public b(String str, File file, String str2, String str3) {
        this.f10518g = HttpClientUtil.APPLICATION_OCTET_STREAM;
        this.f10516e = str;
        this.f10517f = str2;
        try {
            this.b = new FileInputStream(file);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        this.f10515d = file.length();
        if (str3 != null) {
            this.f10518g = str3;
        }
        this.f10514c = file;
    }

    private b(InputStream inputStream, int i2, String str, String str2, String str3) {
        this.f10518g = HttpClientUtil.APPLICATION_OCTET_STREAM;
        this.f10516e = str;
        this.f10517f = str2;
        this.b = inputStream;
        this.f10515d = i2;
        this.f10518g = str3;
    }
}
