package com.example.ivy_lee_method;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
//import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity);
        
        //instantiate graph 
		final GraphView graph = (GraphView) findViewById(R.id.graph);

		//get saved data
		final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
		String arrayString = pref.getString("arrayList", null);
		Log.d("test", arrayString);
		
		//get arraylist 
		String s = pref.getString("arrayList", "");
		Log.d("array",s);
		try{
		for(int i = 0; i <30 ; i++){
			Model.graphTasksCompleted.add(Integer.parseInt(s.substring(0, s.indexOf(','))));
			s = s.substring(s.indexOf(',')+1);
		}
		}
		catch(StringIndexOutOfBoundsException e){

		}
		
		//radio buttons
		final RadioButton week =  (RadioButton) findViewById(R.id.weekCheck);
		final RadioButton month =  (RadioButton) findViewById(R.id.monthCheck);
		
		RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);

		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

		    @Override
		    public void onCheckedChanged(RadioGroup group, int checkedId) 
		       {
	    		LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
	    		});
		    	if(week.isChecked()) {
		    		for(int i = 0 ; i <7 ; i++) {
		    			graph.removeAllSeries();
		    			DataPoint dp = new DataPoint(i, Model.graphTasksCompleted.get(6-i));
		    			series.appendData(dp, true, 500);}
		    		graph.getViewport().setMaxX(6);
		    		graph.getViewport().setXAxisBoundsManual(true);
		    	}
		              else if(month.isChecked()) {
		        	for(int i= 0 ; i <30 ; i++) {
		        		graph.removeAllSeries();
		    			DataPoint dp = new DataPoint(i, Model.graphTasksCompleted.get(29-i));
		    			series.appendData(dp, true, 500);}
		    		graph.getViewport().setMaxX(29);
		    		graph.getViewport().setXAxisBoundsManual(true);

		        }
				graph.addSeries(series);
				series.setDrawBackground(true);
				series.setBackgroundColor(Color.argb(100, 100, 0, 200));
		     }
		});
				
		
		//add week by default
		LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
		});
		for(int i = 0 ; i <7 ; i++) {
			DataPoint dp = new DataPoint(i, Model.graphTasksCompleted.get(6-i));
			series.appendData(dp, true, 500);}		
		
		//add series and format
		graph.addSeries(series);
		graph.getViewport().setMaxX(6);
		StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
		staticLabelsFormatter.setHorizontalLabels(new String[] {" "," ","  ","  "});
		graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
		graph.getViewport().setXAxisBoundsManual(true);
		series.setDrawBackground(true);
		series.setBackgroundColor(Color.argb(100, 100, 0, 200));     
    }



}
