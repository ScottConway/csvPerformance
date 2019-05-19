package org.opencsv.csvperformance.domain;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import org.joda.time.DateTime;
import org.opencsv.csvperformance.util.JodaDateTimeConverter;

public class Simple10 {
    @CsvBindByName
    private String text1;
    @CsvBindByName
    private Integer num1;
    @CsvBindByName
    private Double double1;
    @CsvCustomBindByName(converter = JodaDateTimeConverter.class)
    private DateTime dateTime1;
    @CsvBindByName
    private byte byte1;
    @CsvBindByName
    private String text2;
    @CsvBindByName
    private Integer num2;
    @CsvBindByName
    private Double double2;
    @CsvCustomBindByName(converter = JodaDateTimeConverter.class)
    private DateTime dateTime2;
    @CsvBindByName
    private byte byte2;

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Double getDouble1() {
        return double1;
    }

    public void setDouble1(Double double1) {
        this.double1 = double1;
    }

    public DateTime getDateTime1() {
        return dateTime1;
    }

    public void setDateTime1(DateTime dateTime1) {
        this.dateTime1 = dateTime1;
    }

    public byte getByte1() {
        return byte1;
    }

    public void setByte1(byte byte1) {
        this.byte1 = byte1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Double getDouble2() {
        return double2;
    }

    public void setDouble2(Double double2) {
        this.double2 = double2;
    }

    public DateTime getDateTime2() {
        return dateTime2;
    }

    public void setDateTime2(DateTime dateTime2) {
        this.dateTime2 = dateTime2;
    }

    public byte getByte2() {
        return byte2;
    }

    public void setByte2(byte byte2) {
        this.byte2 = byte2;
    }

    @Override
    public String toString() {
        return "Simple10{" +
                "text1='" + text1 + '\'' +
                ", num1=" + num1 +
                ", double1=" + double1 +
                ", dateTime1=" + dateTime1 +
                ", byte1=" + byte1 +
                ", text2='" + text2 + '\'' +
                ", num2=" + num2 +
                ", double2=" + double2 +
                ", dateTime2=" + dateTime2 +
                ", byte2=" + byte2 +
                '}';
    }
}
