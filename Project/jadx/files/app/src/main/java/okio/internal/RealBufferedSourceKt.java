package okio.internal;

import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.text.a;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.Sink;
import okio.Timeout;
import okio.Util;
import okio.buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b¨\u00068"}, d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 4, 0})
public final class RealBufferedSourceKt {
    public static final void commonClose(@NotNull buffer bufferVar) throws IOException {
        if (bufferVar.closed) {
            return;
        }
        bufferVar.closed = true;
        bufferVar.source.close();
        bufferVar.bufferField.clear();
    }

    public static final boolean commonExhausted(@NotNull buffer bufferVar) {
        if (!bufferVar.closed) {
            return bufferVar.bufferField.exhausted() && bufferVar.source.read(bufferVar.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(@NotNull buffer bufferVar, byte b, long j2, long j3) {
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        while (j2 < j3) {
            long jIndexOf = bufferVar.bufferField.indexOf(b, j2, j3);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = bufferVar.bufferField.size();
            if (size >= j3 || bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                break;
            }
            j2 = Math.max(j2, size);
        }
        return -1L;
    }

    public static final long commonIndexOfElement(@NotNull buffer bufferVar, @NotNull ByteString byteString, long j2) {
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOfElement = bufferVar.bufferField.indexOfElement(byteString, j2);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = bufferVar.bufferField.size();
            if (bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull buffer bufferVar) {
        return Okio.buffer(new PeekSource(bufferVar));
    }

    public static final boolean commonRangeEquals(@NotNull buffer bufferVar, long j2, @NotNull ByteString byteString, int i2, int i3) {
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j2 < 0 || i2 < 0 || i3 < 0 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            long j3 = ((long) i4) + j2;
            if (!bufferVar.request(1 + j3) || bufferVar.bufferField.getByte(j3) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public static final long commonRead(@NotNull buffer bufferVar, @NotNull Buffer buffer, long j2) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(true ^ bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
            return -1L;
        }
        return bufferVar.bufferField.read(buffer, Math.min(j2, bufferVar.bufferField.size()));
    }

    public static final long commonReadAll(@NotNull buffer bufferVar, @NotNull Sink sink) throws IOException {
        long j2 = 0;
        while (bufferVar.source.read(bufferVar.bufferField, 8192) != -1) {
            long jCompleteSegmentByteCount = bufferVar.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j2 += jCompleteSegmentByteCount;
                sink.write(bufferVar.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (bufferVar.bufferField.size() <= 0) {
            return j2;
        }
        long size = j2 + bufferVar.bufferField.size();
        Buffer buffer = bufferVar.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(@NotNull buffer bufferVar) throws EOFException {
        bufferVar.require(1L);
        return bufferVar.bufferField.readByte();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull buffer bufferVar, long j2) throws EOFException {
        bufferVar.require(j2);
        return bufferVar.bufferField.readByteArray(j2);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull buffer bufferVar, long j2) throws EOFException {
        bufferVar.require(j2);
        return bufferVar.bufferField.readByteString(j2);
    }

    public static final long commonReadDecimalLong(@NotNull buffer bufferVar) throws EOFException {
        byte b;
        bufferVar.require(1L);
        long j2 = 0;
        while (true) {
            long j3 = j2 + 1;
            if (!bufferVar.request(j3)) {
                break;
            }
            b = bufferVar.bufferField.getByte(j2);
            if ((b < ((byte) 48) || b > ((byte) 57)) && !(j2 == 0 && b == ((byte) 45))) {
                break;
            }
            j2 = j3;
        }
        if (j2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9] or '-' character but was 0x");
            a.a(16);
            a.a(16);
            sb.append(Integer.toString(b, 16));
            throw new NumberFormatException(sb.toString());
        }
        return bufferVar.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(@NotNull buffer bufferVar, @NotNull byte[] bArr) throws EOFException {
        try {
            bufferVar.require(bArr.length);
            bufferVar.bufferField.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (bufferVar.bufferField.size() > 0) {
                Buffer buffer = bufferVar.bufferField;
                int i3 = buffer.read(bArr, i2, (int) buffer.size());
                if (i3 == -1) {
                    throw new AssertionError();
                }
                i2 += i3;
            }
            throw e2;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull buffer bufferVar) throws EOFException {
        byte b;
        bufferVar.require(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!bufferVar.request(i3)) {
                break;
            }
            b = bufferVar.bufferField.getByte(i2);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) 102)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            a.a(16);
            a.a(16);
            sb.append(Integer.toString(b, 16));
            throw new NumberFormatException(sb.toString());
        }
        return bufferVar.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@NotNull buffer bufferVar) throws EOFException {
        bufferVar.require(4L);
        return bufferVar.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull buffer bufferVar) throws EOFException {
        bufferVar.require(4L);
        return bufferVar.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull buffer bufferVar) throws EOFException {
        bufferVar.require(8L);
        return bufferVar.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull buffer bufferVar) throws EOFException {
        bufferVar.require(8L);
        return bufferVar.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull buffer bufferVar) throws EOFException {
        bufferVar.require(2L);
        return bufferVar.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull buffer bufferVar) throws EOFException {
        bufferVar.require(2L);
        return bufferVar.bufferField.readShortLe();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull buffer bufferVar, long j2) throws EOFException {
        bufferVar.require(j2);
        return bufferVar.bufferField.readUtf8(j2);
    }

    public static final int commonReadUtf8CodePoint(@NotNull buffer bufferVar) throws EOFException {
        bufferVar.require(1L);
        byte b = bufferVar.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            bufferVar.require(2L);
        } else if ((b & 240) == 224) {
            bufferVar.require(3L);
        } else if ((b & 248) == 240) {
            bufferVar.require(4L);
        }
        return bufferVar.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull buffer bufferVar) {
        long jIndexOf = bufferVar.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(bufferVar.bufferField, jIndexOf);
        }
        if (bufferVar.bufferField.size() != 0) {
            return bufferVar.readUtf8(bufferVar.bufferField.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull buffer bufferVar, long j2) throws EOFException {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j2).toString());
        }
        long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
        byte b = (byte) 10;
        long jIndexOf = bufferVar.indexOf(b, 0L, j3);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(bufferVar.bufferField, jIndexOf);
        }
        if (j3 < Long.MAX_VALUE && bufferVar.request(j3) && bufferVar.bufferField.getByte(j3 - 1) == ((byte) 13) && bufferVar.request(1 + j3) && bufferVar.bufferField.getByte(j3) == b) {
            return BufferKt.readUtf8Line(bufferVar.bufferField, j3);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = bufferVar.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(bufferVar.bufferField.size(), j2) + " content=" + buffer.readByteString().hex() + "…");
    }

    public static final boolean commonRequest(@NotNull buffer bufferVar, long j2) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (bufferVar.bufferField.size() < j2) {
            if (bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(@NotNull buffer bufferVar, long j2) throws EOFException {
        if (!bufferVar.request(j2)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@NotNull buffer bufferVar, @NotNull Options options) throws EOFException {
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iSelectPrefix = BufferKt.selectPrefix(bufferVar.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                bufferVar.bufferField.skip(options.getByteStrings()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (bufferVar.source.read(bufferVar.bufferField, 8192) != -1);
        return -1;
    }

    public static final void commonSkip(@NotNull buffer bufferVar, long j2) throws EOFException {
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j2, bufferVar.bufferField.size());
            bufferVar.bufferField.skip(jMin);
            j2 -= jMin;
        }
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull buffer bufferVar) {
        return bufferVar.source.getTimeout();
    }

    @NotNull
    public static final String commonToString(@NotNull buffer bufferVar) {
        return "buffer(" + bufferVar.source + ')';
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull buffer bufferVar) throws IOException {
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteArray();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull buffer bufferVar) throws IOException {
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteString();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull buffer bufferVar) throws IOException {
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readUtf8();
    }

    public static final void commonReadFully(@NotNull buffer bufferVar, @NotNull Buffer buffer, long j2) throws IOException {
        try {
            bufferVar.require(j2);
            bufferVar.bufferField.readFully(buffer, j2);
        } catch (EOFException e2) {
            buffer.writeAll(bufferVar.bufferField);
            throw e2;
        }
    }

    public static final long commonIndexOf(@NotNull buffer bufferVar, @NotNull ByteString byteString, long j2) throws IOException {
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOf = bufferVar.bufferField.indexOf(byteString, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = bufferVar.bufferField.size();
            if (bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (size - ((long) byteString.size())) + 1);
        }
    }

    public static final int commonRead(@NotNull buffer bufferVar, @NotNull byte[] bArr, int i2, int i3) {
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
            return -1;
        }
        return bufferVar.bufferField.read(bArr, i2, (int) Math.min(j2, bufferVar.bufferField.size()));
    }
}
