package okhttp3.internal;

import androidx.exifinterface.media.ExifInterface;
import cn.bmob.v3.realtime.Client;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.g;
import kotlin.collections.k;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.collections.y;
import kotlin.j;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.b.a;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.d;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017\u001a'\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"¢\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\bø\u0001\u0000\u001a-\u0010'\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u0002H)0!\"\u0002H)H\u0007¢\u0006\u0002\u0010+\u001a1\u0010,\u001a\u0004\u0018\u0001H)\"\u0004\b\u0000\u0010)2\u0006\u0010-\u001a\u00020\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H)0/2\u0006\u00100\u001a\u00020\u0011¢\u0006\u0002\u00101\u001a\u0016\u00102\u001a\u0002032\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u000f\u001a\"\u00105\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\bø\u0001\u0000\u001a%\u00106\u001a\u00020\u001b\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u0002H7082\u0006\u00109\u001a\u0002H7H\u0000¢\u0006\u0002\u0010:\u001a\u0015\u0010;\u001a\u00020\u0014*\u00020<2\u0006\u0010=\u001a\u00020\u0014H\u0086\u0004\u001a\u0015\u0010;\u001a\u00020\u0017*\u00020\u00142\u0006\u0010=\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010;\u001a\u00020\u0014*\u00020>2\u0006\u0010=\u001a\u00020\u0014H\u0086\u0004\u001a\n\u0010?\u001a\u00020@*\u00020A\u001a\r\u0010B\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\r\u0010C\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\n\u0010D\u001a\u00020\u000f*\u00020\u0011\u001a\u0012\u0010E\u001a\u00020\u000f*\u00020F2\u0006\u0010G\u001a\u00020F\u001a\n\u0010H\u001a\u00020\u001b*\u00020I\u001a\n\u0010H\u001a\u00020\u001b*\u00020J\u001a\n\u0010H\u001a\u00020\u001b*\u00020K\u001a#\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010M\u001a\u00020\u0011¢\u0006\u0002\u0010N\u001a&\u0010O\u001a\u00020\u0014*\u00020\u00112\u0006\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020\u00142\b\b\u0002\u0010S\u001a\u00020\u0014\u001a&\u0010O\u001a\u00020\u0014*\u00020\u00112\u0006\u0010T\u001a\u00020\u00112\b\b\u0002\u0010R\u001a\u00020\u00142\b\b\u0002\u0010S\u001a\u00020\u0014\u001a\u001a\u0010U\u001a\u00020\u000f*\u00020V2\u0006\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u0019\u001a;\u0010Y\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0Z2\u0017\u0010[\u001a\u0013\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u00020\u000f0\\¢\u0006\u0002\b]H\u0086\bø\u0001\u0000\u001a5\u0010^\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010!2\u000e\u0010_\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110`¢\u0006\u0002\u0010a\u001a\n\u0010b\u001a\u00020\u0017*\u00020c\u001a+\u0010d\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010M\u001a\u00020\u00112\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00110`¢\u0006\u0002\u0010e\u001a\n\u0010f\u001a\u00020\u0014*\u00020\u0011\u001a\u001e\u0010g\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010R\u001a\u00020\u00142\b\b\u0002\u0010S\u001a\u00020\u0014\u001a\u001e\u0010h\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010R\u001a\u00020\u00142\b\b\u0002\u0010S\u001a\u00020\u0014\u001a\u0014\u0010i\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010R\u001a\u00020\u0014\u001a9\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010_\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110`¢\u0006\u0002\u0010k\u001a\u0012\u0010l\u001a\u00020\u000f*\u00020m2\u0006\u0010n\u001a\u00020o\u001a\u0012\u0010p\u001a\u00020\u000f*\u00020K2\u0006\u0010q\u001a\u00020r\u001a\r\u0010s\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a\r\u0010t\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a\n\u0010u\u001a\u00020\u0014*\u00020Q\u001a\n\u0010v\u001a\u00020\u0011*\u00020K\u001a\u0012\u0010w\u001a\u00020x*\u00020r2\u0006\u0010y\u001a\u00020x\u001a\n\u0010z\u001a\u00020\u0014*\u00020r\u001a\u0012\u0010{\u001a\u00020\u0014*\u00020|2\u0006\u0010}\u001a\u00020<\u001a\u001a\u0010{\u001a\u00020\u000f*\u00020V2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u0019\u001a\u0010\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0(*\u00020\u0003\u001a\u0011\u0010\u0080\u0001\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u007f0(\u001a\u000b\u0010\u0081\u0001\u001a\u00020\u0011*\u00020\u0014\u001a\u000b\u0010\u0081\u0001\u001a\u00020\u0011*\u00020\u0017\u001a\u0016\u0010\u0082\u0001\u001a\u00020\u0011*\u00020F2\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u000f\u001a\u001d\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(\u001a7\u0010\u0085\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u0087\u0001\u0012\u0005\u0012\u0003H\u0088\u00010\u0086\u0001\"\u0005\b\u0000\u0010\u0087\u0001\"\u0005\b\u0001\u0010\u0088\u0001*\u0011\u0012\u0005\u0012\u0003H\u0087\u0001\u0012\u0005\u0012\u0003H\u0088\u00010\u0086\u0001\u001a\u0014\u0010\u0089\u0001\u001a\u00020\u0017*\u00020\u00112\u0007\u0010\u008a\u0001\u001a\u00020\u0017\u001a\u0016\u0010\u008b\u0001\u001a\u00020\u0014*\u0004\u0018\u00010\u00112\u0007\u0010\u008a\u0001\u001a\u00020\u0014\u001a\u001f\u0010\u008c\u0001\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010R\u001a\u00020\u00142\b\b\u0002\u0010S\u001a\u00020\u0014\u001a\u000e\u0010\u008d\u0001\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a'\u0010\u008e\u0001\u001a\u00030\u008f\u0001*\b0\u0090\u0001j\u0003`\u0091\u00012\u0013\u0010\u0092\u0001\u001a\u000e\u0012\n\u0012\b0\u0090\u0001j\u0003`\u0091\u00010(\u001a\u0015\u0010\u0093\u0001\u001a\u00020\u001b*\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0014\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u00118\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0096\u0001"}, d2 = {"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "", "okHttpName", "", TTDownloadField.TT_USERAGENT, "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", "offset", "count", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableListOf", "", ExifInterface.GPS_DIRECTION_TRUE, "elements", "([Ljava/lang/Object;)Ljava/util/List;", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "addIfAbsent", ExifInterface.LONGITUDE_EAST, "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "concat", "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", "discard", "Lokio/Source;", "timeout", "timeUnit", "filterList", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hasIntersection", "comparator", "Ljava/util/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "Lokhttp3/internal/io/FileSystem;", BmobDbOpenHelper.FILE, "Ljava/io/File;", "isHealthy", "source", "Lokio/BufferedSource;", AgooConstants.MESSAGE_NOTIFICATION, "notifyAll", "parseHexDigit", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "wait", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Util")
public final class Util {

    @NotNull
    public static final String userAgent = "okhttp/4.9.0";

    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = Headers.INSTANCE.of(new String[0]);

    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.INSTANCE, EMPTY_BYTE_ARRAY, (MediaType) null, 1, (Object) null);

    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.INSTANCE, EMPTY_BYTE_ARRAY, (MediaType) null, 0, 0, 7, (Object) null);
    private static final Options UNICODE_BOMS = Options.INSTANCE.of(ByteString.INSTANCE.decodeHex("efbbbf"), ByteString.INSTANCE.decodeHex("feff"), ByteString.INSTANCE.decodeHex("fffe"), ByteString.INSTANCE.decodeHex("0000ffff"), ByteString.INSTANCE.decodeHex("ffff0000"));

    @JvmField
    @NotNull
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    @JvmField
    public static final boolean assertionsEnabled = OkHttpClient.class.desiredAssertionStatus();

    @JvmField
    @NotNull
    public static final String okHttpName = StringsKt__StringsKt.b(StringsKt__StringsKt.a(OkHttpClient.class.getName(), (CharSequence) "okhttp3."), Client.TAG);

    public static final <E> void addIfAbsent(@NotNull List<E> list, E e2) {
        if (list.contains(e2)) {
            return;
        }
        list.add(e2);
    }

    public static final int and(byte b, int i2) {
        return b & i2;
    }

    public static final int and(short s2, int i2) {
        return s2 & i2;
    }

    public static final long and(int i2, long j2) {
        return j2 & ((long) i2);
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull final EventListener eventListener) {
        return new EventListener.Factory() { // from class: okhttp3.internal.Util.asFactory.1
            @Override // okhttp3.EventListener.Factory
            @NotNull
            public final EventListener create(@NotNull Call call) {
                return eventListener;
            }
        };
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object obj) {
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object obj) {
        if (!assertionsEnabled || Thread.holdsLock(obj)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
    }

    public static final boolean canParseAsIpAddress(@NotNull String str) {
        return VERIFY_AS_IP_ADDRESS.a(str);
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl httpUrl, @NotNull HttpUrl httpUrl2) {
        return i.a((Object) httpUrl.host(), (Object) httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && i.a((Object) httpUrl.scheme(), (Object) httpUrl2.scheme());
    }

    public static final int checkDuration(@NotNull String str, long j2, @Nullable TimeUnit timeUnit) {
        boolean z2 = true;
        if (!(j2 >= 0)) {
            throw new IllegalStateException((str + " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j2);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException((str + " too large.").toString());
        }
        if (millis == 0 && j2 > 0) {
            z2 = false;
        }
        if (z2) {
            return (int) millis;
        }
        throw new IllegalArgumentException((str + " too small.").toString());
    }

    public static final void checkOffsetAndCount(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(@NotNull Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final String[] concat(@NotNull String[] strArr, @NotNull String str) {
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
        strArr2[g.d(strArr2)] = str;
        if (strArr2 != null) {
            return strArr2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
    }

    public static final int delimiterOffset(@NotNull String str, @NotNull String str2, int i2, int i3) {
        while (i2 < i3) {
            if (StringsKt__StringsKt.a((CharSequence) str2, str.charAt(i2), false, 2, (Object) null)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, str2, i2, i3);
    }

    public static final boolean discard(@NotNull Source source, int i2, @NotNull TimeUnit timeUnit) {
        try {
            return skipAll(source, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> iterable, @NotNull l<? super T, Boolean> lVar) {
        List<T> listA = k.a();
        for (T t2 : iterable) {
            if (lVar.invoke(t2).booleanValue()) {
                if (listA.isEmpty()) {
                    listA = new ArrayList<>();
                }
                if (listA == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<T>");
                }
                n.a(listA).add(t2);
            }
        }
        return listA;
    }

    @NotNull
    public static final String format(@NotNull String str, @NotNull Object... objArr) {
        m mVar = m.a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean hasIntersection(@NotNull String[] strArr, @Nullable String[] strArr2, @NotNull Comparator<? super String> comparator) {
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(@NotNull Response response) {
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(@NotNull a<j> aVar) {
        try {
            aVar.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(@NotNull T... tArr) {
        Object[] objArr = (Object[]) tArr.clone();
        return Collections.unmodifiableList(k.b(Arrays.copyOf(objArr, objArr.length)));
    }

    public static final int indexOf(@NotNull String[] strArr, @NotNull String str, @NotNull Comparator<String> comparator) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@NotNull String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (i.a(cCharAt, 31) <= 0 || i.a(cCharAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String str, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String str, int i2, int i3) {
        int i4 = i3 - 1;
        if (i4 >= i2) {
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4--;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfNonWhitespace(@NotNull String str, int i2) {
        int length = str.length();
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return indexOfNonWhitespace(str, i2);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] strArr, @NotNull String[] strArr2, @NotNull Comparator<? super String> comparator) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isCivilized(@NotNull FileSystem fileSystem, @NotNull File file) throws IOException {
        Sink sink = fileSystem.sink(file);
        try {
            try {
                fileSystem.delete(file);
                kotlin.l.a.a(sink, null);
                return true;
            } catch (IOException unused) {
                j jVar = j.a;
                kotlin.l.a.a(sink, null);
                fileSystem.delete(file);
                return false;
            }
        } finally {
        }
    }

    public static final boolean isHealthy(@NotNull Socket socket, @NotNull BufferedSource bufferedSource) {
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z2 = !bufferedSource.exhausted();
                socket.setSoTimeout(soTimeout);
                return z2;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void notify(@NotNull Object obj) {
        obj.notify();
    }

    public static final void notifyAll(@NotNull Object obj) {
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    @NotNull
    public static final String peerName(@NotNull Socket socket) {
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        return remoteSocketAddress instanceof InetSocketAddress ? ((InetSocketAddress) remoteSocketAddress).getHostName() : remoteSocketAddress.toString();
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource bufferedSource, @NotNull Charset charset) throws IOException {
        int iSelect = bufferedSource.select(UNICODE_BOMS);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            return StandardCharsets.UTF_8;
        }
        if (iSelect == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (iSelect == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (iSelect == 3) {
            return d.f20994d.a();
        }
        if (iSelect == 4) {
            return d.f20994d.b();
        }
        throw new AssertionError();
    }

    @Nullable
    public static final <T> T readFieldOrNull(@NotNull Object obj, @NotNull Class<T> cls, @NotNull String str) throws IllegalAccessException {
        T tCast;
        Object fieldOrNull;
        Class<?> superclass = obj.getClass();
        while (true) {
            tCast = null;
            if (!(!i.a(superclass, Object.class))) {
                if (!(!i.a((Object) str, (Object) "delegate")) || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, cls, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    break;
                }
                tCast = cls.cast(obj2);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
        }
        return tCast;
    }

    public static final int readMedium(@NotNull BufferedSource bufferedSource) throws IOException {
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[PHI: r12
  0x0051: PHI (r12v6 boolean) = (r12v5 boolean), (r12v10 boolean) binds: [B:23:0x0074, B:13:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean skipAll(@org.jetbrains.annotations.NotNull okio.Source r11, int r12, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            long r0 = java.lang.System.nanoTime()
            okio.Timeout r2 = r11.getThis$0()
            boolean r2 = r2.getHasDeadline()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L1d
            okio.Timeout r2 = r11.getThis$0()
            long r5 = r2.deadlineNanoTime()
            long r5 = r5 - r0
            goto L1e
        L1d:
            r5 = r3
        L1e:
            okio.Timeout r2 = r11.getThis$0()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.deadlineNanoTime(r12)
            okio.Buffer r12 = new okio.Buffer     // Catch: java.lang.Throwable -> L5a java.io.InterruptedIOException -> L70
            r12.<init>()     // Catch: java.lang.Throwable -> L5a java.io.InterruptedIOException -> L70
        L34:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.read(r12, r7)     // Catch: java.lang.Throwable -> L5a java.io.InterruptedIOException -> L70
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L44
            r12.clear()     // Catch: java.lang.Throwable -> L5a java.io.InterruptedIOException -> L70
            goto L34
        L44:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L51
        L49:
            okio.Timeout r11 = r11.getThis$0()
            r11.clearDeadline()
            goto L77
        L51:
            okio.Timeout r11 = r11.getThis$0()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
            goto L77
        L5a:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L67
            okio.Timeout r11 = r11.getThis$0()
            r11.clearDeadline()
            goto L6f
        L67:
            okio.Timeout r11 = r11.getThis$0()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
        L6f:
            throw r12
        L70:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L51
            goto L49
        L77:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull final String str, final boolean z2) {
        return new ThreadFactory() { // from class: okhttp3.internal.Util.threadFactory.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z2);
                return thread;
            }
        };
    }

    public static final void threadName(@NotNull String str, @NotNull a<j> aVar) {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(str);
        try {
            aVar.invoke();
        } finally {
            h.b(1);
            threadCurrentThread.setName(name);
            h.a(1);
        }
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers headers) {
        IntRange intRangeD = kotlin.ranges.g.d(0, headers.size());
        ArrayList arrayList = new ArrayList(kotlin.collections.l.a(intRangeD, 10));
        Iterator<Integer> it = intRangeD.iterator();
        while (it.hasNext()) {
            int iA = ((u) it).a();
            arrayList.add(new Header(headers.name(iA), headers.value(iA)));
        }
        return arrayList;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.getName().utf8(), header.getValue().utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final String toHexString(long j2) {
        return Long.toHexString(j2);
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl httpUrl, boolean z2) {
        String strHost;
        if (StringsKt__StringsKt.a((CharSequence) httpUrl.host(), (CharSequence) ":", false, 2, (Object) null)) {
            strHost = '[' + httpUrl.host() + ']';
        } else {
            strHost = httpUrl.host();
        }
        if (!z2 && httpUrl.port() == HttpUrl.INSTANCE.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return toHostHeader(httpUrl, z2);
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> list) {
        return Collections.unmodifiableList(s.a((Collection) list));
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> map) {
        return map.isEmpty() ? y.a() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static final long toLongOrDefault(@NotNull String str, long j2) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static final int toNonNegativeInt(@Nullable String str, int i2) {
        if (str != null) {
            try {
                long j2 = Long.parseLong(str);
                if (j2 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j2 < 0) {
                    return 0;
                }
                return (int) j2;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    @NotNull
    public static final String trimSubstring(@NotNull String str, int i2, int i3) {
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i2, i3);
        return str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i3));
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return trimSubstring(str, i2, i3);
    }

    public static final void wait(@NotNull Object obj) throws InterruptedException {
        obj.wait();
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception exc, @NotNull List<? extends Exception> list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            b.a(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(@NotNull BufferedSink bufferedSink, int i2) throws IOException {
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
    }

    public static final int delimiterOffset(@NotNull String str, char c2, int i2, int i3) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, c2, i2, i3);
    }

    @NotNull
    public static final String toHexString(int i2) {
        return Integer.toHexString(i2);
    }

    public static final void closeQuietly(@NotNull Socket socket) {
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(@NotNull ServerSocket serverSocket) {
        try {
            serverSocket.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(@NotNull Buffer buffer, byte b) throws EOFException {
        int i2 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            i2++;
            buffer.readByte();
        }
        return i2;
    }
}
