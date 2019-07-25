package com.mycompany.exampleproject.homeScreen;

import com.mycompany.exampleproject.FlightModel;
import com.mycompany.exampleproject.FlightViewModel;

import java.util.ArrayList;

/**
 * Created by mkaratadipalayam on 10/10/16.
 */

public class HomeModel {
}
class HomeViewModel{
    //TODO - filter to have only the needed data
    ArrayList<FlightViewModel> listOfFlights;
}
class HomeRequest{
    boolean isFutureTrips;
}

class HomeResponse {
    ArrayList<FlightModel> listOfFlights;
}