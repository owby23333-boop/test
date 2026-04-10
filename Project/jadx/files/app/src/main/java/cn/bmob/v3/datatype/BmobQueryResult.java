package cn.bmob.v3.datatype;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BmobQueryResult<T> implements Serializable {
    private static final long serialVersionUID = 1;
    int count;
    private List<T> results;

    public BmobQueryResult() {
        this.results = Collections.emptyList();
    }

    public int getCount() {
        return this.count;
    }

    public List<T> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    void setCount(int i2) {
        this.count = i2;
    }

    void setResults(List<T> list) {
        this.results = list;
    }

    public BmobQueryResult(List<T> list, int i2) {
        this.results = list;
        this.count = i2;
    }
}
