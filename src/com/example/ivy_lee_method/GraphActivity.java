package com.example.ivy_lee_method;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;


import com.jjoe64.graphview.GraphView;
//import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity);
        
        //instantiate graph 
		GraphView graph = (GraphView) findViewById(R.id.graph);

		//add random data
		LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
		});
		for(int i= 0 ; i <80 ; i++) {
			DataPoint dp = new DataPoint(i, Math.random()*20);
		series.appendData(dp, true, 500);
		}			
		
		//add series and format
		graph.addSeries(series);
		graph.getViewport().setMaxX(60);
		series.setDrawBackground(true);
		series.setBackgroundColor(Color.argb(100, 100, 0, 200));     
    }



}
