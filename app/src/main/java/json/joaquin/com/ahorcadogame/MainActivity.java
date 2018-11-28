package json.joaquin.com.ahorcadogame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    String[] categorys;
    String[] descriptionCategorys;
    String[] levels;
    String[] descriptionLevels;
    Spinner categorySpinner, levelSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categorys = this.getResources().getStringArray(R.array.categoria);
        descriptionCategorys = this.getResources().getStringArray(R.array.descripcioncategoria);
        levels = this.getResources().getStringArray(R.array.nivel);
        descriptionLevels = this.getResources().getStringArray(R.array.descripcionnivel);
        categorySpinner = (Spinner) findViewById(R.id.category);
        levelSpinner = (Spinner) findViewById(R.id.nivel);
        categorySpinner.setAdapter(new SpinnerAdapter(this, R.layout.custom_spinner, categorys));
        levelSpinner.setAdapter(new SpinnerAdapter2(this, R.layout.custom_spinner, levels));
    }

    public void Navegar(View v) {
        switch (v.getId()) {
            case R.id.start:
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                i.putExtra("categoria", categorySpinner.getSelectedItem().toString());
                i.putExtra("nivel", levelSpinner.getSelectedItem().toString());
                startActivity(i);
                break;
            case R.id.score:
                Intent i2 = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(i2);
                break;
        }
    }

    public class SpinnerAdapter extends ArrayAdapter {

        public SpinnerAdapter(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
        }


        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView label = (TextView) row.findViewById(R.id.txt1);
            label.setText(categorys[position]);
            TextView sub = (TextView) row.findViewById(R.id.txt2);
            sub.setText(descriptionCategorys[position]);
            return row;
        }
    }

    public class SpinnerAdapter2 extends ArrayAdapter {

        public SpinnerAdapter2(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
        }


        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView label = (TextView) row.findViewById(R.id.txt1);
            label.setText(levels[position]);
            TextView sub = (TextView) row.findViewById(R.id.txt2);
            sub.setText(descriptionLevels[position]);
            return row;
        }
    }
}