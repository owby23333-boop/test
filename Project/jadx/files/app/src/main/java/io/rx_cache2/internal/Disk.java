package io.rx_cache2.internal;

import io.rx_cache2.internal.encrypt.FileEncryptor;
import io.victoralbertos.jolyglot.JolyglotGenerics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
public final class Disk implements Persistence {
    private final File cacheDirectory;
    private final FileEncryptor fileEncryptor;
    private final JolyglotGenerics jolyglot;

    @Inject
    public Disk(File file, FileEncryptor fileEncryptor, JolyglotGenerics jolyglotGenerics) {
        this.cacheDirectory = file;
        this.fileEncryptor = fileEncryptor;
        this.jolyglot = jolyglotGenerics;
    }

    private String safetyKey(String str) {
        return str.replaceAll("/", "_");
    }

    @Override // io.rx_cache2.internal.Persistence
    public List<String> allKeys() {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = this.cacheDirectory.listFiles();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        for (File file : fileArrListFiles) {
            if (file.isFile()) {
                arrayList.add(file.getName());
            }
        }
        return arrayList;
    }

    @Override // io.rx_cache2.internal.Persistence
    public void evict(String str) {
        new File(this.cacheDirectory, safetyKey(str)).delete();
    }

    @Override // io.rx_cache2.internal.Persistence
    public void evictAll() {
        File[] fileArrListFiles = this.cacheDirectory.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file != null) {
                    file.delete();
                }
            }
        }
    }

    @Override // io.rx_cache2.internal.Persistence
    public <T> T retrieve(String str, Class<T> cls, boolean z2, String str2) {
        File file = new File(this.cacheDirectory, safetyKey(str));
        if (z2) {
            file = this.fileEncryptor.decrypt(str2, file);
        }
        try {
            T t2 = (T) this.jolyglot.fromJson(file, (Class) cls);
            if (z2) {
                file.delete();
            }
            return t2;
        } catch (Exception unused) {
            if (z2) {
                file.delete();
            }
            return null;
        } catch (Throwable th) {
            if (z2) {
                file.delete();
            }
            throw th;
        }
    }

    public <T> T[] retrieveArray(String str, Class<T> cls) {
        try {
            return (T[]) ((Object[]) this.jolyglot.fromJson(new File(this.cacheDirectory, safetyKey(str)), (Class) Array.newInstance((Class<?>) cls, 1).getClass()));
        } catch (Exception unused) {
            return null;
        }
    }

    public <C extends Collection<T>, T> C retrieveCollection(String str, Class<C> cls, Class<T> cls2) {
        try {
            return (C) this.jolyglot.fromJson(new File(this.cacheDirectory, safetyKey(str)), this.jolyglot.newParameterizedType(cls, cls2));
        } catch (Exception unused) {
            return null;
        }
    }

    public <M extends Map<K, V>, K, V> M retrieveMap(String str, Class cls, Class<K> cls2, Class<V> cls3) {
        try {
            return (M) this.jolyglot.fromJson(new File(this.cacheDirectory, safetyKey(str)), this.jolyglot.newParameterizedType(cls, cls2, cls3));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // io.rx_cache2.internal.Persistence
    public <T> Record<T> retrieveRecord(String str, boolean z2, String str2) {
        Class<?> cls = Object.class;
        File file = new File(this.cacheDirectory, safetyKey(str));
        if (z2) {
            try {
                file = this.fileEncryptor.decrypt(str2, file);
            } catch (Exception unused) {
                if (z2) {
                    file.delete();
                }
                return null;
            } catch (Throwable th) {
                if (z2) {
                    file.delete();
                }
                throw th;
            }
        }
        Record record = (Record) this.jolyglot.fromJson(file, this.jolyglot.newParameterizedType(Record.class, cls));
        Class<?> cls2 = record.getDataClassName() == null ? cls : Class.forName(record.getDataClassName());
        if (record.getDataCollectionClassName() != null) {
            cls = Class.forName(record.getDataCollectionClassName());
        }
        Record<T> record2 = Collection.class.isAssignableFrom(cls) ? (Record) this.jolyglot.fromJson(file.getAbsoluteFile(), this.jolyglot.newParameterizedType(Record.class, this.jolyglot.newParameterizedType(cls, cls2))) : cls.isArray() ? (Record) this.jolyglot.fromJson(file.getAbsoluteFile(), this.jolyglot.newParameterizedType(Record.class, cls)) : Map.class.isAssignableFrom(cls) ? (Record) this.jolyglot.fromJson(file.getAbsoluteFile(), this.jolyglot.newParameterizedType(Record.class, this.jolyglot.newParameterizedType(cls, Class.forName(record.getDataKeyMapClassName()), cls2))) : (Record) this.jolyglot.fromJson(file.getAbsoluteFile(), this.jolyglot.newParameterizedType(Record.class, cls2));
        record2.setSizeOnMb((file.length() / 1024.0f) / 1024.0f);
        if (z2) {
            file.delete();
        }
        return record2;
    }

    @Override // io.rx_cache2.internal.Persistence
    public void save(String str, Object obj, boolean z2, String str2) throws Throwable {
        String strSafetyKey = safetyKey(str);
        String json = obj instanceof Record ? this.jolyglot.toJson(obj, this.jolyglot.newParameterizedType(obj.getClass(), Object.class)) : this.jolyglot.toJson(obj);
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(new File(this.cacheDirectory, strSafetyKey), false);
                try {
                    fileWriter2.write(json);
                    fileWriter2.flush();
                    fileWriter2.close();
                    if (z2) {
                        this.fileEncryptor.encrypt(str2, new File(this.cacheDirectory, strSafetyKey));
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.flush();
                            fileWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
            throw new RuntimeException(e);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // io.rx_cache2.internal.Persistence
    public void saveRecord(String str, Record record, boolean z2, String str2) throws Throwable {
        save(str, record, z2, str2);
    }

    @Override // io.rx_cache2.internal.Persistence
    public int storedMB() {
        File[] fileArrListFiles = this.cacheDirectory.listFiles();
        if (fileArrListFiles == null) {
            return 0;
        }
        long length = 0;
        for (File file : fileArrListFiles) {
            length += file.length();
        }
        double d2 = length;
        Double.isNaN(d2);
        return (int) Math.ceil((d2 / 1024.0d) / 1024.0d);
    }
}
