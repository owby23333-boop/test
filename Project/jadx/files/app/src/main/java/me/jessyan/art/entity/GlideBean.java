package me.jessyan.art.entity;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public class GlideBean implements Serializable {
    private String encrypt_info;
    private int encrypt_type;
    private int id;
    private String signature;

    public GlideBean() {
    }

    public String getEncrypt_info() {
        return this.encrypt_info;
    }

    public int getEncrypt_type() {
        return this.encrypt_type;
    }

    public int getId() {
        return this.id;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setEncrypt_info(String str) {
        this.encrypt_info = str;
    }

    public void setEncrypt_type(int i2) {
        this.encrypt_type = i2;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    @NotNull
    public String toString() {
        return "glideBean{id=" + this.id + ", encrypt_info=" + this.encrypt_info + '}';
    }

    public GlideBean(int i2, String str) {
        this.id = i2;
        this.encrypt_info = str;
    }

    public GlideBean(int i2, String str, int i3) {
        this.id = i2;
        this.encrypt_info = str;
        this.encrypt_type = i3;
    }

    public GlideBean(int i2, String str, int i3, String str2) {
        this.id = i2;
        this.encrypt_info = str;
        this.encrypt_type = i3;
        this.signature = str2;
    }
}
