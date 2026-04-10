package com.alipay.android.phone.mrpc.core.a;

import android.util.Log;
import com.alipay.android.phone.mrpc.core.RpcException;
import com.mibi.sdk.component.Constants;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {
    private int c;
    private Object d;

    public e(int i, String str, Object obj) {
        super(str, obj);
        this.c = i;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public void a(Object obj) {
        this.d = obj;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.d != null) {
                arrayList.add(new BasicNameValuePair("extParam", com.alipay.sdk.m.f.a.a(this.d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f1630a));
            arrayList.add(new BasicNameValuePair("id", this.c + ""));
            Log.d("JsonSerializer", "mParams is:" + this.f1631b);
            Object obj = this.f1631b;
            arrayList.add(new BasicNameValuePair(Constants.KEY_REQUEST_DATA, obj == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : com.alipay.sdk.m.f.a.a(obj)));
            String str = URLEncodedUtils.format(arrayList, "utf-8");
            Log.i("JsonSerializer", "request = " + str);
            return str.getBytes();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("request  =");
            sb.append(this.f1631b);
            sb.append(":");
            sb.append(e);
            throw new RpcException(9, sb.toString() != null ? e.getMessage() : "", e);
        }
    }
}
