package wfm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wfm.models.WLSConfig;
import wfm.repos.SysConfigDAO;

@Service
public class SysConfigService {

	@Autowired
    SysConfigDAO dao;
	
	
	public WLSConfig getWLSConfig() {
		return dao.getWLSConfig();
	}
	
}
