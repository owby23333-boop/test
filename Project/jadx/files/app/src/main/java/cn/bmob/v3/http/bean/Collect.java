package cn.bmob.v3.http.bean;

/* JADX INFO: loaded from: classes.dex */
public class Collect {
    public static final int OPEN = 1;
    private String id;
    private int isOpen;

    public String getId() {
        return this.id;
    }

    public int getIsOpen() {
        return this.isOpen;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Collect setIsOpen(int i2) {
        this.isOpen = i2;
        return this;
    }
}
