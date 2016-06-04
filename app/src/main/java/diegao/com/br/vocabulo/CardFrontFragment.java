package diegao.com.br.vocabulo;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A fragment representing the front of the card.
 */
public  class CardFrontFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_front, container, false);

        Vocabulo vocabulo = new Vocabulo();
        vocabulo.setWord("Anacrônico");
        vocabulo.setDefinition("Divergencia de tempo / Época diferente / Discrepância temporal");
        //vocabulo.setUseExemple("Um smartphone no ano de 1920 é algo completamente anacrônico");

        TextView textViewTitulo = (TextView) view.findViewById(R.id.txtWord);
        TextView textViewDefinition = (TextView) view.findViewById(R.id.txtDefinition);

        textViewTitulo.setText(vocabulo.getWord());
        textViewDefinition.setText(vocabulo.getDefinition());


        //return inflater.inflate(R.layout.fragment_card_back, container, false);
        return view;
    }
}