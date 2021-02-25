package com.fineex.printer.bean;

import android.os.Parcel;
import android.text.TextUtils;

import com.fineex.printer.FineExPrinter;
import com.fineex.printer.Printer;
import com.fineex.printer.jpl.Barcode;
import com.fineex.printer.jpl.JPL;
import com.fineex.printer.jpl.Page;
import com.fineex.printer.jpl.Text;

/**
 * @Author： Chen
 * @Date： 2020/8/20
 * @Desc：
 */
public class PreTrayBean implements Printer {

    /**
     * CommodityUnitCode : 7867887
     * TrayCode : 1232
     * WarehouseName : 测试仓库
     * MemberName : 测试会员
     * Amount : 1232
     * CommodityUnitDetail : A*1|B*2
     * PrintUser : 四火
     * PrintDate : 2020-01-01 12:00
     */

    private String CommodityUnitCode = "CP1234567891234-2";
    private String TrayCode = "YBTP123456789";
    private String WarehouseName = "测试仓库";
    private String MemberName = "测试会员";
    private String Amount = "9999";
    private String CommodityUnitDetail = " A*1|B*2";
    private String PrintUser = "名字长度";
    private String PrintDate = "2020-01-01 12:00";

    public String getCommodityUnitCode() {
        if (TextUtils.isEmpty(CommodityUnitCode)) return "";
        return CommodityUnitCode;
    }


    public String getTrayCode() {
        if (TextUtils.isEmpty(TrayCode)) return "";
        return TrayCode;
    }


    public String getWarehouseName() {
        if (TextUtils.isEmpty(WarehouseName)) return "";
        return WarehouseName;
    }


    public String getMemberName() {
        if (TextUtils.isEmpty(MemberName)) return "";
        return MemberName;
    }


    public String getAmount() {
        if (TextUtils.isEmpty(Amount)) return "";
        return Amount;
    }


    public String getCommodityUnitDetail() {
        if (TextUtils.isEmpty(CommodityUnitDetail)) return "";
        return CommodityUnitDetail;
    }


    public String getPrintUser() {
        if (TextUtils.isEmpty(PrintUser)) return "";
        return PrintUser;
    }


    public String getPrintDate() {
        if (TextUtils.isEmpty(PrintDate)) return "";
        return PrintDate;
    }


    @Override
    public void print(FineExPrinter printer) {
        int fontSize = 22;
        int fontHeight = 36;
        int PRINT_WIDTH = 570;
        int PRINT_HEIGHT = 380;

        printer.jpl.page.start(0, 0, PRINT_WIDTH, PRINT_HEIGHT, Page.PAGE_ROTATE.x0);

        //托盘号及其条码
        printer.jpl.text.drawOut(FineExPrinter.ALIGN.CENTER, 0, getTrayCode(), 44, true, false, false, false, Text.TEXT_ENLARGE.x1, Text.TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);
        printer.jpl.barcode.code128(FineExPrinter.ALIGN.CENTER, 54, 50, Barcode.BAR_UNIT.x2, Barcode.BAR_ROTATE.ANGLE_0, getTrayCode());

        printer.jpl.text.drawOut(6, textStartY(120, 40, 1), "成品号：" + getCommodityUnitCode(), 30);
        printer.jpl.text.drawOut(410, textStartY(132, fontHeight, 1), "数量：", fontSize);
        printer.jpl.text.drawOut(480, textStartY(120, 50, 1), getAmount(), 40, true);

        String detail = "明细：" + getCommodityUnitDetail();
        int length = detail.length();
        if (length <= 46) {
            printer.jpl.text.drawOut(6, textStartY(170, fontHeight, 1), detail.substring(0, length), fontSize);
        } else if (length <= 92) {
            printer.jpl.text.drawOut(6, textStartY(170, fontHeight, 1), detail.substring(0, 46), fontSize);
            printer.jpl.text.drawOut(6, textStartY(170, fontHeight, 2), detail.substring(46, length), fontSize);
        } else {
            printer.jpl.text.drawOut(6, textStartY(170, fontHeight, 1), detail.substring(0, 46), fontSize);
            printer.jpl.text.drawOut(6, textStartY(170, fontHeight, 2), detail.substring(46, 90) + "...", fontSize);
        }

        printer.jpl.text.drawOut(6, textStartY(240, fontHeight, 1), "仓库：" + getWarehouseName(), fontSize);
        printer.jpl.text.drawOut(6, textStartY(240, fontHeight, 2), "会员：" + getMemberName(), fontSize);
        printer.jpl.text.drawOut(6, textStartY(240, fontHeight, 3), "打印人：" + getPrintUser(), fontSize);
        printer.jpl.text.drawOut(PRINT_WIDTH / 3 + 30, textStartY(240, fontHeight, 3), "打印时间：" + getPrintDate(), fontSize);

        printer.jpl.page.end();
        printer.jpl.page.print();
        printer.jpl.feedMarkOrGap(0);//printer.jpl.feedNextLabelEnd(48);
    }

    private int textStartY(int startY, int fontHeight, int line) {
        if (startY < 0)
            return 0;
        if (fontHeight < 0)
            return 0;
        if (line < 1)
            return 0;
        return startY + fontHeight * (line - 1);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.CommodityUnitCode);
        dest.writeString(this.TrayCode);
        dest.writeString(this.WarehouseName);
        dest.writeString(this.MemberName);
        dest.writeString(this.Amount);
        dest.writeString(this.CommodityUnitDetail);
        dest.writeString(this.PrintUser);
        dest.writeString(this.PrintDate);
    }

    public PreTrayBean() {
    }

    protected PreTrayBean(Parcel in) {
        this.CommodityUnitCode = in.readString();
        this.TrayCode = in.readString();
        this.WarehouseName = in.readString();
        this.MemberName = in.readString();
        this.Amount = in.readString();
        this.CommodityUnitDetail = in.readString();
        this.PrintUser = in.readString();
        this.PrintDate = in.readString();
    }

    public static final Creator<PreTrayBean> CREATOR = new Creator<PreTrayBean>() {
        @Override
        public PreTrayBean createFromParcel(Parcel source) {
            return new PreTrayBean(source);
        }

        @Override
        public PreTrayBean[] newArray(int size) {
            return new PreTrayBean[size];
        }
    };
}
