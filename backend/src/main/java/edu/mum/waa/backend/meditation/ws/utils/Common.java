package edu.mum.waa.backend.meditation.ws.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Common {
    public static Integer  calcWeekDays(final LocalDate start, final LocalDate end) {
        final DayOfWeek startW = start.getDayOfWeek();
        final DayOfWeek endW = end.getDayOfWeek();
        final long days = DAYS.between(start, end) + 1;
        final long daysWithoutSunday = days - ((days + startW.getValue())/7);

        //adjust for starting and ending on a Sunday:
        return (int) daysWithoutSunday + (startW == DayOfWeek.SUNDAY ? 1 : 0) + (endW == DayOfWeek.SUNDAY ? 1 : 0);
    }

    public static Double calcExtraPoint(Double percentage){
        Double extra = 0.0;
        if(percentage >= 70.0 && percentage<80.0){
            extra = 0.5;
        }
        else if (percentage >=80.0 && percentage<90.0){
            extra = 1.0;
        }
        else if(percentage >=90.0){
            extra = 1.5;
        }
        return extra;
    }
    public static Double calcAttendancePercentage(Integer attended, Integer required){
        System.out.println("attendence: "+attended+" required: "+required);
           Double percent = 0.0;
           if (attended != null && required!= null)
               return ((double) attended/ required)*100.0;
           return  percent;

    }

//
//    public static List<LocalDate> getAllDateOfBlock(BlockEntity blockEntity) {
//        LocalDate start =blockEntity.getStartDate();
//        LocalDate end = blockEntity.getEndDate();
//        List<LocalDate> totalDates = new ArrayList<>();
//        while (!start.isAfter(end)) {
//            if (start.getDayOfWeek() != DayOfWeek.SUNDAY) {
//                totalDates.add(start);
//            }
//                start = start.plusDays(1);
//        }
//        return totalDates;
//    }
}
