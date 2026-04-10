package org.repackage.com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: classes4.dex */
class ValueData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2551a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i) {
        this.f2551a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f2551a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
