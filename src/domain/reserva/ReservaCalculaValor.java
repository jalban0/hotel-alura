package domain.reserva;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.sql.Date;
import java.util.Calendar;

public class ReservaCalculaValor {

    private JDateChooser dataEntrada;
    private JDateChooser dataSaida;
    private Integer valorDiaria = 500;



    public void calcularValor(JDateChooser dataEntrada, JDateChooser dataSaida, JTextField txtValor) {
        int valor = 0;
        if (dataEntrada.getDate() != null && dataSaida.getDate() != null) {
            Calendar inicio = dataEntrada.getCalendar();
            Calendar fim = dataSaida.getCalendar();

            //para contar a partir do dia seguinte.
            int dias = -1;

            while (inicio.before(fim) || inicio.equals(fim)) {
                dias++;
                inicio.add(Calendar.DATE, 1); // dias que será aumentados.
            }
            valor = dias * valorDiaria;
            txtValor.setText("R$ " + valor);
        }
    }

    public JDateChooser getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(JDateChooser dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public JDateChooser getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(JDateChooser dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Integer valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
