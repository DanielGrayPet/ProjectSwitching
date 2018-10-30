package com.example.petru.projectact;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Smiley extends AppCompatActivity {
    //Bitmap pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
        //pic = BitmapFactory.decodeResource(getResources(), R.drawable.sky);
    }

    private class DrawView extends View {
        Paint p;
        float dx, dy, ddx, ddy;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            dx = 0;
            dy = 0;
            //Speed of the smiley
            ddx = 4;
            ddy = 4;
        }

        protected void onDraw(Canvas canvas) {
            //canvas.drawBitmap(pic, 0, 0, p);
            dx += ddx;
            dy += ddy;
            if (dx < -(float) (getHeight() * 0.5) || (dx + getWidth() / 2) > (getWidth() - (float) (getHeight() * 0.3))) {
                ddx = -ddx;
            }
            if (dy < -(float) (getHeight() * 0.2) || (dy + getHeight() / 2) > getHeight() - (float) (getHeight() * 0.3)) {
                ddy = -ddy;
            }
            //draw face
            p.setColor(Color.YELLOW);
            canvas.drawCircle(dx + getWidth() / 2, dy + getHeight() / 2 , (float) (getHeight() * 0.25), p);
            //draw eyes
            p.setColor(Color.LTGRAY);
            canvas.drawCircle(dx + getWidth() / 2 - (float) (getWidth() * 0.1875), dy + (getHeight() / 2) - (float) (getHeight() * 0.0875), (float) (getHeight() * 0.0625), p);
            canvas.drawCircle(dx + getWidth() / 2 + (float) (getWidth() * 0.1875), dy + (getHeight() / 2) - (float) (getHeight() * 0.0875), (float) (getHeight() * 0.0625), p);
            //draw pupils
            p.setColor(Color.BLACK);
            if (ddy < 0) {
                canvas.drawCircle(dx + getWidth() / 2 - (float) (getWidth() * 0.1875), dy + getHeight() / 2 - (float) (getHeight() * 0.1), (float) (getHeight() * 0.0375), p);
                canvas.drawCircle(dx + getWidth() / 2 + (float) (getWidth() * 0.1875), dy + getHeight() / 2 - (float) (getHeight() * 0.1), (float) (getHeight() * 0.0375), p);
            } else {
                canvas.drawCircle(dx + getWidth() / 2 - (float) (getWidth() * 0.1875), dy + getHeight() / 2 - (float) (getHeight() * 0.075), (float) (getHeight() * 0.0375), p);
                canvas.drawCircle(dx + getWidth() / 2 + (float) (getWidth() * 0.1875), dy + getHeight() / 2 - (float) (getHeight() * 0.075), (float) (getHeight() * 0.0375), p);
            }
            //properties of line
            p.setColor(Color.RED);
            p.setStrokeWidth(25);
            //draw red frame
            canvas.drawLine(0, 0, getWidth() - 1, 0, p);
            canvas.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1, p);
            canvas.drawLine(getWidth() - 1, getHeight() - 1, 0, getHeight() - 1, p);
            canvas.drawLine(0, getHeight() - 1, 0, 0, p);
            //check on left and draw tongue
            if (ddx * ddy < 0) {
                canvas.drawArc(dx + getWidth() / 2 - (float) (getWidth() * 0.21), dy + getHeight() / 2 + (float) (getHeight() * 0.0125), dx + getWidth() / 2 + (float) (getWidth() * 0.21), dy + getHeight() / 2 + (float) (getHeight() * 0.1375), -30, (float) (getHeight() * 0.25), false, p);
            } else {
                canvas.drawArc(dx + getWidth() / 2 - (float) (getWidth() * 0.21), dy + getHeight() / 2 + (float) (getHeight() * 0.0125), dx + getWidth() / 2 + (float) (getWidth() * 0.21), dy + getHeight() / 2 + (float) (getHeight() * 0.1375), 30, (float) (getHeight() * 0.25), false, p);
            }
            invalidate();
        }

        //call onDraw again

    }
}
