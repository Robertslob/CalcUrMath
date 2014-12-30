package com.teamindecisive.calcurmath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class GraphSettings extends ActionBarActivity
{
	Button btn;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graph_settings);
		btn = (Button)findViewById(R.id.graphButton);
		
		// Otherwise the button will be all-caps
		btn.setTransformationMethod(null);
		
		// If the button is clicked, call the method openGraph
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v)
			{
				openGraph();
			}
		});
	}
	
	// Start the graph activity with the new settings
	public void openGraph()
	{
		Intent startActivity = new Intent(this, GraphActivity.class);
	    startActivity(startActivity);
	}
}
