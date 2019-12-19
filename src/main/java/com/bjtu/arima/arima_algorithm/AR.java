package com.bjtu.arima.arima_algorithm;

import java.util.*;

public class AR {

    double[] originalData={};
    int p;
    ARMAMath armamath=new ARMAMath();

    /**
     * AR模型
     * @param stdoriginalData
     * @param p //p为MA模型阶数
     */
    public AR(double [] stdoriginalData,int p)
    {
        this.originalData=stdoriginalData;
        this.p=p;
    }
    /**
     * 返回AR模型参数
     * @return
     */
    public Vector<double[]> ARmodel()
    {
        Vector<double[]> v=new Vector<double[]>();
        v.add(armamath.parcorrCompute(originalData, p, 0));
        return v;//得到了自回归系数
        //还要估计方差项吗？
    }
}
