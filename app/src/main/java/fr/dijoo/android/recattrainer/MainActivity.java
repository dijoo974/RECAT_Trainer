package fr.dijoo.android.recattrainer;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Property;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import fr.dijoo.android.recattrainer.R;

public class MainActivity extends AppCompatActivity {


    Random rand = new Random();
    String [] catList = {"S", "G", "H", "K", "M", "L"};

    int catLeader = rand.nextInt(6);
    int catFollower = rand.nextInt(6);
    int score = 0;
    int tries =0;

    int[][] catTable = {{3, 4, 5, 5, 6, 8},
            {3, 3, 4, 4, 5, 7},
            {3, 3, 3, 3, 4, 6},
            {3, 3, 3, 3, 3, 5},
            {3, 3, 3, 3, 3, 4},
            {3, 3, 3, 3, 3, 3}};

    String[] catS = { "A380" };
    String[] catG = { "B777", "B747", "B787", "A340", "A330", "A350"};
    String[] catH = { "B757", "B767", "A310", "A300", "MD11"};
    String[] catK = { "B736", "B737", "B738", "B739", "A318", "A319", "A320", "A321", "C130", "MD80", "MD90"};
    String[] catM = { "B733", "B735", "AT42", "AT72", "DH8", "BA46", "RJ45", "RJ1H", "CRJ1", "CRJ2", "CRJ7", "CRJ9", "E135" , "E145", "E195", "F70", "F100", "GLF2", "GLF4", "CL30", "CL60" };
    String[] catL = { "FA10", "C560", "LJ35", "C56X", "D328", "C680", "H25B", "LJ35", "LJ45", "SF34", "SW4", "BE40", "E120"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayForLeader(catLeader);
        displayLeaderType(catLeader);
        displayForFollower(catFollower);
        displayFollowerType(catFollower);

        /*
        This change the color of the status bar by the colorPrimaryDark
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Displays the score.
     */

    public void displayScore(int score) {


        TextView scoreView = (TextView) findViewById(R.id.score);


        if (tries != 0)
        {
            int percents = 100 * score / tries;
            scoreView.setText("" + String.valueOf(score) + " / " + String.valueOf(tries) + " (" + percents + "%)");
        }
        else
        {
            scoreView.setText("0 / 0");
        }
    }

    /**
     * Displays the score.
     */

    public void displayScoreRed(int score) {


        TextView scoreView = (TextView) findViewById(R.id.score);
        String scoreString ="";

        if (tries != 0)
        {
            int percents = 100 * score / tries;
            scoreString = "" + String.valueOf(score) + " / " + String.valueOf(tries) + " (" + percents + "%)";




        }
        else
        {
            scoreString = "0 / 0";
        }


        scoreView.setText(scoreString);
        scoreView.setTextColor(getResources().getColor(R.color.colorError));

        scoreView.animate().alpha(1f).setDuration(1000l);


        scoreView.setTextColor(getResources().getColor(R.color.standardTextColor));


    }


    /**
     * Displays the category of the leader.
     */

    public void displayForLeader(int catLeader) {


        TextView catLeaderView = (TextView) findViewById(R.id.leader);
        catLeaderView.setText(catList[catLeader]);
    }

    /**
     * Displays the type of the leader.
     */

    public void displayLeaderType(int catLeader) {


        TextView leaderTypeView = (TextView) findViewById(R.id.leaderType);
        leaderTypeView.setText(typeByCat(catLeader));
    }


    /**
     * Displays the category of the follower.
     */

    public void displayFollowerType(int catFollower) {
        TextView followerTypeView = (TextView) findViewById(R.id.followerType);
        followerTypeView.setText(typeByCat(catFollower));
    }


    /**
     * Displays the category of the follower.
     */

    public void displayForFollower(int catFollower) {
        TextView catFollowerView = (TextView) findViewById(R.id.follower);
        catFollowerView.setText(catList[catFollower]);
    }


    /**
     * Displays the category of the follower.
     *
     */

    public String typeByCat(int cat) {
        switch (cat)
        {
            case 0 :
                return catS[rand.nextInt(catS.length)];

            case 1 :
                return catG[rand.nextInt(catG.length)];

            case 2 :
                return catH[rand.nextInt(catH.length)];

            case 3 :
                return catK[rand.nextInt(catK.length)];

            case 4 :
                return catM[rand.nextInt(catM.length)];

            case 5 :
                return catL[rand.nextInt(catL.length)];

            default:
                return "A321";

        }
    }


    public void spacing3(View view) {

        spacing(3);

    }


    public void spacing4(View view) {
        spacing(4);
    }

    public void spacing5(View view) {
        spacing(5);
    }

    public void spacing6(View view) {
        spacing(6);
    }

    public void spacing7(View view) {
        spacing(7);
    }

    public void spacing8(View view) {

        spacing(8);
    }


    public void spacing(int catSep) {

        if (catTable[catLeader][catFollower] == catSep) {
            catLeader = rand.nextInt(6);
            catFollower = rand.nextInt(6);
            displayForLeader(catLeader);
            displayLeaderType(catLeader);
            displayForFollower(catFollower);
            displayFollowerType(catFollower);

            score++;



        }

            tries++;

            displayScore(score);





    }



    public void reset(View view)
    {
        /* permet de faire tourner l'image reset
        * Il y a un animator rotator en xml
        * */
        final ImageView myImage = (ImageView)findViewById(R.id.reset);
        final Animation myRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotator);
        myImage.startAnimation(myRotation);


        score = 0;
        tries = 0;

        catLeader = rand.nextInt(6);
        catFollower = rand.nextInt(6);
        displayForLeader(catLeader);
        displayLeaderType(catLeader);
        displayForFollower(catFollower);
        displayFollowerType(catFollower);

        displayScore(score);

    }


    public void hideTab(View view)
    {
        View hideTabView = findViewById(R.id.tab_view);

        int tab_visibility = hideTabView.getVisibility();

        if (tab_visibility != View.GONE)
        {
            hideTabView.setVisibility(View.GONE);
        }
        else
        {
            hideTabView.setVisibility(View.VISIBLE);
        }

    }





}
