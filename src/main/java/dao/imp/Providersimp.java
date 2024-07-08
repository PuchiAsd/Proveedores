package dao.imp;

import dao.IProvidersDao;
import models.UserProviderDto;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Providersimp implements IProvidersDao {
    private static final String SELECT_ALL_USERS = "SELECT id,nombre,rut,direccion,correo,telefono,contacto,telefono_contacto FROM providers";{
    }

    @Override
    public UserProviderDto getUser(int id) {
        return null;
    }

    @Override
    public List<UserProviderDto> getAllProvider() {
        return null;
    }

    @Override
    public UserProviderDto insertProvider(UserProviderDto user) {
        return null;
    }
}

