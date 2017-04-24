package com.example.ivy_lee_method;



import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class SettingsActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        
        
        //timepicker
        final TimePicker t = (TimePicker) findViewById(R.id.timePicker1);

        //submit button
        Button SubmitButton = (Button) findViewById(R.id.timeSubmitButton);
        
        SubmitButton.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//get time on time picker
		        int sethour = t.getCurrentHour();
		        int setminute = t.getCurrentMinute();
		        
		        //set up notification to repeat at that time
		        Calendar firingCal= Calendar.getInstance();
		        Calendar currentCal = Calendar.getInstance();

		        firingCal.set(Calendar.HOUR_OF_DAY, sethour); // At the hour you wanna fire
		        firingCal.set(Calendar.MINUTE, setminute); // Particular minute
		        firingCal.set(Calendar.SECOND, 0); // particular second

		        long intendedTime = firingCal.getTimeInMillis();
				 
				 //set notification
				 scheduleNotification(getNotification("Please set your 6 daily tasks"), intendedTime);
				 
				 
				 //toast
				 Toast.makeText(getApplicationContext(), "Notification time set.", Toast.LENGTH_SHORT).show(); 
				
				return true;
			
			}
	});
	}
	
	private void scheduleNotification(Notification notification, long time) {

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.RTC, time, AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Ivy Lee Method");
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.ic_launcher);
        return builder.build();
    }
	
}
