package com.amgcyo.cuttadon.api.entity.soloader;

import androidx.annotation.Nullable;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class AbiBean implements Serializable {
    private String file_md5;
    private String file_name;

    public AbiBean(String str, String str2) {
        this.file_name = str;
        this.file_md5 = str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbiBean)) {
            return false;
        }
        AbiBean abiBean = (AbiBean) obj;
        return this.file_md5.equalsIgnoreCase(abiBean.file_md5) && this.file_name.equalsIgnoreCase(abiBean.file_name);
    }

    public String getFile_md5() {
        return this.file_md5;
    }

    public String getFile_name() {
        return this.file_name;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setFile_md5(String str) {
        this.file_md5 = str;
    }

    public void setFile_name(String str) {
        this.file_name = str;
    }

    @NotNull
    public String toString() {
        return "AbiBean{file_name='" + this.file_name + "', file_md5='" + this.file_md5 + "'}";
    }

    public AbiBean() {
    }
}
