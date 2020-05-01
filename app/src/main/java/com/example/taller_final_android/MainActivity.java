package com.example.taller_final_android;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private EditText idunico;
    private EditText codigomatricula;
    private EditText nombre;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private Button calcular;
    private EditText resultado;
    private Button salir;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idunico=findViewById(R.id.txtid);
        codigomatricula=findViewById(R.id.txtmatricula);
        nombre=findViewById(R.id.txtnombre);
        nota1=findViewById(R.id.txtnota1);
        nota2=findViewById(R.id.txtnota2);
        nota3=findViewById(R.id.txtnota3);
        calcular=findViewById(R.id.btncalcular);
        salir=findViewById(R.id.btnsalir);
        resultado=findViewById(R.id.txtresultado);
          databaseReference= FirebaseDatabase.getInstance().getReference("Estudiantes");
          progressDialog=new ProgressDialog(this);
          calcular.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  double not1,not2,not3,prom;

                  not1=Double.parseDouble(nota1.getText().toString());
                  not2=Double.parseDouble(nota2.getText().toString());
                  not3=Double.parseDouble(nota3.getText().toString());

                  prom = (not1+not2+not3)/3;
                  resultado.setText(String.valueOf(prom));


                  String cod=codigomatricula.getText().toString().trim();
                  String nom=nombre.getText().toString().trim();
                  String res=resultado.getText().toString().trim();
                  progressDialog.setMessage("realizando registro");
                  String id=databaseReference.push().getKey();
                  Dtopromedio dtopromedio = new Dtopromedio(id, cod, nom, res);


                  databaseReference.child(id).setValue(dtopromedio);
                  Toast.makeText(MainActivity.this,"se ha guardado la informacion con su promedio ",Toast.LENGTH_LONG).show();




              }
          });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


    }
}
