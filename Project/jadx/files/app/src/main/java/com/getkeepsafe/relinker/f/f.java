package com.getkeepsafe.relinker.f;

import com.getkeepsafe.relinker.f.c;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: ElfParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements Closeable, c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final FileChannel f14851s;

    public f(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f14851s = new FileInputStream(file).getChannel();
    }

    private long a(c.b bVar, long j2, long j3) throws IOException {
        for (long j4 = 0; j4 < j2; j4++) {
            c.AbstractC0315c abstractC0315cA = bVar.a(j4);
            if (abstractC0315cA.a == 1) {
                long j5 = abstractC0315cA.f14847c;
                if (j5 <= j3 && j3 <= abstractC0315cA.f14848d + j5) {
                    return (j3 - j5) + abstractC0315cA.b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    protected int b(ByteBuffer byteBuffer, long j2) throws IOException {
        a(byteBuffer, j2, 2);
        return byteBuffer.getShort() & ISelectionInterface.HELD_NOTHING;
    }

    protected long c(ByteBuffer byteBuffer, long j2) throws IOException {
        a(byteBuffer, j2, 8);
        return byteBuffer.getLong();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14851s.close();
    }

    protected String d(ByteBuffer byteBuffer, long j2) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j3 = 1 + j2;
            short sA = a(byteBuffer, j2);
            if (sA == 0) {
                return sb.toString();
            }
            sb.append((char) sA);
            j2 = j3;
        }
    }

    protected long e(ByteBuffer byteBuffer, long j2) throws IOException {
        a(byteBuffer, j2, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public c.b i() throws IOException {
        this.f14851s.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (e(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sA = a(byteBufferAllocate, 4L);
        boolean z2 = a(byteBufferAllocate, 5L) == 2;
        if (sA == 1) {
            return new d(z2, this);
        }
        if (sA == 2) {
            return new e(z2, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public List<String> j() throws IOException {
        long j2;
        this.f14851s.position(0L);
        ArrayList arrayList = new ArrayList();
        c.b bVarI = i();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVarI.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = bVarI.f14845e;
        int i2 = 0;
        if (j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j3 = bVarI.a(0).a;
        }
        long j4 = 0;
        while (true) {
            if (j4 >= j3) {
                j2 = 0;
                break;
            }
            c.AbstractC0315c abstractC0315cA = bVarI.a(j4);
            if (abstractC0315cA.a == 2) {
                j2 = abstractC0315cA.b;
                break;
            }
            j4++;
        }
        if (j2 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j5 = 0;
        while (true) {
            c.a aVarA = bVarI.a(j2, i2);
            long j6 = j2;
            long j7 = aVarA.a;
            if (j7 == 1) {
                arrayList2.add(Long.valueOf(aVarA.b));
            } else if (j7 == 5) {
                j5 = aVarA.b;
            }
            i2++;
            if (aVarA.a == 0) {
                break;
            }
            j2 = j6;
        }
        if (j5 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(bVarI, j3, j5);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(d(byteBufferAllocate, ((Long) it.next()).longValue() + jA));
        }
        return arrayList;
    }

    protected short a(ByteBuffer byteBuffer, long j2) throws IOException {
        a(byteBuffer, j2, 1);
        return (short) (byteBuffer.get() & 255);
    }

    protected void a(ByteBuffer byteBuffer, long j2, int i2) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        long j3 = 0;
        while (j3 < i2) {
            int i3 = this.f14851s.read(byteBuffer, j2 + j3);
            if (i3 == -1) {
                throw new EOFException();
            }
            j3 += (long) i3;
        }
        byteBuffer.position(0);
    }
}
