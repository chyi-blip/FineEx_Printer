package com.fineex.printer;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fineex.printer.bean.InMarkPrintBean;
import com.fineex.printer.bean.KeyValue;
import com.fineex.printer.bean.MarkPrintBean;
import com.fineex.printer.bean.PreTrayBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Printer> printList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void intoMark(View view) {
        printList.clear();
        InMarkPrintBean bean = new InMarkPrintBean();
        bean.setBoxMark("XM56856545156");
        bean.setWarehouseMember("发网仓库发网会员");
        bean.setInCode("RK46854689");
        bean.setSyncId("465656464");
        bean.setCommodityName("测试商品");
        bean.setBarCode("56859874");
        ArrayList<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new KeyValue("键名键名", "54689596565"));
        keyValues.add(new KeyValue("键名键名", "54689596565"));
        keyValues.add(new KeyValue("键名键名", "54689596565"));
        keyValues.add(new KeyValue("键名键名", "54689596565"));
        keyValues.add(new KeyValue("键名键名", "54689596565"));
        keyValues.add(new KeyValue("键名键名", "54689596565"));
        bean.setMarkConfig(keyValues);
        bean.setMemberNo("56859874");
        bean.setBoxGauge("545");
        bean.setBatchCode("BH4546556564");
        bean.setShelfLife("5665");
        bean.setTentativePeriod("5656");
        bean.setCount("2");
        bean.setRemark("五百万现金");
        bean.setPrintUser("小明");
        bean.setPrintDate("2019-01-01 12:00");
        bean.setOrderDate("2019-01-01");
        printList.add(bean);

        PrinterService.startPrintService(this, printList);
    }

    public void boxCommonMark(View view) {
        printList.clear();
        MarkPrintBean bean = new MarkPrintBean();
        bean.setStoreName("T湖北武汉海林广场店");
        bean.setTemplateType("9801");
        bean.setStoreCode("456565");
        bean.setBoxNum("1");
        bean.setConsignee("小明");
        bean.setConsigneePhone("17601236985");
        bean.setConsigneeAddress("上海市宝山区呼兰路100号");
        bean.setSender("小明");
        bean.setSenderWarehouse("上海发网仓库");
        bean.setSenderPhone("17601236985");
        bean.setSenderAddress("上海市宝山区呼兰路100号");
        bean.setOrderCode("567484154655465");
        bean.setTransportCode("4554545715454");
        bean.setWeight("54");
        bean.setVolume("4");
        bean.setSKU("5");
        bean.setCount("56");
        bean.setSumBoxCount("56");
        bean.setBoxOrder("6");
        bean.setRemark("五百万现金");
        bean.setPrintUser("小明");
        bean.setPrintDate("2019-01-01 12:00");
        bean.setOrderDate("2019-01-01");
        bean.setStoreCodeName("46556564T湖北武汉海林广场店");

        printList.add(bean);

        PrinterService.startPrintService(this, printList);
    }

    public void boxXBLMark(View view) {
        printList.clear();
        MarkPrintBean bean = new MarkPrintBean();
        bean.setStoreName("T湖北武汉海林广场店");
        bean.setTemplateType("9801");
        bean.setStoreCode("456565");
        bean.setBoxNum("1");
        bean.setConsignee("小明");
        bean.setConsigneePhone("17601236985");
        bean.setConsigneeAddress("上海市宝山区呼兰路100号");
        bean.setSender("小明");
        bean.setSenderWarehouse("上海发网仓库");
        bean.setSenderPhone("17601236985");
        bean.setSenderAddress("上海市宝山区呼兰路100号");
        bean.setOrderCode("567484154655465");
        bean.setTransportCode("4554545715454");
        bean.setWeight("54");
        bean.setVolume("4");
        bean.setSKU("5");
        bean.setCount("56");
        bean.setSumBoxCount("56");
        bean.setBoxOrder("6");
        bean.setRemark("五百万现金");
        bean.setPrintUser("小明");
        bean.setPrintDate("2019-01-01 12:00");
        bean.setOrderDate("2019-01-01");
        bean.setStoreCodeName("46556564T湖北武汉海林广场店");

        printList.add(bean);
        PrinterService.startPrintService(this, printList);
    }

    public void preTrayMark(View view) {
        printList.clear();
        printList.add(new PreTrayBean());

        PrinterService.startPrintService(this, printList);
    }
}