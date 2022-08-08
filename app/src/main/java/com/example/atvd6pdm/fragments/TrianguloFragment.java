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

public class TrianguloFragment extends Fragment {

    private EditText editBase, editAltura;
    private Button btnCalculaTriangulo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_triangulo, container, false);

        editBase = view.findViewById(R.id.editBase);
        editAltura = view.findViewById(R.id.editAltura);
        btnCalculaTriangulo = view.findViewById(R.id.btnCalculaTriangulo);

        btnCalculaTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editBase.getText().toString().isEmpty() || editAltura.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    double base = Double.parseDouble(editBase.getText().toString());
                    double altura = Double.parseDouble(editAltura.getText().toString());

                    double areaTri = (base*altura)/2;

                    AlertDialog.Builder resul = new AlertDialog.Builder(getActivity());
                    resul.setTitle("Resultado!");
                    String saida = String.format("A área do triângulo é de: %.1f", areaTri);
                    resul.setMessage(saida);
                    resul.setIcon(R.drawable.calcular);
                    resul.show();

                    editAltura.setText("");
                    editBase.setText("");
                }
            }
        });

        return view;
    }
}