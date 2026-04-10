package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
final class h implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Logger f1093e = Logger.getLogger(e.class.getName());
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e a;
    private final a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f1094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final d.a f1095d;

    static final class a implements s {
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte f1096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1098e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        short f1099f;

        a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) {
            this.a = eVar;
        }

        private void h() throws IOException {
            int i2 = this.f1097d;
            int iA = h.a(this.a);
            this.f1098e = iA;
            this.b = iA;
            byte b = (byte) (this.a.readByte() & 255);
            this.f1096c = (byte) (this.a.readByte() & 255);
            if (h.f1093e.isLoggable(Level.FINE)) {
                h.f1093e.fine(e.a(true, this.f1097d, this.b, b, this.f1096c));
            }
            this.f1097d = this.a.readInt() & Integer.MAX_VALUE;
            if (b != 9) {
                e.b("%s != TYPE_CONTINUATION", Byte.valueOf(b));
                throw null;
            }
            if (this.f1097d == i2) {
                return;
            }
            e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            while (true) {
                int i2 = this.f1098e;
                if (i2 == 0) {
                    this.a.skip(this.f1099f);
                    this.f1099f = (short) 0;
                    if ((this.f1096c & 4) != 0) {
                        break;
                    }
                    h();
                } else {
                    long jA = this.a.a(cVar, Math.min(j2, i2));
                    if (jA != -1) {
                        this.f1098e = (int) (((long) this.f1098e) - jA);
                        return jA;
                    }
                }
            }
            return -1L;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return this.a.b();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    interface b {
        void a();

        void a(int i2, int i3, int i4, boolean z2);

        void a(int i2, int i3, List<c> list) throws IOException;

        void a(int i2, long j2);

        void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar);

        void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar);

        void a(boolean z2, int i2, int i3);

        void a(boolean z2, int i2, int i3, List<c> list);

        void a(boolean z2, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i3) throws IOException;

        void a(boolean z2, n nVar);
    }

    h(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, boolean z2) {
        this.a = eVar;
        this.f1094c = z2;
        this.b = new a(this.a);
        this.f1095d = new d.a(4096, this.b);
    }

    static int a(int i2, byte b2, short s2) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s2 <= i2) {
            return (short) (i2 - s2);
        }
        e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Integer.valueOf(i2));
        throw null;
    }

    static int a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    private List<c> a(int i2, short s2, byte b2, int i3) throws IOException {
        a aVar = this.b;
        aVar.f1098e = i2;
        aVar.b = i2;
        aVar.f1099f = s2;
        aVar.f1096c = b2;
        aVar.f1097d = i3;
        this.f1095d.c();
        return this.f1095d.a();
    }

    private void a(b bVar, int i2) throws IOException {
        int i3 = this.a.readInt();
        bVar.a(i2, i3 & Integer.MAX_VALUE, (this.a.readByte() & 255) + 1, (Integer.MIN_VALUE & i3) != 0);
    }

    private void a(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z2 = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        short s2 = (b2 & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
        bVar.a(z2, i3, this.a, a(i2, b2, s2));
        this.a.skip(s2);
    }

    private void b(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        }
        if (i3 != 0) {
            e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int i4 = this.a.readInt();
        int i5 = this.a.readInt();
        int i6 = i2 - 8;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVarA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.a(i5);
        if (bVarA == null) {
            e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i5));
            throw null;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVarB = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.f866e;
        if (i6 > 0) {
            fVarB = this.a.b(i6);
        }
        bVar.a(i4, bVarA, fVarB);
    }

    private void c(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z2 = (b2 & 1) != 0;
        short s2 = (b2 & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i3);
            i2 -= 5;
        }
        bVar.a(z2, i3, -1, a(a(i2, b2, s2), s2, b2, i3));
    }

    private void d(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 8) {
            e.b("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        }
        if (i3 != 0) {
            e.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        bVar.a((b2 & 1) != 0, this.a.readInt(), this.a.readInt());
    }

    private void e(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        }
        if (i3 != 0) {
            a(bVar, i3);
        } else {
            e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void f(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short s2 = (b2 & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
        bVar.a(i3, this.a.readInt() & Integer.MAX_VALUE, a(a(i2 - 4, b2, s2), s2, b2, i3));
    }

    private void g(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        }
        if (i3 == 0) {
            e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
        int i4 = this.a.readInt();
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVarA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.a(i4);
        if (bVarA != null) {
            bVar.a(i3, bVarA);
        } else {
            e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i4));
            throw null;
        }
    }

    private void h(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b2 & 1) != 0) {
            if (i2 == 0) {
                bVar.a();
                return;
            } else {
                e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        }
        if (i2 % 6 != 0) {
            e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        }
        n nVar = new n();
        for (int i4 = 0; i4 < i2; i4 += 6) {
            short s2 = this.a.readShort();
            int i5 = this.a.readInt();
            switch (s2) {
                case 2:
                    if (i5 != 0 && i5 != 1) {
                        e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        throw null;
                    }
                    break;
                    break;
                case 3:
                    s2 = 4;
                    break;
                case 4:
                    s2 = 7;
                    if (i5 < 0) {
                        e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                    break;
                    break;
                case 5:
                    if (i5 < 16384 || i5 > 16777215) {
                        e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
                        throw null;
                    }
                    break;
                    break;
            }
            nVar.a(s2, i5);
        }
        bVar.a(false, nVar);
    }

    private void i(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
            throw null;
        }
        long j2 = ((long) this.a.readInt()) & 2147483647L;
        if (j2 != 0) {
            bVar.a(i3, j2);
        } else {
            e.b("windowSizeIncrement was 0", Long.valueOf(j2));
            throw null;
        }
    }

    public void a(b bVar) throws IOException {
        if (this.f1094c) {
            if (a(true, bVar)) {
                return;
            }
            e.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVarB = this.a.b(e.a.e());
        if (f1093e.isLoggable(Level.FINE)) {
            f1093e.fine(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("<< CONNECTION %s", fVarB.b()));
        }
        if (e.a.equals(fVarB)) {
            return;
        }
        e.b("Expected a connection header but was %s", fVarB.h());
        throw null;
    }

    public boolean a(boolean z2, b bVar) throws IOException {
        try {
            this.a.a(9L);
            int iA = a(this.a);
            if (iA < 0 || iA > 16384) {
                e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
                throw null;
            }
            byte b2 = (byte) (this.a.readByte() & 255);
            if (z2 && b2 != 4) {
                e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(b2));
                throw null;
            }
            byte b3 = (byte) (this.a.readByte() & 255);
            int i2 = this.a.readInt() & Integer.MAX_VALUE;
            if (f1093e.isLoggable(Level.FINE)) {
                f1093e.fine(e.a(true, i2, iA, b2, b3));
            }
            switch (b2) {
                case 0:
                    a(bVar, iA, b3, i2);
                    return true;
                case 1:
                    c(bVar, iA, b3, i2);
                    return true;
                case 2:
                    e(bVar, iA, b3, i2);
                    return true;
                case 3:
                    g(bVar, iA, b3, i2);
                    return true;
                case 4:
                    h(bVar, iA, b3, i2);
                    return true;
                case 5:
                    f(bVar, iA, b3, i2);
                    return true;
                case 6:
                    d(bVar, iA, b3, i2);
                    return true;
                case 7:
                    b(bVar, iA, b3, i2);
                    return true;
                case 8:
                    i(bVar, iA, b3, i2);
                    return true;
                default:
                    this.a.skip(iA);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }
}
