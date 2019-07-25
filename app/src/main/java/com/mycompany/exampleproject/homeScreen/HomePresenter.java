package com.mycompany.exampleproject.homeScreen;

import android.support.annotation.NonNull;
import android.util.Log;

import com.mycompany.exampleproject.FlightModel;
import com.mycompany.exampleproject.FlightViewModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

interface HomePresenterInput {
    void presentHomeMetaData(HomeResponse response);
}

public class HomePresenter implements HomePresenterInput {

    public static String TAG = HomePresenter.class.getSimpleName();

    public WeakReference<HomeActivityInput> output;
    private Calendar currentTime;


    public Calendar getCurrentTime() {
        if(currentTime == null) return Calendar.getInstance();
        return currentTime;
    }



    public void setCurrentTime(Calendar currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public void presentHomeMetaData(HomeResponse response) {
        // Log.e(TAG, "presentHomeMetaData() called with: response = [" + response + "]");
        //Do your decoration or filtering here
        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.listOfFlights = new ArrayList<>();


        if (response.listOfFlights != null) {

            for (FlightModel fm : response.listOfFlights) {
                FlightViewModel fvm = new FlightViewModel();

                fvm.departureCity = fm.departureCity;
                fvm.arrivalCity = fm.arrivalCity;
                fvm.flightName = fm.flightName;
                fvm.startingTime = fm.startingTime;
                fvm.departureTime = fm.departureTime;
                fvm.arrivalTime = fm.arrivalTime;
                //Decoration
                Calendar startingTime = getCalendar(fvm.startingTime);
                long daysDiff = getDaysDiff(getCurrentTime().getTimeInMillis(),startingTime.getTimeInMillis());
                setDaysFlyDecorationText(fvm, daysDiff,getCurrentTime().getTimeInMillis(),startingTime.getTimeInMillis());

                homeViewModel.listOfFlights.add(fvm);
            }


            output.get().displayHomeMetaData(homeViewModel);
        }
    }

    private void setDaysFlyDecorationText(FlightViewModel fvm, long daysDiff,long startTime,long endTime) {
        if(endTime > startTime){
            fvm.noOfDaysToFly = "You have " + daysDiff + " days to fly";
        } else {
            //daysDiff =-daysDiff;
            fvm.noOfDaysToFly = "It has been " + daysDiff + " days since you flew";
        }
    }

    @NonNull
    private Calendar getCalendar(String date) {
        //Date should be in the format YYYY/MM/DD if not return
        if (date != null && !date.isEmpty() && date.length() == 10 ) {
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));
            Calendar startingTime = Calendar.getInstance();
            startingTime.set(year, month - 1, day, 0, 0, 0);
            return startingTime;
        }
        return null;
    }

    private long getDaysDiff(long startTime,long endTime) {
        long msDiff;
        if (endTime > startTime) {
             msDiff = endTime - startTime;
        } else {
             msDiff = startTime - endTime;
        }
        long daysDiff = TimeUnit.MILLISECONDS.toDays(msDiff);
        Log.e(TAG,"diff is  "+ daysDiff);
        return daysDiff;
    }
}
