package com.example.opet.agendamento.Activity;

import android.view.View;
import android.widget.ListView;

import com.example.opet.agendamento.DAO.AgendaDAO;
import com.example.opet.agendamento.Model.Agenda;

/**
 * Created by opet on 09/05/2018.
 */

public class ListarAgenda {
    private ListView listaAgenda;
    AgendaDAO agendaDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        carregarElementos();
    }

    public void carregarElementos(){
        listaAgenda = (ListView) findViewById(R.id.listaAgenda);
        agendaDAO = new AgendaDAO(this);
        List<Agenda> agendas = agendaDAO.carregaDadosLista();
        myAdapter = new AgendaAdapter(this, R.layout.item_produto,produtos);
        listaAgenda.setAdapter(myAdapter);
        listaAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Agenda agenda = (Agenda) parent.getItemAtPosition(position);
                Intent atualizarIntent = new Intent(ListarProdutosActivity.this,AtualizarAgenda.class);
                atualizarIntent.putExtra("ID",agenda.getID());
                startActivity(atualizarIntent);
            }
        });
    }
}
