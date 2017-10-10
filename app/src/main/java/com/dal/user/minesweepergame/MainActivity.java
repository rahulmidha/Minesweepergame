package com.dal.user.minesweepergame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

import static android.R.attr.data;


public class MainActivity extends AppCompatActivity {

    GridView grid, grid2;
    Activity activity;
    View[] clicked = new View[1];
    class GridAdapter extends BaseAdapter{
        Context context;
        int[][] mat;
        public GridAdapter(Context c,int[][] mat)
        {
            context = c;
            this.mat = mat;
        }

        @Override
        public int getCount() {
            return 81;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView newTextView;
            if(view != null)
                newTextView = (TextView) view;
            else
                newTextView = new TextView(context);

            newTextView.setText(""+mat[i/9][i - 9*(i/9)]);
//            newTextView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(clicked[0]!=null)
//                        clicked[0].setBackgroundColor(0x00000000);
//                    view.setBackgroundColor(Color.GRAY);
//                    clicked[0] = view;
//                }1
//            });
            return newTextView;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(new GridAdapter(this.getBaseContext(),Generator.generate(8,9,9)));

    }

}
