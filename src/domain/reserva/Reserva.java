package domain.reserva;

import java.sql.Date;
import java.util.Objects;

public class Reserva {

    private Integer id;
    private Date dataEntrada;
    private Date dataSaida;
    private String valor;
    private String formaPagamento;

    public Reserva(Integer id, Date dataEntrada, Date dataSaida, String valor, String formaPagamento) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public Reserva(Date dataEntrada, Date dataSaida, String valor, String formaPagamento) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public String getValor() {
        return valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id.equals(reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
