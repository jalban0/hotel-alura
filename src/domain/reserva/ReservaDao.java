package domain.reserva;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDao {

    private Connection connection;

    public ReservaDao(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Reserva reserva){

        try{
            String sql = "INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento)" +
                    "VALUES(?, ?, ?, ?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                preparedStatement.setDate(1, reserva.getDataEntrada());
                preparedStatement.setDate(2, reserva.getDataSaida());
                preparedStatement.setString(3, reserva.getValor());
                preparedStatement.setString(4, reserva.getFormaPagamento());
                preparedStatement.execute();

                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    while (resultSet.next()){
                        reserva.setId(resultSet.getInt(1));
                    }
                }
            }

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public List<Reserva> buscar() {
        List<Reserva> reservas = new ArrayList<>();
        try{
            String sql = "SELECT id, data_entrada, data_saida, valor, forma_pagamento FROM reservas";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.execute();
                transformaResultSetEmReserva(reservas, preparedStatement);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformaResultSetEmReserva(List<Reserva> reservas, PreparedStatement preparedStatement) throws SQLException {

        try(ResultSet resultSet = preparedStatement.getResultSet()){
            while (resultSet.next()){
                Reserva reserva = new Reserva(resultSet.getInt(1), resultSet.getDate(2), resultSet.getDate(3),resultSet.getString(4),resultSet.getString(5));
                reservas.add(reserva);
            }
        }
    }

    public List<Reserva> buscarPorId(String id) {
        List<Reserva> reservas = new ArrayList<>();
        try{
            String sql = "SELECT id, data_entrada, data_saida, valor, forma_pagamento FROM reservas WHERE id = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, id);
                preparedStatement.execute();

                transformaResultSetEmReserva(reservas, preparedStatement);
            }

            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Date dataEntrada, Date dataSaida, String valor, String formaPagamento, Integer id) {

        try(PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE reservas SET data_entrada = ?," +
                        "data_saida = ?, valor = ?, forma_pagamento = ?" +
                        "WHERE id = ?")){

            preparedStatement.setDate(1, dataEntrada);
            preparedStatement.setDate(2, dataSaida);
            preparedStatement.setString(3, valor);
            preparedStatement.setString(4, formaPagamento);
            preparedStatement.setInt(5, id);

            preparedStatement.execute();
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);

        }
    }

    public void deletar(Integer id) {
        try(PreparedStatement pstm = connection.prepareStatement(
                "DELETE FROM reservas WHERE id = ?"
        )) {
            pstm.setInt(1, id);
            pstm.execute();
        }catch (SQLException ex){
            throw  new RuntimeException(ex);
        }
    }
}
