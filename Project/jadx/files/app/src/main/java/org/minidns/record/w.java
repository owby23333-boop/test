package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.record.Record;

/* JADX INFO: compiled from: UNKNOWN.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Record.TYPE f21653u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final byte[] f21654v;

    private w(DataInputStream dataInputStream, int i2, Record.TYPE type) throws IOException {
        this.f21653u = type;
        this.f21654v = new byte[i2];
        dataInputStream.readFully(this.f21654v);
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.f21654v);
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return this.f21653u;
    }

    public static w a(DataInputStream dataInputStream, int i2, Record.TYPE type) throws IOException {
        return new w(dataInputStream, i2, type);
    }
}
