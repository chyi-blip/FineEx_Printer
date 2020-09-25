package com.fineex.printer;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;


import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;



/**
 * @author： Chen
 * Date： 2020/7/6
 * Desc：
 */
public abstract class PrinterService extends Service {
    public static final String PRINT_INFO = "PRINT_INFO";
    private String CHANNEL_ONE_ID = "1001";
    private CharSequence CHANNEL_ONE_NAME = "WMS";
    private CopyOnWriteArraySet<Printer> printInfoQueue = new CopyOnWriteArraySet<>();
    private boolean isEnd;
    private Thread thread;

    private Handler handler = new Handler(getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            toast("打印失败提示：" + msg.obj.toString());
            stopSelf();
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        init();

        Notification.Builder builder = new Notification.Builder(this.getApplicationContext())
                .setSmallIcon(getSmallIcon()) // 设置状态栏内的小图标
                .setContentTitle(getContentTitle())
                .setContentText("打印服务已启动") // 设置上下文内容
                .setWhen(System.currentTimeMillis()); // 设置该通知发生的时间

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            //修改安卓8.1以上系统报错
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ONE_ID, CHANNEL_ONE_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(false);//如果使用中的设备支持通知灯，则说明此通知通道是否应显示灯
            notificationChannel.setShowBadge(false);//是否显示角标
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_SECRET);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(notificationChannel);
            builder.setChannelId(CHANNEL_ONE_ID);
        }


        Notification notification = builder.build(); // 获取构建好的Notification
        notification.defaults = Notification.DEFAULT_SOUND; //设置为默认的声音
        startForeground(1, notification);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isEnd) {
                    try {
                        Log.d("FineEx", "打印服务工作中。。。");
                        if (printInfoQueue.isEmpty()) {
                            Thread.sleep(1000);
                            continue;
                        }
                        Printer printer = printInfoQueue.iterator().next();
                        FineExPrinter fineExPrinter = FineExPrinter.getInstance(getDeviceMAC());
                        if (BluetoothAdapter.getDefaultAdapter().isDiscovering())
                            BluetoothAdapter.getDefaultAdapter().cancelDiscovery();

                        fineExPrinter.close();
                        if (!fineExPrinter.open(FineExPrinter.PRINTER_TYPE.ULT113x)) {
                            error("打印机打开失败", printer);
                            break;
                        }

                        if (!fineExPrinter.wakeUp()) {
                            error("打印机唤醒失败", printer);
                            break;
                        }
                        if (fineExPrinter.getPortState() != Port.PORT_STATE.PORT_OPEND) {
                            error("蓝牙错误", printer);
                            break;
                        }
                        boolean printerState = fineExPrinter.getPrinterState(3000);
                        if (!printerState) {
                            error("获取打印机状态失败", printer);
                            break;
                        }
                        if (fineExPrinter.printerInfo.isCoverOpen) {
                            error("打印机纸仓盖未关闭", printer);
                            break;
                        }
                        if (fineExPrinter.printerInfo.isNoPaper) {
                            error("打印机缺纸", printer);
                            break;
                        }
                        printer.print(fineExPrinter);
                        while (true) {
                            Log.d("FineEx", "打印中。。。");
                            Thread.sleep(100);
                            //此处的读超时需要算上打印内容的时间。请根据打印内容调整,如果你打印的内容更多，就需要设置更多的时间。
                            if (!fineExPrinter.getPrinterState(3000)) {
                                Thread.sleep(100);
                                continue;
                            }
                            if (fineExPrinter.printerInfo.isPrinting) {
                                Thread.sleep(100);
                            } else {
                                printInfoQueue.remove(printer);
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        error("打印异常错误", printInfoQueue.iterator().next());
                        break;
                    }
                }
            }
        });
        thread.start();
    }

    /**
     * 初始化操作
     */
    protected abstract void init();

    protected abstract int getSmallIcon();

    protected abstract String getContentTitle();

    protected abstract String getDeviceMAC();

    protected abstract void toast(String msg);

    protected void error(String msg, Printer printer) {
        printInfoQueue.remove(printer);
        Message message = new Message();
        message.obj = msg;
        handler.sendMessage(message);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            ArrayList<Printer> printerInfoList = intent.getParcelableArrayListExtra(PRINT_INFO);
            printInfoQueue.addAll(printerInfoList);
            toast("加入打印队列成功，请稍后");
        }
        return START_NOT_STICKY;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        isEnd = true;
        stopForeground(true);// 停止前台服务--参数：表示是否移除之前的通知
        handler = null;
    }
}
