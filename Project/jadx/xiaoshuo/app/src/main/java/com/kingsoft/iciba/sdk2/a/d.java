package com.kingsoft.iciba.sdk2.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class d extends a {
    private static final String DMDATA = "{\"version\":16,\"dictlist\":[{\"id\":14,\"dictname\":\"英汉词典\",\"filename\":\"ec_xiaobai.dic\",\"count\":60000,\"size\":\"2.50M\",\"vername\":\"v1.3\",\"vercode\":2},{\"id\":15,\"dictname\":\"汉英词典\",\"filename\":\"ce_xiaobai.dic\",\"count\":60000,\"size\":\"1.78MB\",\"vername\":\"v1.2.5\",\"vercode\":1},{\"id\":16,\"dictname\":\"汉汉词典\",\"filename\":\"cc.dic\",\"count\":60000,\"size\":\"3.38MB\",\"vername\":\"v1.1\",\"vercode\":2}]}";
    private static final String g = "d";
    private Map af;
    private List ag;
    private final Object ah;

    public d(Context context) {
        super(context);
        this.af = new HashMap();
        this.ag = new ArrayList();
        this.ah = new Object();
    }

    private e q(String str) {
        String strM;
        e eVar = new e();
        int i = TextUtils.isEmpty(str) ? -2 : str.matches("[!-~,\\s]+") ? 0 : 1;
        synchronized (this.ah) {
            Iterator it = this.af.keySet().iterator();
            while (it.hasNext()) {
                c cVar = (c) this.af.get(it.next());
                if (cVar != null && cVar.S == i && cVar.g()) {
                    a(cVar);
                    str = cVar.u() ? l(str) : str.toLowerCase();
                    if (cVar.c(k(str)) >= 0 && (strM = m(str)) != null && strM.length() > 0) {
                        eVar.a(cVar, strM);
                    }
                }
            }
        }
        return eVar;
    }

    public final void a(List list, String str) {
        this.ag.clear();
        try {
            JSONArray jSONArray = new JSONObject(DMDATA).getJSONArray("dictlist");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                b bVar = new b();
                jSONObject.getInt("id");
                Long.valueOf(jSONObject.getLong("count")).longValue();
                jSONObject.getInt("vercode");
                jSONObject.getString("dictname");
                bVar.setFileName(jSONObject.getString("filename"));
                jSONObject.getString("size");
                jSONObject.getString("vername");
                this.ag.add(bVar);
            }
        } catch (Exception e) {
            this.ag.clear();
            Log.e(g, "Analysis dict configure file failed", e);
        }
        Iterator it = this.ag.iterator();
        while (it.hasNext()) {
            String str2 = str + File.separator + ((b) it.next()).getFileName();
            if (new File(str2).exists()) {
                synchronized (this.ah) {
                    f fVar = new f(str2);
                    if (this.af.containsKey(str2)) {
                        this.af.remove(str2);
                    }
                    this.af.put(str2, fVar);
                }
            }
        }
    }

    public final ArrayList p(String str) {
        e eVarQ = q(str);
        if (eVarQ == null || eVarQ.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < eVarQ.size(); i++) {
            String str2 = eVarQ.e(i).P;
            byte[] bytes = str2.getBytes();
            if (bytes.length > 3 && bytes[0] == -17 && bytes[1] == -69 && bytes[2] == -65) {
                str2 = new String(bytes, 3, bytes.length - 3);
            }
            String str3 = (str2.equals("英汉词典") || str2.equals("汉英词典") || str2.equals("英汉词典增强版") || str2.equals("汉英词典增强版")) ? "baseInfo" : str2.equals("汉汉词典") ? "cc_mean" : null;
            String strA = a(eVarQ.e(i).P, eVarQ.f(i));
            if (str3 != null && strA != null) {
                arrayList.add(new AbstractMap.SimpleEntry(str3, strA));
            }
        }
        return arrayList;
    }

    public final int v() {
        return this.af.size();
    }
}
