package com.david_duncker.zoomeraid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;


//Begin SQLiteOpenHelper class

public class DataBaseHelper extends SQLiteOpenHelper
{
    private static final String TAG = "Log"; // Tag just for the LogCat window
    //destination path (location) of our database on device
    private String DB_PATH = "";
    private static final String DB_NAME ="ZoomerAid.db";// Database name
    private static final int DB_VERSION = 1;
    private SQLiteDatabase mDataBase;

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL("CREATE TABLE Addresses (StreetNumber1 int(10), StreetNumber2 int(10), odd_even varchar(10), Address varchar(20), Text1 varchar(400), Image varchar(50), Text2 varchar(400))");

        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,99999,'EVEN','GENERAL ADVICE AND GUIDELINES','Use Google satellite view to pinpoint the exact location of the house to make it easier to find. Calling the customer less than 1 minute before arrival will ensure that they come out exactly as you arrive. If the customer lives in an apartment complex, call a few minutes ahead of time and ask them to meet you in the lobby.','ic_launcher','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1500,1540,'EVEN','EASTMEDICALCENTERDRIVE','The Hospital. Its either Motts Childrens Hospital, Med Inn, or the Cardiovascular Center. Call the customer at least 5 minutes ahead of time, ask them which one, and go to the appropriate place','hospital','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,99999,'EVEN','MOTTS CHILDRENS HOSPITAL','Meet at the half-circle in front of the main lobby/employee entrance. Call ahead of time, it takes customers 5-7 minutes to come down','hospital','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,99999,'EVEN','MED INN','Meet at the SouthEast corner of the parking lot at the very end of Simpson Drive. Call ahead of time, it takes customers 7-10 minutes to come down','hospital','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,99999,'EVEN','CVC/CARDIOVASCULARCENTER','Go down Simpson Drive, and take a left right before the parking lot for Med Inn. Pass an ambulance dispatching driveway on your right side, and the employee entrance will be on your right','hospital','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1992,2098,'EVEN','PAULINE BLVD','On Pauline Boulevard, between Stadium and Maple','park_place','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1300,1300,'EVEN','SOUTH UNIVERSITY','The apartment building is facing South Forest, near the corner of South Forest and South University. It takes customers about 3-5 minutes to get down the elevator, so call them ahead of time and ask them to meet you in the lobby.','southu','Remember: Dispatchers dont want drivers going up elevators. It increases delivery times for everybody else in Ann Arbor, and you most likely have to park illegally to get there. Let the customer know that you cant park illegally and leave your car unattended.')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (619,619,'ODD','EUNIVERSITY','It takes the customer about 3-5 minutes to get down to the lobby, so call ahead of time.','ic_launcher','Remember: Dispatchers dont want drivers going up elevators. It increases delivery times for everybody else in Ann Arbor, and you most likely have to park illegally to get there. Let the customer know that you cant park illegally and leave your car unattended.')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (100,100,'EVEN','OBSERVATORY','Park in the parking lot directly north next to the dormitory (closest to East Ann street), and ask the customer to meet you in the parking lot. It takes 4-6 minutes for the customer to come down, so call ahead.','observatory','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (200,200,'EVEN','OBSERVATORY','Call the customer and ask them which of the three doors you want to meet them at. There are three doors, a north door closest to Alice Lloyd Hall, a middle door, and a south door closest to Stockwell Hall. It takes about 3-5 minutes for the customer to come down, so call ahead.','observatory','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (2215,2215,'EVEN','FULLERRD','The VA Hospital. There are essentially 4 meeting spots: 1) The red awning by the old emergency room (turn onto Fuller Court, take the first left, and keep left until you see a red awning on your right side), 2) The Emergency Room (turn onto Fuller Court, take the first left, and keep right until you see 2 sliding doors followed by a black gate on your left side), 3) The Boiler Room/Employee Parking Lot/Service Entrance/Red awning by the buses (turn onto Fuller Court and take the 2nd left), 4) The main entrance by the 3 flags (go down Fuller Road and take a right when you reach Glazier Way).','va','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,1000,'EITHER','BROOKFIELDDR','Use the map, or call the customer','brookfield','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,1000,'EITHER','BYNAN','','bynan','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,1000,'EITHER','EVERGREEN','At night, you might need to show ID to the front gate before getting in','evergreen','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,1000,'EITHER','WAYMARKETDR','Call the customer, and ask them how, exactly, to get to their house if youre coming from Eisenhower Rd and passing the Candlewood hotel','ic_launcher','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (6655,6655,'EITHER','JACKSONRD','Look at map','j6655','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (0,99999,'EITHER','GLENCOEHILLSDRIVE','Look at map','glencoe_hills','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1800,1900,'EITHER','WSTADIUMBLVD','Look at map','manch_flats','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1721,1825,'EITHER','PAULINEBLVD','Look at map','manch_flats','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1100,1130,'EITHER','NORMANPLACE','Look at map','manch_flats','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1900,2000,'EITHER','WLIBERTYST','Look at map','manch_west','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1000,2000,'EITHER','NIELSENCT','Look at map','med_center_ct','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1940,1990,'EITHER','TRAVERRD','Look at map','trav_crossing','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1021,1067,'EITHER','BARTONDRIVE','Look at map','trav_crossing','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (2300,2500,'EITHER','LANCASHIREDRIVE','Look at map','traver_ridge','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (2300,2500,'EITHER','HURONPKWY','Look at map','traver_ridge','')");
        db.execSQL("INSERT INTO Addresses (StreetNumber1, StreetNumber2, odd_even, Address, Text1, Image, Text2) Values (1100,1130,'EITHER','NORMANPLACE','Look at map','manch_flats','')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nothing for now
    }

    public DataBaseHelper(Context context) {

        super(context, DB_NAME, null, 1);//Requirement of parent class

        Log.i(TAG, "DatabaseHelper initialized");

        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }

        Log.i(TAG, "Data Path: " + DB_PATH + DB_NAME);

        File dbfile=new File(DB_PATH + DB_NAME);

        Log.i(TAG, DB_PATH + DB_NAME + " is File: " + dbfile.isFile());



    }

}

//End SQLiteOpenHelper class

