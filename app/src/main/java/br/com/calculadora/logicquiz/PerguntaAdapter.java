package br.com.calculadora.logicquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



/**
 * Created by andre on 11/08/16.
 */
public class PerguntaAdapter extends BaseAdapter{
    private final Context context;
    private final List<String> perguntas;

    public PerguntaAdapter(Context context, List<String> perguntas) {
        this.context = context;
        this.perguntas = perguntas;
    }

    @Override
    public int getCount() {
        return perguntas.size();
    }

    @Override
    public Object getItem(int position) {
        return perguntas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String alternativa = perguntas.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoLetra = (TextView) view.findViewById(R.id.item_letra);
        if(position == 0){
            campoLetra.setText("A)");
        }else if(position == 1){
            campoLetra.setText("B)");
        }else if(position == 2){
            campoLetra.setText("C)");
        }else if(position == 3){
            campoLetra.setText("D)");
        }

        TextView campoAlter = (TextView) view.findViewById(R.id.item_altenativa);
        campoAlter.setText(alternativa);

        return view;
    }
}
