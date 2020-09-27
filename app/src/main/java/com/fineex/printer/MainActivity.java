package com.fineex.printer;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fineex.printer.bean.InMarkPrintBean;
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
        printList.add(new InMarkPrintBean(getResources()));

        PrinterService.startPrintService(this, printList);
    }

    public void boxCommonMark(View view) {
        printList.clear();
        MarkPrintBean bean = new MarkPrintBean(getResources());
        bean.setTemplateType("9801");
        printList.add(bean);

        PrinterService.startPrintService(this, printList);
    }

    public void boxXBLMark(View view) {
        printList.clear();
        MarkPrintBean bean = new MarkPrintBean(getResources());
        bean.setTemplateType("9802");
        printList.add(bean);

        PrinterService.startPrintService(this, printList);
    }

    public void preTrayMark(View view) {
        printList.clear();
        printList.add(new PreTrayBean());

        PrinterService.startPrintService(this, printList);
    }
}