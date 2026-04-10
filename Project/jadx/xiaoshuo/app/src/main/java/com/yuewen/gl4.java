package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public class gl4<T> {
    public static final int d = 0;
    public static final b e = new b();
    public static final a f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11593b;
    public T c;

    public static class a extends c<JSONObject> {
        public a() {
            super(false);
        }

        @Override // com.yuewen.gl4.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public JSONObject b(JSONObject jSONObject, int i, JSONObject jSONObject2) throws JSONException {
            if (i != 0) {
                return null;
            }
            return jSONObject2;
        }
    }

    public static class b extends c<Void> {
        public b() {
            super(false);
        }

        @Override // com.yuewen.gl4.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void b(JSONObject jSONObject, int i, JSONObject jSONObject2) throws JSONException {
            return null;
        }
    }

    public static abstract class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f11594a;

        public c(boolean z) {
            this.f11594a = z;
        }

        public final boolean a() {
            return this.f11594a;
        }

        public abstract T b(JSONObject jSONObject, int i, JSONObject jSONObject2) throws JSONException;
    }

    public static <T> gl4<T> b(JSONObject jSONObject, c<T> cVar) throws JSONException {
        gl4<T> gl4Var = new gl4<>();
        if (jSONObject.has("code")) {
            gl4Var.f11592a = jSONObject.getInt("code");
            gl4Var.f11593b = jSONObject.optString("description");
            if (cVar == null || !jSONObject.has("data")) {
                gl4Var.c = cVar.a() ? cVar.b(jSONObject, gl4Var.f11592a, null) : null;
            } else {
                gl4Var.c = cVar.b(jSONObject, gl4Var.f11592a, jSONObject.getJSONObject("data"));
            }
        } else if (jSONObject.getString("S").equals("Ok")) {
            gl4Var.f11592a = 0;
            gl4Var.f11593b = "";
            if (cVar == null || !jSONObject.has("R")) {
                gl4Var.c = cVar.b(jSONObject, gl4Var.f11592a, null);
            } else {
                gl4Var.c = cVar.b(jSONObject, gl4Var.f11592a, jSONObject.getJSONObject("R"));
            }
        } else {
            gl4Var.f11592a = Integer.parseInt(jSONObject.getString("R"));
            gl4Var.f11593b = jSONObject.optString("Desc");
            gl4Var.c = null;
        }
        return gl4Var;
    }

    public boolean a() {
        return this.f11592a == 0;
    }
}
