package com.kwad.sdk.utils.kwai;

/* JADX INFO: loaded from: classes3.dex */
final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.utils.kwai.a$a, reason: collision with other inner class name */
    static class C0458a extends j {
        C0458a(int i2, int i3, Object obj, int i4, boolean z2) {
            super(i2, i3, obj, i4, z2);
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte EX() {
            return (byte) 7;
        }
    }

    static abstract class b {
        int offset;

        b() {
        }

        abstract byte EX();
    }

    static class c extends b {
        boolean value;

        c(int i2, boolean z2) {
            this.offset = i2;
            this.value = z2;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte EX() {
            return (byte) 1;
        }
    }

    static class d extends b {
        double value;

        d(int i2, double d2) {
            this.offset = i2;
            this.value = d2;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte EX() {
            return (byte) 5;
        }
    }

    static class e extends b {
        float value;

        e(int i2, float f2) {
            this.offset = i2;
            this.value = f2;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte EX() {
            return (byte) 3;
        }
    }

    static class f extends b {
        int value;

        f(int i2, int i3) {
            this.offset = i2;
            this.value = i3;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte EX() {
            return (byte) 2;
        }
    }

    static class g extends b {
        long value;

        g(int i2, long j2) {
            this.offset = i2;
            this.value = j2;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte EX() {
            return (byte) 4;
        }
    }

    static class h extends j {
        h(int i2, int i3, Object obj, int i4, boolean z2) {
            super(i2, i3, obj, i4, z2);
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte EX() {
            return (byte) 8;
        }
    }

    static class i extends j {
        i(int i2, int i3, String str, int i4, boolean z2) {
            super(i2, i3, str, i4, z2);
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        final byte EX() {
            return (byte) 6;
        }
    }

    static abstract class j extends b {
        int aAD;
        boolean aAE;
        int start;
        Object value;

        j(int i2, int i3, Object obj, int i4, boolean z2) {
            this.start = i2;
            this.offset = i3;
            this.value = obj;
            this.aAD = i4;
            this.aAE = z2;
        }
    }
}
