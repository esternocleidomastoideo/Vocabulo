package diegao.com.br.vocabulo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.detector = new GestureDetector(this);

        Vocabulo vocabulo = new Vocabulo();
        vocabulo.setWord("Anacrônico");
        vocabulo.setDefinition("Divergencia de tempo / Época diferente / Discrepância temporal");
        vocabulo.setUseExemple("Um smartphone no ano de 1920 é algo completamente anacrônico");
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

            Log.i("INFORMATION ", "###### vai flipar #####");
            //Intent intent = new Intent(this,Screen3.class);
            //intent.putExtra("statuspoint",statuspoint);
            //startActivity(intent);
        }
        return false;
    }

}
