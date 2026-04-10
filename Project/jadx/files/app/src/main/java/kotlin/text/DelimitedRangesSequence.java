package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: kotlin.text.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
final class DelimitedRangesSequence implements kotlin.sequences.c<IntRange> {
    private final CharSequence a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.jvm.b.p<CharSequence, Integer, Pair<Integer, Integer>> f20996d;

    /* JADX INFO: renamed from: kotlin.text.e$a */
    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements Iterator<IntRange>, kotlin.jvm.internal.o.a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f20997s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f20998t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f20999u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Nullable
        private IntRange f21000v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f21001w;

        a() {
            this.f20998t = kotlin.ranges.g.a(DelimitedRangesSequence.this.b, 0, DelimitedRangesSequence.this.a.length());
            this.f20999u = this.f20998t;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f20999u
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f20997s = r1
                r0 = 0
                r6.f21000v = r0
                goto La2
            Lc:
                kotlin.text.e r0 = kotlin.text.DelimitedRangesSequence.this
                int r0 = kotlin.text.DelimitedRangesSequence.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L25
                int r0 = r6.f21001w
                int r0 = r0 + r3
                r6.f21001w = r0
                int r0 = r6.f21001w
                kotlin.text.e r4 = kotlin.text.DelimitedRangesSequence.this
                int r4 = kotlin.text.DelimitedRangesSequence.c(r4)
                if (r0 >= r4) goto L33
            L25:
                int r0 = r6.f20999u
                kotlin.text.e r4 = kotlin.text.DelimitedRangesSequence.this
                java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L49
            L33:
                int r0 = r6.f20998t
                kotlin.m.d r1 = new kotlin.m.d
                kotlin.text.e r4 = kotlin.text.DelimitedRangesSequence.this
                java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.b(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.c(r4)
                r1.<init>(r0, r4)
                r6.f21000v = r1
                r6.f20999u = r2
                goto La0
            L49:
                kotlin.text.e r0 = kotlin.text.DelimitedRangesSequence.this
                kotlin.jvm.b.p r0 = kotlin.text.DelimitedRangesSequence.a(r0)
                kotlin.text.e r4 = kotlin.text.DelimitedRangesSequence.this
                java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.b(r4)
                int r5 = r6.f20999u
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.a(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L79
                int r0 = r6.f20998t
                kotlin.m.d r1 = new kotlin.m.d
                kotlin.text.e r4 = kotlin.text.DelimitedRangesSequence.this
                java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.b(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.c(r4)
                r1.<init>(r0, r4)
                r6.f21000v = r1
                r6.f20999u = r2
                goto La0
            L79:
                java.lang.Object r2 = r0.f()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.g()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f20998t
                kotlin.m.d r4 = kotlin.ranges.e.d(r4, r2)
                r6.f21000v = r4
                int r2 = r2 + r0
                r6.f20998t = r2
                int r2 = r6.f20998t
                if (r0 != 0) goto L9d
                r1 = 1
            L9d:
                int r2 = r2 + r1
                r6.f20999u = r2
            La0:
                r6.f20997s = r3
            La2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence.a.a():void");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20997s == -1) {
                a();
            }
            return this.f20997s == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        @NotNull
        public IntRange next() {
            if (this.f20997s == -1) {
                a();
            }
            if (this.f20997s == 0) {
                throw new NoSuchElementException();
            }
            IntRange intRange = this.f21000v;
            if (intRange == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.f21000v = null;
            this.f20997s = -1;
            return intRange;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(@NotNull CharSequence charSequence, int i2, int i3, @NotNull kotlin.jvm.b.p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> pVar) {
        this.a = charSequence;
        this.b = i2;
        this.f20995c = i3;
        this.f20996d = pVar;
    }

    @Override // kotlin.sequences.c
    @NotNull
    public Iterator<IntRange> iterator() {
        return new a();
    }
}
