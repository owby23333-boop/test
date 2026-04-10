package okhttp3.internal.publicsuffix;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.collections.k;
import kotlin.collections.s;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.l.a;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSuffixDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';

    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {(byte) 42};
    private static final List<String> PREVAILING_RULE = j.a("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* JADX INFO: compiled from: PublicSuffixDatabase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", MonitorConstants.CONNECT_TYPE_GET, "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i2) {
            int i3;
            int iAnd;
            int iAnd2;
            int length = bArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = (i4 + length) / 2;
                while (i5 > -1 && bArr[i5] != ((byte) 10)) {
                    i5--;
                }
                int i6 = i5 + 1;
                int i7 = 1;
                while (true) {
                    i3 = i6 + i7;
                    if (bArr[i3] == ((byte) 10)) {
                        break;
                    }
                    i7++;
                }
                int i8 = i3 - i6;
                int i9 = i2;
                boolean z2 = false;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    if (z2) {
                        z2 = false;
                        iAnd = 46;
                    } else {
                        iAnd = Util.and(bArr2[i9][i10], 255);
                    }
                    iAnd2 = iAnd - Util.and(bArr[i6 + i11], 255);
                    if (iAnd2 != 0) {
                        break;
                    }
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    }
                    if (bArr2[i9].length == i10) {
                        if (i9 == bArr2.length - 1) {
                            break;
                        }
                        i9++;
                        z2 = true;
                        i10 = -1;
                    }
                }
                if (iAnd2 >= 0) {
                    if (iAnd2 <= 0) {
                        int i12 = i8 - i11;
                        int length2 = bArr2[i9].length - i10;
                        int length3 = bArr2.length;
                        for (int i13 = i9 + 1; i13 < length3; i13++) {
                            length2 += bArr2[i13].length;
                        }
                        if (length2 >= i12) {
                            if (length2 <= i12) {
                                return new String(bArr, i6, i8, StandardCharsets.UTF_8);
                            }
                        }
                    }
                    i4 = i3 + 1;
                }
                length = i6 - 1;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$findMatchingRule$1, reason: invalid class name */
    /* JADX INFO: compiled from: PublicSuffixDatabase.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        AnonymousClass1(PublicSuffixDatabase publicSuffixDatabase) {
            super(publicSuffixDatabase, PublicSuffixDatabase.class, "publicSuffixListBytes", "getPublicSuffixListBytes()[B", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return PublicSuffixDatabase.access$getPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl
        public void set(@Nullable Object obj) {
            ((PublicSuffixDatabase) this.receiver).publicSuffixListBytes = (byte[]) obj;
        }
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase publicSuffixDatabase) {
        byte[] bArr = publicSuffixDatabase.publicSuffixListBytes;
        if (bArr != null) {
            return bArr;
        }
        throw null;
    }

    private final List<String> findMatchingRule(List<String> domainLabels) {
        String str;
        String strBinarySearch;
        String str2;
        List<String> listA;
        List<String> listA2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (!(this.publicSuffixListBytes != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = domainLabels.size();
        byte[][] bArr = new byte[size][];
        for (int i2 = 0; i2 < size; i2++) {
            String str3 = domainLabels.get(i2);
            Charset charset = StandardCharsets.UTF_8;
            if (str3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            bArr[i2] = str3.getBytes(charset);
        }
        int length = bArr.length;
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                strBinarySearch = null;
                break;
            }
            Companion companion = INSTANCE;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                throw null;
            }
            strBinarySearch = companion.binarySearch(bArr2, bArr, i3);
            if (strBinarySearch != null) {
                break;
            }
            i3++;
        }
        if (bArr.length > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length2 = bArr3.length - 1;
            for (int i4 = 0; i4 < length2; i4++) {
                bArr3[i4] = WILDCARD_LABEL;
                Companion companion2 = INSTANCE;
                byte[] bArr4 = this.publicSuffixListBytes;
                if (bArr4 == null) {
                    throw null;
                }
                String strBinarySearch2 = companion2.binarySearch(bArr4, bArr3, i4);
                if (strBinarySearch2 != null) {
                    str2 = strBinarySearch2;
                    break;
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            int length3 = bArr.length - 1;
            int i5 = 0;
            while (true) {
                if (i5 >= length3) {
                    break;
                }
                Companion companion3 = INSTANCE;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    throw null;
                }
                String strBinarySearch3 = companion3.binarySearch(bArr5, bArr, i5);
                if (strBinarySearch3 != null) {
                    str = strBinarySearch3;
                    break;
                }
                i5++;
            }
        }
        if (str != null) {
            return StringsKt__StringsKt.a((CharSequence) (EXCEPTION_MARKER + str), new char[]{'.'}, false, 0, 6, (Object) null);
        }
        if (strBinarySearch == null && str2 == null) {
            return PREVAILING_RULE;
        }
        if (strBinarySearch == null || (listA = StringsKt__StringsKt.a((CharSequence) strBinarySearch, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
            listA = k.a();
        }
        if (str2 == null || (listA2 = StringsKt__StringsKt.a((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
            listA2 = k.a();
        }
        return listA.size() > listA2.size() ? listA : listA2;
    }

    private final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] byteArray = bufferedSourceBuffer.readByteArray(bufferedSourceBuffer.readInt());
            byte[] byteArray2 = bufferedSourceBuffer.readByteArray(bufferedSourceBuffer.readInt());
            kotlin.j jVar = kotlin.j.a;
            a.a(bufferedSourceBuffer, null);
            synchronized (this) {
                this.publicSuffixListBytes = byteArray;
                this.publicSuffixExceptionListBytes = byteArray2;
                kotlin.j jVar2 = kotlin.j.a;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z2 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z2 = true;
                } catch (IOException e2) {
                    Platform.INSTANCE.get().log("Failed to read public suffix list", 5, e2);
                    if (z2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String domain) {
        List<String> listA = StringsKt__StringsKt.a((CharSequence) domain, new char[]{'.'}, false, 0, 6, (Object) null);
        return i.a((Object) kotlin.collections.i.f((List) listA), (Object) "") ? s.a((List) listA, 1) : listA;
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String domain) {
        int size;
        int size2;
        List<String> listSplitDomain = splitDomain(IDN.toUnicode(domain));
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        return kotlin.sequences.i.a(kotlin.sequences.i.a(s.a((Iterable) splitDomain(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    public final void setListBytes(@NotNull byte[] publicSuffixListBytes, @NotNull byte[] publicSuffixExceptionListBytes) {
        this.publicSuffixListBytes = publicSuffixListBytes;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
