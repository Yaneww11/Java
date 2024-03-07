import adult_and_child.Adult;
import videos.Video;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static  Video videoWithMoreLikesStatic(Video video1, Video video2){
        if (video1.getLikes() > video2.getLikes()){
            return video1;
        }
        else {
            return video2;
        }
    }

    public static boolean isLeapYear(int year){
        return (year%4==0 && year%100!=0) || year%400==0;
    }
    public static int sum_divider(int num){
        int i = 2;
        int sum = 1;
        while (i != num/2 + 1){
            if (num % i == 0){
                sum += i;
            }
            i++;
        }
        return sum;
    }


    public static void main(String[] args) {

        final int bottom = 10_000;
        final int top = 99_999;

        int randomNumber = (int) (Math.random() * (top - bottom) + bottom);
        System.out.println("Random number between 10 000 and 99 999: " + randomNumber);
        /*
        int year = 2024;
        isLeapYear(year);

        System.out.println(sum_divider(16));

        Video.setMaxDuration(BigDecimal.TEN);
        Video video1 = new Video(0);
        System.out.println(video1);

        Video video2 = new Video("Video 2", BigDecimal.valueOf(2.5), 20, 1);
        Video video3 = new Video("Video 3", BigDecimal.valueOf(4.5), 23, 2);

        BigDecimal sum = video2.getDuration().add(video3.getDuration());
        System.out.println("sum = " + sum.toString());

        LocalDate dateUploaded = LocalDate.now();
        LocalDate dateUploaded2 = LocalDate.of(2024, 6, 5);
        System.out.println(video2.videoWithMoreLikes(video3));
        System.out.println(Main.videoWithMoreLikesStatic(video2, video3));

         */

        Adult adult = new Adult("Ivan", LocalDate.of(2001,3,4), BigDecimal.valueOf(1000), BigDecimal.ZERO, false);
        System.out.println(adult);
    }
}