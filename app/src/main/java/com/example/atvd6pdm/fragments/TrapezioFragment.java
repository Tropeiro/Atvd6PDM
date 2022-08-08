package com.example.atvd6pdm.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.atvd6pdm.R;

public class TrapezioFragment extends Fragment {

    private EditText editBaseMaior, editBaseMenor, editAlturaTrapezio;
    private Button btnCalculaTrapezio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trapezio, container, false);

        editAlturaTrapezio = view.findViewById(R.id.editAlturaTrapezio);
        editBaseMaior = view.findViewById(R.id.editBaseMaior);
        editBaseMenor = view.findViewById(R.id.editBaseMenor);
        btnCalculaTrapezio = view.findViewById(R.id.btnCalculaTrapezio);

        btnCalculaTrapezio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editBaseMenor.getText().toString().isEmpty() || editBaseMaior.getText().toString().isEmpty()
                || editAlturaTrapezio.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }else{
                    double altura = Double.parseDouble(editAlturaTrapezio.getText().toString());
                    double basemaior = Double.parseDouble(editBaseMaior.getText().toString());
                    double basemenor = Double.parseDouble(editBaseMenor.getText().toString());

                    double resultado = ((basemaior + basemenor)/2) * altura;

                    AlertDialog.Builder resul = new AlertDialog.Builder(getContext());
                    resul.setTitle("Área de um Trapézio");
                    String saida = String.format("A área do trapézio é de: %.1f", resultado);
                    resul.setMessage(saida);
                    resul.setIcon(R.drawable.calcular);
                    resul.show();

                    editAlturaTrapezio.setText("");
                    editBaseMaior.setText("");
                    editBaseMenor.setText("");
                }
            }
        });
        return view;
    }
}