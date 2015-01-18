/*package com.teamindecisive.calcurmath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;*/

package com.teamindecisive.calcurmath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.teamindecisive.calcurmath.function.Calculus;


public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button [] buttons;
	TextView [] ansViews;
	EditText txtEdit;
	LinearLayout [] tabs; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);	
		buttons = new Button[56];
		ansViews = new TextView[12];
		tabs = new LinearLayout[4];
		txtEdit = (EditText)findViewById(R.id.TextInput);
		txtEdit.setRawInputType(InputType.TYPE_CLASS_TEXT);
        txtEdit.setTextIsSelectable(true);	
		// Add the tabs, buttons and answers from the layout to their arrays
		setTabs();
		setButtons();
		setAnsViews();
		// set the onClickListener for the buttons
        for(int i=0; i<56; i++)
        	buttons[i].setOnClickListener(this);
	}
	
	protected void setButtons(){
		buttons[0]  = (Button) findViewById(R.id.Button_zero);
        buttons[1]  = (Button) findViewById(R.id.Button_one);
        buttons[2]  = (Button) findViewById(R.id.Button_two);
        buttons[3]  = (Button) findViewById(R.id.Button_three);
        buttons[4]  = (Button) findViewById(R.id.Button_four);
        buttons[5]  = (Button) findViewById(R.id.Button_five);
        buttons[6]  = (Button) findViewById(R.id.Button_six);
        buttons[7]  = (Button) findViewById(R.id.Button_seven);
        buttons[8]  = (Button) findViewById(R.id.Button_eight);
        buttons[9]  = (Button) findViewById(R.id.Button_nine);
        buttons[10] = (Button) findViewById(R.id.Button_substract);
        buttons[11] = (Button) findViewById(R.id.Button_plus);
        buttons[12] = (Button) findViewById(R.id.Button_del);
        buttons[13] = (Button) findViewById(R.id.Button_closebr);
        buttons[14] = (Button) findViewById(R.id.Button_openbr);
        buttons[15] = (Button) findViewById(R.id.Button_x);
        buttons[16] = (Button) findViewById(R.id.Button_ans);
        buttons[17] = (Button) findViewById(R.id.Button_multiply);
        buttons[18] = (Button) findViewById(R.id.Button_divide);
        buttons[19] = (Button) findViewById(R.id.Button_dot);
        buttons[20] = (Button) findViewById(R.id.Button_equals);
        buttons[21] = (Button) findViewById(R.id.Button_approximate);
        buttons[22] = (Button) findViewById(R.id.Button_rest);
        buttons[23] = (Button) findViewById(R.id.Button_func);
        buttons[24] = (Button) findViewById(R.id.Button_bsc);
        buttons[25] = (Button) findViewById(R.id.Button_geo);
        buttons[26] = (Button) findViewById(R.id.Button_sin);
        buttons[27] = (Button) findViewById(R.id.Button_asin);
        buttons[28] = (Button) findViewById(R.id.Button_cos);
        buttons[29] = (Button) findViewById(R.id.Button_tan);
        buttons[30] = (Button) findViewById(R.id.Button_atan);
        buttons[31] = (Button) findViewById(R.id.Button_acos);
        buttons[32] = (Button) findViewById(R.id.Button_squared);
        buttons[33] = (Button) findViewById(R.id.Button_sqrt);
        buttons[34] = (Button) findViewById(R.id.Button_power);
        buttons[35] = (Button) findViewById(R.id.Button_root);
        buttons[36] = (Button) findViewById(R.id.Button_inv);
        buttons[37] = (Button) findViewById(R.id.Button_abs);
        buttons[38] = (Button) findViewById(R.id.Button_log);
        buttons[39] = (Button) findViewById(R.id.Button_ln);
        buttons[40] = (Button) findViewById(R.id.Button_diff);
        buttons[41] = (Button) findViewById(R.id.Button_integr);
        buttons[42] = (Button) findViewById(R.id.Button_pi);
        buttons[43] = (Button) findViewById(R.id.Button_graph);
        buttons[44] = (Button) findViewById(R.id.Button_equalsrest);
        buttons[45] = (Button) findViewById(R.id.Button_greater);
        buttons[46] = (Button) findViewById(R.id.Button_smaller);
        buttons[47] = (Button) findViewById(R.id.Button_constants);
        buttons[48] = (Button) findViewById(R.id.Button_unequal);
        buttons[49] = (Button) findViewById(R.id.Button_greaterequal);
        buttons[50] = (Button) findViewById(R.id.Button_smallerequal);
        buttons[51] = (Button) findViewById(R.id.Button_graphrest);
        buttons[52] = (Button) findViewById(R.id.Button_factorial);
        buttons[53] = (Button) findViewById(R.id.Button_ncr);
        buttons[54] = (Button) findViewById(R.id.Button_npr);
        buttons[55] = (Button) findViewById(R.id.Button_about);
	}
	
	protected void setAnsViews(){
		ansViews[0]  = (TextView) findViewById(R.id.ansView1);
		ansViews[1]  = (TextView) findViewById(R.id.ansView2);
		ansViews[2]  = (TextView) findViewById(R.id.ansView3);
		ansViews[3]  = (TextView) findViewById(R.id.ansView4);
		ansViews[4]  = (TextView) findViewById(R.id.ansView5);
		ansViews[5]  = (TextView) findViewById(R.id.ansView6);
		ansViews[6]  = (TextView) findViewById(R.id.ansView7);
		ansViews[7]  = (TextView) findViewById(R.id.ansView8);
		ansViews[8]  = (TextView) findViewById(R.id.ansView9);
		ansViews[9]  = (TextView) findViewById(R.id.ansView10);
		ansViews[10] = (TextView) findViewById(R.id.ansView11);
		ansViews[11] = (TextView) findViewById(R.id.ansView12);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	@Override
    public void onClick(View v){
		switch(v.getId()) {
		case R.id.Button_equals:
			moveAnsText();
			ansViews[0].setText(txtEdit.getText().toString());
			ansViews[1].setText(Calculus.lowerCase(txtEdit.getText().toString()));
			txtEdit.setText("");
			break;
			 
		case R.id.Button_approximate:
			moveAnsText();
			ansViews[0].setText(txtEdit.getText().toString());
			ansViews[1].setText(Calculus.doubleLowerCase(txtEdit.getText().toString()));
			txtEdit.setText("");
			break;
			
		case R.id.Button_diff: 
			
			diff();
			/*start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"diff()", 0, 6);
	   	 	txtEdit.setSelection(start+5);*/
	   	 	break;
		
		case R.id.Button_about: 
			showAbout();
			break;

		case R.id.Button_graph:
			goToGraph();   
			break;	   
	  
		case R.id.Button_bsc:
			tabsInvisible();
			tabs[0].setVisibility(View.VISIBLE);
			break;
			
		case R.id.Button_func: 
			tabsInvisible();
			tabs[1].setVisibility(View.VISIBLE);
			break;
	     
		case R.id.Button_geo:
			tabsInvisible();
			tabs[2].setVisibility(View.VISIBLE);
			break;
	 
		case R.id.Button_rest:
			tabsInvisible();
			tabs[3].setVisibility(View.VISIBLE);
			break;
		default: txtEdit = onClickSwitch.txtSwitch(txtEdit, v);
		}    
	}
	
	protected void setTabs(){
		tabs[0] = (LinearLayout) findViewById(R.id.bscLinLay);
		tabs[1] = (LinearLayout) findViewById(R.id.funcLinLay);
		tabs[2] = (LinearLayout) findViewById(R.id.geoLinLay);
		tabs[3] = (LinearLayout) findViewById(R.id.restLinLay);		
	}
	
	public void showAbout(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Made by Robert, Joris, Daan and Willem.")
		       .setTitle("About")
		       .setPositiveButton("Go to our site", new DialogInterface.OnClickListener() {
		    	   public void onClick(DialogInterface dialog, int id) {
		    		   Intent browserIntent = 
		               new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.projects.science.uu.nl/INFOB1PICA/2014/6a/index.html"));		    		   
		    		   startActivity(browserIntent);
		           }
		       })
		       .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		    	   public void onClick(DialogInterface dialog, int id) {
		               //dialog verdwijnt automatisch als je een knop indrukt dus dit is leeg
		           }
		       });
		builder.show();		 
	}
	
	public void diff(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final EditText input = new EditText(this);
		//input.setText("diff()");
		//input.setSelection(4);
		builder.setMessage("Enter the function you would like to differentiate below.")
			   .setTitle("Differentiatie")
			   .setView(input)
			   .setPositiveButton("Diffentiate!", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int id) {
					   String inputString = input.getText().toString();
					   moveAnsText();
					   ansViews[0].setText(inputString);
					   ansViews[1].setText(Calculus.lowerCase("diff(" + inputString + ", x)"));
		           }})
			   .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int id) {
					   dialog.cancel();				
				   }});
		builder.show();
	}
	
	public void tabsInvisible(){
		for(int i=0; i<4; i++)
			tabs[i].setVisibility(View.INVISIBLE);		
	}
	
	protected void moveAnsText(){
		for(int i=11; i>1; i--)
			ansViews[i].setText(ansViews[i-2].getText().toString());
	}
	
	public void goToGraph()
	{
		Intent i = new Intent(this, GraphActivity.class);
		startActivity(i);
	}
}
