package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.efs.sdk.base.core.util.concurrent.c<HttpResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f1575a;
    Map<String, String> b;
    public byte[] c;
    public File d;
    public String e;
    public Map<String, String> f;
    public boolean g = false;

    @Override // com.efs.sdk.base.core.util.concurrent.c
    public final /* synthetic */ HttpResponse a() {
        String str = this.e;
        str.hashCode();
        if (str.equals("get")) {
            return HttpEnv.getInstance().getHttpUtil().get(this.f1575a, this.b);
        }
        if (!str.equals("post")) {
            Log.e("efs.util.http", "request not support method '" + this.e + "'");
            return null;
        }
        byte[] bArr = this.c;
        if (bArr != null && bArr.length > 0) {
            if (this.g) {
                return HttpEnv.getInstance().getHttpUtil().postAsFile(this.f1575a, this.b, this.c);
            }
            return HttpEnv.getInstance().getHttpUtil().post(this.f1575a, this.b, this.c);
        }
        return HttpEnv.getInstance().getHttpUtil().post(this.f1575a, this.b, this.d);
    }
}
