package com.example.ivy_lee_method;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class HomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        
        
        //BUTTONS--
        
		// home page graphs button 
		final Button Graphs = (Button) findViewById(R.id.graphsButton);

		//start new activity on button press
		Graphs.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					
					//intent for graphs activity
					Intent myIntent = new Intent(getApplicationContext(),
							GraphActivity.class);
					startActivity(myIntent);
				}
				return true;
			}
		});
		// home page settings button
				final Button Settings = (Button) findViewById(R.id.settingsButton);

				//start new activity on button press
				Settings.setOnTouchListener(new View.OnTouchListener() {
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						if (event.getAction() == MotionEvent.ACTION_DOWN) {
							
							//intent for graphs activity
							Intent myIntent = new Intent(getApplicationContext(),
									SettingsActivity.class);
							startActivity(myIntent);
						}
						return true;
					}
				});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
