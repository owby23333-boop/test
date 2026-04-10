package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.k;
import com.anythink.expressad.foundation.h.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class c extends e<JSONArray> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10536c = c.class.getSimpleName();

    public c(int i2, String str, String str2, com.anythink.expressad.foundation.g.f.e<JSONArray> eVar) {
        super(i2, str, str2, eVar);
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    protected final k<JSONArray> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return k.a(new JSONArray(new String(cVar.b, com.anythink.expressad.foundation.g.f.g.e.a(cVar.f10553d))), cVar);
        } catch (UnsupportedEncodingException e2) {
            o.d(f10536c, e2.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        } catch (JSONException e3) {
            o.d(f10536c, e3.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }
}
