package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public class ju {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f8143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final short f869a;

    public ju() {
        this("", (byte) 0, (short) 0);
    }

    public String toString() {
        return "<TField name:'" + this.f868a + "' type:" + ((int) this.f8143a) + " field-id:" + ((int) this.f869a) + ">";
    }

    public ju(String str, byte b2, short s) {
        this.f868a = str;
        this.f8143a = b2;
        this.f869a = s;
    }
}
