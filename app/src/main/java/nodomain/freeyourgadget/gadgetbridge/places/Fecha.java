package nodomain.freeyourgadget.gadgetbridge.places;

import java.util.Date;
import java.util.GregorianCalendar;

import java.util.Calendar;
import java.util.Date;

public class Fecha {

    String nameDayOfweek;
    String Month;
    Calendar c;
    int dayOfMonth,year;
    int hora,minuto,segundo;
    public Fecha() {
        c = Calendar.getInstance();
        dayOfMonth=c.get(Calendar.DAY_OF_MONTH);
        year= c.get(Calendar.YEAR);
        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                nameDayOfweek="Domingo";
                break;
            case 2:
                nameDayOfweek="Lunes";
                break;
            case 3:
                nameDayOfweek="Martes";
                break;
            case 4:
                nameDayOfweek="Miercoles";
                break;
            case 5:
                nameDayOfweek="Jueves";
                break;
            case 6:
                nameDayOfweek="Viernes";
                break;
            case 7:
                nameDayOfweek="Sabado";
                break;

        }
        switch (c.get(Calendar.MONTH)){
            case 0:
                Month="Enero";
                break;
            case 1:
                Month="Febrero";
                break;
            case 2:
                Month="Marzo";
                break;
            case 3:
                Month="Abril";
                break;
            case 4:
                Month="Mayo";
                break;
            case 5:
                Month="Junio";
                break;
            case 6:
                Month="Julio";
                break;
            case 7:
                Month="Agosto";
                break;
            case 8:
                Month="Septiembre";
                break;
            case 9:
                Month="Octubre";
                break;
            case 10:
                Month="Noviembre";
                break;
            case 11:
                Month="Diciembre";
                break;
        }
    }
    public Date getDate(){
        return c.getTime();
    }
    public String getFechaString(){
        return nameDayOfweek+", "+dayOfMonth+" de "+Month+" "+year;
    }
    public String getTimeString(){
        hora=c.get(Calendar.HOUR_OF_DAY);
        minuto=c.get(Calendar.MINUTE);
        segundo=c.get(Calendar.SECOND);
        if (segundo>10){
            if (minuto>10){
                if (c.get(Calendar.AM_PM) == Calendar.PM){
                    return hora+":"+minuto+":"+segundo+" PM";}else{
                    return hora+":"+minuto+":"+segundo+" AM";
                }
            }else
            {
                if (c.get(Calendar.AM_PM) == Calendar.PM){
                    return hora+":0"+minuto+":"+segundo+" PM";}else{
                    return hora+":0"+minuto+":"+segundo+" AM";
                }
            }
        }else{
            if (minuto>10) {
                if (c.get(Calendar.AM_PM) == Calendar.PM) {
                    return hora + ":" + minuto + ":" + "0" + segundo + " PM";
                } else {
                    return hora + ":" + minuto + ":" + "0" + segundo + " AM";
                }
            } else {
                if (c.get(Calendar.AM_PM) == Calendar.PM) {
                    return hora + ":0" + minuto + ":" + "0" + segundo + " PM";
                } else {
                    return hora + ":0" + minuto + ":" + "0" + segundo + " AM";
                }
            }
        }
    }
    public String getDay(){
        return  nameDayOfweek;
    }
    public int getHora(){
        return hora;
    }
}
