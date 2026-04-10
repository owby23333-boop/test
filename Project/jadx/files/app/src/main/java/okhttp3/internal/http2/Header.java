package okhttp3.internal.http2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.i;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Header.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0004\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0006HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\nHÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/http2/Header;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokio/ByteString;", "(Lokio/ByteString;Ljava/lang/String;)V", "(Lokio/ByteString;Lokio/ByteString;)V", "hpackSize", "", "component1", "component2", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final /* data */ class Header {

    @NotNull
    public static final String RESPONSE_STATUS_UTF8 = ":status";

    @JvmField
    public final int hpackSize;

    @JvmField
    @NotNull
    public final ByteString name;

    @JvmField
    @NotNull
    public final ByteString value;

    @JvmField
    @NotNull
    public static final ByteString PSEUDO_PREFIX = ByteString.INSTANCE.encodeUtf8(":");

    @JvmField
    @NotNull
    public static final ByteString RESPONSE_STATUS = ByteString.INSTANCE.encodeUtf8(":status");

    @NotNull
    public static final String TARGET_METHOD_UTF8 = ":method";

    @JvmField
    @NotNull
    public static final ByteString TARGET_METHOD = ByteString.INSTANCE.encodeUtf8(TARGET_METHOD_UTF8);

    @NotNull
    public static final String TARGET_PATH_UTF8 = ":path";

    @JvmField
    @NotNull
    public static final ByteString TARGET_PATH = ByteString.INSTANCE.encodeUtf8(TARGET_PATH_UTF8);

    @NotNull
    public static final String TARGET_SCHEME_UTF8 = ":scheme";

    @JvmField
    @NotNull
    public static final ByteString TARGET_SCHEME = ByteString.INSTANCE.encodeUtf8(TARGET_SCHEME_UTF8);

    @NotNull
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";

    @JvmField
    @NotNull
    public static final ByteString TARGET_AUTHORITY = ByteString.INSTANCE.encodeUtf8(TARGET_AUTHORITY_UTF8);

    public Header(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = this.name.size() + 32 + this.value.size();
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            byteString = header.name;
        }
        if ((i2 & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ByteString getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ByteString getValue() {
        return this.value;
    }

    @NotNull
    public final Header copy(@NotNull ByteString name, @NotNull ByteString value) {
        return new Header(name, value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Header)) {
            return false;
        }
        Header header = (Header) other;
        return i.a(this.name, header.name) && i.a(this.value, header.value);
    }

    public int hashCode() {
        ByteString byteString = this.name;
        int iHashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.value;
        return iHashCode + (byteString2 != null ? byteString2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    public Header(@NotNull String str, @NotNull String str2) {
        this(ByteString.INSTANCE.encodeUtf8(str), ByteString.INSTANCE.encodeUtf8(str2));
    }

    public Header(@NotNull ByteString byteString, @NotNull String str) {
        this(byteString, ByteString.INSTANCE.encodeUtf8(str));
    }
}
