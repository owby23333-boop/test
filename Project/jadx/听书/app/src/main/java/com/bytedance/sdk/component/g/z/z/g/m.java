package com.bytedance.sdk.component.g.z.z.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.i;
import com.bytedance.sdk.component.g.z.kb;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.p;
import com.bytedance.sdk.component.g.z.v;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m extends ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f726a;
    public long dl;
    v g;
    kb gc = null;
    HttpURLConnection z;

    public String toString() {
        return "";
    }

    public m(HttpURLConnection httpURLConnection, v vVar) {
        this.z = httpURLConnection;
        this.g = vVar;
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public long z() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public long g() {
        return this.f726a;
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public int dl() {
        try {
            return this.z.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public boolean a() {
        return dl() >= 200 && dl() < 300;
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public String gc() throws IOException {
        return this.z.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public p m() {
        try {
            return new e(this.z);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public com.bytedance.sdk.component.g.z.m e() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.z.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(entry.getKey()) || dl() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.g.z.m((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public String z(String str) {
        return this.z.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public String z(String str, String str2) {
        return !TextUtils.isEmpty(z(str)) ? z(str) : str2;
    }

    @Override // com.bytedance.sdk.component.g.z.ls, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            m().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public i gz() {
        return i.HTTP_1_1;
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public kb fo() {
        return this.gc;
    }
}
