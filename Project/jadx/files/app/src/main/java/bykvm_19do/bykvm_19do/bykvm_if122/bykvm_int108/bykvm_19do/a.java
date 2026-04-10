package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1728c;

    public a(Context context) {
        super(context);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVarC = c();
        if (aVarC != null) {
            this.f1728c = aVarC.a();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected String a() {
        return TextUtils.isEmpty(this.f1728c) ? "appId为空" : "";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected String b() {
        return "admob";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected Map<String, Object> d() {
        HashMap map = new HashMap();
        map.put("app_id", this.f1728c);
        return map;
    }
}
