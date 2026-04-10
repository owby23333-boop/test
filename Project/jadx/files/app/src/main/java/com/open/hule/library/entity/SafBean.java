package com.open.hule.library.entity;

import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class SafBean implements Serializable {
    private File file;
    private String migration_package;
    private int type;

    public File getFile() {
        return this.file;
    }

    public String getMigration_package() {
        return this.migration_package;
    }

    public int getType() {
        return this.type;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setMigration_package(String str) {
        this.migration_package = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
