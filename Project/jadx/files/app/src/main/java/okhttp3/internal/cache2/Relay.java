package okhttp3.internal.cache2;

import cn.bmob.v3.util.BmobDbOpenHelper;
import com.anythink.expressad.foundation.d.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.j;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Relay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B3\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u00105\u001a\u0004\u0018\u00010\u0005J \u00106\u001a\u0002032\u0006\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006<"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", BmobDbOpenHelper.FILE, "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", "metadata", "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", c.bX, "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;

    @NotNull
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;

    @Nullable
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;

    @Nullable
    private Source upstream;

    @NotNull
    private final Buffer upstreamBuffer;
    private long upstreamPos;

    @Nullable
    private Thread upstreamReader;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ByteString PREFIX_CLEAN = ByteString.INSTANCE.encodeUtf8("OkHttp cache v1\n");

    @JvmField
    @NotNull
    public static final ByteString PREFIX_DIRTY = ByteString.INSTANCE.encodeUtf8("OkHttp DIRTY :(\n");

    /* JADX INFO: compiled from: Relay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", BmobDbOpenHelper.FILE, "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Relay edit(@NotNull File file, @NotNull Source upstream, @NotNull ByteString metadata, long bufferMaxSize) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, bufferMaxSize, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        @NotNull
        public final Relay read(@NotNull File file) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
            Buffer buffer = new Buffer();
            fileOperator.read(0L, buffer, 32L);
            if (!i.a(buffer.readByteString(Relay.PREFIX_CLEAN.size()), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long j2 = buffer.readLong();
            long j3 = buffer.readLong();
            Buffer buffer2 = new Buffer();
            fileOperator.read(j2 + 32, buffer2, j3);
            return new Relay(randomAccessFile, null, j2, buffer2.readByteString(), 0L, null);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Relay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", "timeout", "Lokio/Timeout;", c.cf, "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.getFile().getChannel());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay.this.setSourceCount(r2.getSourceCount() - 1);
                if (Relay.this.getSourceCount() == 0) {
                    RandomAccessFile file = Relay.this.getFile();
                    Relay.this.setFile(null);
                    randomAccessFile = file;
                }
                j jVar = j.a;
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
        
            if (r4 != 2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        
            r2 = java.lang.Math.min(r20, r18.this$0.getUpstreamPos() - r18.sourcePos);
            r18.fileOperator.read(r18.sourcePos + 32, r19, r2);
            r18.sourcePos += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
        
            r7 = r18.this$0.getUpstream().read(r18.this$0.getUpstreamBuffer(), r18.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
        
            if (r7 != (-1)) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
        
            r18.this$0.commit(r18.this$0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ca, code lost:
        
            r2 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00cc, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00cd, code lost:
        
            r18.this$0.setUpstreamReader(null);
            r0 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00d4, code lost:
        
            if (r0 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d6, code lost:
        
            r0.notifyAll();
            r0 = kotlin.j.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00db, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00e4, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00e8, code lost:
        
            r2 = java.lang.Math.min(r7, r20);
            r18.this$0.getUpstreamBuffer().copyTo(r19, 0, r2);
            r18.sourcePos += r2;
            r18.fileOperator.write(r18.this$0.getUpstreamPos() + 32, r18.this$0.getUpstreamBuffer().clone(), r7);
            r5 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x011a, code lost:
        
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x011b, code lost:
        
            r18.this$0.getBuffer().write(r18.this$0.getUpstreamBuffer(), r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x013c, code lost:
        
            if (r18.this$0.getBuffer().size() <= r18.this$0.getBufferMaxSize()) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x013e, code lost:
        
            r18.this$0.getBuffer().skip(r18.this$0.getBuffer().size() - r18.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0158, code lost:
        
            r0 = r18.this$0;
            r0.setUpstreamPos(r0.getUpstreamPos() + r7);
            r0 = kotlin.j.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0164, code lost:
        
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0165, code lost:
        
            r5 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0167, code lost:
        
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0168, code lost:
        
            r18.this$0.setUpstreamReader(null);
            r0 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x016f, code lost:
        
            if (r0 == null) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0171, code lost:
        
            r0.notifyAll();
            r0 = kotlin.j.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0176, code lost:
        
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0177, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x017f, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0186, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0189, code lost:
        
            monitor-enter(r18.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x018a, code lost:
        
            r18.this$0.setUpstreamReader(null);
            r3 = r18.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0191, code lost:
        
            if (r3 == null) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x019a, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x019b, code lost:
        
            r3.notifyAll();
            r3 = kotlin.j.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01a1, code lost:
        
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(@org.jetbrains.annotations.NotNull okio.Buffer r19, long r20) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 438
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        @NotNull
        /* JADX INFO: renamed from: timeout, reason: from getter */
        public Timeout getTimeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j2, ByteString byteString, long j3) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j2;
        this.metadata = byteString;
        this.bufferMaxSize = j3;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString prefix, long upstreamSize, long metadataSize) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(prefix);
        buffer.writeLong(upstreamSize);
        buffer.writeLong(metadataSize);
        if (!(buffer.size() == 32)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        new FileOperator(this.file.getChannel()).write(0L, buffer, 32L);
    }

    private final void writeMetadata(long upstreamSize) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + upstreamSize, buffer, this.metadata.size());
    }

    public final void commit(long upstreamSize) throws IOException {
        writeMetadata(upstreamSize);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, upstreamSize, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            j jVar = j.a;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly(source);
        }
        this.upstream = null;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    @NotNull
    /* JADX INFO: renamed from: metadata, reason: from getter */
    public final ByteString getMetadata() {
        return this.metadata;
    }

    @Nullable
    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z2) {
        this.complete = z2;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i2) {
        this.sourceCount = i2;
    }

    public final void setUpstream(@Nullable Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j2) {
        this.upstreamPos = j2;
    }

    public final void setUpstreamReader(@Nullable Thread thread) {
        this.upstreamReader = thread;
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j2, ByteString byteString, long j3, f fVar) {
        this(randomAccessFile, source, j2, byteString, j3);
    }
}
