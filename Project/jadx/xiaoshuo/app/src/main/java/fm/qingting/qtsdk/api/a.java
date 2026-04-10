package fm.qingting.qtsdk.api;

import com.google.gson.annotations.SerializedName;
import com.mibi.sdk.common.CommonConstants;
import fm.qingting.qtsdk.QTException;

/* JADX INFO: loaded from: classes8.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("data")
    private T f21057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("errmsg")
    private String f21058b;

    @SerializedName(CommonConstants.KEY_ERR_CODE)
    private int c;

    public T a() {
        return this.f21057a;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.f21058b;
    }

    public QTException d() {
        if (this.c != 0) {
            return new QTException(this.f21058b, this.c);
        }
        return null;
    }

    public void a(int errcode) {
        this.c = errcode;
    }

    public void a(String errmsg) {
        this.f21058b = errmsg;
    }
}
