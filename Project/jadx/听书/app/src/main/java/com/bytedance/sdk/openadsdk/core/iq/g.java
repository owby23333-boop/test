package com.bytedance.sdk.openadsdk.core.iq;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1160a;
    public int dl = 1;
    private int e;
    private long fo;
    public int g;
    public ArrayList<Integer> gc;
    private long gz;
    private long kb;
    public com.bytedance.sdk.openadsdk.ls.dl.dl.g m;
    private long uy;
    private JSONObject wp;
    public String z;

    public String z() {
        return this.z;
    }

    public void z(String str) {
        this.z = str;
    }

    public int g() {
        return this.g;
    }

    public void z(int i) {
        this.g = i;
    }

    public int dl() {
        return this.e;
    }

    public void g(int i) {
        this.e = i;
    }

    public String a() {
        return this.f1160a;
    }

    public void g(String str) {
        this.f1160a = str;
    }

    public JSONObject gc() {
        return this.wp;
    }

    public void z(JSONObject jSONObject) {
        this.wp = jSONObject;
    }

    public int m() {
        return this.dl;
    }

    public void dl(int i) {
        this.dl = i;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.dl.g e() {
        return this.m;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.m = gVar;
    }

    public ArrayList<Integer> gz() {
        return this.gc;
    }

    public void z(ArrayList<Integer> arrayList) {
        this.gc = arrayList;
    }

    public static void z(g gVar) {
        int iG;
        if (gVar == null || gVar.e() == null || (iG = gVar.g()) >= 0 || iG == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.g.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObjectGc = g.this.gc();
                if (jSONObjectGc == null) {
                    jSONObjectGc = new JSONObject();
                }
                jSONObjectGc.put("from", g.this.m());
                jSONObjectGc.put("err_code", g.this.g());
                jSONObjectGc.put("err_msg", g.this.a());
                jSONObjectGc.put("server_res_str", g.this.z());
                if (g.this.gz() != null && g.this.gz().size() > 0) {
                    jSONObjectGc.put("mate_unavailable_code_list", new JSONArray((Collection) g.this.gz()).toString());
                }
                com.bytedance.sdk.component.utils.wp.z("AdLogInfoModel", "rd_client_custom_error = ", jSONObjectGc);
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("rd_client_custom_error").z(g.this.e().tb()).g(jSONObjectGc.toString());
            }
        }, "rd_client_custom_error");
    }

    public long fo() {
        return this.gz;
    }

    public void z(long j) {
        this.gz = j;
    }

    public long uy() {
        return this.fo;
    }

    public void g(long j) {
        this.fo = j;
    }

    public long kb() {
        return this.uy;
    }

    public void dl(long j) {
        this.uy = j;
    }

    public long wp() {
        return this.kb;
    }

    public void a(long j) {
        this.kb = j;
    }
}
