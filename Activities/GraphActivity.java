package com.teamindecisive.calcurmath;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teamindecisive.calcurmath.function.Calculus;

public class GraphActivity extends ActionBarActivity
{	
	public GraphView graph;
	public double xMin = -10.0;
	double xMax = 10.0;
	int xScl = 10;
	int yScl = 10;
	String[] functions = new String[6];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		/*setContentView(R.layout.activity_settings);
		Button btn = (Button) findViewById(R.id.graphButton);
		btn.setTransformationMethod(null);
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				getAxesFromText();
				getFunctionsFromText();
				drawGraph();
			}
		});*/
		openSettings();
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
		setContentView(R.layout.activity_settings);
		Button btn = (Button) findViewById(R.id.graphButton);
		btn.setTransformationMethod(null);
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				getAxesFromText();
				getFunctionsFromText();
				drawGraph();
			}
		});
	}
	
	protected void getAxesFromText(){
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
	
	protected void getFunctionsFromText(){
		EditText [] editFunctions = new EditText[6];
		editFunctions[0] = (EditText) findViewById(R.id.F1_Edit);
		editFunctions[1] = (EditText) findViewById(R.id.F2_Edit);
		editFunctions[2] = (EditText) findViewById(R.id.F3_Edit);
		editFunctions[3] = (EditText) findViewById(R.id.F4_Edit);
		editFunctions[4] = (EditText) findViewById(R.id.F5_Edit);
		editFunctions[5] = (EditText) findViewById(R.id.F6_Edit);		
		for(int i=0; i<6; i++)
			if(!(editFunctions[i].getText().toString().matches("") | editFunctions[i].getText().toString() == null))
				functions[i] = editFunctions[i].getText().toString();
	}
	
	protected void drawGraph()
	{
		float[] xvalues = new float[(int)(xMax-xMin)*100+1];
        float[][] functionValues = new float[6][(int)(xMax-xMin)*100+1];
	    for (int i=0;i<(int)(xMax-xMin)*100+1;i++)
		{        	
			double temp = (xMin+i*.01);	
        	xvalues[i] = (float)temp;
        	String stringTemp = String.valueOf(temp);
        	for(int n = 0; n<6; n++)
        		if(!(functions[n] =="" | functions[n]==null))
        			functionValues[n][i] = (float)Double.parseDouble(Calculus.getValue(functions[n], stringTemp, false));       
		}
	    graph = new GraphView(this, xvalues, functionValues, xScl, yScl);
	    setContentView(graph);
	}
}

	    
