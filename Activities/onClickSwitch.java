package com.teamindecisive.calcurmath;

import android.view.View;
import android.widget.EditText;

public class onClickSwitch {
	
	public static EditText txtSwitch(EditText txtEdit, View v){
		int start;
		int end;
		switch(v.getId()) {
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
            // if next char is a closed bracket, jump 1 space forward
            if(txtEdit.getText().toString().length()==end){
            	end = Math.max(txtEdit.getSelectionEnd(), 0);
            	txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
    					")", 0, 1); 
            	}
            else if(end==start && txtEdit.getText().toString().charAt(end)==')')
            	txtEdit.setSelection(start+1);
            else {
            	end = Math.max(txtEdit.getSelectionEnd(), 0);
            	txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
    					")", 0, 1);
            }			
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
			
		case R.id.Button_del: 
            start = Math.max(txtEdit.getSelectionStart(), 0);
            end = Math.max(txtEdit.getSelectionEnd(), 0);
            if(start!=end) {
            	txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
                    "", 0, 0);
            }
            else {
            	if(start!=0) {
            		start-=1;
            		txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
            				"", 0, 0);
            		}
            	}
            break;
	      
		case R.id.Button_dot: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					".", 0, 1);
			break;
			
		case R.id.Button_sin: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Sin()", 0, 5);
			txtEdit.setSelection(start+4);
			break;

		case R.id.Button_cos: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Cos()", 0, 5);
			txtEdit.setSelection(start+4);
			break;
		   
		case R.id.Button_tan: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Tan()", 0, 5);
			txtEdit.setSelection(start+4);
			break;
		   
		case R.id.Button_pi: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Pi", 0, 2);				   
			break;
		   
		case R.id.Button_asin: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
		       	    "ArcSin()", 0, 8);
			txtEdit.setSelection(start+7);
		   	break;
		   
		   
		case R.id.Button_acos: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"ArcCos()", 0, 8);
			txtEdit.setSelection(start+7);
			break;
		   
		case R.id.Button_atan: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"ArcTan()", 0, 8);
			txtEdit.setSelection(start+7);
			break;
     
		case R.id.Button_squared: 
            start = Math.max(txtEdit.getSelectionStart(), 0);
            end = Math.max(txtEdit.getSelectionEnd(), 0);
            txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
                    "()^2", 0, 4);
            txtEdit.setSelection(start+1);
            break;

		case R.id.Button_sqrt: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"sqrt()", 0, 6);
			txtEdit.setSelection(start+5);
			break;

		case R.id.Button_power: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"()^()", 0, 5);
			txtEdit.setSelection(start+1);
			break;

		case R.id.Button_root: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"()^(1/)", 0, 6);
			txtEdit.setSelection(start+1);
			break;

		case R.id.Button_inv: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"1/()", 0, 5);
		 	txtEdit.setSelection(start+3);
		 	break;

		case R.id.Button_integr: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"integrate()", 0, 11);
  		 	txtEdit.setSelection(start+10);
  		 	break;		

		case R.id.Button_ln: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"ln()", 0, 4);
			txtEdit.setSelection(start+3);
			break;

		case R.id.Button_log: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"log()", 0, 5);
			txtEdit.setSelection(start+4);
			break;

		case R.id.Button_abs: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"abs()", 0, 5);
			txtEdit.setSelection(start+4);
			break;
			
		case R.id.Button_equalsrest: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"=", 0, 1);
			break;
		   
		case R.id.Button_greater: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					">", 0, 1);
			break;
		   
		case R.id.Button_smaller: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"<", 0, 1);
			break;
		   
		case R.id.Button_constants: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"WTFF", 0, 4);
			break;
		   	
		case R.id.Button_unequal: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"!=", 0, 2);
			break;
		   
		case R.id.Button_greaterequal: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					">=", 0, 2);
			break;
		   
		case R.id.Button_smallerequal: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"<=", 0, 2);
			break;	
		   
		case R.id.Button_factorial: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"!", 0, 1);
			break;
		   
		case R.id.Button_ncr: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
		           "NcR", 0, 3);
		  	break;
		   
		case R.id.Button_npr: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"NpR", 0, 3);
			break;
		}			
		return txtEdit;
	}
}
