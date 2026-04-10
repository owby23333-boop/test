package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.h;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.o;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile a b;
    private volatile Context a;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.a$a, reason: collision with other inner class name */
    class RunnableC0060a implements Runnable {
        final /* synthetic */ JSONObject a;

        RunnableC0060a(a aVar, JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = b.a(i.e().d());
            try {
                this.a.put("upload_scene", "direct");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            b.a(strA, this.a.toString());
        }
    }

    private a(@NonNull Context context) {
        this.a = context;
    }

    public static a a() {
        if (b == null) {
            b = new a(i.b());
        }
        return b;
    }

    @Nullable
    public String a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.a(h.c(this.a), h.b(), b.a(i.e().d()), jSONObject, b.a());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strA = b.a(i.e().d());
            String strA2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.a(h.c(this.a), h.a(), strA, jSONObject, b.b());
            jSONObject.put("upload_scene", "direct");
            if (b.a(strA, jSONObject.toString()).a()) {
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.a(strA2);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        o.a(new RunnableC0060a(this, jSONObject));
    }
}
