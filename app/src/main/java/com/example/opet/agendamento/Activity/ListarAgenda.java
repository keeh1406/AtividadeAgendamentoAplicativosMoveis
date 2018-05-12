package com.example.opet.agendamento.Activity;

import android.view.View;
import android.widget.ListView;
import android.content.Intent;
import com.example.opet.agendamento.DAO.AgendaDAO;
import com.example.opet.agendamento.Model.Agenda;
import android.os.Bundle;
import android.widget.AdapterView;
import android.app.Activity;
import java.util.List;
import com.example.opet.agendamento.Adapter.AgendaAdapter;
import com.example.opet.agendamento.R;


/**
 * Created by opet on 09/05/2018.
 */

public class ListarAgenda  extends Activity{
    private ListView listaAgenda;
    private AgendaAdapter myAdapter;
    AgendaDAO agendaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_agenda);

        carregarElementos();
    }

    public void carregarElementos(){
        listaAgenda = (ListView) findViewById(R.id.listaAgenda);
        AgendaDAO agendaDAO = null;

        List<Agenda>loadAgendaByIds = agendaDAO.loadAgendaByIds(int[] agendaID);
        myAdapter = new AgendaAdapter(this, R.layout.item_agenda,loadAgendaByIds);
        listaAgenda.setAdapter(myAdapter);
        listaAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Agenda agenda = (Agenda) parent.getItemAtPosition(position);
                Intent atualizarIntent = new Intent(ListarAgenda.this,AtualizarAgenda.class);
                atualizarIntent.putExtra("ID",agenda.getID());
                startActivity(atualizarIntent);
            }
        });
    }
}
