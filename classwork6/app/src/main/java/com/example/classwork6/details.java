package com.example.classwork6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_details);

        Bundle b = getIntent().getExtras();
        pokemon p = (pokemon) b.getSerializable ("pokemon");

        TextView name = findViewById (R.id.nameTag);
        TextView attack = findViewById (R.id.attack);
        TextView defence = findViewById (R.id.defence);
        TextView total = findViewById (R.id.details_total);

        CircleImageView img = findViewById (R.id.details_image);

        name.setText (p.getName ());
        attack.setText (p.getAttack ()+"");
        defence.setText (p.getDefence ()+"");
        total.setText (p.getTotal ()+"");
        img.setImageResource (p.getImage ());



    }
}