package com.bjtu.arima.arima_algorithm;

import com.bjtu.arima.arima_web.dao.SelectData;

import java.sql.SQLException;
import java.util.ArrayList;

public class test1 {

    public static void main(String args[])
    {
        ArrayList<Integer> arraylist=new ArrayList<Integer>();
        try {
            SelectData selectData = new SelectData();
            int[] data = selectData.getOneIntData("test1",1);
            for(int i = 0;i<data.length;i++){
                arraylist.add(data[i]); }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        double[] dataArray=new double[arraylist.size()-1];
        for(int i=0;i<arraylist.size()-1;i++)
            dataArray[i]=arraylist.get(i);

        //System.out.println(arraylist.size());
        int predictPeriod = 7;
        double[] resultarray = new double[predictPeriod];
        for(int i = 0;i<predictPeriod;i++){
            ARIMA arima=new ARIMA(dataArray);
            int []model=arima.getARIMAmodel();
//				System.out.println("Best model is [p,q]="+"["+model[0]+" "+model[1]+"]");
            int result = arima.aftDeal(arima.predictValue(model[0],model[1]));
//				System.out.println("Predict value="+result);
//				System.out.println("Predict error="+(arima.aftDeal(arima.predictValue(model[0],model[1]))-arraylist.get(arraylist.size()-1))/arraylist.get(arraylist.size()-1)*100+"%");
            System.arraycopy(dataArray, 1, dataArray, 0, dataArray.length-1);
            dataArray[dataArray.length-1] = result;
            resultarray[i] = result;
        }
        for(int k =0 ;k<resultarray.length;k++)
            System.out.println(resultarray[k]+",");

        //	String[] str = (String[])list1.toArray(new String[0]);

//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			ino.close();
//		}
    }
}
