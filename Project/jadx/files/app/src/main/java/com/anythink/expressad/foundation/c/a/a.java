package com.anythink.expressad.foundation.c.a;

import com.anythink.expressad.foundation.g.a.d;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private d a;

    /* JADX INFO: renamed from: com.anythink.expressad.foundation.c.a.a$a, reason: collision with other inner class name */
    private static class C0204a {
        private static a a = new a(0);

        private C0204a() {
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0204a.a;
    }

    private JSONArray b() {
        return new JSONArray((Collection) this.a.a());
    }

    private a() {
        this.a = new d();
    }

    public final JSONObject a(String str) {
        JSONObject jSONObjectB = this.a.b(str);
        if (jSONObjectB != null) {
            return jSONObjectB;
        }
        return null;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                this.a.a(next, jSONObject.optJSONObject(next));
            }
        }
    }
}
