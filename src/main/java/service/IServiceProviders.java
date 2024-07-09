package service;

import models.UserProviderDto;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;

import java.util.List;

public interface IServiceProviders {
    public List<UserProviderDto> getAllUserProviders();
    public Boolean insertUserProvider(UserProviderDto user);
}