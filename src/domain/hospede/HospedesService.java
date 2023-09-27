package domain.hospede;

import factory.ConnectionFactory;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class HospedesService {

    private HospedeDao hospedeDao;

    public HospedesService() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.hospedeDao = new HospedeDao(connection);
    }

    public void salvar (Hospedes hospedes) {
        this.hospedeDao.salvar(hospedes);
    }

    public List<Hospedes> buscar() {
        return this.hospedeDao.listarHospedes();
    }

    public List<Hospedes> buscarPorId(String id) {
        return this.hospedeDao.buscarPorId(id);
    }

    public void atualizar(Integer id, String nome, String sobreNome, Date dataNasc, String nacionalidade, String telefone, Integer reserva_id) {
        this.hospedeDao.atualizar(id, nome, sobreNome, dataNasc, nacionalidade, telefone, reserva_id);
    }

    public void deletar(Integer id) {
        this.hospedeDao.deletar(id);
    }

    public List<Hospedes> buscarHospedePorNome(String nome) {
        return this.hospedeDao.buscarHospedePorNome(nome);
    }
}
