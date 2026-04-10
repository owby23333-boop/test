package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class CurrentParsingState {
    private int a = 0;
    private State b = State.NUMERIC;

    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    CurrentParsingState() {
    }

    int a() {
        return this.a;
    }

    void b(int i2) {
        this.a = i2;
    }

    boolean c() {
        return this.b == State.ISO_IEC_646;
    }

    void d() {
        this.b = State.ALPHA;
    }

    void e() {
        this.b = State.ISO_IEC_646;
    }

    void f() {
        this.b = State.NUMERIC;
    }

    void a(int i2) {
        this.a += i2;
    }

    boolean b() {
        return this.b == State.ALPHA;
    }
}
