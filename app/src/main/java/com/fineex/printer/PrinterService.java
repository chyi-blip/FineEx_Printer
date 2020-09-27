package com.fineex.printer;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * @author： Chen
 * create： 2020/9/27
 * description：
 */
public class PrinterService extends BasePrinterService {

    @Override
    protected void init() {
        handler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                toast("打印失败提示：" + msg.obj.toString());
                stopSelf();
            }
        };
    }

    @Override
    protected int getSmallIcon() {
        return R.mipmap.ic_launcher_round;
    }

    @Override
    protected String getContentTitle() {
        return "打印服务";
    }

    @Override
    protected String getDeviceMAC() {
        return "DC:0D:30:90:28:65";
    }

    @Override
    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public static void startPrintService(Context context, ArrayList<Printer> printInfoEntities) {
        Intent intent = new Intent();
        intent.setClass(context, PrinterService.class);
        intent.putExtra(PRINT_INFO, printInfoEntities);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //android8.0以上通过startForegroundService启动service
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
