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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button [] buttons;
	EditText txtEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);
		
		buttons = new Button[25];
		txtEdit = (EditText)findViewById(R.id.TextInput);
		setButtons();
        for(int i=0; i<25; i++)
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
        buttons[21] = (Button) findViewById(R.id.Button_prob);
        buttons[22] = (Button) findViewById(R.id.Button_func);
        buttons[23] = (Button) findViewById(R.id.Button_bsc);
        buttons[24] = (Button) findViewById(R.id.Button_geo); 
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
     int start;
     int end;
     switch(v.getId())
     {
     case R.id.Button_one: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "1", 0, 1);
      break;
      
     case R.id.Button_two: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "2", 0, 1);
      break;
      
     case R.id.Button_three: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "3", 0, 1);
      break;
      
     case R.id.Button_four: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "4", 0, 1);
      break;
      
     case R.id.Button_five: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "5", 0, 1);
      break;
      
     case R.id.Button_six: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "6", 0, 1);
      break;
      
     case R.id.Button_seven: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "7", 0, 1);
      break;
      
     case R.id.Button_eight: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "8", 0, 1);
      break;
      
     case R.id.Button_nine: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "9", 0, 1);
      break;
      
     case R.id.Button_zero: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "0", 0, 1);
      break;
     case R.id.Button_closebr: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              ")", 0, 1);
      break;
     
     case R.id.Button_openbr: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "(", 0, 1);
      break;
     
     case R.id.Button_x: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "x", 0, 1);
      break;
     case R.id.Button_ans: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "ans", 0, 3);
      break;
          
     case R.id.Button_plus: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
              "+", 0, 1);
      break;
          
     case R.id.Button_multiply: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
    		  "*", 0, 1);
      break;
          
     case R.id.Button_substract: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
    		  "-", 0, 1);
      break;
          
     case R.id.Button_divide: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
    		  "/", 0, 1);
      break;
          
     case R.id.Button_dot: 
      start = Math.max(txtEdit.getSelectionStart(), 0);
      end = Math.max(txtEdit.getSelectionEnd(), 0);
      txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
    		  ".", 0, 1);
      break;
          
     case R.id.Button_equals: 
      //hier moet nog iets wat geen normale button is
      break;
          
     case R.id.Button_geo: 
      //hier moet nog iets wat geen normale button is
      break;
      
     case R.id.Button_bsc: 
         //hier moet nog iets wat geen normale button is
         break;
     case R.id.Button_prob: 
         //hier moet nog iets wat geen normale button is
         break;
     case R.id.Button_func: 
         //hier moet nog iets wat geen normale button is
         break;
     }
	}
	
	public void goToGraph()
	{
		Intent i = new Intent(this, GraphActivity.class);
		startActivity(i);
	}
}
