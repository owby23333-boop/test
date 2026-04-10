package com.kwai.adclient.logger.snapshot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private final String aDk;
    private final LinkedList<d> aDl;
    private int aDm;
    private final int aDn;
    private long aDo;

    c(String str) {
        this(str, 10);
    }

    c(String str, int i2) {
        this.aDk = str == null ? "" : str;
        this.aDl = new LinkedList<>();
        this.aDn = Math.min(i2, 30);
        this.aDo = System.currentTimeMillis();
    }

    public final synchronized long FU() {
        return this.aDo;
    }

    public synchronized d eQ(String str) {
        d dVar;
        if (this.aDl.size() >= this.aDn) {
            this.aDl.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        int i2 = this.aDm;
        this.aDm = i2 + 1;
        sb.append(i2);
        dVar = new d(sb.toString());
        this.aDl.addLast(dVar);
        this.aDo = System.currentTimeMillis();
        return dVar;
    }

    synchronized JSONObject eR(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<d> it = this.aDl.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().FT());
            }
            jSONObject.put("session_id", str);
            jSONObject.put("segment_name", this.aDk);
            jSONObject.put("spans", jSONArray);
            this.aDo = System.currentTimeMillis();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aDk.equals(((c) obj).aDk);
    }

    final String getName() {
        return this.aDk;
    }

    public int hashCode() {
        return Objects.hash(this.aDk);
    }
}
