package service.serviceimp;
import models.UserProviderDto;

import java.util.List;

import dao.imp.ProvidersImp;
import models.UserProviderDto;
import service.IServiceProviders;

import java.util.List;

public class ServiceProvidersImp implements IServiceProviders {
    private ProvidersImp providersImp = new ProvidersImp();

    @Override
    public List<UserProviderDto> getAllUserProviders() {
        return providersImp.getAllProvider();
    }

    @Override
    public Boolean insertUserProvider(UserProviderDto user) {

        return  providersImp.insertProvider(user);
    }
}