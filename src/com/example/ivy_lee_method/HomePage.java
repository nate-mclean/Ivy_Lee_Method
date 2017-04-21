package com.example.ivy_lee_method;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class HomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        
        //text edits and corresponding checkboxes
        
        final EditText task1 = (EditText) findViewById(R.id.editText1);
        final EditText task2 = (EditText) findViewById(R.id.EditText2);
        final EditText task3 = (EditText) findViewById(R.id.EditText3);
        final EditText task4 = (EditText) findViewById(R.id.EditText4);
        final EditText task5 = (EditText) findViewById(R.id.EditText5);
        final EditText task6 = (EditText) findViewById(R.id.EditText6);
        
        final CheckBox task1check = (CheckBox) findViewById(R.id.checkBox1);
        final CheckBox task2check = (CheckBox) findViewById(R.id.CheckBox2);
        final CheckBox task3check = (CheckBox) findViewById(R.id.CheckBox3);
        final CheckBox task4check = (CheckBox) findViewById(R.id.CheckBox4);
        final CheckBox task5check = (CheckBox) findViewById(R.id.CheckBox5);
        final CheckBox task6check = (CheckBox) findViewById(R.id.CheckBox6);
        
        
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
				
				//STATE (enter tasks or check off tasks)
				
				//submit button
				final Button Submit = (Button) findViewById(R.id.submitButton);
				
				if(Model.tasksEntered == false){
					task1check.setVisibility(View.INVISIBLE);
					task2check.setVisibility(View.INVISIBLE);
					task3check.setVisibility(View.INVISIBLE);
					task4check.setVisibility(View.INVISIBLE);
					task5check.setVisibility(View.INVISIBLE);
					task6check.setVisibility(View.INVISIBLE);
					
					Submit.setOnTouchListener(new View.OnTouchListener() {
						@Override
						public boolean onTouch(View v, MotionEvent event) {
							if (event.getAction() == MotionEvent.ACTION_DOWN) {
								
								//set boolean true
								Model.tasksEntered = true;
								Submit.setVisibility(View.INVISIBLE);
								
								//set daily tasks, and disable text edits
								Model.dailyTasksList.add(task1.getText().toString());
								task1.setFocusable(false);
								Model.dailyTasksList.add(task2.getText().toString());
								task2.setFocusable(false);
								Model.dailyTasksList.add(task3.getText().toString());
								task3.setFocusable(false);
								Model.dailyTasksList.add(task4.getText().toString());
								task4.setFocusable(false);
								Model.dailyTasksList.add(task5.getText().toString());
								task5.setFocusable(false);
								Model.dailyTasksList.add(task6.getText().toString());
								task6.setFocusable(false);
								
								//enable check boxes
								task1check.setVisibility(View.VISIBLE);
								task2check.setVisibility(View.VISIBLE);
								task3check.setVisibility(View.VISIBLE);
								task4check.setVisibility(View.VISIBLE);
								task5check.setVisibility(View.VISIBLE);
								task6check.setVisibility(View.VISIBLE);
								
							}
							return true;
						}
					});					
				}
				if(Model.tasksEntered){
					Submit.setVisibility(View.INVISIBLE);

				}
        
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
