package io.victoralbertos.jolyglot;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class GsonSpeaker implements JolyglotGenerics {
    private final Gson gson;

    public GsonSpeaker(Gson gson) {
        this.gson = gson;
    }

    @Override // io.victoralbertos.jolyglot.JolyglotGenerics
    public GenericArrayType arrayOf(Type type) {
        return Types.arrayOf(type);
    }

    @Override // io.victoralbertos.jolyglot.Jolyglot
    public <T> T fromJson(String str, Class<T> cls) throws RuntimeException {
        return (T) this.gson.fromJson(str, (Class) cls);
    }

    @Override // io.victoralbertos.jolyglot.JolyglotGenerics
    public ParameterizedType newParameterizedType(Type type, Type... typeArr) {
        return Types.newParameterizedType(type, typeArr);
    }

    @Override // io.victoralbertos.jolyglot.Jolyglot
    public String toJson(Object obj) {
        return this.gson.toJson(obj);
    }

    @Override // io.victoralbertos.jolyglot.JolyglotGenerics
    public <T> T fromJson(String str, Type type) throws RuntimeException {
        return (T) this.gson.fromJson(str, type);
    }

    @Override // io.victoralbertos.jolyglot.JolyglotGenerics
    public String toJson(Object obj, Type type) {
        return this.gson.toJson(obj, type);
    }

    public GsonSpeaker() {
        this.gson = new Gson();
    }

    @Override // io.victoralbertos.jolyglot.Jolyglot
    public <T> T fromJson(File file, Class<T> cls) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    T t2 = (T) this.gson.fromJson((Reader) bufferedReader2, (Class) cls);
                    bufferedReader2.close();
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                    return t2;
                } catch (IOException e2) {
                    e = e2;
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // io.victoralbertos.jolyglot.JolyglotGenerics
    public <T> T fromJson(File file, Type type) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    T t2 = (T) this.gson.fromJson(bufferedReader2, type);
                    bufferedReader2.close();
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                    return t2;
                } catch (IOException e2) {
                    e = e2;
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
