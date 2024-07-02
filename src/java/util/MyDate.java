/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author hvurq
 */
public class MyDate {
    public long longDate;
    Date myDate = new Date();

    public MyDate() {
        this.longDate = this.myDate.getTime();
    }
    public MyDate(Timestamp timestamp){
        this.longDate = timestamp.getTime();
    }

    public Timestamp parse(){
        return new Timestamp(this.longDate);//accepts a long value which can be taken from Date
    }
    
}
