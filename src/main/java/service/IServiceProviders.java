package service;

import jakarta.jws.soap.SOAPBinding;
import models.UserProviderDto;

import java.util.List;

public interface IServiceProviders {
    public List<UserProviderDto> getAllUserProvides();

}
