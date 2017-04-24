package com.example.ivy_lee_method;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Application;

//this class will store all data to be accessed by the Controller files

public class Model {
	
	//declare all global variables
	public static int dailyTasksCompleted = 0;
	
	public static int currentDay = 0;
	
	public static boolean tasksEntered = false;
	
	public static ArrayList<String> dailyTasksList = new ArrayList<String>();
	
	public static ArrayList< Integer> graphTasksCompleted = new ArrayList<Integer>();
	
	
}
