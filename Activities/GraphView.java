package com.teamindecisive.calcurmath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

// This class was at first implemented by Ankit Srivastava
// We thank her and adjusted it for our purpose
public class GraphView extends View 
{
	private Paint paint;
	private float[] xValues,yValues;
	private float maxx,maxy,minx,miny,locxAxis,locyAxis;
	private int axes = 1;
	
	public GraphView(Context context, float[] xValues, float[] yValues, int axes) 
	{
		super(context);
		this.xValues=xValues;
		this.yValues=yValues;
		this.axes=axes;
		paint = new Paint();

		getAxes(xValues, yValues);		
	}

	@Override
	protected void onDraw(Canvas canvas) 
	{	
		float canvasHeight = getHeight();
		float canvasWidth = getWidth();
		int[] xValuesInPixels = toPixel(canvasWidth, minx, maxx, xValues); 
		int[] yValuesInPixels = toPixel(canvasHeight, miny, maxy, yValues);
		int locxAxisInPixels = toPixelInt(canvasHeight, miny, maxy, locxAxis);
		int locyAxisInPixels = toPixelInt(canvasWidth, minx, maxx, locyAxis);

		paint.setStrokeWidth(2);
		canvas.drawARGB(255, 255, 255, 255);
		for (int i = 0; i < xValues.length-1; i++) 
		{
			paint.setColor(Color.RED);
			canvas.drawLine(xValuesInPixels[i],canvasHeight-yValuesInPixels[i],xValuesInPixels[i+1],canvasHeight-yValuesInPixels[i+1],paint);
		}
		
		paint.setColor(Color.BLACK);
		canvas.drawLine(0,canvasHeight-locxAxisInPixels,canvasWidth,canvasHeight-locxAxisInPixels,paint);
		canvas.drawLine(locyAxisInPixels,0,locyAxisInPixels,canvasHeight,paint);
		
		//Automatic axes markings, modify n to control the number of axes labels
		if (axes!=0)
		{
			float temp = 0.0f;
			int n=10;
			paint.setTextAlign(Paint.Align.CENTER);
			paint.setTextSize(20.0f);
			for (int i=1;i<=n;i++)
			{
				temp = Math.round(10*(minx+(i-1)*(maxx-minx)/n))/10;
				canvas.drawText(""+temp, (float)toPixelInt(canvasWidth, minx, maxx, temp),canvasHeight-locxAxisInPixels+20, paint);
				temp = Math.round(10*(miny+(i-1)*(maxy-miny)/n))/10;
				canvas.drawText(""+temp, locyAxisInPixels+20,canvasHeight-(float)toPixelInt(canvasHeight, miny, maxy, temp), paint);
			}
			canvas.drawText(""+maxx, (float)toPixelInt(canvasWidth, minx, maxx, maxx),canvasHeight-locxAxisInPixels+20, paint);
			canvas.drawText(""+maxy, locyAxisInPixels+20,canvasHeight-(float)toPixelInt(canvasHeight, miny, maxy, maxy), paint);
		}		
	}
	
	private int[] toPixel(float pixels, float min, float max, float[] value) 
	{		
		double[] p = new double[value.length];
		int[] pint = new int[value.length];
		
		for (int i = 0; i < value.length; i++) 
		{
			p[i] = .1*pixels+((value[i]-min)/(max-min))*.8*pixels;
			pint[i] = (int)p[i];
		}		
		return (pint);
	}
	
	private void getAxes(float[] xValues, float[] yValues) 
	{		
		// The first xValue is the smallest and the last the biggest
		minx=xValues[0];
		maxx=xValues[xValues.length-1];
		// For the yValue, we have to find it through the getMin and getMax methods
		miny=getMin(yValues);
		maxy=getMax(yValues);
		
		if (minx>=0)
			locyAxis=minx;
		else if (minx<0 && maxx>=0)
			locyAxis=0;
		else
			locyAxis=maxx;
		
		if (miny>=0)
			locxAxis=miny;
		else if (miny<0 && maxy>=0)
			locxAxis=0;
		else
			locxAxis=maxy;		
	}
	
	private int toPixelInt(float pixels, float min, float max, float value) 
	{		
		double p;
		int pint;
		p = .1*pixels+((value-min)/(max-min))*.8*pixels;
		pint = (int)p;
		return (pint);
	}

	private float getMax(float[] v) 
	{
		float largest = v[0];
		for (int i = 0; i < v.length; i++)
			if (v[i] > largest)
				largest = v[i];
		return largest;
	}

	private float getMin(float[] v) 
	{
		float smallest = v[0];
		for (int i = 0; i < v.length; i++)
			if (v[i] < smallest)
				smallest = v[i];
		return smallest;
	}
}