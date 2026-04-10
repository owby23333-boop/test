package cn.bmob.v3.datatype;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobRole;
import cn.bmob.v3.BmobUser;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BmobPointer implements Serializable {
    private static final long serialVersionUID = -2906907910428442090L;
    private String __type = "Pointer";
    private String className;
    private String objectId;

    public BmobPointer() {
    }

    private String get__type() {
        return this.__type;
    }

    public String getClassName() {
        return this.className;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public BmobPointer(String str, String str2) {
        setClassName(str);
        setObjectId(str2);
    }

    public BmobPointer(Object obj) {
        if (obj instanceof BmobUser) {
            setClassName("_User");
            setObjectId(((BmobUser) obj).getObjectId());
        } else if (obj instanceof BmobRole) {
            setClassName(BmobRole.tableName);
            setObjectId(((BmobRole) obj).getObjectId());
        } else if (obj instanceof BmobObject) {
            BmobObject bmobObject = (BmobObject) obj;
            setClassName(bmobObject.getClass().getSimpleName());
            setObjectId(bmobObject.getObjectId());
        }
    }
}
