package cn.bmob.v3.datatype;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BmobSmsState implements Serializable {
    private static final long serialVersionUID = 1;
    private String smsState;
    private String verifyState;

    public BmobSmsState(String str, String str2) {
        this.smsState = str;
        this.verifyState = str2;
    }

    public String getSmsState() {
        return this.smsState;
    }

    public String getVerifyState() {
        return this.verifyState;
    }

    public void setSmsState(String str) {
        this.smsState = str;
    }

    public void setVerifyState(String str) {
        this.verifyState = str;
    }
}
