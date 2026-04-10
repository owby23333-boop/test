package okhttp3.internal.ws;

import cn.bmob.v3.realtime.Client;
import com.anythink.core.c.e;
import com.anythink.expressad.d.a.b;
import com.anythink.expressad.foundation.d.c;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0005_`abcB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000203H\u0016J\u001f\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0000¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Gj\u0002`H2\b\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010I\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u0006\u0010J\u001a\u000203J\u0018\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u000e\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020 J\u0006\u0010S\u001a\u00020\u0012J\b\u0010!\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u000203H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010N\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010Y\u001a\u000203J\r\u0010Z\u001a\u00020\u0012H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u000203H\u0000¢\u0006\u0002\b]J\f\u0010^\u001a\u00020\u0012*\u00020\u000eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", b.dO, "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", c.cf, "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", e.a, "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", TTLogUtil.TAG_EVENT_REQUEST, "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "isValid", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;

    @NotNull
    private final WebSocketListener listener;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;
    private static final List<Protocol> ONLY_HTTP1 = j.a(Protocol.HTTP_1_1);
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;

        @Nullable
        private final ByteString reason;

        public Close(int i2, @Nullable ByteString byteString, long j2) {
            this.code = i2;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j2;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final ByteString getReason() {
            return this.reason;
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Message {

        @NotNull
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i2, @NotNull ByteString byteString) {
            this.formatOpcode = i2;
            this.data = byteString;
        }

        @NotNull
        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static abstract class Streams implements Closeable {
        private final boolean client;

        @NotNull
        private final BufferedSink sink;

        @NotNull
        private final BufferedSource source;

        public Streams(boolean z2, @NotNull BufferedSource bufferedSource, @NotNull BufferedSink bufferedSink) {
            this.client = z2;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }

        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final BufferedSink getSink() {
            return this.sink;
        }

        @NotNull
        public final BufferedSource getSource() {
            return this.source;
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e2) {
                RealWebSocket.this.failWebSocket(e2, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(@NotNull TaskRunner taskRunner, @NotNull Request request, @NotNull WebSocketListener webSocketListener, @NotNull Random random, long j2, @Nullable WebSocketExtensions webSocketExtensions, long j3) {
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j2;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j3;
        this.taskQueue = taskRunner.newQueue();
        if (!i.a((Object) "GET", (Object) this.originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + this.originalRequest.method()).toString());
        }
        ByteString.Companion companion = ByteString.INSTANCE;
        byte[] bArr = new byte[16];
        this.random.nextBytes(bArr);
        kotlin.j jVar = kotlin.j.a;
        this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        Integer num = webSocketExtensions.serverMaxWindowBits;
        if (num == null) {
            return true;
        }
        int iIntValue = num.intValue();
        return 8 <= iIntValue && 15 >= iIntValue;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void awaitTermination(long timeout, @NotNull TimeUnit timeUnit) throws InterruptedException {
        this.taskQueue.idleLatch().await(timeout, timeUnit);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull Response response, @Nullable Exchange exchange) throws IOException {
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String strHeader$default = Response.header$default(response, "Connection", null, 2, null);
        if (!n.b("Upgrade", strHeader$default, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader$default + '\'');
        }
        String strHeader$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        if (!n.b(Client.PROTOCOL_WEBSOCKET, strHeader$default2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader$default2 + '\'');
        }
        String strHeader$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        String strBase64 = ByteString.INSTANCE.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (!(!i.a((Object) strBase64, (Object) strHeader$default3))) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader$default3 + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int code, @Nullable String reason) {
        return close(code, reason, 60000L);
    }

    public final void connect(@NotNull OkHttpClient client) {
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient okHttpClientBuild = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request requestBuild = this.originalRequest.newBuilder().header("Upgrade", Client.PROTOCOL_WEBSOCKET).header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", AgooConstants.ACK_FLAG_NULL).header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        this.call = new RealCall(okHttpClientBuild, requestBuild, true);
        this.call.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket.connect.1
            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call, @NotNull IOException e2) {
                RealWebSocket.this.failWebSocket(e2, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Exchange exchange = response.getExchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    Streams streamsNewWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions webSocketExtensions = WebSocketExtensions.INSTANCE.parse(response.headers());
                    RealWebSocket.this.extensions = webSocketExtensions;
                    if (!RealWebSocket.this.isValid(webSocketExtensions)) {
                        synchronized (RealWebSocket.this) {
                            RealWebSocket.this.messageAndCloseQueue.clear();
                            RealWebSocket.this.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + requestBuild.url().redact(), streamsNewWebSocketStreams);
                        RealWebSocket.this.getListener().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e2) {
                        RealWebSocket.this.failWebSocket(e2, null);
                    }
                } catch (IOException e3) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e3, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public final void failWebSocket(@NotNull Exception e2, @Nullable Response response) {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            kotlin.j jVar = kotlin.j.a;
            try {
                this.listener.onFailure(this, e2, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getListener$okhttp, reason: from getter */
    public final WebSocketListener getListener() {
        return this.listener;
    }

    public final void initReaderAndWriter(@NotNull final String name, @NotNull final Streams streams) throws IOException {
        final WebSocketExtensions webSocketExtensions = this.extensions;
        synchronized (this) {
            this.name = name;
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
            this.writerTask = new WriterTask();
            if (this.pingIntervalMillis != 0) {
                final long nanos = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
                final String str = name + " ping";
                this.taskQueue.schedule(new Task(str) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1
                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.writePingFrame$okhttp();
                        return nanos;
                    }
                }, nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            kotlin.j jVar = kotlin.j.a;
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int code, @NotNull String reason) {
        WebSocketReader webSocketReader;
        Streams streams;
        WebSocketWriter webSocketWriter;
        boolean z2 = true;
        if (!(code != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalStateException("already closed".toString());
            }
            this.receivedCloseCode = code;
            this.receivedCloseReason = reason;
            webSocketReader = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                streams = this.streams;
                this.streams = null;
                WebSocketReader webSocketReader2 = this.reader;
                this.reader = null;
                webSocketWriter = this.writer;
                this.writer = null;
                this.taskQueue.shutdown();
                webSocketReader = webSocketReader2;
            } else {
                streams = null;
                webSocketWriter = null;
            }
            kotlin.j jVar = kotlin.j.a;
        }
        try {
            this.listener.onClosing(this, code, reason);
            if (streams != null) {
                this.listener.onClosed(this, code, reason);
            }
        } finally {
            if (streams != null) {
                Util.closeQuietly(streams);
            }
            if (webSocketReader != null) {
                Util.closeQuietly(webSocketReader);
            }
            if (webSocketWriter != null) {
                Util.closeQuietly(webSocketWriter);
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull String text) throws IOException {
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(@NotNull ByteString payload) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(payload);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(@NotNull ByteString payload) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(@NotNull ByteString payload) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(payload);
            runWriter();
            return true;
        }
        return false;
    }

    public final boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e2) {
            failWebSocket(e2, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    @NotNull
    /* JADX INFO: renamed from: request, reason: from getter */
    public Request getOriginalRequest() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull String text) {
        return send(ByteString.INSTANCE.encodeUtf8(text), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018b  */
    /* JADX WARN: Type inference failed for: r1v10, types: [okhttp3.internal.ws.WebSocketWriter] */
    /* JADX WARN: Type inference failed for: r1v13, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v17, types: [T, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, okhttp3.internal.ws.WebSocketReader] */
    /* JADX WARN: Type inference failed for: r2v19, types: [T, okhttp3.internal.ws.WebSocketWriter] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3, types: [okio.ByteString] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean writeOneFrame$okhttp() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            WebSocketWriter webSocketWriter = this.writer;
            if (webSocketWriter != null) {
                int i2 = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                kotlin.j jVar = kotlin.j.a;
                if (i2 == -1) {
                    try {
                        webSocketWriter.writePing(ByteString.EMPTY);
                        return;
                    } catch (IOException e2) {
                        failWebSocket(e2, null);
                        return;
                    }
                }
                failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i2 - 1) + " successful ping/pongs)"), null);
            }
        }
    }

    public final synchronized boolean close(int code, @Nullable String reason, long cancelAfterCloseMillis) {
        WebSocketProtocol.INSTANCE.validateCloseCode(code);
        ByteString byteStringEncodeUtf8 = null;
        if (reason != null) {
            byteStringEncodeUtf8 = ByteString.INSTANCE.encodeUtf8(reason);
            if (!(((long) byteStringEncodeUtf8.size()) <= 123)) {
                throw new IllegalArgumentException(("reason.size() > 123: " + reason).toString());
            }
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(code, byteStringEncodeUtf8, cancelAfterCloseMillis));
            runWriter();
            return true;
        }
        return false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull ByteString bytes) throws IOException {
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull ByteString bytes) {
        return send(bytes, 2);
    }

    private final synchronized boolean send(ByteString data, int formatOpcode) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + ((long) data.size()) > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += (long) data.size();
            this.messageAndCloseQueue.add(new Message(formatOpcode, data));
            runWriter();
            return true;
        }
        return false;
    }
}
