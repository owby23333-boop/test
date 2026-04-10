package org.minidns.dnsmessage;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: Question.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final DnsName a;
    public final Record.TYPE b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Record.CLASS f21469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f21470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f21471e;

    public a(DnsName dnsName, Record.TYPE type, Record.CLASS r3, boolean z2) {
        this.a = dnsName;
        this.b = type;
        this.f21469c = r3;
        this.f21470d = z2;
    }

    public DnsMessage.b a() {
        DnsMessage.b bVarG = DnsMessage.g();
        bVarG.a(this);
        return bVarG;
    }

    public byte[] b() {
        if (this.f21471e == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                this.a.a(dataOutputStream);
                dataOutputStream.writeShort(this.b.g());
                dataOutputStream.writeShort(this.f21469c.f() | (this.f21470d ? 32768 : 0));
                dataOutputStream.flush();
                this.f21471e = byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return this.f21471e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return Arrays.equals(b(), ((a) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(b());
    }

    public String toString() {
        return this.a.h() + ".\t" + this.f21469c + '\t' + this.b;
    }

    public a(DnsName dnsName, Record.TYPE type, Record.CLASS r4) {
        this(dnsName, type, r4, false);
    }

    public a(DnsName dnsName, Record.TYPE type) {
        this(dnsName, type, Record.CLASS.IN);
    }

    public a(CharSequence charSequence, Record.TYPE type, Record.CLASS r3) {
        this(DnsName.a(charSequence), type, r3);
    }

    public a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        this.a = DnsName.a(dataInputStream, bArr);
        this.b = Record.TYPE.getType(dataInputStream.readUnsignedShort());
        this.f21469c = Record.CLASS.b(dataInputStream.readUnsignedShort());
        this.f21470d = false;
    }
}
