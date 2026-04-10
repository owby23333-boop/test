package com.yuewen;

import com.duokan.common.BookFormat;
import com.duokan.reader.domain.document.PointAnchor;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class cs0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kv3<Map<BookFormat, a>> f9765a;

    public interface a {
        PointAnchor b(long j, long j2, long j3, long j4);

        PointAnchor c(gh0 gh0Var, String str, String str2);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static cs0 f9766a = new cs0();
    }

    public static cs0 c() {
        return b.f9766a;
    }

    public static void d(kv3<Map<BookFormat, a>> kv3Var) {
        f9765a = kv3Var;
    }

    public PointAnchor a(BookFormat bookFormat, long j, long j2, long j3, long j4) {
        a aVar = f9765a.get().get(bookFormat);
        if (aVar != null) {
            return aVar.b(j, j2, j3, j4);
        }
        throw new RuntimeException("Not supported format: " + bookFormat);
    }

    public PointAnchor b(BookFormat bookFormat, gh0 gh0Var, String str, String str2) {
        a aVar = f9765a.get().get(bookFormat);
        if (aVar != null) {
            if (gh0Var == null) {
                return null;
            }
            return aVar.c(gh0Var, str, str2);
        }
        throw new RuntimeException("Not supported format: " + bookFormat);
    }
}
