package dao;
import models.UserProviderDto;
import java.util.List;

public interface IProvidersDao {

    public List<UserProviderDto> getAllProvider();
    public Boolean insertProvider (UserProviderDto user);
}