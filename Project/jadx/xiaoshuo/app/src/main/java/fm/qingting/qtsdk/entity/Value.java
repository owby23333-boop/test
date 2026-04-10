package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes8.dex */
public class Value {

    @Expose
    private Long id;

    @Expose
    private String name;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
