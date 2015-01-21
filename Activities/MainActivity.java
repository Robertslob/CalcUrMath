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

import org.matheclipse.core.expression.F;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.teamindecisive.calcurmath.function.Calculus;


public class MainActivity extends ActionBarActivity{
	
	TextView [] ansViews;
	EditText txtEdit;
	Button equals, approximate;
	Keyboard basicKeyboard, functionKeyboard, restKeyboard;
	KeyboardView keyboardView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);	
		ansViews = new TextView[24];
		txtEdit = (EditText)findViewById(R.id.TextInput);
		// Set the buttons
		equals = (Button) findViewById(R.id.Button_equals);
		approximate = (Button) findViewById(R.id.Button_approximate);
        
        // Set the listeners for the equals and approximate button
        setButtonListeners();
        
		//txtEdit.setRawInputType(InputType.TYPE_CLASS_TEXT);
        //txtEdit.setTextIsSelectable(true);	
		// Add the answers views from the layout to its array
		setAnsViews();
		
        // Create the Keyboards
        basicKeyboard = new Keyboard(this, R.xml.basickeyboard);
        functionKeyboard = new Keyboard(this, R.xml.functionkeyboard);
        restKeyboard = new Keyboard(this, R.xml.restkeyboard);

        // Lookup the KeyboardView
        keyboardView= (KeyboardView)findViewById(R.id.keyboardview);
        // Attach the basic keyboard to the view
        keyboardView.setKeyboard( basicKeyboard );
        
        // Install the key handler 
        keyboardView.setOnKeyboardActionListener(onKeyboardActionListener);
        
        // make the txtEdit open our custom keyboard when clicked upon
        txtEdit.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		showKeyboard(v);
        	}
        });       
        
        txtEdit.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if( hasFocus ) showKeyboard(v); else hideKeyboard(v);
            }
        });
        
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Do not show the preview balloons
        keyboardView.setPreviewEnabled(false);
        // We let the evalengine start up by differentiating and integrating
        // We differentiate and integrate to make these parts of the engine active already
        loadEvalEngine();
		}
	
	protected void loadEvalEngine(){
		Calculus.lowerCase("Integrate(x,x)");
		Calculus.lowerCase("Diff(x,x)");
	}
	
	protected OnKeyboardActionListener onKeyboardActionListener = new OnKeyboardActionListener() {
        @Override public void onKey(int primaryCode, int[] keyCodes) 
        {             
        	// Do an action for each key pressed on the keyboard
             switch(primaryCode){
	             case 10001: keyboardView.setKeyboard(basicKeyboard); 
	             	break;
	             case 10002: keyboardView.setKeyboard(functionKeyboard); 
	             	break;
	             case 10003: keyboardView.setKeyboard(restKeyboard); 
	             	break;
	             case 10004: goToGraph(); 
	             	break;
	             case 10005: showAbout(); 
	             	break;
	             case 100: 
	            	int start = Math.max(txtEdit.getSelectionStart(), 0);
	    			int end = Math.max(txtEdit.getSelectionEnd(), 0);
	    			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
	    					ansViews[0].getText().toString(), 0, ansViews[0].getText().length());
	    			break;
	             /*case 901: diff(); 
	             	break;
	             case 902: integrate(); 
	             	break;*/
	             	// The rest of the cases can be handled with the onClickSwitch class
	             default: txtEdit = onClickSwitch.txtSwitch(txtEdit, primaryCode); 
	             	break;        
             }
        }

        @Override public void onPress(int arg0) {
        }

        @Override public void onRelease(int primaryCode) {
        }

        @Override public void onText(CharSequence text) {
        }

        @Override public void swipeDown() {
        	hideKeyboard(keyboardView);
        }

        @Override public void swipeLeft() {
        	if(keyboardView.getKeyboard().equals(basicKeyboard))
        		keyboardView.setKeyboard(functionKeyboard);
        	else if(keyboardView.getKeyboard().equals(functionKeyboard))
        		keyboardView.setKeyboard(restKeyboard);
        }

        @Override public void swipeRight() {
        	if(keyboardView.getKeyboard().equals(functionKeyboard))
        		keyboardView.setKeyboard(basicKeyboard);
        	else if(keyboardView.getKeyboard().equals(restKeyboard))
        		keyboardView.setKeyboard(functionKeyboard);        	
        }

        @Override public void swipeUp() {
        	keyboardView.setKeyboard(restKeyboard);
        }
    };
	
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
		ansViews[12]  = (TextView) findViewById(R.id.ansView13);
		ansViews[13]  = (TextView) findViewById(R.id.ansView14);
		ansViews[14]  = (TextView) findViewById(R.id.ansView15);
		ansViews[15]  = (TextView) findViewById(R.id.ansView16);
		ansViews[16]  = (TextView) findViewById(R.id.ansView17);
		ansViews[17]  = (TextView) findViewById(R.id.ansView18);
		ansViews[18]  = (TextView) findViewById(R.id.ansView19);
		ansViews[19]  = (TextView) findViewById(R.id.ansView20);
		ansViews[20]  = (TextView) findViewById(R.id.ansView21);
		ansViews[21]  = (TextView) findViewById(R.id.ansView22);
		ansViews[22] = (TextView) findViewById(R.id.ansView23);
		ansViews[23] = (TextView) findViewById(R.id.ansView24);
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
		if (id == R.id.action_graph) {
			goToGraph();
			return true;
		}
		return super.onOptionsItemSelected(item);
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
	/*
	public void diff(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final EditText input = new EditText(this);
		builder.setMessage("Enter the function you would like to differentiate below.")
			   .setTitle("Differentiation")
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
	
	public void integrate(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final EditText input = new EditText(this);
		builder.setMessage("Enter the function you would like to integrate below.")
			   .setTitle("Integration")
			   .setView(input)
			   .setPositiveButton("Integrate!", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int id) {
					   String inputString = input.getText().toString();
					   moveAnsText();
					   ansViews[0].setText(inputString);
					   ansViews[1].setText(Calculus.lowerCase("Integrate(" + inputString + ", x)"));
		           }})
			   .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int id) {
					   dialog.cancel();				
				   }});
		builder.show();
	}*/
	
	protected void setButtonListeners(){
		
		equals.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(!txtEdit.getText().toString().isEmpty()){
					try{						
						moveAnsText();
						ansViews[0].setText(txtEdit.getText().toString());
						ansViews[1].setText(Calculus.lowerCase(txtEdit.getText().toString()));													
					}
					catch(Exception e){
						ansViews[1].setText("Error");
					}
					txtEdit.getText().clear();
				}
			}						
		});		
		
		approximate.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(!txtEdit.getText().toString().isEmpty()){
					try{					
						moveAnsText();
						ansViews[0].setText(txtEdit.getText().toString());
						ansViews[1].setText(Calculus.doubleLowerCase(txtEdit.getText().toString()));							
					}
					catch(Exception e){
						ansViews[1].setText("Error");	
					}
					txtEdit.getText().clear();
				}
			}			
		});
	}
	
	protected String optimizeInput(String s){
		s = s.replace('i', 'I');
		s = s.replace("[","(");
		s = s.replace("]",",x)");
		return s;
	}
	
	protected String optimizeAnswer(String s){
		s = s.replace("sec", "1/cos");
		s = s.replace("csc", "1/sin");
		s = s.replace("cot", "1/tan");
		s = s.replace('I', 'i');
		return s;
	}
	
	protected void moveAnsText(){
		for(int i=23; i>1; i--)
			ansViews[i].setText(ansViews[i-2].getText().toString());
	}
	
	public void goToGraph()
	{
		Intent i = new Intent(this, GraphActivity.class);
		startActivity(i);
	}
	
	public void hideKeyboard(View v){
    	keyboardView.setVisibility(View.GONE);
        keyboardView.setEnabled(false);
    }
    
    public void showKeyboard(View v){
       keyboardView.setVisibility(View.VISIBLE);
       keyboardView.setEnabled(true);
       if( v!=null)((InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
