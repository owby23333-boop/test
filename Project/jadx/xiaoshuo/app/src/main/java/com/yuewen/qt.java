package com.yuewen;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class qt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final qt f16689a = new qt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static a f16690b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final String f16691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final String f16692b;

        @NotNull
        public final String c;

        public a(@NotNull String bookId, @NotNull String bridgeId, @NotNull String source) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            Intrinsics.checkNotNullParameter(bridgeId, "bridgeId");
            Intrinsics.checkNotNullParameter(source, "source");
            this.f16691a = bookId;
            this.f16692b = bridgeId;
            this.c = source;
        }

        public static /* synthetic */ a e(a aVar, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aVar.f16691a;
            }
            if ((i & 2) != 0) {
                str2 = aVar.f16692b;
            }
            if ((i & 4) != 0) {
                str3 = aVar.c;
            }
            return aVar.d(str, str2, str3);
        }

        @NotNull
        public final String a() {
            return this.f16691a;
        }

        @NotNull
        public final String b() {
            return this.f16692b;
        }

        @NotNull
        public final String c() {
            return this.c;
        }

        @NotNull
        public final a d(@NotNull String bookId, @NotNull String bridgeId, @NotNull String source) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            Intrinsics.checkNotNullParameter(bridgeId, "bridgeId");
            Intrinsics.checkNotNullParameter(source, "source");
            return new a(bookId, bridgeId, source);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f16691a, aVar.f16691a) && Intrinsics.areEqual(this.f16692b, aVar.f16692b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        @NotNull
        public final String f() {
            return this.f16691a;
        }

        @NotNull
        public final String g() {
            return this.f16692b;
        }

        @NotNull
        public final String h() {
            return this.c;
        }

        public int hashCode() {
            return (((this.f16691a.hashCode() * 31) + this.f16692b.hashCode()) * 31) + this.c.hashCode();
        }

        @NotNull
        public String toString() {
            return "BridgeInfo(bookId=" + this.f16691a + ", bridgeId=" + this.f16692b + ", source=" + this.c + ")";
        }
    }

    @Nullable
    public static final a a() {
        return f16690b;
    }

    @JvmStatic
    public static /* synthetic */ void b() {
    }

    public static final void c(@Nullable a aVar) {
        f16690b = aVar;
    }
}
