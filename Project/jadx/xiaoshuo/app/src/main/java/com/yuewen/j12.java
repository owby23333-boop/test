package com.yuewen;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public interface j12 {
    public static final j12 H0 = new a();

    public class a implements j12 {
        @Override // com.yuewen.j12
        public boolean d() {
            return false;
        }

        @Override // com.yuewen.j12
        public c12[] g(String str) {
            return new c12[0];
        }

        @Override // com.yuewen.j12
        public void i(com.duokan.download.common.b bVar) {
        }

        @Override // com.yuewen.j12
        public void o(c12 c12Var) {
        }

        @Override // com.yuewen.j12
        public void s(c12 c12Var, boolean z) {
        }

        @Override // com.yuewen.j12
        public c12 u(String str, String str2, u12 u12Var, JSONObject jSONObject) {
            return null;
        }

        @Override // com.yuewen.j12
        public void w(com.duokan.download.common.b bVar) {
        }

        @Override // com.yuewen.j12
        public void x(c12 c12Var) {
        }
    }

    boolean d();

    c12[] g(String str);

    void i(com.duokan.download.common.b bVar);

    void o(c12 c12Var);

    void s(c12 c12Var, boolean z);

    c12 u(String str, String str2, u12 u12Var, JSONObject jSONObject);

    void w(com.duokan.download.common.b bVar);

    void x(c12 c12Var);
}
