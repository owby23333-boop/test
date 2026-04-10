package okhttp3.internal.ws;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.message.proguard.ad;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.m;
import kotlin.text.n;
import okhttp3.Headers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WebSocketExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", TTDownloadField.TT_HASHCODE, "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final /* data */ class WebSocketExtensions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    @JvmField
    @Nullable
    public final Integer clientMaxWindowBits;

    @JvmField
    public final boolean clientNoContextTakeover;

    @JvmField
    public final boolean perMessageDeflate;

    @JvmField
    @Nullable
    public final Integer serverMaxWindowBits;

    @JvmField
    public final boolean serverNoContextTakeover;

    @JvmField
    public final boolean unknownValues;

    /* JADX INFO: compiled from: WebSocketExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull Headers responseHeaders) throws IOException {
            int size = responseHeaders.size();
            boolean z2 = false;
            Integer num = null;
            boolean z3 = false;
            Integer num2 = null;
            boolean z4 = false;
            boolean z5 = false;
            for (int i2 = 0; i2 < size; i2++) {
                if (n.b(responseHeaders.name(i2), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String strValue = responseHeaders.value(i2);
                    boolean z6 = z5;
                    boolean z7 = z4;
                    boolean z8 = z3;
                    boolean z9 = z2;
                    int i3 = 0;
                    while (i3 < strValue.length()) {
                        int iDelimiterOffset$default = Util.delimiterOffset$default(strValue, ',', i3, 0, 4, (Object) null);
                        int iDelimiterOffset = Util.delimiterOffset(strValue, ';', i3, iDelimiterOffset$default);
                        String strTrimSubstring = Util.trimSubstring(strValue, i3, iDelimiterOffset);
                        int i4 = iDelimiterOffset + 1;
                        if (n.b(strTrimSubstring, "permessage-deflate", true)) {
                            if (z9) {
                                z6 = true;
                            }
                            while (i4 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = Util.delimiterOffset(strValue, ';', i4, iDelimiterOffset$default);
                                int iDelimiterOffset3 = Util.delimiterOffset(strValue, '=', i4, iDelimiterOffset2);
                                String strTrimSubstring2 = Util.trimSubstring(strValue, i4, iDelimiterOffset3);
                                String strC = iDelimiterOffset3 < iDelimiterOffset2 ? StringsKt__StringsKt.c(Util.trimSubstring(strValue, iDelimiterOffset3 + 1, iDelimiterOffset2), "\"") : null;
                                i4 = iDelimiterOffset2 + 1;
                                if (n.b(strTrimSubstring2, "client_max_window_bits", true)) {
                                    if (num != null) {
                                        z6 = true;
                                    }
                                    Integer numA = strC != null ? m.a(strC) : null;
                                    num = numA;
                                    if (numA == null) {
                                        z6 = true;
                                    }
                                } else if (n.b(strTrimSubstring2, "client_no_context_takeover", true)) {
                                    if (z8) {
                                        z6 = true;
                                    }
                                    if (strC != null) {
                                        z6 = true;
                                    }
                                    z8 = true;
                                } else if (n.b(strTrimSubstring2, "server_max_window_bits", true)) {
                                    if (num2 != null) {
                                        z6 = true;
                                    }
                                    Integer numA2 = strC != null ? m.a(strC) : null;
                                    num2 = numA2;
                                    if (numA2 == null) {
                                        z6 = true;
                                    }
                                } else if (n.b(strTrimSubstring2, "server_no_context_takeover", true)) {
                                    if (z7) {
                                        z6 = true;
                                    }
                                    if (strC != null) {
                                        z6 = true;
                                    }
                                    z7 = true;
                                } else {
                                    z6 = true;
                                }
                            }
                            i3 = i4;
                            z9 = true;
                        } else {
                            i3 = i4;
                            z6 = true;
                        }
                    }
                    z2 = z9;
                    z3 = z8;
                    z4 = z7;
                    z5 = z6;
                }
            }
            return new WebSocketExtensions(z2, num, z3, num2, z4, z5);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean z2, @Nullable Integer num, boolean z3, @Nullable Integer num2, boolean z4, boolean z5) {
        this.perMessageDeflate = z2;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z3;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z4;
        this.unknownValues = z5;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = webSocketExtensions.perMessageDeflate;
        }
        if ((i2 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i2 & 4) != 0) {
            z3 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z6 = z3;
        if ((i2 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i2 & 16) != 0) {
            z4 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z7 = z4;
        if ((i2 & 32) != 0) {
            z5 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z2, num3, z6, num4, z7, z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getPerMessageDeflate() {
        return this.perMessageDeflate;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getClientMaxWindowBits() {
        return this.clientMaxWindowBits;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getClientNoContextTakeover() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getServerMaxWindowBits() {
        return this.serverMaxWindowBits;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getServerNoContextTakeover() {
        return this.serverNoContextTakeover;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getUnknownValues() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean perMessageDeflate, @Nullable Integer clientMaxWindowBits, boolean clientNoContextTakeover, @Nullable Integer serverMaxWindowBits, boolean serverNoContextTakeover, boolean unknownValues) {
        return new WebSocketExtensions(perMessageDeflate, clientMaxWindowBits, clientNoContextTakeover, serverMaxWindowBits, serverNoContextTakeover, unknownValues);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) other;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && i.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && i.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.perMessageDeflate;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int i2 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i2 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z3 = this.clientNoContextTakeover;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i3 = (iHashCode + r2) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z4 = this.serverNoContextTakeover;
        ?? r22 = z4;
        if (z4) {
            r22 = 1;
        }
        int i4 = (iHashCode2 + r22) * 31;
        boolean z5 = this.unknownValues;
        return i4 + (z5 ? 1 : z5);
    }

    public final boolean noContextTakeover(boolean clientOriginated) {
        return clientOriginated ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ad.f20406s;
    }

    public /* synthetic */ WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5, int i2, f fVar) {
        this((i2 & 1) != 0 ? false : z2, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? false : z3, (i2 & 8) == 0 ? num2 : null, (i2 & 16) != 0 ? false : z4, (i2 & 32) != 0 ? false : z5);
    }
}
