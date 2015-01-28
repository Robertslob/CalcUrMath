package com.teamindecisive.calcurmath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
	double xMin, xMax, yMin, yMax;
	int xScl, yScl;
	boolean parseError;
	String[] functions = new String[6];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graph);
		setButtons();
	}
	
	public void reset(){
		setContentView(R.layout.activity_graph);
		setButtons();
	}
	
	protected void setButtons(){
		Button btnGraph = (Button) findViewById(R.id.graphButton);
		Button btnReset = (Button) findViewById(R.id.resetButton);
		// Set the onClickListeners
		btnGraph.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				parseError = false;
				getAxesFromText();
				getFunctionsFromText();
				// If there was no parse error, draw the graph
				if(!parseError)
					drawGraph();
			}
		});
		
		btnReset.setOnClickListener(new View.OnClickListener(){			
			@Override
			public void onClick(View v){
				reset();
			}
		});	
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
		// If Calculator is selected in options menu, go to the calculator activity
		if(item.getItemId() == R.id.action_calculator){
			goToCalculator();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	protected void getAxesFromText(){
		// Get the text from the editTexts and assign this text to their values
		EditText xMinEdit = (EditText) findViewById(R.id.xMin_Edit);
		EditText xMaxEdit = (EditText) findViewById(R.id.xMax_Edit);
		EditText yMinEdit = (EditText) findViewById(R.id.yMin_Edit);
		EditText yMaxEdit = (EditText) findViewById(R.id.yMax_Edit);
		EditText xSclEdit = (EditText) findViewById(R.id.xScl_Edit);
		EditText ySclEdit = (EditText) findViewById(R.id.yScl_Edit);
		try{
			xMin = Double.parseDouble(xMinEdit.getText().toString());
			xMax = Double.parseDouble(xMaxEdit.getText().toString());
			yMin = Double.parseDouble(yMinEdit.getText().toString());
			yMax = Double.parseDouble(yMaxEdit.getText().toString());
			xScl = Integer.parseInt(xSclEdit.getText().toString());
			yScl = Integer.parseInt(ySclEdit.getText().toString());
		}
		catch(Exception e){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("There was an error in the axis values. " +
					"Keep in mind that minimum and maximum values should be doubles, " +
					"but the scale values should be integers." )
				   .setTitle("Error at axis values")
				   .setPositiveButton("Try again!", new DialogInterface.OnClickListener() {
					   public void onClick(DialogInterface dialog, int id) {
						   dialog.cancel();
			           }});
			// If we don't use parseError, the graph would still be drawn
			parseError = true;
			builder.show();
		}		
	}
	
	protected void getFunctionsFromText(){
		// Get the text from the editTexts and assign this text to their values
		EditText [] editFunctions = new EditText[6];
		editFunctions[0] = (EditText) findViewById(R.id.F1_Edit);
		editFunctions[1] = (EditText) findViewById(R.id.F2_Edit);
		editFunctions[2] = (EditText) findViewById(R.id.F3_Edit);
		editFunctions[3] = (EditText) findViewById(R.id.F4_Edit);
		editFunctions[4] = (EditText) findViewById(R.id.F5_Edit);
		editFunctions[5] = (EditText) findViewById(R.id.F6_Edit);
		for(int i=0; i<6; i++){
			if(!editFunctions[i].getText().toString().isEmpty()){ //(editFunctions[i].getText().toString().matches("") | editFunctions[i].getText().toString() == null))
				try{
					String s = editFunctions[i].getText().toString();
					// In case of a differentiation/integration, use calculus.lowercase first
					Calculus.getValue(s, "1", false);
					functions[i] = Calculus.lowerCase(s);
				}
				catch(Exception e){
					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					builder.setMessage("There was an error in the functions, " +
							"when integrating/differentiating, please make sure you use diff[..]/Integrate[..]. " +
							"Furthermore please make sure that the dependent variable is x.") 							
						   .setTitle("Error at functions")
						   .setPositiveButton("Try again!", new DialogInterface.OnClickListener() {
							   public void onClick(DialogInterface dialog, int id) {
								   dialog.cancel();
					           }});
					// If we don't use parseError, the graph would still be drawn
					parseError = true;
					builder.show();								
				}
			}
			else functions[i] = null;
		}
	}
	
	protected void drawGraph()
	{
		float[] xvalues = new float[(int)(xMax-xMin)*100+1];
        float[][] functionValues = new float[6][(int)(xMax-xMin)*100+1];
	    for (int i=0;i<(int)(xMax-xMin)*100+1;i++)
		{        	
			// Calculate the y-value for all the functions dependent on the x-value
	    	double temp = (xMin+i*.01);	
        	xvalues[i] = (float)temp;
        	String stringTemp = String.valueOf(temp);
        	for(int n = 0; n<6; n++)
        		if(!(functions[n] =="" | functions[n]==null))        			
        			functionValues[n][i] = (float)Double.parseDouble(Calculus.getValue(functions[n], stringTemp, false));       
		}
	    // Show the graph in a builder
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Your graph")
			   .setPositiveButton("Back to settings", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int id) {
					   dialog.cancel();
		           }});
		GraphView graph = new GraphView(this, xvalues, functionValues, xScl, yScl, yMin, yMax);
	    builder.setView(graph);
		builder.show();	    
	}
	
	protected void goToCalculator(){
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
	}
}

	    
