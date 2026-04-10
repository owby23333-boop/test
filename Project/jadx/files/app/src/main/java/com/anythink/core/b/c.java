package com.anythink.core.b;

import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.al;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.t;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {
    String a;
    List<ai> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List<ai> f6526c;

    public c(com.anythink.core.common.e.a aVar) {
        super(aVar);
        this.a = com.anythink.core.common.k.g.a(aVar.a, this.f6541l, this.f6542m, aVar.f7082e, 0).toString();
        List<ai> list = aVar.f7087j;
        if (list == null) {
            this.b = new ArrayList(4);
            this.f6526c = new ArrayList(1);
        } else {
            this.b = new ArrayList(list);
            this.f6526c = new ArrayList(aVar.f7087j);
        }
    }

    private String e() {
        if (!this.f6527d.f7090m) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        JSONArray jSONArray = new JSONArray();
        if (this.f6546q != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ad_source_id", this.f6546q.f7346k);
                jSONObject.put("tp_bid_id", this.f6546q.f7342g);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    @Override // com.anythink.core.b.e
    protected final void a(List<JSONObject> list, com.anythink.core.common.g.i iVar) {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        a(jSONArray, jSONArray2);
        a(jSONArray);
        com.anythink.core.b.a.b bVar = new com.anythink.core.b.a.b();
        bVar.a = this.a;
        bVar.b = jSONArray2.toString();
        bVar.f6506c = e();
        bVar.f6509f = this.f6527d.f7091n.ar();
        Boolean bool = this.f6527d.f7101x;
        if (bool != null && bool.booleanValue()) {
            al alVar = this.f6527d.f7100w;
            if (alVar != null) {
                bVar.f6507d = alVar.a().toString();
            }
            bVar.f6508e = jSONArray.toString();
        }
        bVar.f6510g = this.f6527d.f7091n.e();
        com.anythink.core.b.a.a aVar = new com.anythink.core.b.a.a(this.f6543n, this.f6542m, this.f6541l, list, 0);
        aVar.a(bVar);
        aVar.a(0, iVar);
    }

    @Override // com.anythink.core.b.e
    protected final String b() {
        return this.f6527d.f7089l;
    }

    @Override // com.anythink.core.b.e, com.anythink.core.b.d
    protected final void a(ai aiVar, l lVar, long j2) {
        super.a(aiVar, lVar, j2);
        if (aiVar.aa()) {
            return;
        }
        com.anythink.core.common.k.g.a(this.b, aiVar, false);
    }

    private void a(JSONArray jSONArray) {
        List<ai> list;
        Boolean bool = this.f6527d.f7101x;
        if (bool == null || !bool.booleanValue() || (list = this.f6527d.f7086i) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ai aiVar = this.f6527d.f7086i.get(i2);
            if (t.a(this.f6542m, aiVar)) {
                jSONArray.put(new al.a(aiVar).a());
            }
        }
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        List<ai> list;
        List<ai> list2 = this.b;
        if (list2 != null) {
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ai aiVar = list2.get(i2);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ad_source_id", aiVar.t());
                    jSONObject.put("price", aiVar.x());
                    m mVarN = aiVar.N();
                    if (mVarN != null) {
                        jSONObject.put("tp_bid_id", mVarN.f7342g);
                    }
                    jSONObject.put(com.anythink.core.common.l.am, aiVar.ag());
                    jSONArray2.put(jSONObject);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        Boolean bool = this.f6527d.f7101x;
        if (bool == null || !bool.booleanValue() || (list = this.f6526c) == null) {
            return;
        }
        for (ai aiVar2 : list) {
            if (t.a(this.f6542m, aiVar2)) {
                jSONArray.put(new al.a(aiVar2).a());
            }
        }
    }
}
