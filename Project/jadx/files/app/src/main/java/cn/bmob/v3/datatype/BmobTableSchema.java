package cn.bmob.v3.datatype;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BmobTableSchema implements Serializable {
    private static final long serialVersionUID = 1;
    private String className;
    private Map<String, Map<String, Object>> fields;

    public BmobTableSchema() {
    }

    public String getClassName() {
        return this.className;
    }

    public Map<String, Map<String, Object>> getFields() {
        return Collections.unmodifiableMap(this.fields);
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setFields(Map<String, Map<String, Object>> map) {
        this.fields = map;
    }

    public BmobTableSchema(String str, Map<String, Map<String, Object>> map) {
        this.className = str;
        this.fields = map;
    }
}
