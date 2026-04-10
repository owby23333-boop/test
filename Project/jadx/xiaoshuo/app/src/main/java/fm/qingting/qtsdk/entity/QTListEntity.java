package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class QTListEntity<T> {

    @SerializedName("data")
    private List<T> data;

    @SerializedName("page")
    private int page;

    @SerializedName("pagesize")
    private int pagesize;

    @SerializedName("total")
    private int total;

    public List<T> getData() {
        return this.data;
    }

    public int getPage() {
        return this.page;
    }

    public int getPagesize() {
        return this.pagesize;
    }

    public int getTotal() {
        return this.total;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
