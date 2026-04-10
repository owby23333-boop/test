package okio;

import com.anythink.expressad.foundation.h.i;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.umeng.message.utils.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.c;
import okio.internal.SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0015\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\r\u0010\u0019\u001a\u00020\u001aH\u0010¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u001d\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0001H\u0010¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001aH\u0016J\r\u0010#\u001a\u00020\u0004H\u0010¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0010¢\u0006\u0002\b(J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001aH\u0016J(\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0016J(\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0016J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u0001H\u0016J\b\u00105\u001a\u00020\u0001H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\u0001H\u0002J\b\u00108\u001a\u00020\u0010H\u0016J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J%\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0010¢\u0006\u0002\b?J\b\u0010@\u001a\u00020AH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006B"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", DBDefinition.SEGMENT_TABLE_NAME, "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "digest", "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "", "getSize$okio", TTDownloadField.TT_HASHCODE, "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "offset", "otherOffset", "byteCount", i.f10649g, HttpRequest.PARAM_CHARSET, "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 4, 0})
public final class SegmentedByteString extends ByteString {

    @NotNull
    private final transient int[] directory;

    @NotNull
    private final transient byte[][] segments;

    public SegmentedByteString(@NotNull byte[][] bArr, @NotNull int[] iArr) {
        super(ByteString.EMPTY.getData());
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        if (byteString != null) {
            return byteString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = getDirectory()[length + i2];
            int i5 = getDirectory()[i2];
            messageDigest.update(getSegments()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        return new ByteString(messageDigest.digest());
    }

    @Override // okio.ByteString
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: getDirectory$okio, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    @NotNull
    /* JADX INFO: renamed from: getSegments$okio, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = getDirectory()[length + i2];
            int i6 = getDirectory()[i2];
            byte[] bArr = getSegments()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        setHashCode$okio(i3);
        return i3;
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments().length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = getDirectory()[length + i2];
                int i5 = getDirectory()[i2];
                mac.update(getSegments()[i2], i4, i5 - i3);
                i2++;
                i3 = i5;
            }
            return new ByteString(mac.doFinal());
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] other, int fromIndex) {
        return toByteString().indexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int pos) {
        Util.checkOffsetAndCount(getDirectory()[getSegments().length - 1], pos, 1L);
        int iSegment = SegmentedByteStringKt.segment(this, pos);
        return getSegments()[iSegment][(pos - (iSegment == 0 ? 0 : getDirectory()[iSegment - 1])) + getDirectory()[getSegments().length + iSegment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] other, int fromIndex) {
        return toByteString().lastIndexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        if (offset < 0 || offset > size() - byteCount) {
            return false;
        }
        int i2 = byteCount + offset;
        int iSegment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = iSegment == 0 ? 0 : getDirectory()[iSegment - 1];
            int i4 = getDirectory()[iSegment] - i3;
            int i5 = getDirectory()[getSegments().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - offset;
            if (!other.rangeEquals(otherOffset, getSegments()[iSegment], i5 + (offset - i3), iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset) {
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int beginIndex, int endIndex) {
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
        }
        if (!(endIndex <= size())) {
            throw new IllegalArgumentException(("endIndex=" + endIndex + " > length(" + size() + ')').toString());
        }
        int i2 = endIndex - beginIndex;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + endIndex + " < beginIndex=" + beginIndex).toString());
        }
        if (beginIndex == 0 && endIndex == size()) {
            return this;
        }
        if (beginIndex == endIndex) {
            return ByteString.EMPTY;
        }
        int iSegment = SegmentedByteStringKt.segment(this, beginIndex);
        int iSegment2 = SegmentedByteStringKt.segment(this, endIndex - 1);
        byte[][] bArr = (byte[][]) c.a(getSegments(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i3 = iSegment;
            int i4 = 0;
            while (true) {
                iArr[i4] = Math.min(getDirectory()[i3] - beginIndex, i2);
                int i5 = i4 + 1;
                iArr[i4 + bArr.length] = getDirectory()[getSegments().length + i3];
                if (i3 == iSegment2) {
                    break;
                }
                i3++;
                i4 = i5;
            }
        }
        int i6 = iSegment != 0 ? getDirectory()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (beginIndex - i6);
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = getDirectory()[length + i2];
            int i6 = getDirectory()[i2];
            int i7 = i6 - i3;
            c.a(getSegments()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream out) throws IOException {
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = getDirectory()[length + i2];
            int i5 = getDirectory()[i2];
            out.write(getSegments()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@NotNull Buffer buffer, int offset, int byteCount) {
        int i2 = byteCount + offset;
        int iSegment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = iSegment == 0 ? 0 : getDirectory()[iSegment - 1];
            int i4 = getDirectory()[iSegment] - i3;
            int i5 = getDirectory()[getSegments().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - offset;
            int i6 = i5 + (offset - i3);
            Segment segment = new Segment(getSegments()[iSegment], i6, i6 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment.prev;
                buffer.head = segment.next;
            } else {
                segment2.prev.push(segment);
            }
            offset += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) size()));
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        if (offset < 0 || offset > size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i2 = byteCount + offset;
        int iSegment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = iSegment == 0 ? 0 : getDirectory()[iSegment - 1];
            int i4 = getDirectory()[iSegment] - i3;
            int i5 = getDirectory()[getSegments().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - offset;
            if (!Util.arrayRangeEquals(getSegments()[iSegment], i5 + (offset - i3), other, otherOffset, iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iSegment++;
        }
        return true;
    }
}
