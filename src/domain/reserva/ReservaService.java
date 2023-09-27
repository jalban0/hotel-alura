package domain.reserva;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ReservaService {

    private ReservaDao reservaDao;

    public ReservaService() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.reservaDao = new ReservaDao(connection);
    }

    public void salvar(Reserva reserva){
        this.reservaDao.salvar(reserva);

    }

    public List<Reserva> buscar(){
        return this.reservaDao.buscar();
    }

    public List<Reserva> buscarReservasPorId(String id) {
        return this.reservaDao.buscarPorId(id);
    }

    public void atualizar(Date dataEntrada, Date dataSaida, String valor, String formaPagamento, Integer id) {
        this.reservaDao.atualizar(dataEntrada, dataSaida, valor, formaPagamento, id);
    }

    public void deletar(Integer id) {
        this.reservaDao.deletar(id);
    }
}
