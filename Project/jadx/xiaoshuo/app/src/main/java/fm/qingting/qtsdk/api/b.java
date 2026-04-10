package fm.qingting.qtsdk.api;

import com.google.gson.annotations.SerializedName;
import com.mibi.sdk.common.CommonConstants;
import fm.qingting.qtsdk.QTException;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("data")
    private List<T> f21059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("page")
    private int f21060b;

    @SerializedName("pagesize")
    private int c;

    @SerializedName("total")
    private int d;

    @SerializedName("errmsg")
    private String e;

    @SerializedName(CommonConstants.KEY_ERR_CODE)
    private int f;

    public List<T> a() {
        return this.f21059a;
    }

    public QTException b() {
        if (this.f != 0) {
            return new QTException(this.e, this.f);
        }
        return null;
    }

    public int c() {
        return this.f21060b;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }
}
