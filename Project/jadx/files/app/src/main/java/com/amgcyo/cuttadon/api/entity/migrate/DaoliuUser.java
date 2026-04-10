package com.amgcyo.cuttadon.api.entity.migrate;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class DaoliuUser implements Serializable {
    private static final long serialVersionUID = -8231327737663712704L;
    private String token;
    private long user_id;

    public String getToken() {
        return this.token;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUser_id(long j2) {
        this.user_id = j2;
    }

    @NonNull
    public String toString() {
        return "DaoliuUser{user_id=" + this.user_id + ", token='" + this.token + "'}";
    }
}
