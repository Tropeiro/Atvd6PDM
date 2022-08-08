
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

public class CirculoFragment extends Fragment {

    private EditText editRaio;
    private Button btnCalculaCirculo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_circulo, container, false);

        editRaio = view.findViewById(R.id.editRaio);
        btnCalculaCirculo = view.findViewById(R.id.btnCalculaCirculo);

        btnCalculaCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editRaio.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    double raio = Double.parseDouble(editRaio.getText().toString());
                    double pi = 3.14;
                    double areaCirc = pi * (Math.pow(raio,2));

                    AlertDialog.Builder resul = new AlertDialog.Builder(getActivity());
                    resul.setTitle("Resultado!");
                    String saida = String.format("A área do círculo é de: %.2f", areaCirc);
                    resul.setMessage(saida);
                    resul.setIcon(R.drawable.calcular);
                    resul.show();

                    editRaio.setText("");
                }
            }
        });
        return view;
    }


}