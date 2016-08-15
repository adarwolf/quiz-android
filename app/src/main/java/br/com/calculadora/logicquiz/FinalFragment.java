package br.com.calculadora.logicquiz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FinalFragment extends Fragment {
    private ArrayList<String> resposta;
    private int count = 0;
    public FinalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.resposta = getArguments().getStringArrayList("resposta");
        for(int i = 0; i < 10; i++){
            if(this.resposta.get(i).equals("Correta")){
                count++;
            }
            int j = i + 1;
            this.resposta.set(i, j +") " + this.resposta.get(i));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_final, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fin);
        textView.setText("Você acertou: "+ count + " perguntas");

        ListView list = (ListView) view.findViewById(R.id.list_resp);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, this.resposta);
        list.setAdapter(adapter);
        return view;
    }

}
