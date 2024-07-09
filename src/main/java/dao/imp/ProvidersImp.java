package dao.imp;
import connection.MysqlConnection;
import dao.IProvidersDao;
import models.UserProviderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvidersImp implements IProvidersDao{
    private static final String SELECT_ALL_USERS = "SELECT name, rut, address, mail, phone_number, contact, contact_number FROM providers";
    private static final String INSERT_USER = "INSERT INTO providers(name, rut, address, mail, phone_number, contact, contact_number) VALUES(?,?,?,?,?,?,?)";

    @Override
    public List<UserProviderDto> getAllProvider() {
        List<UserProviderDto> providers = new ArrayList<UserProviderDto>();
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)){
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()){
                UserProviderDto user = new UserProviderDto();
                user.setNombre(res.getString("name"));
                user.setRut(res.getString("rut"));
                user.setDireccion(res.getString("address"));
                user.setCorreo(res.getString("mail"));
                user.setTelefono(res.getString("phone_number"));
                user.setContacto(res.getString("contact"));
                user.setTelefono_contacto(res.getString("contact_number"));
                providers.add(user);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return providers;
    }

    @Override
    public Boolean insertProvider(UserProviderDto user) {

        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)){
            preparedStatement.setString(1, user.getNombre());
            preparedStatement.setString(2, user.getRut());
            preparedStatement.setString(3, user.getDireccion());
            preparedStatement.setString(4, user.getCorreo());
            preparedStatement.setString(5, user.getTelefono());
            preparedStatement.setString(6, user.getContacto());
            preparedStatement.setString(7, user.getTelefono_contacto());

            int rowInserted =  preparedStatement.executeUpdate();
            if(rowInserted > 0){
                return true;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return false;
    }
}