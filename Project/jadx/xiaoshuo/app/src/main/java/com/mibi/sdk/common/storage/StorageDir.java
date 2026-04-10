package com.mibi.sdk.common.storage;

import android.os.FileObserver;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class StorageDir extends StorageFile {

    public abstract class StorageDirObserver extends FileObserver {
        public StorageDirObserver(int i) {
            super(StorageDir.this.getAbsolutePath(), i);
        }
    }

    public StorageDir(File file, String str) {
        super(file, str);
        mkdirs();
    }

    public void append(String str, String str2) {
        new StorageFile(this, str).append(str2);
    }

    public boolean delete(String str) {
        return new StorageFile(this, str).delete();
    }

    public boolean deleteAll() {
        if (!hasFiles()) {
            return true;
        }
        for (StorageFile storageFile : listFiles()) {
            if (!storageFile.delete()) {
                return false;
            }
        }
        return true;
    }

    public long getFileLength(String str) {
        return new StorageFile(this, str).length();
    }

    public boolean hasFile(String str) {
        if (hasFiles()) {
            for (StorageFile storageFile : listFiles()) {
                if (storageFile.getName().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasFiles() {
        StorageFile[] storageFileArrListFiles = listFiles();
        return storageFileArrListFiles != null && storageFileArrListFiles.length > 0;
    }

    public long lastModified(String str) {
        return new StorageFile(this, str).lastModified();
    }

    @Override // java.io.File
    public String[] list() {
        String[] list;
        synchronized (StorageFile.getFileLock(this)) {
            list = super.list();
        }
        return list;
    }

    public String read(String str) {
        return new StorageFile(this, str).read();
    }

    public ArrayList<String> readAndSplit(String str) {
        return new StorageFile(this, str).readAndSplit();
    }

    public byte[] readBytes(String str) {
        return new StorageFile(this, str).readBytes();
    }

    public Serializable readObject(String str) {
        return new StorageFile(this, str).readObject();
    }

    public void write(String str, String str2) {
        new StorageFile(this, str).write(str2);
    }

    public void writeBytes(String str, byte[] bArr) {
        new StorageFile(this, str).writeBytes(bArr);
    }

    public void writeObject(String str, Serializable serializable) {
        new StorageFile(this, str).writeObject(serializable);
    }

    @Override // java.io.File
    public StorageFile[] listFiles() {
        synchronized (StorageFile.getFileLock(this)) {
            String[] list = list();
            if (list == null) {
                return null;
            }
            int length = list.length;
            StorageFile[] storageFileArr = new StorageFile[length];
            for (int i = 0; i < length; i++) {
                storageFileArr[i] = new StorageFile(this, list[i]);
            }
            return storageFileArr;
        }
    }

    public StorageDir(String str, String str2) {
        super(str, str2);
        mkdirs();
    }

    public StorageDir(String str) {
        super(str);
        mkdirs();
    }
}
