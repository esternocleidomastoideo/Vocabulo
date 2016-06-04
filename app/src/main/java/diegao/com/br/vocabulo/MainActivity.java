package diegao.com.br.vocabulo;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends Activity implements GestureDetector.OnGestureListener{


    private GestureDetector detector;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.detector = new GestureDetector(this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }


    @Override
    public void onLongPress(MotionEvent e) {

    }



    @Override
    public boolean onTouchEvent(MotionEvent event){

        if(this.detector.onTouchEvent(event)){

            return true;
        }

        return super.onTouchEvent(event);
    }


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if(Math.abs(e1.getY()-e2.getY())>250){
            return false;
        }

        //right to left
        if(e1.getX()-e2.getX()>100 && Math.abs(velocityX)>200){


            FragmentManager fm = getFragmentManager();

            fm.beginTransaction().setCustomAnimations(R.animator.card_flip_right_in,R.animator.card_flip_right_out,R.animator.card_flip_left_in,R.animator.card_flip_left_out)
                    .replace(R.id.container,new CardBackFragment())
                    .addToBackStack(null)
                    .commit();

             //left to right
        }else if (e2.getX() - e1.getX() > 100 && Math.abs(velocityX) >200) {

            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().setCustomAnimations(R.animator.card_flip_left_in,R.animator.card_flip_left_out,R.animator.card_flip_right_in,R.animator.card_flip_right_out)

                    .replace(R.id.container,new CardFrontFragment())
                    .addToBackStack(null)
                    .commit();

        }
        return false;
    }



}
