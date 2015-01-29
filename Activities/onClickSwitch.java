package com.teamindecisive.calcurmath;

import android.widget.EditText;

public class onClickSwitch {
	
	public static EditText txtSwitch(EditText txtEdit, int primaryCode){
		// Start and end of selection
		int start;
		int end;
		switch(primaryCode) {
		case 1:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"1", 0, 1);
			break;
			
		case 2:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"2", 0, 1);
			break; 		  
		  
		case 3:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"3", 0, 1);
			break;		  
		  
		case 4:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"4", 0, 1);
			break;		  
		  
		case 5:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"5", 0, 1);
			break;		  
		  
		case 6:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"6", 0, 1);
			break;		  
		  
		case 7:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
	    		 	"7", 0, 1);
			break;		  
		  
		case 8:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"8", 0, 1);
			break;		  
		  
		case 9:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"9", 0, 1);
			break;	 	
		  
		case 0:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"0", 0, 1);
			break;
			
		case 101:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"+", 0, 1);
			break;
		  
		case 102:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"-", 0, 1);
			break;
			
		case 103:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"*", 0, 1);
			break;	
		      
		case 104:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"/", 0, 1);
			break;
			
		case 105:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"i", 0, 1);
			break;
			
		case 1001: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					".", 0, 1);
			break;
			
		case 1002:
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"(", 0, 1);
			break;
		  
		case 1003: 
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
		
		case -1: 
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
            
		case -100: 
            txtEdit.getText().clear();
            break;
            
		case 201: 
            start = Math.max(txtEdit.getSelectionStart(), 0);
            end = Math.max(txtEdit.getSelectionEnd(), 0);
            txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
                    "()^2", 0, 4);
            txtEdit.setSelection(start+1);
            break;

		case 202: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"sqrt()", 0, 6);
			txtEdit.setSelection(start+5);
			break;

		case 203: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"()^()", 0, 5);
			txtEdit.setSelection(start+1);
			break;

		case 204: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"()^(1/)", 0, 7);
			txtEdit.setSelection(start+1);
			break;

		case 205: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"1/()", 0, 4);
		 	txtEdit.setSelection(start+3);
		 	break;
		 	
		case 206: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"||", 0, 2);
			txtEdit.setSelection(start+1);
			break;
			
		case 207: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"log()", 0, 5);
			txtEdit.setSelection(start+4);
			break;
			
		case 208: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"e^()", 0, 4);
			txtEdit.setSelection(start+3);
			break;		
			
		case 301: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Sin()", 0, 5);
			txtEdit.setSelection(start+4);
			break;

		case 302: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Cos()", 0, 5);
			txtEdit.setSelection(start+4);
			break;
		   
		case 303: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Tan()", 0, 5);
			txtEdit.setSelection(start+4);
			break;
		   
		case 304: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Pi", 0, 2);				   
			break;
			
		case 305: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"x", 0, 1);				   
			break;
		   
		case 306: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
		       	    "ArcSin()", 0, 8);
			txtEdit.setSelection(start+7);
		   	break;
		   
		   
		case 307: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"ArcCos()", 0, 8);
			txtEdit.setSelection(start+7);
			break;
		   
		case 308: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"ArcTan()", 0, 8);
			txtEdit.setSelection(start+7);
			break;
			
		case 401: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"<", 0, 1);
			break;
			
		case 402: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					">", 0, 1);
			break;
			
		case 403: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"<=", 0, 2);
			break;	
			
		case 404: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					">=", 0, 2);
			break;
			
		case 405: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"!", 0, 1);
			break;
			
		case 406: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
		           "NcR[,]", 0, 6);
			txtEdit.setSelection(start+4);
		  	break;
		   
		case 407: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"NpR[,]", 0, 6);
			txtEdit.setSelection(start+4);
			break;	
		
		case 901: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Diff[]", 0, 6);
			txtEdit.setSelection(start+5);
			break;	 
		case 902: 
			start = Math.max(txtEdit.getSelectionStart(), 0);
			end = Math.max(txtEdit.getSelectionEnd(), 0);
			txtEdit.getText().replace(Math.min(start, end), Math.max(start, end),
					"Integrate[]", 0, 11);
			txtEdit.setSelection(start+10);
			break;	
		}
		// We adjust the text of the txtEdit, and return the adjusted txtEdit
		return txtEdit;
	}
}
