package com.fineex.printer;

import android.os.Parcelable;

/**
 * @Author： Chen
 * @Date： 2020/7/6
 * @Desc：
 */
public interface Printer extends Parcelable {
    void print(FineExPrinter printer);
}
