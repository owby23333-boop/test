package com.anythink.basead;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static Map<String, Object> a(com.anythink.basead.d.b bVar) {
        if (bVar != null) {
            return a(bVar.d());
        }
        return null;
    }

    public static Map<String, Object> a(com.anythink.basead.f.c cVar) {
        if (cVar != null) {
            return a(cVar.e());
        }
        return null;
    }

    public static Map<String, Object> a(i iVar) {
        if (iVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("offer_id", iVar.p());
        map.put("creative_id", iVar.q());
        map.put(ATAdConst.NETWORK_CUSTOM_KEY.IS_DEEPLINK_OFFER, Integer.valueOf((TextUtils.isEmpty(iVar.o()) && TextUtils.isEmpty(iVar.z())) ? 0 : 1));
        if (iVar instanceof aa) {
            map.put("dsp_id", ((aa) iVar).T());
        }
        return map;
    }
}
