package com.yuewen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class rb0 extends p12 {
    public static final String S = "delete_files_task__cloud_file_infos";
    public static final String T = "delete_files_task__permanent";
    public static final String U = "delete_files_task__deleted_file_infos";
    public ArrayList<u12> P;
    public boolean Q;
    public ArrayList<u12> R;

    public rb0(String str, String str2, List<u12> list, boolean z, int i) {
        super(str, str2, list.get(0).e(), 2, i);
        this.P = new ArrayList<>();
        this.R = new ArrayList<>();
        this.P.addAll(list);
        this.Q = z;
    }

    @Override // com.yuewen.p12, com.duokan.core.async.work.b
    public void E(JSONObject jSONObject) {
        super.E(jSONObject);
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<u12> it = this.P.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().d());
            }
            jSONObject.put(S, jSONArray);
            jSONObject.put(T, this.Q);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<u12> it2 = this.R.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().d());
            }
            jSONObject.put(U, jSONArray2);
        } catch (JSONException unused) {
        }
    }

    public List<u12> K() {
        return this.P;
    }

    public List<u12> L() {
        return this.R;
    }

    public boolean M() {
        return this.Q;
    }

    public void N(u12 u12Var) {
        if (this.R.contains(u12Var)) {
            return;
        }
        this.R.add(u12Var);
    }

    @Override // com.yuewen.p12, com.duokan.core.async.work.b
    public void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        this.P.addAll(u12.b(jSONObject.getJSONArray(S)));
        this.Q = jSONObject.optBoolean(T);
        this.R.addAll(u12.b(jSONObject.getJSONArray(U)));
    }

    public rb0(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.P = new ArrayList<>();
        this.R = new ArrayList<>();
    }
}
