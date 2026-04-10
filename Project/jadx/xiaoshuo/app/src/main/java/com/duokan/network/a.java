package com.duokan.network;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes17.dex */
public abstract class a<R> {

    /* JADX INFO: renamed from: com.duokan.network.a$a, reason: collision with other inner class name */
    public static final class C0248a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final ResponseException f3799a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0248a(@NotNull ResponseException error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.f3799a = error;
        }

        public static /* synthetic */ C0248a d(C0248a c0248a, ResponseException responseException, int i, Object obj) {
            if ((i & 1) != 0) {
                responseException = c0248a.f3799a;
            }
            return c0248a.c(responseException);
        }

        @NotNull
        public final ResponseException b() {
            return this.f3799a;
        }

        @NotNull
        public final C0248a c(@NotNull ResponseException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new C0248a(error);
        }

        @NotNull
        public final ResponseException e() {
            return this.f3799a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0248a) && Intrinsics.areEqual(this.f3799a, ((C0248a) obj).f3799a);
        }

        public int hashCode() {
            return this.f3799a.hashCode();
        }

        @Override // com.duokan.network.a
        @NotNull
        public String toString() {
            return "Error(error=" + this.f3799a + ")";
        }
    }

    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final T f3800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final String f3801b;
        public final int c;
        public final long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@Nullable T t, @NotNull String msg, int i, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.f3800a = t;
            this.f3801b = msg;
            this.c = i;
            this.d = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b g(b bVar, Object obj, String str, int i, long j, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = bVar.f3800a;
            }
            if ((i2 & 2) != 0) {
                str = bVar.f3801b;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                i = bVar.c;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                j = bVar.d;
            }
            return bVar.f(obj, str2, i3, j);
        }

        @Nullable
        public final T b() {
            return this.f3800a;
        }

        @NotNull
        public final String c() {
            return this.f3801b;
        }

        public final int d() {
            return this.c;
        }

        public final long e() {
            return this.d;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f3800a, bVar.f3800a) && Intrinsics.areEqual(this.f3801b, bVar.f3801b) && this.c == bVar.c && this.d == bVar.d;
        }

        @NotNull
        public final b<T> f(@Nullable T t, @NotNull String msg, int i, long j) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            return new b<>(t, msg, i, j);
        }

        @Nullable
        public final T h() {
            return this.f3800a;
        }

        public int hashCode() {
            T t = this.f3800a;
            return ((((((t == null ? 0 : t.hashCode()) * 31) + this.f3801b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d);
        }

        @NotNull
        public final String i() {
            return this.f3801b;
        }

        public final int j() {
            return this.c;
        }

        public final long k() {
            return this.d;
        }

        @Override // com.duokan.network.a
        @NotNull
        public String toString() {
            return "Success(data=" + this.f3800a + ", msg=" + this.f3801b + ", result=" + this.c + ", timestamp=" + this.d + ")";
        }

        public /* synthetic */ b(Object obj, String str, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? 0L : j);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean a() {
        return this instanceof b;
    }

    @NotNull
    public String toString() {
        if (this instanceof b) {
            return "Success[data=" + ((b) this).h() + "]";
        }
        if (!(this instanceof C0248a)) {
            throw new NoWhenBranchMatchedException();
        }
        return "Error[exception=" + ((C0248a) this).e() + "]";
    }

    public a() {
    }
}
