package cn.bmob.v3.datatype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BmobRelation implements Serializable {
    private static final long serialVersionUID = 7419229244419967901L;
    private String __op = "AddRelation";
    private List<BmobPointer> objects = new ArrayList();

    public BmobRelation(Object obj) {
        this.objects.add(new BmobPointer(obj));
    }

    public void add(Object obj) {
        this.objects.add(new BmobPointer(obj));
    }

    public List<BmobPointer> getObjects() {
        return Collections.unmodifiableList(this.objects);
    }

    public String get__op() {
        return this.__op;
    }

    @Deprecated
    public void isRemove(boolean z2) {
        if (z2) {
            this.__op = "RemoveRelation";
        }
    }

    public void remove(Object obj) {
        this.__op = "RemoveRelation";
        this.objects.add(new BmobPointer(obj));
    }

    public void setObjects(List<BmobPointer> list) {
        this.objects = list;
    }

    public BmobRelation() {
    }
}
