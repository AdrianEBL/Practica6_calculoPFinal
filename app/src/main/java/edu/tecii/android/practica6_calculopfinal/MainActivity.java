package edu.tecii.android.practica6_calculopfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.inputpa1)
    EditText inputpa1;
    @Bind(R.id.inputpa2)
    EditText inputpa2;
    @Bind(R.id.inputpa3)
    EditText inputpa3;
    @Bind(R.id.inputpa4)
    EditText inputpa4;
    @Bind(R.id.inputpb1)
    EditText inputpb1;
    @Bind(R.id.inputpb2)
    EditText inputpb2;
    @Bind(R.id.inputpb3)
    EditText inputpb3;
    @Bind(R.id.inputpb4)
    EditText inputpb4;
    @Bind(R.id.btnclcr)
    Button btnclcr;
    @Bind(R.id.inputpy)
    TextView inputpy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnclcr)
    public void calcularcalproyec(){
        String a1 = inputpa1.getText().toString();
        String a2 = inputpa2.getText().toString();
        String a3 = inputpa3.getText().toString();
        String a4 = inputpa4.getText().toString();
        String b1 = inputpb1.getText().toString();
        String b2 = inputpb2.getText().toString();
        String b3 = inputpb3.getText().toString();
        String b4 = inputpb4.getText().toString();

        if (!a1.isEmpty() && !a2.isEmpty() && !a3.isEmpty() && !a4.isEmpty()
                && !b1.isEmpty() && !b2.isEmpty() && !b3.isEmpty() && !b4.isEmpty()){
            double pa1 = Double.parseDouble(a1);
            double pa2 = Double.parseDouble(a2);
            double pa3 = Double.parseDouble(a3);
            double pa4 = Double.parseDouble(a4);
            double pb1 = Double.parseDouble(b1);
            double pb2 = Double.parseDouble(b2);
            double pb3 = Double.parseDouble(b3);
            double pb4 = Double.parseDouble(b4);

            double ppa = (0.20*pa1) + (0.20*pa2) + (0.25*pa3) + (0.35*pa4);
            double ppb = (0.20*pb1) + (0.20*pb2) + (0.25*pb3) + (0.35*pb4);

            double py = (70 - (0.30*ppa) - (0.35*ppb)) / 0.35;

            if (py <= 100){
                String  cpy= "";
                cpy = "La calificacion necesaria para un promedio final aprobatorio tiene que ser >= "
                        + String.format("%2.2f",py) + "";

                inputpy.setText(cpy);
            } else {
                inputpy.setText("No es posible aprobar ni con la maxima calificacion en el proyecto");
            }

        }
    }
}
