package com.example.opet.agendamento.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.opet.agendamento.R;

public class MainActivity extends Activity {

        public void carregaItemMenu(View v){
            switch (v.getId()) {
                case R.id.btnInserir:
                    carregarIntent(CadastrarAgenda.class);
                    break;
                case R.id.btnListarAgenda:
                    carregarIntent(ListarAgenda.class);
                    break;
                case R.id.btnListarAgendaData:
                    carregarIntent(ListarAgendaData.class);
                    break;
                case R.id.btnListarAgendaNaoRealizado:
                    carregarIntent(ListarAgendaDataNaoRealizada.class);
                    break;
            }
        }

        private void carregarIntent(Class classe){
            Intent intent = new Intent(MainActivity.this,classe);
            startActivity(intent);
        }
    }
