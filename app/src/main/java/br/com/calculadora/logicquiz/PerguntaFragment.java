package br.com.calculadora.logicquiz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerguntaFragment extends Fragment implements View.OnClickListener{
    private ArrayList<String> l;
    private int position;
    private String alternativa = "";
    private ArrayList<String> resposta;
    public PerguntaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.position = getArguments().getInt("id");
        this.resposta = getArguments().getStringArrayList("resposta");
        l = new PerguntaDAO(getContext()).busca(position);
        System.out.println(l);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pergunta, container, false);

        TextView pergunta = (TextView) view.findViewById(R.id.pergunta);
        String s = l.get(0);
        pergunta.setText(s);

        ListView list = (ListView) view.findViewById(R.id.list_alternativa);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
                view.setSelected(true);
                switch (position){
                    case 0:
                        alternativa = "A";
                        break;
                    case 1:
                        alternativa = "B";
                        break;
                    case 2:
                        alternativa = "C";
                        break;
                    case 3:
                        alternativa = "D";
                        break;

                }
                System.out.println(alternativa);
            }
        });
        PerguntaAdapter adapter = new PerguntaAdapter(getContext(), l.subList(1, 5));
        list.setAdapter(adapter);

        Button next = (Button) view.findViewById(R.id.next_btn);
        next.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(!alternativa.isEmpty()){
            if(alternativa.equals(l.get(5))){
                Toast.makeText(getContext(), "Resposta certa", Toast.LENGTH_SHORT).show();
                this.resposta.add("Correta");
            }else{
                Toast.makeText(getContext(), "Resposta errada", Toast.LENGTH_SHORT).show();
                this.resposta.add("Errada");
            }
            if(position == 10){
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("resposta", resposta);
                Fragment fragment = new FinalFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_body, fragment);
                fragment.setArguments(bundle);
                fragmentTransaction.commit();
            }else{
                position++;
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("resposta", resposta);
                bundle.putInt("id",position);
                Fragment fragment = new PerguntaFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.container_body, fragment);
                fragment.setArguments(bundle);
                fragmentTransaction.commit();
            }
        }
    }
}
