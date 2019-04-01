package com.unionpay.account.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by david on 17/2/15.
 *
 * @see http://www.cnblogs.com/relucent/p/4955340.html
 */
public class IdWorker {

    private final long twepoch = 1288834974657L;
    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private final long sequenceBits = 12L;
    private final long workerIdShift = sequenceBits;
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public IdWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    static AtomicLong index = new AtomicLong(1);

    public static String genSeriaL20(String s_machine_index)
    {
        String now_yyMMddHHmm = formatDate2Str(new Date(), "yyMMddHHmm");
        try
        {
            s_machine_index = leftPadding(s_machine_index, 3);
        }
        catch (Exception e)
        {
            s_machine_index = "001";
        }

        Long currentValue = index.getAndIncrement();
        if (currentValue > 9999999)
        {
            index.set(1);
            currentValue = index.getAndIncrement();
        }
        String curIndexStr = leftPadding(String.valueOf(currentValue), 7);
        return now_yyMMddHHmm + s_machine_index + curIndexStr;
    }

    /**
     * 生成16位 user_id
     * @return
     */
    public static String genUserId(){
        return  genSeriaL16("02");
    }

    public static String genSeriaL16(String s_machine_index)
    {
        String now_yyMMddHHmm = formatDate2Str(new Date(), "yyMMddHHmmSSS");
        try
        {
            s_machine_index = leftPadding(s_machine_index, 2);
        }
        catch (Exception e)
        {
            s_machine_index = "01";
        }

        Long currentValue = index.getAndIncrement();
        if (currentValue > 9999)
        {
            index.set(1);
            currentValue = index.getAndIncrement();
        }
        String curIndexStr = leftPadding(String.valueOf(currentValue), 4);
        return now_yyMMddHHmm + s_machine_index + curIndexStr;
    }

    public static String leftPadding(String str, int toLength)
    {
        int length = str.length();
        if (length < toLength)
        {
            for (int i = 0; i < toLength - length; i++)
            {
                str = "0" + str;
            }
        }
        return str;
    }
    public static  String formatDate2Str(Date sDate,String format)
    {
        if (sDate == null) return null;
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(sDate);


    }


    public static void main(String[] args) 
    {
    	long startTime = System.currentTimeMillis();
        for (int i = 0 ; i < 10000;  i++)
        {
            System.out.println(genSeriaL16("96"));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时==" + (endTime-startTime) + " 毫秒");
//        IdWorker idWorker = new IdWorker(0, 0);
//        for (int i = 0; i < 1000; i++) {
//            long id = idWorker.nextId();
//            System.out.println(         UUID.randomUUID().toString());
//       //     System.out.println(id);
//        }
    }
}
