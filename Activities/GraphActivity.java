package com.teamindecisive.calcurmath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class GraphActivity extends ActionBarActivity 
{	
	double xMin;
	double xMax;
	int xScl;
	int yScl;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		getAxes();
		getFunctions();
        float[] xvalues = new float[(int)(xMax-xMin)*100+1];
        float[] yvalues = new float[(int)(xMax-xMin)*100+1];
	    for (int i=0;i<(int)(xMax-xMin)*100+1;i++)
		{        	
			double temp = (xMin+i*.01);	
        	xvalues[i] = (float)temp;	
        	yvalues[i] = (float)(10*Math.sin(temp));
	    }     
	    GraphView graph = new GraphView(this, xvalues, yvalues, 1);
	    setContentView(graph);
	}
	
	protected void getAxes()
	{
		EditText xMinEdit = (EditText) findViewById(R.id.xMin_Edit);
		EditText xMaxEdit = (EditText) findViewById(R.id.xMax_Edit);
		EditText xSclEdit = (EditText) findViewById(R.id.xScl_Edit);
		EditText ySclEdit = (EditText) findViewById(R.id.yScl_Edit);
		// nog Try-catch van maken
		xMin = Double.parseDouble(xMinEdit.getText().toString());
		xMax = Double.parseDouble(xMaxEdit.getText().toString());
		xScl = Integer.parseInt(xSclEdit.getText().toString());
		yScl = Integer.parseInt(ySclEdit.getText().toString());
	}
	
	protected void getFunctions()
	{
		// Array?
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.graph, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		if(item.getItemId() == R.id.action_settings){
			openSettings();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void openSettings()
	{
		Intent startActivity = new Intent(this, GraphSettings.class);
	    startActivity(startActivity);
	}
}

	    
