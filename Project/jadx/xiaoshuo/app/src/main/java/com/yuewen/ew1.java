package com.yuewen;

import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: classes12.dex */
public class ew1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vn1<String> f10971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w31<?> f10972b;

    public class a implements kv3<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10973a;

        public a(String str) {
            this.f10973a = str;
        }

        @Override // com.yuewen.kv3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get() {
            return this.f10973a;
        }
    }

    public ew1(String str) {
        this(str, (w31<?>) null);
    }

    public static /* synthetic */ String d() {
        return "";
    }

    public String b() {
        File file = new File(Uri.parse(this.f10971a.get()).getPath());
        w31<?> w31Var = this.f10972b;
        return "dbFile{filename=" + file.getName() + ",length=" + file.length() + ",modify=" + file.lastModified() + "}\n" + (w31Var == null ? "" : w31Var.a().toString());
    }

    public boolean c() {
        w31<?> w31Var = this.f10972b;
        return w31Var != null && w31Var.a().a();
    }

    public ew1(vn1 vn1Var) {
        this((vn1<String>) vn1Var, (w31<?>) null);
    }

    public ew1(String str, w31<?> w31Var) {
        this.f10971a = new vn1<>(new kv3() { // from class: com.yuewen.dw1
            @Override // com.yuewen.kv3
            public final Object get() {
                return ew1.d();
            }
        });
        this.f10971a = new vn1<>(new a(str));
        this.f10972b = w31Var;
    }

    public ew1(vn1<String> vn1Var, w31<?> w31Var) {
        new vn1(new kv3() { // from class: com.yuewen.dw1
            @Override // com.yuewen.kv3
            public final Object get() {
                return ew1.d();
            }
        });
        this.f10971a = vn1Var;
        this.f10972b = w31Var;
    }

    public ew1(ew1 ew1Var) {
        this.f10971a = new vn1<>(new kv3() { // from class: com.yuewen.dw1
            @Override // com.yuewen.kv3
            public final Object get() {
                return ew1.d();
            }
        });
        this.f10971a = ew1Var.f10971a;
        this.f10972b = ew1Var.f10972b;
    }
}
