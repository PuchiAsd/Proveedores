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
    private static final String SELECT_ALL_USERS = "SELECT nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM proveedores";
    private static final String INSERT_USER = "INSERT INTO proveedores(nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES(?,?,?,?,?,?,?)";

    @Override
    public List<UserProviderDto> getAllProvider() {
        List<UserProviderDto> providers = new ArrayList<UserProviderDto>();
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)){
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()){
                UserProviderDto user = new UserProviderDto();
                user.setNombre(res.getString("nombre"));
                user.setRut(res.getString("rut"));
                user.setDireccion(res.getString("direccion"));
                user.setCorreo(res.getString("correo"));
                user.setTelefono(res.getString("telefono"));
                user.setContacto(res.getString("contacto"));
                user.setTelefono_contacto(res.getString("telefono_contacto"));
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