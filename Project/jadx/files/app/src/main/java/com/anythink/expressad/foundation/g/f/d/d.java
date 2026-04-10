package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.k;
import com.anythink.expressad.foundation.h.o;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends e<JSONObject> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10537c = d.class.getSimpleName();

    public d(int i2, String str, String str2, com.anythink.expressad.foundation.g.f.e<JSONObject> eVar) {
        super(i2, str, str2, eVar);
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    protected final k<JSONObject> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return cVar.a == 204 ? k.a(new JSONObject(), cVar) : k.a(new JSONObject(new String(cVar.b, com.anythink.expressad.foundation.g.f.g.e.a(cVar.f10553d))), cVar);
        } catch (UnsupportedEncodingException e2) {
            o.d(f10537c, e2.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        } catch (JSONException e3) {
            o.d(f10537c, e3.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }
}
