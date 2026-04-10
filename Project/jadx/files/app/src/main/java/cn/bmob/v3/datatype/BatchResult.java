package cn.bmob.v3.datatype;

import cn.bmob.v3.exception.BmobException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BatchResult implements Serializable {
    private static final long serialVersionUID = 1;
    private String createdAt;
    private BmobException error;
    private boolean isSuccess;
    private String objectId;
    private String updatedAt;

    public String getCreatedAt() {
        return this.createdAt;
    }

    public BmobException getError() {
        return this.error;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setError(BmobException bmobException) {
        this.error = bmobException;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public void setSuccess(boolean z2) {
        this.isSuccess = z2;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }
}
