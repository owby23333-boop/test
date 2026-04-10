package org.minidns.record;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.minidns.record.Record;

/* JADX INFO: compiled from: Data.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private byte[] f21607s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private transient Integer f21608t;

    private void b() {
        if (this.f21607s != null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(new DataOutputStream(byteArrayOutputStream));
            this.f21607s = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final int a() {
        b();
        return this.f21607s.length;
    }

    protected abstract void a(DataOutputStream dataOutputStream) throws IOException;

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        h hVar = (h) obj;
        hVar.b();
        b();
        return Arrays.equals(this.f21607s, hVar.f21607s);
    }

    public abstract Record.TYPE getType();

    public final int hashCode() {
        if (this.f21608t == null) {
            b();
            this.f21608t = Integer.valueOf(Arrays.hashCode(this.f21607s));
        }
        return this.f21608t.intValue();
    }

    public final void b(DataOutputStream dataOutputStream) throws IOException {
        b();
        dataOutputStream.write(this.f21607s);
    }
}
