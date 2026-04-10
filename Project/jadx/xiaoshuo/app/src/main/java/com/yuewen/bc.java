package com.yuewen;

import com.duokan.common.BookFormat;
import com.duokan.reader.domain.document.PointAnchor;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kv3<Map<BookFormat, a>> f9036a;

    public interface a {
        PointAnchor parsePointAnchor(JSONObject jSONObject);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final bc f9037a = new bc();
    }

    public static bc a() {
        return b.f9037a;
    }

    public static void c(kv3<Map<BookFormat, a>> kv3Var) {
        f9036a = kv3Var;
    }

    public PointAnchor b(BookFormat bookFormat, JSONObject jSONObject) {
        a aVar = f9036a.get().get(bookFormat);
        if (aVar != null) {
            return aVar.parsePointAnchor(jSONObject);
        }
        throw new RuntimeException("Not supported format: " + bookFormat);
    }
}
