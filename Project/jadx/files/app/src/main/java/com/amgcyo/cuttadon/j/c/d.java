package com.amgcyo.cuttadon.j.c;

import androidx.room.TypeConverter;
import com.amgcyo.cuttadon.api.entity.other.MkRegular;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

/* JADX INFO: compiled from: MkRegularConverter.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: compiled from: MkRegularConverter.java */
    class a extends TypeToken<ArrayList<MkRegular>> {
        a() {
        }
    }

    @TypeConverter
    public static ArrayList<MkRegular> a(String str) {
        return (ArrayList) new Gson().fromJson(str, new a().getType());
    }

    @TypeConverter
    public static String a(ArrayList<MkRegular> arrayList) {
        return new Gson().toJson(arrayList);
    }
}
