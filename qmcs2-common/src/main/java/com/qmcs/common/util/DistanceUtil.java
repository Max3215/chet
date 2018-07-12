package com.qmcs.common.util;

/**
 * Created by zhoudu on 2017-06-15.
 */
public class DistanceUtil {


    /**
     *
     * @param longitude0 第一点精度
     * @param latitude0  第一点纬度
     * @param longitude1 第二点精度
     * @param latitude1 第二点纬度
     * @return
     */
    public static float calculateLineDistance(final double longitude0,final double latitude0, final double longitude1,final double latitude1) {
            try {
                double var2 = 0.01745329251994329D;
                double var4 = longitude0;
                double var6 = latitude0;
                double var8 = longitude1;
                double var10 = latitude1;
                var4 *= 0.01745329251994329D;
                var6 *= 0.01745329251994329D;
                var8 *= 0.01745329251994329D;
                var10 *= 0.01745329251994329D;
                double var12 = Math.sin(var4);
                double var14 = Math.sin(var6);
                double var16 = Math.cos(var4);
                double var18 = Math.cos(var6);
                double var20 = Math.sin(var8);
                double var22 = Math.sin(var10);
                double var24 = Math.cos(var8);
                double var26 = Math.cos(var10);
                double[] var28 = new double[3];
                double[] var29 = new double[3];
                var28[0] = var18 * var16;
                var28[1] = var18 * var12;
                var28[2] = var14;
                var29[0] = var26 * var24;
                var29[1] = var26 * var20;
                var29[2] = var22;
                double var30 = Math.sqrt((var28[0] - var29[0]) * (var28[0] - var29[0]) + (var28[1] - var29[1]) * (var28[1] - var29[1]) + (var28[2] - var29[2]) * (var28[2] - var29[2]));
                return (float)(Math.asin(var30 / 2.0D) * 1.27420015798544E7D);
            } catch (Throwable var32) {
                var32.printStackTrace();
                return 0.0F;
            }
    }



//    public static void main(String[] args){
//        System.out.print(calculateLineDistance(107.76195,29.32182,120.304063,30.405831));
//    }
}
