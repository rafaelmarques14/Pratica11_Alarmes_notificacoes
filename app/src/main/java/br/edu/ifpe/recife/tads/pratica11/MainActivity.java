package br.edu.ifpe.recife.tads.pratica11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scheduleAlarm() {
        // Tempo atual mais 10 segundos (10 * 1000 milissegundos)
        Long time = new GregorianCalendar().getTimeInMillis()+10*1000;
        // Cria Intent do alarm, que será recebido pela classe AlarmReceiver
        Intent intentAlarm = new Intent(this, AlarmReceiver.class);

        // Cria um PendingIntent, usado para fazer o broadcast do alarme
        PendingIntent pendingAlarmIntent = PendingIntent.getBroadcast(
                this, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);
        //Obtem o gerenciador de alarmes do sistema
        AlarmManager alarmManager =
                (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        //Configura um alarme lançará o intent em 10 segundos
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingAlarmIntent);
        Toast.makeText(this, "Alarme agendado.", Toast.LENGTH_LONG).show();
        // Finaliza a atividade
        this.finish();
    }
    public void onScheduleButtonClick(View view) {
        scheduleAlarm();
    }


}