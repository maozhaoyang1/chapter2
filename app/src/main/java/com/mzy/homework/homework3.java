package com.mzy.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class homework3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(new ListViewAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(homework3.this, "当前位置" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(homework3.this, Main2Activity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public static class ListViewAdapter extends BaseAdapter {
        private int[] args =
                new int[100];


        private Context mContext;

        public ListViewAdapter(Context context) {
            mContext = context;
        }

        @Override public int getCount() {
            return args.length;
        }

        @Override public Object getItem(int position) {
            return null;
        }

        @Override public long getItemId(int position) {
            return 0;
        }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                view = inflater.inflate(R.layout.style, null);
            } else {
                view = convertView;
            }
            return view;
        }
    }
}