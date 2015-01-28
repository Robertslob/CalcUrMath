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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.LayoutInflater;
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
        
        // Assign and set the listeners for the equals and approximate button
        setCalculateButtons();
        
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
        
        // Don't let the basic keyboard pop up on start-up
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Do not show the preview balloons
        keyboardView.setPreviewEnabled(false);
        // We let the evalengine start up by differentiating and integrating
        // We differentiate and integrate to make these parts of the engine active already
        loadEvalEngine();
		}
	
	// Do two calculation to load the evalengine
	protected void loadEvalEngine(){
		Calculus.lowerCase("Integrate(x,x)");
		Calculus.lowerCase("Diff(x,x)");
	}
	
	// If something on the keyboard is pressed, this handles the result action
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
	             case 408: goToConstants();
	             	break;
	             case 100: 
	            	int start = Math.max(txtEdit.getSelectionStart(), 0);
	    			int end = Math.max(txtEdit.getSelectionEnd(), 0);
	    			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
	    					ansViews[0].getText().toString(), 0, ansViews[0].getText().length());
	    			break;
	    			// In the default case, the onclickswitch class can handle it
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
	
    // set the AnsViews
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
		
		// Set the onclicklistener for the ansViews
		for(int i = 0; i<24; i++)
		{
			ansViews[i].setOnClickListener(new OnClickListener(){
				@Override
	            public void onClick(View v) {					
					// If an ansView is pressed, insert that string in the txtEdit
					String s = ((TextView)v).getText().toString();
					int start = Math.max(txtEdit.getSelectionStart(), 0);
					int end = Math.max(txtEdit.getSelectionEnd(), 0);
					txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
							s, 0, s.length());
	            }
			});
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_graph) {
			goToGraph();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Open when the about button is pressed
	public void showAbout(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Made by Robert, Joris, Daan and Willem.")
		       .setTitle("About")
		       .setPositiveButton("Go to our site", new DialogInterface.OnClickListener() {
		    	   public void onClick(DialogInterface dialog, int id) {
		    		   // Open the browser and go to our site
		    		   Intent browserIntent = 
		               new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.projects.science.uu.nl/INFOB1PICA/2014/6a/index.html"));		    		   
		    		   startActivity(browserIntent);
		           }
		       })
		       .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		    	   public void onClick(DialogInterface dialog, int id) {
		               // Dialog closes automatically when button is pressed
		           }
		       });
		builder.show();		 
	}
	
	// If the constants button is pressed, create and alertdialog with the constants layout as view
	@SuppressLint("InflateParams") protected void goToConstants(){		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflater = getLayoutInflater();
		// Create the view from the layout
		View v = inflater.inflate(R.layout.constants, null);
		builder.setMessage("Choose a constant below")
			   .setTitle("Constants")
			   .setView(v)
			   .setPositiveButton("Done", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int id) {
					   dialog.cancel();
		           }});		
		builder.show();
		setConstantButtons(v);
	}
	
	// Set all the buttons from the constants
	protected void setConstantButtons(View layout){
		Button[] constants = new Button[24];
		// We use layout.findViewById to make sure the buttons arent null, since the layout isn't initialised yet
		constants[0] = (Button) layout.findViewById(R.id.tableButtonA);
		constants[1] = (Button) layout.findViewById(R.id.tableButtonB);
		constants[2] = (Button) layout.findViewById(R.id.tableButtonC);
		constants[3] = (Button) layout.findViewById(R.id.tableButtonD);
		constants[4] = (Button) layout.findViewById(R.id.tableButtonF);
		constants[5] = (Button) layout.findViewById(R.id.tableButtonG);
		constants[6] = (Button) layout.findViewById(R.id.tableButtonH);
		constants[7] = (Button) layout.findViewById(R.id.tableButtonJ);
		constants[8] = (Button) layout.findViewById(R.id.tableButtonK);
		constants[9] = (Button) layout.findViewById(R.id.tableButtonL);
		constants[10] = (Button) layout.findViewById(R.id.tableButtonM);
		constants[11] = (Button) layout.findViewById(R.id.tableButtonN);
		constants[12] = (Button) layout.findViewById(R.id.tableButtonO);
		constants[13] = (Button) layout.findViewById(R.id.tableButtonP);
		constants[14] = (Button) layout.findViewById(R.id.tableButtonQ);
		constants[15] = (Button) layout.findViewById(R.id.tableButtonR);
		constants[16] = (Button) layout.findViewById(R.id.tableButtonS);
		constants[17] = (Button) layout.findViewById(R.id.tableButtonT);
		constants[18] = (Button) layout.findViewById(R.id.tableButtonU);
		constants[19] = (Button) layout.findViewById(R.id.tableButtonV);
		constants[20] = (Button) layout.findViewById(R.id.tableButtonW);
		constants[21] = (Button) layout.findViewById(R.id.tableButtonY);
		constants[22] = (Button) layout.findViewById(R.id.tableButtonZ);
			
		for(int i = 0; i<23; i++){
			constants[i].setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					// Let a builder be created if a button is pressed
					constantPressedBuilder(v);
				}
			});
		}
	}
	
	protected void constantPressedBuilder(View v){
		// The character of the button
		final String buttonText = ((Button)v).getText().toString();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);	
		// The EditText, set color Black and make both decimal and negative values possible
		final EditText input = new EditText(getBaseContext());
		input.setTextColor(getResources().getColor(R.color.black));
		input.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_NUMBER_FLAG_SIGNED);
		// Create the builder
		builder.setMessage("Give this constant a value or insert it")
			   .setTitle("Constant " + buttonText)
			   .setView(input)
			   .setPositiveButton("Assign value", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int id) {
					   // Assign the value of the string to the constant in Calculus
					   String inputString = input.getText().toString();
					   Calculus.lowerCase(buttonText + "=" + inputString);
		           }})
			   .setNegativeButton("Insert", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int id) {
					   // Put the variable in the txtEdit
					   int start = Math.max(txtEdit.getSelectionStart(), 0);
					   int end = Math.max(txtEdit.getSelectionEnd(), 0);
					   txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
							   buttonText, 0, 1);
					   // Dialog closes automatically if button is pressed
				   }});
		builder.show();
	}
	
	// Assign and Set the listeners for the equals and approximate button
	protected void setCalculateButtons(){
		equals = (Button) findViewById(R.id.Button_equals);
		approximate = (Button) findViewById(R.id.Button_approximate);
		
		equals.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(!txtEdit.getText().toString().isEmpty()){
					try{
						// Move the ansTexts, then set the input in the most above ansView
						// In the ansVIew beneath that, put the calculated value
						moveAnsText();
						ansViews[0].setText(txtEdit.getText().toString());
						ansViews[1].setText(Calculus.lowerCase(txtEdit.getText().toString()));													
					}
					catch(Exception e){
						// May there be an exception, insert Error where the value should be and open an alertdialog
						showError(e);
						ansViews[1].setText("Error");
					}
					// Clear the txtEdit for a new calculation
					txtEdit.getText().clear();
				}
			}						
		});		
		
		approximate.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(!txtEdit.getText().toString().isEmpty()){
					try{
						// Move the ansTexts, then set the input in the most above ansView
						// In the ansVIew beneath that, put the calculated double 
						moveAnsText();
						ansViews[0].setText(txtEdit.getText().toString());
						ansViews[1].setText(Calculus.doubleLowerCase(txtEdit.getText().toString()));							
					}
					catch(Exception e){
						// May there be an exception, insert Error where the value should be and open an alertdialog
						showError(e);
						ansViews[1].setText("Error");	
					}
					// Clear the txtEdit for a new calculation
					txtEdit.getText().clear();
				}
			}			
		});
	}
	
	protected void showError(Exception e){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("We can't calculate that. " + e)
		       .setTitle("Error in calculation")
		       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		    	   public void onClick(DialogInterface dialog, int id) {
		    		   // Closes automatically when a button is pressed
		           }
		       });
		builder.show();	
	}
	
	// Let the input of the ansViews go down
	protected void moveAnsText(){
		for(int i=23; i>1; i--)
			ansViews[i].setText(ansViews[i-2].getText().toString());
	}
	
	// Start the graphActivity
	public void goToGraph()
	{
		Intent i = new Intent(this, GraphActivity.class);
		startActivity(i);
	}
	
	// Hide the keyboard
	public void hideKeyboard(View v){
    	keyboardView.setVisibility(View.GONE);
        keyboardView.setEnabled(false);
    }
    
	// SHow the keyboard
    public void showKeyboard(View v){
       keyboardView.setVisibility(View.VISIBLE);
       keyboardView.setEnabled(true);
       if( v!=null)((InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
