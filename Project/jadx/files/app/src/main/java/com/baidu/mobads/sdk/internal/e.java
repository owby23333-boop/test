package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private dd a;
    private String b;

    public interface a {
        void a();

        void a(int i2, String str);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i2);

        void a(List<NativeResponse> list);

        void b();

        void b(int i2, String str);

        void b(NativeResponse nativeResponse);

        void c();
    }

    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public e(Context context, String str, a aVar, boolean z2, int i2) {
        this(context, aVar, new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z2, i2));
    }

    public void a() {
        dd ddVar = this.a;
        if (ddVar != null) {
            ddVar.e();
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public e(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z2, int i2) {
        this.a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z2, i2);
        this.a.a(expressAdListener);
        this.a.a(1);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dd ddVar = this.a;
        if (ddVar != null) {
            ddVar.g(this.b);
        }
        this.a.a(requestParameters);
        this.a.a();
    }

    public void a(b bVar) {
        dd ddVar = this.a;
        if (ddVar != null) {
            ddVar.a(bVar);
        }
    }

    public void a(int i2) {
        dd ddVar = this.a;
        if (ddVar != null) {
            ddVar.f12903p = i2;
        }
    }

    public e(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z2, int i2) {
        this.a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z2, i2);
        this.a.a(entryAdListener);
    }

    public void a(boolean z2) {
        dd ddVar = this.a;
        if (ddVar != null) {
            ddVar.c(z2);
        }
    }

    public void b(String str) {
        this.b = str;
    }

    public e(Context context, String str, a aVar, boolean z2, int i2, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z2, i2);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z2, i2);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.a = new dd(context, str, "video", z2, i2);
            } else {
                this.a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z2, i2);
            }
        }
        this.a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        if (this.a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.a.g(this.b);
        this.a.a(requestParameters);
        return this.a.m();
    }

    public void a(String str) {
        dd ddVar = this.a;
        if (ddVar != null) {
            ddVar.b(str);
        }
    }

    public e(Context context, a aVar, dd ddVar) {
        this.a = ddVar;
        this.a.a(aVar);
    }
}
