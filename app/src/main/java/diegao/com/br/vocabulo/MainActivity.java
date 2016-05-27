package diegao.com.br.vocabulo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class MainActivity extends Activity implements GestureDetector.OnGestureListener{


    private GestureDetector detector;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.detector = new GestureDetector(this);

        Vocabulo vocabulo = new Vocabulo();
        vocabulo.setWord("Anacrônico");
        vocabulo.setDefinition("Divergencia de tempo / Época diferente / Discrepância temporal");
        vocabulo.setUseExemple("Um smartphone no ano de 1920 é algo completamente anacrônico");


        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().add(R.id.container,new CardFrontFragment()).commit();




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

        if(e1.getX()-e2.getX()>100 && Math.abs(velocityX)>200){


            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().add(R.id.container,new CardBackFragment()).commit();

            Log.i("INFORMATION ", "###### FLIPOU!!! #####");
            //Intent intent = new Intent(this,Screen3.class);
            //intent.putExtra("statuspoint",statuspoint);
            //startActivity(intent);
        }
        return false;
    }



}
