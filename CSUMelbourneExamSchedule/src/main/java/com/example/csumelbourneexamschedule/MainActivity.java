package com.example.csumelbourneexamschedule;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ALERT");
        builder.setMessage("The timetable for subjects can change prior any notice. \nRefer to interact message inbox for further details. \nThank you");
        builder.setPositiveButton("ACCEPT", null);
        builder.show();
       setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {


            }
        });



        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {


                Toast.makeText(
                        getApplicationContext(),
                       listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_LONG)
                        .show();
                return false;
            }
        });


         }




    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        listDataChild  = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Information Technology Subjects");
        listDataHeader.add("Accounting Subjects");
        listDataHeader.add("Business Subjects");


        // Adding child data
        List<String> infoTech = new ArrayList<String>();
        infoTech.add("ITC 105 COMMUNICATION INFORMATION MANAGEMENT DATABASE \nDate: 29 OCTOBER 2011 \nTime: 09:30 ");
        infoTech.add("ITC 114 DATABASE MANAGEMENT SYSTEMS  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 200 DATABASE ADMINISTRATION  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 203 OBJECT ORIENTED SYSTEM ANALYSIS and DESIGN  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 211 SYSTEM ANALYSIS  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 240 IT INFRASTRUCTURE MANAGEMENT  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 242 INTRODUCTION TO DATA COMMUNICATIONS  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 254 WIRELESS NETWORKS  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 303 SOFTWARE DEVELOPMENT PROJECT 1  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 308 IT PROJECT \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 309 SOFTWARE DEVELOPMENT PROJECT 2  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 313 PROGRAMMING IN JAVA 2  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 314 VISUALISATION AND CLOUD COMPUTING   \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 354 NETWORK ENGINEERING 2 \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 356 WEB BASED INFORMATION SYSTEMS  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 358 MANAGEMENT AND INFORMATION SECURITY \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 383 STRATEGIC INFORMATION MANAGEMENT \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 412 SYSTEM ANALYSIS PG\nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 423 DATABASE SYSTEMS\nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC 431 COMPUTER NETWORKS\nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC  \nDate:  OCTOBER 2011 \nTime: :");
        infoTech.add("ITC  \nDate:  OCTOBER 2011 \nTime: :");






        List<String> acc = new ArrayList<String>();
        acc.add("ACC 100 ACCOUNTING 1 \nDate: 22 OCTOBER 2013 \nTime: 02:50");
        acc.add("ACC 110 ACCOUNTING 2 \nDate: 28 OCTOBER 2013 \nTime: 09:20");

        List<String> business = new ArrayList<String>();
        business.add("BUS 110 PROFESSIONAL PRACTICE \nDate:  OCTOBER 2013 \nTime: 09:20 ");
        business.add("BUS 370 BUSINESS INTERNSHIP \nDate:  OCTOBER 2013 \nTime: 09:20 ");



        listDataChild.put(listDataHeader.get(0), infoTech); // Header, Child data
        listDataChild.put(listDataHeader.get(1), acc);
        listDataChild.put(listDataHeader.get(2), business);
    }


}