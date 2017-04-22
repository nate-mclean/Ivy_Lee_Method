package com.example.ivy_lee_method;


import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


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
        
      //get saved data
		final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
	
	//get day
		Calendar c = Calendar.getInstance(); 
		final int currentDay = c.get(Calendar.DAY_OF_MONTH);
		
		if(pref.getString("task1c", "").equals("true"))
			task1check.setChecked(true);
		else
			task1check.setChecked(false);
		if(pref.getString("task2c", "").equals("true"))
			task2check.setChecked(true);
		else
			task2check.setChecked(false);
		if(pref.getString("task3c", "").equals("true"))
			task3check.setChecked(true);
		else
			task3check.setChecked(false);
		if(pref.getString("task4c", "").equals("true"))
			task4check.setChecked(true);
		else
			task4check.setChecked(false);
		if(pref.getString("task5c", "").equals("true"))
			task5check.setChecked(true);
		else
			task5check.setChecked(false);
		if(pref.getString("task6c", "").equals("true"))
			task6check.setChecked(true);
		else
			task6check.setChecked(false);
		
        //check box updates
        task1check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            	Editor editor = pref.edit();
            	if(isChecked){
				editor.putString("task1c", "true");
				Model.dailyTasksCompleted++;
				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
            	}
            	else{
    				editor.putString("task1c", "false");
    				Model.dailyTasksCompleted--;
    				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
                	}
            	editor.commit();
            }
        }
     );     
        //chek box 2
        task2check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            	Editor editor = pref.edit();
            	if(isChecked){
				editor.putString("task2c", "true");
				Model.dailyTasksCompleted++;
				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
            	}
            	else{
    				editor.putString("task2c", "false");
    				Model.dailyTasksCompleted--;
    				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
                	}
            	editor.commit();
            }
        }
     );   
        //chek box 3
        task3check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            	Editor editor = pref.edit();
            	if(isChecked){
				editor.putString("task3c", "true");
				Model.dailyTasksCompleted++;
				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
            	}
            	else{
    				editor.putString("task3c", "false");
    				Model.dailyTasksCompleted--;
    				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
                	}
            	editor.commit();
            }
        }
     ); 
        //chek box 4
        task4check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            	Editor editor = pref.edit();
            	if(isChecked){
				editor.putString("task4c", "true");
				Model.dailyTasksCompleted++;
				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
            	}
            	else{
    				editor.putString("task4c", "false");
    				Model.dailyTasksCompleted--;
    				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
                	}
            	editor.commit();
            }
        }
     ); 
        //chek box 5
        task5check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            	Editor editor = pref.edit();
            	if(isChecked){
				editor.putString("task5c", "true");
				Model.dailyTasksCompleted++;
				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
            	}
            	else{
    				editor.putString("task5c", "false");
    				Model.dailyTasksCompleted--;
    				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
                	}
            	editor.commit();
            }
        }
     );         //chek box 6
        task6check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            	Editor editor = pref.edit();
            	if(isChecked){
				editor.putString("task6c", "true");
				Model.dailyTasksCompleted++;
				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
            	}
            	else{
    				editor.putString("task6c", "false");
    				Model.dailyTasksCompleted--;
    				Model.graphTasksCompleted.put(currentDay, Model.dailyTasksCompleted);
                	}
            	editor.commit();
            }
        }
     ); 
        
        
        //BUTTONS TO GO FROM PAGE TO PAGE--
        
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
			
				
				//see if its a new day
				int storedDay=0;
				try{
				storedDay = Integer.parseInt(pref.getString("day", ""));
				Log.d("storedDay",Integer.toString(storedDay));
				Log.d("currentDay",Integer.toString(currentDay));
				
				} catch(NumberFormatException E){
					
				}
				
				if(storedDay == currentDay){
					Editor editor = pref.edit();
					editor.putString("tasksEntered", "true");
					Model.tasksEntered=true;
					editor.commit();
				}
				else if(storedDay != currentDay){
					//update storedDay
					//save data to phone memory					
					Editor editor = pref.edit();
					
					editor.putString("tasksEntered", "false");
					editor.putString("day", Integer.toString(currentDay));
					editor.commit();
					Model.tasksEntered=false;
					//set state
					
					
				}
				
				//submit button
				final Button Submit = (Button) findViewById(R.id.submitButton);
				//info text
				final TextView infoText = (TextView) findViewById(R.id.infoText);
				
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
								infoText.setVisibility(View.INVISIBLE);
								
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
								
								//save data to phone memory
								SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
								Editor editor = pref.edit();
								
								editor.putString("tasksEntered", "true");
								editor.putString("task1", task1.getText().toString());
								editor.putString("task2", Model.dailyTasksList.get(1));
								editor.putString("task3", Model.dailyTasksList.get(2));
								editor.putString("task4", Model.dailyTasksList.get(3));
								editor.putString("task5", Model.dailyTasksList.get(4));
								editor.putString("task6", Model.dailyTasksList.get(5));
								Log.d("login",task1.getText().toString());
								Log.d("login2",Model.dailyTasksList.get(1));
								editor.commit();
								
							}
							return true;
						}
					});					
				}
				
				
				//get state 
				//tasks already entered
				if(Model.tasksEntered){
					Submit.setVisibility(View.INVISIBLE);
					//get tasks and display them
					
					task1.setText(pref.getString("task1", ""));
					task2.setText(pref.getString("task2", ""));
					task3.setText(pref.getString("task3", ""));
					task4.setText(pref.getString("task4", ""));
					task5.setText(pref.getString("task5", ""));
					task6.setText(pref.getString("task6", ""));
					//cant edit edittexts
					task1.setFocusable(false);
					task2.setFocusable(false);
					task3.setFocusable(false);
					task4.setFocusable(false);
					task5.setFocusable(false);
					task6.setFocusable(false);

				}
				//tasks not entered yet
				if(!Model.tasksEntered){
					Submit.setVisibility(View.VISIBLE);
					infoText.setText("Please enter 6 tasks");
					
					//clear all checkboxes
					Editor editor = pref.edit();
					
					editor.putString("tasksEntered", "true");
					editor.putString("task1c","false");
					editor.putString("task2c", "false");
					editor.putString("task3c", "false");
					editor.putString("task4c", "false");
					editor.putString("task5c", "false");
					editor.putString("task6c", "false");
					task1check.setChecked(false);
					task2check.setChecked(false);
					task3check.setChecked(false);
					task4check.setChecked(false);
					task5check.setChecked(false);
					task6check.setChecked(false);
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
