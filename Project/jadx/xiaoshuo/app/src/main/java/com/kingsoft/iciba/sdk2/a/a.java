package com.kingsoft.iciba.sdk2.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kingsoft.iciba.sdk2.Ca;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class a {
    private static final String g = "a";
    private c N;
    protected Context h;

    public a(Context context) {
        this.h = context;
    }

    private static String b(String str, String str2) {
        String string = null;
        try {
            JSONObject jSONObject = new JSONObject();
            StringTokenizer stringTokenizer = new StringTokenizer(str2, SignatureUtils.DELIMITER);
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject2 = null;
            JSONObject jSONObject3 = null;
            while (stringTokenizer.hasMoreTokens()) {
                try {
                    String strNextToken = stringTokenizer.nextToken();
                    int i = 0;
                    char cCharAt = strNextToken.charAt(0);
                    if (cCharAt == '%') {
                        if (jSONObject2 != null && jSONArray2.length() > 0) {
                            jSONObject2.put("parts", jSONArray2);
                        }
                        jSONArray2 = new JSONArray();
                        jSONObject2 = new JSONObject();
                        jSONArray.put(jSONObject2);
                        String[] strArrSplit = strNextToken.substring(1).split("\\|");
                        if (strArrSplit.length == 3) {
                            jSONObject2.put("ph_en", strArrSplit[0]);
                            jSONObject2.put("ph_am", strArrSplit[1]);
                            jSONObject2.put("ph_other", strArrSplit[2]);
                        } else if (strArrSplit.length == 2) {
                            jSONObject2.put("ph_en", strArrSplit[0]);
                            jSONObject2.put("ph_am", strArrSplit[1]);
                        } else if (strArrSplit.length == 1) {
                            if (str.equals("汉英词典") || str.equals("汉英词典增强版")) {
                                jSONObject2.put("word_symbol", strArrSplit[0]);
                            } else {
                                jSONObject2.put("ph_en", strArrSplit[0]);
                            }
                        }
                        jSONObject3 = null;
                    } else if (cCharAt == '+') {
                        jSONObject.put("translate_type", 1);
                    } else if (cCharAt == ':') {
                        JSONObject jSONObject4 = new JSONObject();
                        String[] strArrSplit2 = strNextToken.substring(1).split("\\|");
                        if (strArrSplit2.length <= Ca.e.length) {
                            while (i < strArrSplit2.length) {
                                if (!TextUtils.isEmpty(strArrSplit2[i])) {
                                    JSONArray jSONArray3 = new JSONArray();
                                    jSONArray3.put(strArrSplit2[i]);
                                    jSONObject4.put(Ca.e[i], jSONArray3);
                                }
                                i++;
                            }
                            if (jSONObject4.length() > 0) {
                                jSONObject.put("exchange", jSONObject4);
                            }
                        }
                    } else if (cCharAt == '\\') {
                        if (jSONObject3 == null) {
                            jSONObject3 = new JSONObject();
                            jSONArray2.put(jSONObject3);
                            jSONObject3.put("part", "");
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        String[] strArrSplit3 = strNextToken.substring(1).split(";");
                        int length = strArrSplit3.length;
                        while (i < length) {
                            jSONArray4.put(strArrSplit3[i]);
                            i++;
                        }
                        jSONObject3.put("means", jSONArray4);
                    } else if (cCharAt == '^') {
                        jSONObject3 = new JSONObject();
                        jSONArray2.put(jSONObject3);
                        jSONObject3.put("part", com.kingsoft.iciba.sdk2.d.j(strNextToken.substring(1)));
                    }
                } catch (Exception e) {
                    Log.e(g, "Create json failed", e);
                    return null;
                }
            }
            if (jSONObject2 != null && jSONArray2.length() > 0) {
                jSONObject2.put("parts", jSONArray2);
            } else if (jSONArray2.length() > 0) {
                JSONObject jSONObject5 = new JSONObject();
                jSONArray.put(jSONObject5);
                jSONObject5.put("parts", jSONArray2);
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("symbols", jSONArray);
            }
            string = jSONObject.toString();
            return string;
        } catch (Exception e2) {
            Log.e(g, "Create json failed", e2);
            return string;
        }
    }

    private static String n(String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray3 = new JSONArray();
            StringTokenizer stringTokenizer = new StringTokenizer(str, SignatureUtils.DELIMITER);
            int iIntValue = 0;
            while (stringTokenizer.hasMoreTokens()) {
                try {
                    String strNextToken = stringTokenizer.nextToken();
                    char cCharAt = strNextToken.charAt(0);
                    if (cCharAt == '!') {
                        jSONObject3.put("usage", strNextToken.substring(1));
                    } else if (cCharAt != '#') {
                        if (cCharAt != '*') {
                            if (cCharAt != '<') {
                                if (cCharAt != '\\') {
                                    if (cCharAt == '^') {
                                        jSONObject2.put("type", strNextToken.substring(1));
                                        jSONObject2.put("spells", jSONArray2);
                                        iIntValue = Integer.valueOf(strNextToken.substring(1)).intValue();
                                    } else if (cCharAt != '|') {
                                        if (cCharAt != '%') {
                                            if (cCharAt == '&') {
                                                if (jSONArray3.length() > 0) {
                                                    jSONObject3.put("means", jSONArray3);
                                                }
                                                jSONArray = new JSONArray();
                                                jSONObject = new JSONObject();
                                                jSONArray2.put(jSONObject);
                                                jSONObject.put("spell", strNextToken.substring(1));
                                                JSONObject jSONObject4 = jSONObject;
                                                jSONArray3 = jSONArray;
                                                jSONObject3 = jSONObject4;
                                            }
                                        } else if (iIntValue == 1) {
                                            jSONObject2.put("radical", strNextToken.substring(1));
                                        } else if (iIntValue == 2) {
                                            jSONObject2.put("compose", strNextToken.substring(1));
                                        } else if (iIntValue == 3) {
                                            if (jSONArray3.length() > 0) {
                                                jSONObject3.put("means", jSONArray3);
                                            }
                                            jSONArray = new JSONArray();
                                            jSONObject = new JSONObject();
                                            jSONArray2.put(jSONObject);
                                            jSONObject.put("spell", strNextToken.substring(1));
                                            JSONObject jSONObject42 = jSONObject;
                                            jSONArray3 = jSONArray;
                                            jSONObject3 = jSONObject42;
                                        }
                                    } else if (iIntValue == 1) {
                                        JSONArray jSONArray4 = new JSONArray();
                                        for (String str2 : strNextToken.substring(1).split(",")) {
                                            jSONArray4.put(str2);
                                        }
                                        jSONObject3.put("words", jSONArray4);
                                    } else if (iIntValue == 3) {
                                        jSONObject3.put("antonym", strNextToken.substring(1));
                                    }
                                } else if (iIntValue == 1) {
                                    jSONObject2.put("wubi", strNextToken.substring(1));
                                } else if (iIntValue == 2) {
                                    jSONArray3.put(strNextToken.substring(1));
                                } else if (iIntValue == 3) {
                                    jSONObject3.put("phrase", strNextToken.substring(1));
                                }
                            } else if (iIntValue == 1) {
                                jSONArray3.put(strNextToken.substring(1));
                            } else if (iIntValue == 3) {
                                jSONObject3.put("sentences", strNextToken.substring(1));
                            }
                        } else if (iIntValue == 1) {
                            jSONObject2.put("structure", strNextToken.substring(1));
                        } else if (iIntValue == 3) {
                            jSONObject3.put("synonym", strNextToken.substring(1));
                        }
                    } else if (iIntValue == 1) {
                        jSONObject2.put("strokes", strNextToken.substring(1));
                    } else if (iIntValue == 2) {
                        jSONObject2.put("word", strNextToken.substring(1));
                    } else if (iIntValue == 3) {
                        jSONArray3.put(strNextToken.substring(1));
                    }
                } catch (Exception e) {
                    Log.e(g, "Create json failed", e);
                    return null;
                }
            }
            if (jSONArray3.length() > 0) {
                jSONObject3.put("means", jSONArray3);
            }
            return jSONObject2.toString();
        } catch (Exception e2) {
            Log.e(g, "Create json failed", e2);
            return null;
        }
    }

    public final void a(c cVar) {
        this.N = cVar;
    }

    public final int k(String str) {
        return a(this.N.U, str);
    }

    public final String l(String str) {
        String strM;
        String lowerCase = str.toLowerCase();
        if (this.N.d(a(this.N.ad, lowerCase)) >= 0 && (strM = m(lowerCase)) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM, SignatureUtils.DELIMITER);
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.charAt(0) == '&') {
                    String[] strArrSplit = strNextToken.substring(1).split(",");
                    if (1 != strArrSplit.length) {
                        if (Pattern.compile("[A-Z]+").matcher(strArrSplit[strArrSplit.length - 1]).find(0)) {
                            for (String str2 : strArrSplit) {
                                if (str2.equals(str)) {
                                    return str;
                                }
                            }
                        } else {
                            lowerCase = strArrSplit[strArrSplit.length - 1];
                        }
                    }
                    lowerCase = strArrSplit[0];
                }
            }
        }
        return lowerCase;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0031 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:0: B:6:0x0013->B:45:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m(java.lang.String r10) {
        /*
            r9 = this;
            com.kingsoft.iciba.sdk2.a.c r0 = r9.N
            boolean r0 = r0.h()
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            com.kingsoft.iciba.sdk2.a.c r0 = r9.N
            java.lang.String[] r0 = r0.W
            int r2 = r0.length
            r3 = 1
            int r2 = r2 - r3
            r4 = 0
            r5 = r4
        L13:
            int r6 = r5 + r2
            int r6 = r6 / 2
            r7 = r0[r6]
            int r7 = r10.compareTo(r7)
            r8 = -1
            if (r7 >= 0) goto L26
            if (r6 != r5) goto L24
        L22:
            r6 = r8
            goto L39
        L24:
            r2 = r6
            goto L2d
        L26:
            if (r7 > 0) goto L29
            goto L39
        L29:
            if (r6 != r2) goto L2c
            goto L22
        L2c:
            r5 = r6
        L2d:
            int r6 = r6 + 1
            if (r6 != r2) goto L13
            r0 = r0[r6]
            int r10 = r10.compareTo(r0)
            if (r10 != 0) goto L22
        L39:
            com.kingsoft.iciba.sdk2.a.c r10 = r9.N
            r10.Z = r6
            if (r6 >= 0) goto L40
            return r1
        L40:
            java.lang.Integer[] r0 = r10.X
            if (r0 == 0) goto L8e
            char[] r10 = r10.Y
            if (r10 == 0) goto L8e
            r10 = r0[r6]
            int r10 = r10.intValue()
            int r10 = r10 / 2
            com.kingsoft.iciba.sdk2.a.c r0 = r9.N
            java.lang.Integer[] r0 = r0.X
            int r1 = r0.length
            int r6 = r6 + r3
            if (r1 <= r6) goto L61
            r0 = r0[r6]
            int r0 = r0.intValue()
            int r0 = r0 / 2
            goto L76
        L61:
            r0 = r10
        L62:
            int r1 = r10 + r3
            com.kingsoft.iciba.sdk2.a.c r2 = r9.N
            char[] r2 = r2.Y
            int r5 = r2.length
            if (r1 >= r5) goto L76
            char r1 = r2[r1]
            r2 = 43
            if (r1 == r2) goto L76
            int r0 = r0 + 1
            int r3 = r3 + 1
            goto L62
        L76:
            int r0 = r0 - r10
            char[] r1 = new char[r0]
        L79:
            if (r4 >= r0) goto L88
            com.kingsoft.iciba.sdk2.a.c r2 = r9.N
            char[] r2 = r2.Y
            int r3 = r10 + r4
            char r2 = r2[r3]
            r1[r4] = r2
            int r4 = r4 + 1
            goto L79
        L88:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r1)
            r1 = r10
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingsoft.iciba.sdk2.a.a.m(java.lang.String):java.lang.String");
    }

    private static int a(String[] strArr, String str) {
        int length = strArr.length - 1;
        int i = 0;
        if (strArr.length <= 5) {
            int i2 = 0;
            while (i2 < strArr.length) {
                int iCompareTo = str.compareTo(strArr[i2]);
                if (iCompareTo == 0) {
                    return i2;
                }
                if (iCompareTo < 0) {
                    break;
                }
                i2++;
            }
            if (i2 > 0) {
                return i2 - 1;
            }
            return 0;
        }
        loop0: while (true) {
            int i3 = i;
            while (i != strArr.length - 2) {
                i = (i3 + length) / 2;
                int iCompareTo2 = str.compareTo(strArr[i]);
                int iCompareTo3 = str.compareTo(strArr[i + 1]);
                if (iCompareTo2 == 0 || (iCompareTo2 > 0 && iCompareTo3 < 0)) {
                    break loop0;
                }
                if (iCompareTo2 < 0) {
                    if (i == 0) {
                        break loop0;
                    }
                    length = i;
                } else if (iCompareTo2 > 0) {
                    break;
                }
            }
            return strArr.length - 1;
        }
        return i;
    }

    public final String a(String str, String str2) {
        byte[] bytes = str.getBytes();
        if (bytes.length > 3 && bytes[0] == -17 && bytes[1] == -69 && bytes[2] == -65) {
            str = new String(bytes, 3, bytes.length - 3);
        }
        if (!str.equals("英汉词典") && !str.equals("汉英词典") && !str.equals("英汉词典增强版") && !str.equals("汉英词典增强版")) {
            if (str.equals("汉汉词典")) {
                return n(str2);
            }
            return null;
        }
        return b(str, str2);
    }
}
