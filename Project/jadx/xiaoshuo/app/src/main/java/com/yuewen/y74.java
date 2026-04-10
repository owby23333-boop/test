package com.yuewen;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes12.dex */
public abstract class y74 {

    public static final class a extends y74 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final String f20239b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, @NotNull String msg) {
            super(null);
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.f20238a = i;
            this.f20239b = msg;
        }

        public final int a() {
            return this.f20238a;
        }

        @NotNull
        public final String b() {
            return this.f20239b;
        }
    }

    public static final class b extends y74 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f20240a = new b();

        public b() {
            super(null);
        }
    }

    public static final class c extends y74 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f20241a = new c();

        public c() {
            super(null);
        }
    }

    public static final class d extends y74 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f20242a = new d();

        public d() {
            super(null);
        }
    }

    public /* synthetic */ y74(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public y74() {
    }
}
