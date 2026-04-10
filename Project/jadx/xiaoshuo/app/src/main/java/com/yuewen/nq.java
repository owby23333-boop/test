package com.yuewen;

import androidx.room.TypeConverter;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class nq {

    public class a extends TypeToken<List<String>> {
        public a() {
        }
    }

    @TypeConverter
    public List<String> a(String tags) {
        return (List) sb1.d(tags, new a().getType());
    }

    @TypeConverter
    public String b(List<String> tags) {
        return sb1.g(tags);
    }
}
