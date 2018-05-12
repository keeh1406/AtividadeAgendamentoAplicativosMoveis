package com.example.opet.agendamento.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.opet.agendamento.Model.Agenda;
import com.example.opet.agendamento.R;

import java.util.List;

/**
 * Created by opet on 11/05/2018.
 */

    public class AgendaAdapter extends ArrayAdapter{
        private int resource;
        private List<Agenda> agendas;

        public AgendaAdapter(Context context, int resource, List<Agenda> objects) {
            super(context, resource, objects);
            this.resource = resource;
            agendas = objects;
        }

        @Override
        public View getView(int position, View currentView, ViewGroup parent){
            View mView = currentView;

            if(mView == null){
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                mView = inflater.inflate(resource,null,false);
            }

            Agenda agenda = agendas.get(position);

            TextView textNomeCompromisso = (TextView) mView.findViewById(R.id.textNomeCompromisso);
            TextView textDescricao = (TextView) mView.findViewById(R.id.textDescricao);
            TextView textDataCompromisso = (TextView) mView.findViewById(R.id.textDataCompromisso);
            TextView textPrioridadeCompromisso = (TextView) mView.findViewById(R.id.textPrioridadeCompromisso);
            TextView textflFinalidado = (TextView) mView.findViewById(R.id.textflRealizado);

            if(textNomeCompromisso != null){
                textNomeCompromisso.setText(agenda.getNomeCompromisso());
            }
            if(textDescricao != null){
                textDescricao.setText(agenda.getDescricao());
            }
            if(textDataCompromisso != null){
                textDataCompromisso.setText(String.valueOf(agenda.getData()));
            }
            if(textPrioridadeCompromisso != null){
                textPrioridadeCompromisso.setText(String.valueOf(agenda.getPrioridade()));
            }
            if(textflFinalidado != null){
                textflFinalidado.setText(String.valueOf(agenda.getFlRealizado()));
            }
            return mView;
        }
}
