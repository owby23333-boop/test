package okhttp3.internal.http2;

import com.anythink.expressad.foundation.d.c;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.baidu.mobads.sdk.internal.bq;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import com.umeng.message.proguard.ad;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Http2Reader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "source", "Lokio/BufferedSource;", "client", "", "(Lokio/BufferedSource;Z)V", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", c.cf, "", "nextFrame", "requireSettings", "handler", "Lokhttp3/internal/http2/Http2Reader$Handler;", "readConnectionPreface", "readData", "length", "", Constants.KEY_FLAGS, "streamId", "readGoAway", "readHeaderBlock", "", "Lokhttp3/internal/http2/Header;", "padding", "readHeaders", "readPing", "readPriority", "readPushPromise", "readRstStream", "readSettings", "readWindowUpdate", "Companion", "ContinuationSource", "Handler", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Reader implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* JADX INFO: compiled from: Http2Reader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "()V", bq.a, "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", "", "length", Constants.KEY_FLAGS, "padding", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int length, int flags, int padding) throws IOException {
            if ((flags & 8) != 0) {
                length--;
            }
            if (padding <= length) {
                return length - padding;
            }
            throw new IOException("PROTOCOL_ERROR padding " + padding + " > remaining length " + length);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Http2Reader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006!"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", Constants.KEY_FLAGS, "", "getFlags", "()I", "setFlags", "(I)V", "left", "getLeft", "setLeft", "length", "getLength", "setLength", "padding", "getPadding", "setPadding", "streamId", "getStreamId", "setStreamId", c.cf, "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readContinuationHeader", "timeout", "Lokio/Timeout;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(@NotNull BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private final void readContinuationHeader() throws IOException {
            int i2 = this.streamId;
            this.left = Util.readMedium(this.source);
            this.length = this.left;
            int iAnd = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            if (Http2Reader.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                Http2Reader.INSTANCE.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, iAnd, this.flags));
            }
            this.streamId = this.source.readInt() & Integer.MAX_VALUE;
            if (iAnd == 9) {
                if (this.streamId != i2) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iAnd + " != TYPE_CONTINUATION");
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long byteCount) throws IOException {
            while (true) {
                int i2 = this.left;
                if (i2 != 0) {
                    long j2 = this.source.read(sink, Math.min(byteCount, i2));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.left -= (int) j2;
                    return j2;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i2) {
            this.flags = i2;
        }

        public final void setLeft(int i2) {
            this.left = i2;
        }

        public final void setLength(int i2) {
            this.length = i2;
        }

        public final void setPadding(int i2) {
            this.padding = i2;
        }

        public final void setStreamId(int i2) {
            this.streamId = i2;
        }

        @Override // okio.Source
        @NotNull
        /* JADX INFO: renamed from: timeout */
        public Timeout getTimeout() {
            return this.source.getTimeout();
        }
    }

    /* JADX INFO: compiled from: Http2Reader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J8\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH&J.\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H&J(\u0010#\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0011H&J&\u0010'\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020-H&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000eH&¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "ackSettings", "", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", Constants.KEY_HOST, "port", "maxAge", "", "data", "inFinished", "", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", IOptionConstant.headers, "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", BaseMonitor.COUNT_ACK, "payload1", "payload2", "priority", "streamDependency", "weight", ad.f20413z, "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "windowUpdate", "windowSizeIncrement", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Handler {
        void ackSettings();

        void alternateService(int streamId, @NotNull String origin, @NotNull ByteString protocol, @NotNull String host, int port, long maxAge);

        void data(boolean inFinished, int streamId, @NotNull BufferedSource source, int length) throws IOException;

        void goAway(int lastGoodStreamId, @NotNull ErrorCode errorCode, @NotNull ByteString debugData);

        void headers(boolean inFinished, int streamId, int associatedStreamId, @NotNull List<Header> headerBlock);

        void ping(boolean ack, int payload1, int payload2);

        void priority(int streamId, int streamDependency, int weight, boolean exclusive);

        void pushPromise(int streamId, int promisedStreamId, @NotNull List<Header> requestHeaders) throws IOException;

        void rstStream(int streamId, @NotNull ErrorCode errorCode);

        void settings(boolean clearPrevious, @NotNull Settings settings);

        void windowUpdate(int streamId, long windowSizeIncrement);
    }

    public Http2Reader(@NotNull BufferedSource bufferedSource, boolean z2) {
        this.source = bufferedSource;
        this.client = z2;
        this.continuation = new ContinuationSource(this.source);
        this.hpackReader = new Hpack.Reader(this.continuation, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z2 = (flags & 1) != 0;
        if ((flags & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iAnd = (flags & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.data(z2, streamId, this.source, INSTANCE.lengthWithoutPadding(length, flags, iAnd));
        this.source.skip(iAnd);
    }

    private final void readGoAway(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i2 = this.source.readInt();
        int i3 = this.source.readInt();
        int i4 = length - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.INSTANCE.fromHttp2(i3);
        if (errorCodeFromHttp2 == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i3);
        }
        ByteString byteString = ByteString.EMPTY;
        if (i4 > 0) {
            byteString = this.source.readByteString(i4);
        }
        handler.goAway(i2, errorCodeFromHttp2, byteString);
    }

    private final List<Header> readHeaderBlock(int length, int padding, int flags, int streamId) throws IOException {
        this.continuation.setLeft(length);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(padding);
        this.continuation.setFlags(flags);
        this.continuation.setStreamId(streamId);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z2 = (flags & 1) != 0;
        int iAnd = (flags & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        if ((flags & 32) != 0) {
            readPriority(handler, streamId);
            length -= 5;
        }
        handler.headers(z2, streamId, -1, readHeaderBlock(INSTANCE.lengthWithoutPadding(length, flags, iAnd), iAnd, flags, streamId));
    }

    private final void readPing(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length != 8) {
            throw new IOException("TYPE_PING length != 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((flags & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPriority(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length == 5) {
            if (streamId == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            readPriority(handler, streamId);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + length + " != 5");
        }
    }

    private final void readPushPromise(Handler handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iAnd = (flags & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.pushPromise(streamId, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(INSTANCE.lengthWithoutPadding(length - 4, flags, iAnd), iAnd, flags, streamId));
    }

    private final void readRstStream(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + length + " != 4");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i2 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.INSTANCE.fromHttp2(i2);
        if (errorCodeFromHttp2 != null) {
            handler.rstStream(streamId, errorCodeFromHttp2);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        throw new java.io.IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0092 A[LOOP:0: B:17:0x003a->B:40:0x0092, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void readSettings(okhttp3.internal.http2.Http2Reader.Handler r7, int r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.readSettings(okhttp3.internal.http2.Http2Reader$Handler, int, int, int):void");
    }

    private final void readWindowUpdate(Handler handler, int length, int flags, int streamId) throws IOException {
        if (length != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + length);
        }
        long jAnd = Util.and(this.source.readInt(), 2147483647L);
        if (jAnd == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.windowUpdate(streamId, jAnd);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean requireSettings, @NotNull Handler handler) throws IOException {
        try {
            this.source.require(9L);
            int medium = Util.readMedium(this.source);
            if (medium > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + medium);
            }
            int iAnd = Util.and(this.source.readByte(), 255);
            int iAnd2 = Util.and(this.source.readByte(), 255);
            int i2 = this.source.readInt() & Integer.MAX_VALUE;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.INSTANCE.frameLog(true, i2, medium, iAnd, iAnd2));
            }
            if (requireSettings && iAnd != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(iAnd));
            }
            switch (iAnd) {
                case 0:
                    readData(handler, medium, iAnd2, i2);
                    return true;
                case 1:
                    readHeaders(handler, medium, iAnd2, i2);
                    return true;
                case 2:
                    readPriority(handler, medium, iAnd2, i2);
                    return true;
                case 3:
                    readRstStream(handler, medium, iAnd2, i2);
                    return true;
                case 4:
                    readSettings(handler, medium, iAnd2, i2);
                    return true;
                case 5:
                    readPushPromise(handler, medium, iAnd2, i2);
                    return true;
                case 6:
                    readPing(handler, medium, iAnd2, i2);
                    return true;
                case 7:
                    readGoAway(handler, medium, iAnd2, i2);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, iAnd2, i2);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(@NotNull Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        ByteString byteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Util.format("<< CONNECTION " + byteString.hex(), new Object[0]));
        }
        if (!i.a(Http2.CONNECTION_PREFACE, byteString)) {
            throw new IOException("Expected a connection header but was " + byteString.utf8());
        }
    }

    private final void readPriority(Handler handler, int streamId) throws IOException {
        int i2 = this.source.readInt();
        handler.priority(streamId, i2 & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, (i2 & ((int) 2147483648L)) != 0);
    }
}
