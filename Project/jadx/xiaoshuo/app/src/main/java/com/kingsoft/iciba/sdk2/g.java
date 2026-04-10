package com.kingsoft.iciba.sdk2;

import com.kingsoft.iciba.sdk2.interfaces.IKSCibaQueryResult;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

/* JADX INFO: loaded from: classes7.dex */
final class g {
    public String B;
    public HttpRequestBase C;
    public HttpResponse D = null;
    public boolean E;
    public ArrayList F;
    public IKSCibaQueryResult G;

    public g(d dVar, String str, HttpRequestBase httpRequestBase, ArrayList arrayList, IKSCibaQueryResult iKSCibaQueryResult) {
        this.E = false;
        this.F = null;
        this.B = str;
        this.C = httpRequestBase;
        if (arrayList == null || arrayList.size() == 0) {
            this.F = null;
        } else {
            this.F = arrayList;
        }
        this.E = true;
        this.G = iKSCibaQueryResult;
    }
}
