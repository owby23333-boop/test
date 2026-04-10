package okio;

import com.anythink.core.api.ATAdConst;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.umeng.analytics.pro.cb;
import com.umeng.message.utils.HttpRequest;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f;
import kotlin.text.d;
import kotlin.text.n;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 Z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001ZB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0000J\u0013\u0010!\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\"H\u0096\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b&J\u0015\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0007¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\tH\u0010¢\u0006\u0002\b)J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u001d\u0010+\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0000H\u0010¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\r\u00103\u001a\u00020\u0004H\u0010¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\tH\u0010¢\u0006\u0002\b7J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\b\u00109\u001a\u00020\u0000H\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020\u0000H\u0016J\b\u0010C\u001a\u00020\u0000H\u0016J\b\u0010D\u001a\u00020\u0000H\u0016J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bEJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016J\u001c\u0010K\u001a\u00020\u00002\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\tH\u0017J\b\u0010N\u001a\u00020\u0000H\u0016J\b\u0010O\u001a\u00020\u0000H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020TH\u0016J%\u0010R\u001a\u00020?2\u0006\u0010U\u001a\u00020V2\u0006\u0010;\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0010¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020?2\u0006\u0010S\u001a\u00020YH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006["}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", TTDownloadField.TT_HASHCODE, "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", MonitorConstants.CONNECT_TYPE_GET, "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", i.f10649g, HttpRequest.PARAM_CHARSET, "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
public class ByteString implements Serializable, Comparable<ByteString> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @NotNull
    private final byte[] data;
    private transient int hashCode;

    @Nullable
    private transient String utf8;

    /* JADX INFO: compiled from: ByteString.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", i.f10649g, "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", HttpRequest.PARAM_CHARSET, "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charset = d.a;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return companion.of(bArr, i2, i3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @JvmName(name = "-deprecated_decodeBase64")
        @Nullable
        /* JADX INFO: renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m320deprecated_decodeBase64(@NotNull String string) {
            return decodeBase64(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m321deprecated_decodeHex(@NotNull String string) {
            return decodeHex(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m322deprecated_encodeString(@NotNull String string, @NotNull Charset charset) {
            return encodeString(string, charset);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m323deprecated_encodeUtf8(@NotNull String string) {
            return encodeUtf8(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m324deprecated_of(@NotNull ByteBuffer buffer) {
            return of(buffer);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m326deprecated_read(@NotNull InputStream inputstream, int byteCount) {
            return read(inputstream, byteCount);
        }

        @JvmStatic
        @Nullable
        public final ByteString decodeBase64(@NotNull String str) {
            byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final ByteString decodeHex(@NotNull String str) {
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            byte[] bArr = new byte[str.length() / 2];
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((ByteStringKt.decodeHexDigit(str.charAt(i3)) << 4) + ByteStringKt.decodeHexDigit(str.charAt(i3 + 1)));
            }
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName(name = "encodeString")
        @NotNull
        public final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
            return new ByteString(str.getBytes(charset));
        }

        @JvmStatic
        @NotNull
        public final ByteString encodeUtf8(@NotNull String str) {
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull ByteBuffer byteBuffer) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName(name = "read")
        @NotNull
        public final ByteString read(@NotNull InputStream inputStream, int i2) throws IOException {
            int i3 = 0;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i2).toString());
            }
            byte[] bArr = new byte[i2];
            while (i3 < i2) {
                int i4 = inputStream.read(bArr, i3, i2 - i3);
                if (i4 == -1) {
                    throw new EOFException();
                }
                i3 += i4;
            }
            return new ByteString(bArr);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m325deprecated_of(@NotNull byte[] array, int offset, int byteCount) {
            return of(array, offset, byteCount);
        }

        @JvmStatic
        @NotNull
        public final ByteString of(@NotNull byte... data) {
            return new ByteString(Arrays.copyOf(data, data.length));
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull byte[] bArr, int i2, int i3) {
            Util.checkOffsetAndCount(bArr.length, i2, i3);
            return new ByteString(kotlin.collections.f.a(bArr, i2, i3 + i2));
        }
    }

    public ByteString(@NotNull byte[] bArr) {
        this.data = bArr;
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return INSTANCE.decodeBase64(str);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return INSTANCE.decodeHex(str);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    @NotNull
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return INSTANCE.encodeString(str, charset);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return INSTANCE.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(byteString2, i2);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(bArr, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i2);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return INSTANCE.of(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return INSTANCE.of(bArr);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull byte[] bArr, int i2, int i3) {
        return INSTANCE.of(bArr, i2, i3);
    }

    @JvmStatic
    @JvmName(name = "read")
    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream, int i2) throws IOException {
        return INSTANCE.read(inputStream, i2);
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException {
        ByteString byteString = INSTANCE.read(in, in.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = byteString.size();
        }
        return byteString.substring(i2, i3);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m318deprecated_getByte(int index) {
        return getByte(index);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m319deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    @NotNull
    public String base64() {
        return Base64.encodeBase64$default(getData(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return Base64.encodeBase64(getData(), Base64.getBASE64_URL_SAFE());
    }

    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        return new ByteString(MessageDigest.getInstance(algorithm).digest(this.data));
    }

    public final boolean endsWith(@NotNull ByteString suffix) {
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == getData().length && byteString.rangeEquals(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int index) {
        return internalGet$okio(index);
    }

    @NotNull
    /* JADX INFO: renamed from: getData$okio, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: getHashCode$okio, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData().length;
    }

    @Nullable
    /* JADX INFO: renamed from: getUtf8$okio, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(getData());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    @NotNull
    public String hex() {
        char[] cArr = new char[getData().length * 2];
        int i2 = 0;
        for (byte b : getData()) {
            int i3 = i2 + 1;
            cArr[i2] = ByteStringKt.getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = ByteStringKt.getHEX_DIGIT_CHARS()[b & cb.f19604m];
        }
        return new String(cArr);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            return new ByteString(mac.doFinal(this.data));
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString key) {
        return hmac$okio("HmacSHA1", key);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString key) {
        return hmac$okio("HmacSHA256", key);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString key) {
        return hmac$okio("HmacSHA512", key);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString other, int fromIndex) {
        return indexOf(other.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public final int indexOf(@NotNull byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData();
    }

    public byte internalGet$okio(int pos) {
        return getData()[pos];
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString other, int fromIndex) {
        return lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        return other.rangeEquals(otherOffset, getData(), offset, byteCount);
    }

    public final void setHashCode$okio(int i2) {
        this.hashCode = i2;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.utf8 = str;
    }

    @NotNull
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @NotNull
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @JvmName(name = ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString prefix) {
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        return new String(this.data, charset);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring(int i2) {
        return substring$default(this, i2, 0, 2, null);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int beginIndex, int endIndex) {
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (endIndex <= getData().length) {
            if (endIndex - beginIndex >= 0) {
                return (beginIndex == 0 && endIndex == getData().length) ? this : new ByteString(kotlin.collections.f.a(getData(), beginIndex, endIndex));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        byte b;
        for (int i2 = 0; i2 < getData().length; i2++) {
            byte b2 = getData()[i2];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                bArrCopyOf[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b4 = bArrCopyOf[i3];
                    if (b4 >= b3 && b4 <= b) {
                        bArrCopyOf[i3] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        byte b;
        for (int i2 = 0; i2 < getData().length; i2++) {
            byte b2 = getData()[i2];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                bArrCopyOf[i2] = (byte) (b2 - 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b4 = bArrCopyOf[i3];
                    if (b4 >= b3 && b4 <= b) {
                        bArrCopyOf[i3] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data = getData();
        return Arrays.copyOf(data, data.length);
    }

    @NotNull
    public String toString() {
        if (getData().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = ByteStringKt.codePointIndexToCharIndex(getData(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strUtf8 = utf8();
            if (strUtf8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strA = n.a(n.a(n.a(strUtf8.substring(0, iCodePointIndexToCharIndex), "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (iCodePointIndexToCharIndex >= strUtf8.length()) {
                return "[text=" + strA + ']';
            }
            return "[size=" + getData().length + " text=" + strA + "…]";
        }
        if (getData().length <= 64) {
            return "[hex=" + hex() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(getData().length);
        sb.append(" hex=");
        if (64 <= getData().length) {
            sb.append((64 == getData().length ? this : new ByteString(kotlin.collections.f.a(getData(), 0, 64))).hex());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
    }

    @NotNull
    public String utf8() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@NotNull OutputStream out) throws IOException {
        out.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer, int offset, int byteCount) {
        ByteStringKt.commonWrite(this, buffer, offset, byteCount);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        return 1;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(@org.jetbrains.annotations.NotNull okio.ByteString r10) {
        /*
            r9 = this;
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        Le:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L26
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L23
            int r4 = r4 + 1
            goto Le
        L23:
            if (r7 >= r8) goto L2d
            goto L2e
        L26:
            if (r0 != r1) goto L2a
            r5 = 0
            goto L2e
        L2a:
            if (r0 >= r1) goto L2d
            goto L2e
        L2d:
            r5 = 1
        L2e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@NotNull byte[] suffix) {
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] other, int fromIndex) {
        int length = getData().length - other.length;
        int iMax = Math.max(fromIndex, 0);
        if (iMax <= length) {
            while (!Util.arrayRangeEquals(getData(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] other, int fromIndex) {
        for (int iMin = Math.min(fromIndex, getData().length - other.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(getData(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && Util.arrayRangeEquals(getData(), offset, other, otherOffset, byteCount);
    }

    public final boolean startsWith(@NotNull byte[] prefix) {
        return rangeEquals(0, prefix, 0, prefix.length);
    }
}
