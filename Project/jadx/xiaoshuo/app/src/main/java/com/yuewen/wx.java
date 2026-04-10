package com.yuewen;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
@TypeConverters({nq.class})
@Entity(tableName = "CategoryBook")
public class wx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @PrimaryKey
    public String f19736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19737b;
    public String c;
    public String d;
    public String e;
    public String f;
    public float g;
    public long h;
    public String i;
    public long j;
    public String k;
    public List<String> l;
    public String m;
    public String n;
    public boolean o;
    public long p;
    public String q;
    public int r;

    @Ignore
    public int s;

    @Ignore
    public boolean t;

    public void A(String coverUrl) {
        this.f = coverUrl;
    }

    public void B(boolean exposed) {
        this.t = exposed;
    }

    public void C(int index) {
        this.r = index;
    }

    public void D(String name) {
        this.c = name;
    }

    public void E(long readCount) {
        this.j = readCount;
    }

    public void F(String readCountHint) {
        this.k = readCountHint;
    }

    public void G(float score) {
        this.g = score;
    }

    public void H(String sortHint) {
        this.n = sortHint;
    }

    public void I(String statusHint) {
        this.m = statusHint;
    }

    public void J(String summary) {
        this.d = summary;
    }

    public void K(List<String> tags) {
        this.l = tags;
    }

    public void L(int type) {
        this.s = type;
    }

    public void M(long wordCount) {
        this.h = wordCount;
    }

    public void N(String wordCountHint) {
        this.i = wordCountHint;
    }

    public String a() {
        return this.e;
    }

    public String b() {
        return this.f19736a;
    }

    public String c() {
        return this.f19737b;
    }

    public long d() {
        return this.p;
    }

    public String e() {
        return this.q;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        wx wxVar = (wx) o;
        return this.f19736a.equals(wxVar.f19736a) && Objects.equals(this.c, wxVar.c);
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.r;
    }

    public String h() {
        return this.c;
    }

    public int hashCode() {
        return Objects.hash(this.f19736a, this.c);
    }

    public long i() {
        return this.j;
    }

    public String j() {
        return this.k;
    }

    public float k() {
        return this.g;
    }

    public String l() {
        return this.n;
    }

    public String m() {
        return this.m;
    }

    public String n() {
        return this.d;
    }

    public List<String> o() {
        return this.l;
    }

    public int p() {
        return this.s;
    }

    public long q() {
        return this.h;
    }

    public String r() {
        return this.i;
    }

    public boolean s() {
        return this.o;
    }

    public boolean t() {
        return this.t;
    }

    public void u(boolean audio) {
        this.o = audio;
    }

    public void v(String author) {
        this.e = author;
    }

    public void w(String bookId) {
        this.f19736a = bookId;
    }

    public void x(String categoryId) {
        this.f19737b = categoryId;
    }

    public void y(long chapterCount) {
        this.p = chapterCount;
    }

    public void z(String chapterCountHint) {
        this.q = chapterCountHint;
    }
}
