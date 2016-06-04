package diegao.com.br.vocabulo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import diegao.com.br.vocabulo.R;

/**
 * A fragment representing the back of the card.
 */
public class CardBackFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_back,container,false);

        Vocabulo vocabulo = new Vocabulo();
        //vocabulo.setWord("Anacrônico");
        //vocabulo.setDefinition("Divergencia de tempo / Época diferente / Discrepância temporal");
        vocabulo.setUseExemple("Um smartphone no ano de 1920 é algo completamente anacrônico");

        //TextView textViewTitulo = (TextView)view.findViewById(R.id.txtWord);
        TextView textSampleUse = (TextView)view.findViewById(R.id.txtSampleUse);
        textSampleUse.setText(vocabulo.getUseExemple());


        //return inflater.inflate(R.layout.fragment_card_back, container, false);
        return view;
    }
}