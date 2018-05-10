package com.example.opet.agendamento.Activity;

/**
 * Created by opet on 09/05/2018.
 */
    import android.app.Activity;
    import android.app.AlertDialog;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.Toast;
    import com.example.opet.agendamento.DAO.AgendaDAO;
    import com.example.opet.agendamento.Model.Agenda;
    import com.example.opet.agendamento.R;
    import com.example.opet.agendamento.Util.Util;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;

    public class AtualizarAgenda extends Activity {
        private int ID;
        private AgendaDAO agendaDAO;
        private Agenda agenda;
        private EditText editCompromisso;
        private EditText editDescricao;
        private EditText editDataCompromisso;
        private EditText editPrioridadeCompromisso;
        private CheckBox checkBoxRealizado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.atualizar_agenda);
            AgendaDAO = new AgendaDAO(this);
            Intent intent = getIntent();
            if(intent.hasExtra("ID")){
                ID = intent.getIntExtra("ID",0);
            }
            try {
                agenda = AgendaDAO.carregaAgendaPorID(ID);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            editCompromisso = (EditText) findViewById(R.id.CompromissoUpdate);
            editDescricao = (EditText) findViewById(R.id.DescricaoUpdate);
            editDataCompromisso = (EditText) findViewById(R.id.DataCompromissoUpdate);
            editPrioridadeCompromisso = (EditText) findViewById(R.id.PrioridadeCompromissoUpdate);
            checkBoxRealizado = (CheckBox) findViewById(R.id.checkBoxRealizadoUpdate);

            editCompromisso.setText(agenda.getNomeCompromisso());
            editDescricao.setText(agenda.getDescricao());
            editDataCompromisso.setText(Util.toString(agenda.getData()));
            editPrioridadeCompromisso.setText(agenda.getPrioridade());
            checkBoxRealizado.setText(agenda.getFlRealizado());
        }

        public void atualizarAgenda(View v) throws ParseException {
            agenda.setNomeCompromisso(editCompromisso.getText().toString());
            agenda.setDescricao(editDescricao.getText().toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            agenda.setData(simpleDateFormat.parse(editDataCompromisso.getText().toString()));
            agenda.setPrioridade(editPrioridadeCompromisso.getText().toString());
            agenda.setFlRealizado(checkBoxRealizado.getText().toString());

            if(agendaDAO.atualizaAgenda(agenda))
                Toast.makeText(AtualizarAgenda.this, "Agendamento atualizado com sucesso.", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(AtualizarAgenda.this, "Erro ao atualizar o agendamento.", Toast.LENGTH_SHORT).show();
            telaInicial();
        }

        public void removerProduto(View v){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.dialog_title);
            builder.setMessage(R.string.dialog_message);
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    agendaDAO.deletaRegistro(ID);
                    Toast.makeText(AtualizarAgenda.this, "Agendamento removido com sucesso.", Toast.LENGTH_SHORT).show();
                    telaInicial();
                }
            });
            builder.setNegativeButton("Não", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }

        private void telaInicial() {
            Intent telaInicial = new Intent(AtualizarAgenda.this,MainActivity.class);
            startActivity(telaInicial);
            finish();
        }
}
