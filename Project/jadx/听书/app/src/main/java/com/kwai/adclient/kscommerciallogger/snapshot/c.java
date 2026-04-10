package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    private final String bfc;
    private final LinkedList<d> bfd;
    private int bfe;
    private final int bff;
    private long bfg;

    c(String str) {
        this(str, 10);
    }

    c(String str, int i) {
        this.bfc = str == null ? "" : str;
        this.bfd = new LinkedList<>();
        this.bff = Math.min(i, 30);
        this.bfg = System.currentTimeMillis();
    }

    final String getName() {
        return this.bfc;
    }

    synchronized JSONObject hQ(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<d> it = this.bfd.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().Tq());
            }
            jSONObject.put("session_id", str);
            jSONObject.put("segment_name", this.bfc);
            jSONObject.put("spans", jSONArray);
            this.bfg = System.currentTimeMillis();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public synchronized d hP(String str) {
        d dVar;
        if (this.bfd.size() >= this.bff) {
            this.bfd.removeFirst();
        }
        StringBuilder sbAppend = new StringBuilder().append(str).append("_");
        int i = this.bfe;
        this.bfe = i + 1;
        dVar = new d(sbAppend.append(i).toString());
        this.bfd.addLast(dVar);
        this.bfg = System.currentTimeMillis();
        return dVar;
    }

    public final synchronized long Tr() {
        return this.bfg;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.bfc.equals(((c) obj).bfc);
    }

    public int hashCode() {
        return Objects.hash(this.bfc);
    }
}
