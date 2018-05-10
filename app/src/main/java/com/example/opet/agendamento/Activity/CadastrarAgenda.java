package com.example.opet.agendamento.Activity;

/**
 * Created by opet on 09/05/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.opet.agendamento.DAO.AgendaDAO;
import com.example.opet.agendamento.Model.Agenda;
import com.example.opet.agendamento.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;

    public class CadastrarAgenda extends Activity {
        private EditText editCompromisso;
        private EditText editDescricao;
        private EditText editDataCompromisso;
        private EditText editPrioridadeCompromisso;
        private CheckBox checkBoxRealizado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cadastrar_agenda);

            editCompromisso = (EditText) findViewById(R.id.createCompromisso);
            editDescricao = (EditText) findViewById(R.id.createDescricao);
            editDataCompromisso = (EditText) findViewById(R.id.createDataCompromisso);
            editPrioridadeCompromisso = (EditText) findViewById(R.id.createPrioridadeCompromisso);
            checkBoxRealizado = (CheckBox) findViewById(R.id.createCheckBoxRealizado);
        }

        public void salvarAgenda(View v) throws ParseException {
            AgendaDAO produtoDAO = new AgendaDAO(this);
            Agenda agenda = new Agenda();
            agenda.setNomeCompromisso(editCompromisso.getText().toString());
            agenda.setDescricao(editDescricao.getText().toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            agenda.setData(simpleDateFormat.parse(editDataCompromisso.getText().toString()));
            agenda.setPrioridade(editPrioridadeCompromisso.getText().toString());
            agenda.setFlRealizado(checkBoxRealizado.getText().toString());

            long resultado = agendaDAO.insereDado(agenda);

            if(resultado > 0){
                exibirMensagem("Cadastro realizado com sucesso!");
                Intent listarProdutos = new Intent(CadastrarAgenda.this,ListarAgenda.class);
                startActivity(listarProdutos);
                finish();
            }
            else{
                exibirMensagem("Erro ao cadastrar o item.");
            }
        }

        private void exibirMensagem(String mensagem){
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        }
}
