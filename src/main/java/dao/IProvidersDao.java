package dao;

import models.UserProviderDto;

import java.util.List;

public interface IProvidersDao {
    public UserProviderDto getUser(int id);

    public List<UserProviderDto> getAllProvider();

    public UserProviderDto insertProvider (UserProviderDto user);
}
