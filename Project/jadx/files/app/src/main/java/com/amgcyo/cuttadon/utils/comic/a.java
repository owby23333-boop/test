package com.amgcyo.cuttadon.utils.comic;

/* JADX INFO: compiled from: ComicsPreferenceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public boolean a(String str, boolean z2) {
        return d.a(str, z2).booleanValue();
    }

    public int b(String str, int i2) {
        return d.a(str, i2).intValue();
    }

    public void c(String str, int i2) {
        d.a(str, Integer.valueOf(i2));
    }

    public float a(String str, int i2) {
        return d.a(str, i2).floatValue();
    }

    public void b(String str, boolean z2) {
        d.a(str, Boolean.valueOf(z2));
    }

    public void a(String str, float f2) {
        d.a(str, Float.valueOf(f2));
    }
}
