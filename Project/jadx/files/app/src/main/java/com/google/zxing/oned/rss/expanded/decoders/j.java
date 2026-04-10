package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: AbstractExpandedDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    private final com.google.zxing.common.a a;
    private final r b;

    j(com.google.zxing.common.a aVar) {
        this.a = aVar;
        this.b = new r(aVar);
    }

    protected final r a() {
        return this.b;
    }

    protected final com.google.zxing.common.a b() {
        return this.a;
    }

    public abstract String c() throws NotFoundException, FormatException;

    public static j a(com.google.zxing.common.a aVar) {
        if (aVar.a(1)) {
            return new g(aVar);
        }
        if (!aVar.a(2)) {
            return new k(aVar);
        }
        int iA = r.a(aVar, 1, 4);
        if (iA == 4) {
            return new a(aVar);
        }
        if (iA == 5) {
            return new b(aVar);
        }
        int iA2 = r.a(aVar, 1, 5);
        if (iA2 == 12) {
            return new c(aVar);
        }
        if (iA2 == 13) {
            return new d(aVar);
        }
        switch (r.a(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", AgooConstants.ACK_BODY_NULL);
            case 57:
                return new e(aVar, "320", AgooConstants.ACK_BODY_NULL);
            case 58:
                return new e(aVar, "310", AgooConstants.ACK_FLAG_NULL);
            case 59:
                return new e(aVar, "320", AgooConstants.ACK_FLAG_NULL);
            case 60:
                return new e(aVar, "310", AgooConstants.ACK_PACK_ERROR);
            case 61:
                return new e(aVar, "320", AgooConstants.ACK_PACK_ERROR);
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
        }
    }
}
