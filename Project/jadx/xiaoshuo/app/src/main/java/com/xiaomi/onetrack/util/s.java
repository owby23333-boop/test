package com.xiaomi.onetrack.util;

import com.xiaomi.onetrack.util.r;

/* JADX INFO: loaded from: classes8.dex */
class s implements r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f7770a;

    public s(boolean z) {
        this.f7770a = z;
    }

    @Override // com.xiaomi.onetrack.util.r.a
    public boolean a(Object obj) {
        return this.f7770a ? r.a(obj) : r.b(obj);
    }
}
