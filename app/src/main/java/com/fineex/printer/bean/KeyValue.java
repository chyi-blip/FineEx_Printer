package com.fineex.printer.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author： Chen
 * @Date： 2020/7/20
 * @Desc：
 */
public class KeyValue implements Parcelable {

    /**
     * "Key": "入库单号",
     * "Value": "RCG456789515454545"
     */
    private String Key;
    private String Value;

    public KeyValue(String key, String value) {
        Key = key;
        Value = value;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Key);
        dest.writeString(this.Value);
    }

    public KeyValue() {
    }

    protected KeyValue(Parcel in) {
        this.Key = in.readString();
        this.Value = in.readString();
    }

    public static final Parcelable.Creator<KeyValue> CREATOR = new Parcelable.Creator<KeyValue>() {
        @Override
        public KeyValue createFromParcel(Parcel source) {
            return new KeyValue(source);
        }

        @Override
        public KeyValue[] newArray(int size) {
            return new KeyValue[size];
        }
    };
}
