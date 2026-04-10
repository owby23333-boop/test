package okhttp3;

import com.anythink.core.api.ATAdConst;
import com.anythink.expressad.d.a.b;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.k;
import kotlin.collections.p;
import kotlin.h;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o.a;
import kotlin.ranges.IntProgression;
import kotlin.ranges.g;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0019H\u0096\u0002J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!J\b\u0010#\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0012\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006("}, d2 = {"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "()I", "byteCount", "", "equals", "", "other", "", MonitorConstants.CONNECT_TYPE_GET, "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", TTDownloadField.TT_HASHCODE, "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", "toString", "value", "values", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, a {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String[] namesAndValues;

    /* JADX INFO: compiled from: Headers.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0010J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0086\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", b.ay, "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", IOptionConstant.headers, "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", "build", MonitorConstants.CONNECT_TYPE_GET, "removeAll", "set", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        @NotNull
        private final List<String> namesAndValues = new ArrayList(20);

        @NotNull
        public final Builder add(@NotNull String line) {
            int iA = StringsKt__StringsKt.a((CharSequence) line, ':', 0, false, 6, (Object) null);
            if (!(iA != -1)) {
                throw new IllegalArgumentException(("Unexpected header: " + line).toString());
            }
            String strSubstring = line.substring(0, iA);
            if (strSubstring == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            add(StringsKt__StringsKt.f(strSubstring).toString(), line.substring(iA + 1));
            return this;
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                addLenient$okhttp(headers.name(i2), headers.value(i2));
            }
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String line) {
            int iA = StringsKt__StringsKt.a((CharSequence) line, ':', 1, false, 4, (Object) null);
            if (iA != -1) {
                addLenient$okhttp(line.substring(0, iA), line.substring(iA + 1));
            } else if (line.charAt(0) == ':') {
                addLenient$okhttp("", line.substring(1));
            } else {
                addLenient$okhttp("", line);
            }
            return this;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String name, @NotNull String value) {
            Headers.INSTANCE.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        @Nullable
        public final String get(@NotNull String name) {
            IntProgression intProgressionA = g.a(g.c(this.namesAndValues.size() - 2, 0), 2);
            int f20969s = intProgressionA.getF20969s();
            int f20970t = intProgressionA.getF20970t();
            int f20971u = intProgressionA.getF20971u();
            if (f20971u >= 0) {
                if (f20969s > f20970t) {
                    return null;
                }
            } else if (f20969s < f20970t) {
                return null;
            }
            while (!n.b(name, this.namesAndValues.get(f20969s), true)) {
                if (f20969s == f20970t) {
                    return null;
                }
                f20969s += f20971u;
            }
            return this.namesAndValues.get(f20969s + 1);
        }

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String name) {
            int i2 = 0;
            while (i2 < this.namesAndValues.size()) {
                if (n.b(name, this.namesAndValues.get(i2), true)) {
                    this.namesAndValues.remove(i2);
                    this.namesAndValues.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Date value) {
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Instant value) {
            return set(name, new Date(value.toEpochMilli()));
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull String value) {
            Headers.INSTANCE.checkName(name);
            Headers.INSTANCE.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            Headers.INSTANCE.checkName(name);
            Headers.INSTANCE.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String name, @NotNull String value) {
            this.namesAndValues.add(name);
            this.namesAndValues.add(StringsKt__StringsKt.f(value).toString());
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Date value) {
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Instant value) {
            add(name, new Date(value.toEpochMilli()));
            return this;
        }
    }

    /* JADX INFO: compiled from: Headers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u0011J\u001d\u0010\u0014\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u000f¨\u0006\u0015"}, d2 = {"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", "name", "", "checkValue", "value", MonitorConstants.CONNECT_TYPE_GET, "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", IOptionConstant.headers, "", "toHeaders", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String name) {
            if (!(name.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = name.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = name.charAt(i2);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), name).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String value, String name) {
            int length = value.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = value.charAt(i2);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), name, value).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] namesAndValues, String name) {
            IntProgression intProgressionA = g.a(g.c(namesAndValues.length - 2, 0), 2);
            int f20969s = intProgressionA.getF20969s();
            int f20970t = intProgressionA.getF20970t();
            int f20971u = intProgressionA.getF20971u();
            if (f20971u >= 0) {
                if (f20969s > f20970t) {
                    return null;
                }
            } else if (f20969s < f20970t) {
                return null;
            }
            while (!n.b(name, namesAndValues[f20969s], true)) {
                if (f20969s == f20970t) {
                    return null;
                }
                f20969s += f20971u;
            }
            return namesAndValues[f20969s + 1];
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m230deprecated_of(@NotNull String... namesAndValues) {
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final Headers of(@NotNull String... namesAndValues) throws CloneNotSupportedException {
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object objClone = namesAndValues.clone();
            if (objClone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr = (String[]) objClone;
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!(strArr[i2] != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                String str = strArr[i2];
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr[i2] = StringsKt__StringsKt.f(str).toString();
            }
            IntProgression intProgressionA = g.a(g.d(0, strArr.length), 2);
            int f20969s = intProgressionA.getF20969s();
            int f20970t = intProgressionA.getF20970t();
            int f20971u = intProgressionA.getF20971u();
            if (f20971u < 0 ? f20969s >= f20970t : f20969s <= f20970t) {
                while (true) {
                    String str2 = strArr[f20969s];
                    String str3 = strArr[f20969s + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (f20969s == f20970t) {
                        break;
                    }
                    f20969s += f20971u;
                }
            }
            return new Headers(strArr, null);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m229deprecated_of(@NotNull Map<String, String> headers) {
            return of(headers);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final Headers of(@NotNull Map<String, String> map) {
            String[] strArr = new String[map.size() * 2];
            int i2 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null) {
                    String string = StringsKt__StringsKt.f(key).toString();
                    if (value != null) {
                        String string2 = StringsKt__StringsKt.f(value).toString();
                        checkName(string);
                        checkValue(string2, string);
                        strArr[i2] = string;
                        strArr[i2 + 1] = string2;
                        i2 += 2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return new Headers(strArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final Headers of(@NotNull Map<String, String> map) {
        return INSTANCE.of(map);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final Headers of(@NotNull String... strArr) {
        return INSTANCE.of(strArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m228deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            length += (long) this.namesAndValues[i2].length();
        }
        return length;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues);
    }

    @Nullable
    public final String get(@NotNull String name) {
        return INSTANCE.get(this.namesAndValues, name);
    }

    @Nullable
    public final Date getDate(@NotNull String name) {
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @Nullable
    public final Instant getInstant(@NotNull String name) {
        Date date = getDate(name);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i2 = 0; i2 < size; i2++) {
            pairArr[i2] = h.a(name(i2), value(i2));
        }
        return kotlin.jvm.internal.b.a(pairArr);
    }

    @NotNull
    public final String name(int index) {
        return this.namesAndValues[index * 2];
    }

    @NotNull
    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(n.a(m.a));
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            treeSet.add(name(i2));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        p.a(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    @JvmName(name = ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(n.a(m.a));
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String strName = name(i2);
            Locale locale = Locale.US;
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase(locale);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i2));
        }
        return treeMap;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(name(i2));
            sb.append(": ");
            sb.append(value(i2));
            sb.append("\n");
        }
        return sb.toString();
    }

    @NotNull
    public final String value(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    @NotNull
    public final List<String> values(@NotNull String name) {
        int size = size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (n.b(name, name(i2), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i2));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : k.a();
    }

    public /* synthetic */ Headers(String[] strArr, f fVar) {
        this(strArr);
    }
}
